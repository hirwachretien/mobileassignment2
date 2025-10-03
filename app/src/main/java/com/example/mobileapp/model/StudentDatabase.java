package com.example.mobileapp.model;

import java.util.ArrayList;
import java.util.List;

public class StudentDatabase {
    private static final List<Students> studentsList = new ArrayList<>();

    public static void addStudent(Students student) {
        studentsList.add(student);
    }

    public static Students getStudentByUsername(String username) {
        for (Students s : studentsList) {
            if (s.getUsername().equals(username)) return s;
        }
        return null;
    }

    public static boolean validateCredentials(String username, String password) {
        Students s = getStudentByUsername(username);
        return s != null && s.getPassword().equals(password);
    }
}
