package com.app.dailyhistory_authentication.infra;

public class PasswordNotEqualsConfirmPasswordException extends RuntimeException {
    public PasswordNotEqualsConfirmPasswordException(String message) {
        super(message);
    }
}
