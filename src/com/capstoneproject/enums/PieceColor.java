package com.capstoneproject.enums;

/**
 * Enum representing the available chess piece colors.
 */
public enum PieceColor {

    BLACK("b", "Black"),
    WHITE("w", "White");

    private final String symbol;
    private final String colorName;

    PieceColor(String symbol, String colorName) {
        this.symbol = symbol;
        this.colorName = colorName;
    }

    public String getColorName() {
        return colorName;
    }

    /**
     * Retrieves the corresponding PieceColor for a given symbol.
     *
     * @param symbol The symbol to match.
     * @return The corresponding PieceColor, or null if not found.
     */
    public static PieceColor getPieceColorEnum(String symbol) {
        for (PieceColor color : values()) {
            if (color.symbol.equalsIgnoreCase(symbol)) {
                return color;
            }
        }
        return null;
    }

}