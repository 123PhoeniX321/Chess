package com.capstoneproject.enums;

/**
 * Enumeration representing the available list types.
 */
public enum ListType {
    NUMERIC("n", "Numerico"),
    CHARACTER("c", "Caracter");

    private final String symbol;
    private final String listTypeName;

    ListType(String symbol, String listTypeName) {
        this.symbol = symbol;
        this.listTypeName = listTypeName;
    }

    public String getListTypeName() {
        return listTypeName;
    }

    public static ListType getListTypeEnum(String symbol) {
        for (ListType type : values()) {
            if (type.symbol.equalsIgnoreCase(symbol)) {
                return type;
            }
        }
        return null;
    }

}