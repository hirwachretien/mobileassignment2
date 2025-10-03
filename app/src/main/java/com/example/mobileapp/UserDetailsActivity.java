package com.example.mobileapp;

import android.content.Intent;
<<<<<<< HEAD
=======
import android.net.Uri;
>>>>>>> 3771dc5 (Update Students.java model)
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class UserDetailsActivity extends AppCompatActivity {

    private TextView tvWelcome, tvUserInfo, tvLoginTime;
<<<<<<< HEAD
    private Button btnLogout;
=======
    private Button btnLogout, btnAUCA; // Added AUCA button
>>>>>>> 3771dc5 (Update Students.java model)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        initializeViews();
        displayUserInfo();
        setupClickListeners();
    }

    private void initializeViews() {
        tvWelcome = findViewById(R.id.tv_welcome);
        tvUserInfo = findViewById(R.id.tv_user_info);
        tvLoginTime = findViewById(R.id.tv_login_time);
        btnLogout = findViewById(R.id.btn_logout);
<<<<<<< HEAD
=======
        btnAUCA = findViewById(R.id.btn_auca); // Initialize AUCA button
>>>>>>> 3771dc5 (Update Students.java model)
    }

    private void displayUserInfo() {
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String fullName = intent.getStringExtra("fullName");
        String email = intent.getStringExtra("email");

        if (username != null) {
            tvWelcome.setText("Welcome back, " + username + "!");
            tvUserInfo.setText("Username: " + username);
        } else if (fullName != null && email != null) {
            tvWelcome.setText("Welcome, " + fullName + "!");
            tvUserInfo.setText("Name: " + fullName + "\nEmail: " + email);
        }

        tvLoginTime.setText("Login Time: " + java.text.DateFormat.getDateTimeInstance().format(new java.util.Date()));
    }

    private void setupClickListeners() {
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDetailsActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
<<<<<<< HEAD
=======

        btnAUCA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open AUCA website in browser
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.auca.ac.rw/"));
                startActivity(browserIntent);
            }
        });
>>>>>>> 3771dc5 (Update Students.java model)
    }
}
