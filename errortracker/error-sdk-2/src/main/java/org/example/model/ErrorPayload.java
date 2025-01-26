package org.example.model;

public class ErrorPayload {
    private final String message;
    private final String stackTrace;

    public ErrorPayload(String message, String stackTrace) {
        this.message = message;
        this.stackTrace = stackTrace;
    }

    public String getMessage() {
        return message;
    }

    public String getStackTrace() {
        return stackTrace;
    }
}
