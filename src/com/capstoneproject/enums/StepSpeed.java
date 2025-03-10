package com.capstoneproject.enums;

/**
 * Enum representing the speed of each sorting step.
 * Defines the minimum and maximum allowed delay in milliseconds.
 */
public enum StepSpeed {

    MIN("100"),
    MAX("1000");

    private final String symbol;

    StepSpeed(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    /**
     * Validates whether a given speed is within the allowed range.
     *
     * @param number The speed value to check.
     * @return True if the speed is valid, false otherwise.
     */
    public static boolean isValid(String number) {
        try {
            int value = Integer.parseInt(number);
            return value >= Integer.parseInt(MIN.getSymbol()) && value <= Integer.parseInt(MAX.getSymbol());
        } catch (NumberFormatException e) {
            return false;
        }
    }

}