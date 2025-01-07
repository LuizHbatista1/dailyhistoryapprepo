package com.app.dailyhistory.infra;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException (String message){
        super("Post not found!");
    }
}
