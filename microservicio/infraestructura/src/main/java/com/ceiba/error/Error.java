package com.ceiba.error;

public class Error {

    private final String exceptionName;
    private final String message;

    public Error(String exceptionName, String message) {
        this.exceptionName = exceptionName;
        this.message = message;
    }

    public String getExceptionName() {
        return this.exceptionName;
    }

    public String getMessage() {
        return this.message;
    }
}
