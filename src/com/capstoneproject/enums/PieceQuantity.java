package com.capstoneproject.enums;

/**
 * Enum representing the available piece quantitys.
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

    /**
     * Retrieves the corresponding PieceQuantity for a given symbol.
     *
     * @param symbol The symbol to match.
     * @return The corresponding PieceQuantity, or null if not found.
     */
    public static PieceQuantity getPieceQuantityEnum(String symbol) {
        for (PieceQuantity quantity : values()) {
            if (quantity.symbol.equals(symbol)) {
                return quantity;
            }
        }
        return null;
    }

}