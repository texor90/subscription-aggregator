package com.sa.jacek.sa.exception;

public class IdMismatchException extends RuntimeException { // porónuje id ze ścieżki z adresu z id w body. Jeśli adresy są tożsame to aktualizacja się wykona.
    private String errorCode = "CODE1";

    public IdMismatchException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public IdMismatchException(String message) {
        super(message);
    }

    public String getErrorCode() {
        return errorCode;
    }
}
