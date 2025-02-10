package com.capstoneproject.enums;

public enum CliParameter {
    SORTING_ALGORITHM("a"),
    LIST_TYPE("t"),
    PIECE_COLOR("c"),
    PIECE_QUANTITY("r"),
    STEP_SPEED("s");

    private final String symbol;

    CliParameter(String symbol) {
        this.symbol = symbol;
    }

    public static CliParameter getCliParameterEnum(String symbol) {
        for (CliParameter parameter : values()) {
            if (parameter == PIECE_QUANTITY && symbol.equalsIgnoreCase("r")) {
                return PIECE_QUANTITY;
            }
            if (parameter.symbol.equals(symbol)) {
                return parameter;
            }
        }
        return null;
    }
}