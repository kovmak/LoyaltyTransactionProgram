package com.krnelx.transactionloyaltyprogram.exceptions;

public class InsufficientPointsException extends RuntimeException {

    public InsufficientPointsException(String message) {
        super(message);
    }
}