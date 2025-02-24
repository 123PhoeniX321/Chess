package com.capstoneproject.enums;

/**
 * Enumeration representing the available piece quantitys.
 */
public enum PieceQuantity {
    ONE("1"),
    TWO("2"),
    FOUR("4"),
    SIX("6"),
    EIGHT("8"),
    TEN("10"),
    SIXTEEN("16");

    private final String symbol;

    PieceQuantity(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static PieceQuantity getPieceQuantityEnum(String symbol) {
        for (PieceQuantity quantity : values()) {
            if (quantity.symbol.equals(symbol)) {
                return quantity;
            }
        }
        return null;
    }

}