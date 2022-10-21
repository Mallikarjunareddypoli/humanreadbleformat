package com.lloyds.humanreadableformat.exceptions;

public class InputTimeFormatException extends Exception{
    public InputTimeFormatException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "InputTimeFormatException{}";
    }
}
