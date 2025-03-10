package com.capstoneproject.enums;

/**
 * Enum representing invalid values used in the CLI controller.
 */
public enum InvalidValue {

    INVALID("Invalid");

    private final String value;

    InvalidValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}