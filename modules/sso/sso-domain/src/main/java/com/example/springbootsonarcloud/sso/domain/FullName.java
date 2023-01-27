package com.example.springbootsonarcloud.sso.domain;

public record FullName(String firstName, String lastName) {
    public String asString() {
        return String.format("%s %s", firstName, lastName);
    }

    public String asString1() {
        return String.format("%s %s", firstName, lastName);
    }

    public String asString2() {
        return String.format("%s %s", firstName, lastName);
    }

    public String asString3() {
        return String.format("%s %s", firstName, lastName);
    }

    public String asString4() {
        return String.format("%s %s", firstName, lastName);
    }

    public String asString5() {
        return String.format("%s %s", firstName, lastName);
    }

}
