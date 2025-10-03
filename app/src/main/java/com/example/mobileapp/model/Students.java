package com.example.mobileapp.model;

import java.io.Serializable;

public class Students implements Serializable {
    private String username;
    private String fullName;
    private String email;
    private String password;
    private String gender;
    private String phone;

    // Constructor
    public Students(String username, String fullName, String email, String password, String gender) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.phone = phone;
    }

    // Getters and setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
