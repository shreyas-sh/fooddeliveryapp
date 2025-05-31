package com.example.fooddeliveryapp.fooddeliveryapp;

public class WrongTypeException extends RuntimeException {
    private String message;

    public WrongTypeException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
