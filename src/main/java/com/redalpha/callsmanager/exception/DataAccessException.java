package com.redalpha.callsmanager.exception;

/**
 * Wrapper for exception thrown by data access layer.
 */
public class DataAccessException extends RuntimeException {

    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
