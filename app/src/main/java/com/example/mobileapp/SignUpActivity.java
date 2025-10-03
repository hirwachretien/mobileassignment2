package com.example.mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mobileapp.model.Students;
import com.example.mobileapp.model.StudentDatabase;

public class SignUpActivity extends AppCompatActivity {

    private EditText etFullName, etEmail, etPassword, etConfirmPassword;
    private RadioGroup rgGender;
    private CheckBox cbTerms;
    private Button btnSignUp, btnBackToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        initializeViews();
        setupClickListeners();
    }

    private void initializeViews() {
        etFullName = findViewById(R.id.et_full_name);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password_signup);
        etConfirmPassword = findViewById(R.id.et_confirm_password);
        rgGender = findViewById(R.id.rg_gender);
        cbTerms = findViewById(R.id.cb_terms);
        btnSignUp = findViewById(R.id.btn_signup);
        btnBackToLogin = findViewById(R.id.btn_back_to_login);
    }

    private void setupClickListeners() {
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSignUp();
            }
        });

        btnBackToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // goes back to login
            }
        });
    }

    private void handleSignUp() {
        String fullName = etFullName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String confirmPassword = etConfirmPassword.getText().toString().trim();

        if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        if (rgGender.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please select your gender", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!cbTerms.isChecked()) {
            Toast.makeText(this, "Please accept terms and conditions", Toast.LENGTH_SHORT).show();
            return;
        }

        // Generate a simple username from email
        String username = email.split("@")[0];

        // Determine gender
        String gender = (rgGender.getCheckedRadioButtonId() == R.id.rb_male) ? "Male" : "Female";

        // Create Students object
        Students student = new Students(username, fullName, email, password, gender);

        // Add student to in-memory database
        StudentDatabase.addStudent(student);

        Toast.makeText(this, "Sign up successful!", Toast.LENGTH_SHORT).show();

        // Navigate to UserDetailsActivity
        navigateToUserDetails(student);
    }

    private void navigateToUserDetails(Students student) {
        Intent intent = new Intent(SignUpActivity.this, UserDetailsActivity.class);
        intent.putExtra("username", student.getUsername());
        intent.putExtra("fullName", student.getFullName());
        intent.putExtra("email", student.getEmail());
        startActivity(intent);
    }
}
