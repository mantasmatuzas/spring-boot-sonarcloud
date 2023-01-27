package com.example.springbootsonarcloud.domain;

public record FullName(String firstName, String lastName) {

    public String asString() {
        return String.format("%s %s", firstName, lastName);
    }
}
