package com.weeroda.feedback.exception;

public class AppException extends RuntimeException {
    public AppException(String message) {
        super(message);
    }

    public AppException(String message, Throwable th) {
        super(message, th);
    }
}
