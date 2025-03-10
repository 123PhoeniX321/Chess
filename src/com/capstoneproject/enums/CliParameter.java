package com.capstoneproject.enums;

/**
 * Enum representing the available CLI parameters for the program.
 */
public enum CliParameter {

    SORTING_ALGORITHM("a"),
    LIST_TYPE("t"),
    PIECE_COLOR("c"),
    PIECE_QUANTITY("r"),
    STEP_SPEED("s"),
    INVALID("");

    private final String symbol;

    CliParameter(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Retrieves the corresponding CliParameter for the given symbol.
     *
     * @param symbol The symbol to match.
     * @return The corresponding CliParameter, or INVALID if not found.
     */
    public static CliParameter getCliParameterEnum(String symbol) {
        for (CliParameter parameter : values()) {
            if (parameter == PIECE_QUANTITY && symbol.equalsIgnoreCase(CliParameter.PIECE_QUANTITY.symbol)) {
                return PIECE_QUANTITY;
            }
            if (parameter.symbol.equals(symbol)) {
                return parameter;
            }
        }
        return INVALID;
    }

    /**
     * Checks if the current parameter is invalid.
     *
     * @return True if the parameter is INVALID, otherwise false.
     */
    public boolean isInvalid() {
        return this == INVALID;
    }

}