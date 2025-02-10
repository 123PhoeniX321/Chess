package com.capstoneproject.enums;

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

    public static boolean isValid(String number) {
        try {
            int value = Integer.parseInt(number);
            return value >= Integer.parseInt(MIN.getSymbol()) && value <= Integer.parseInt(MAX.getSymbol());
        } catch (NumberFormatException e) {
            return false;
        }
    }

}