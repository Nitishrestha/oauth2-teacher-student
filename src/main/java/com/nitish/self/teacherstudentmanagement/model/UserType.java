package com.nitish.self.teacherstudentmanagement.model;

public enum UserType {
    STUDENT("student"),
    TEACHER("teacher"),
    PRINCIPAL("principal"),
    ADMIN("admin");

    private String user;

    UserType(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }
}