package com.app.dailyhistory_authentication.infra;

public class PasswordLessThanEightCharacters extends RuntimeException {
    public PasswordLessThanEightCharacters(String message)
    {
        super(message);
    }
}
