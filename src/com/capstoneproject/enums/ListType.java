package com.capstoneproject.enums;

/**
 * Enum representing the types of lists available for sorting.
 */
public enum ListType {

    NUMERIC("n", "Numeric"),
    CHARACTER("c", "Character");

    private final String symbol;
    private final String listTypeName;

    ListType(String symbol, String listTypeName) {
        this.symbol = symbol;
        this.listTypeName = listTypeName;
    }

    public String getListTypeName() {
        return listTypeName;
    }

    /**
     * Retrieves the corresponding ListType for a given symbol.
     *
     * @param symbol The symbol to match.
     * @return The corresponding ListType, or null if not found.
     */
    public static ListType getListTypeEnum(String symbol) {
        for (ListType type : values()) {
            if (type.symbol.equalsIgnoreCase(symbol)) {
                return type;
            }
        }
        return null;
    }

}