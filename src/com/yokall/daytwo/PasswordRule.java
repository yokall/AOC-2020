package com.yokall.daytwo;

public class PasswordRule {
    private int lowerBound;
    private int upperBound;
    private char significantLetter;
    private String password;

    public int getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }

    public char getSignificantLetter() {
        return significantLetter;
    }

    public void setSignificantLetter(char significantLetter) {
        this.significantLetter = significantLetter;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }
}
