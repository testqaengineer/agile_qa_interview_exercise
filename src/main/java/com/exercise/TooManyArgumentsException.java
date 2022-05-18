package com.exercise;

public class TooManyArgumentsException extends RuntimeException {
    public TooManyArgumentsException() {
        super("Too many arguments");
    }
}
