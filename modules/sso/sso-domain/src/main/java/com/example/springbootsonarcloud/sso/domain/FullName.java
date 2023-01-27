package com.example.springbootsonarcloud.sso.domain;

public record FullName(String firstName, String lastName) {
    public String asString() {
        return String.format("%s %s", firstName, lastName);
    }
}
