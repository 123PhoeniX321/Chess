package com.capstoneproject.enums;

public enum PieceColor {
    BLACK("b", "Negras"),
    WHITE("w", "Blancas");

    private final String symbol;
    private final String colorName;

    PieceColor(String symbol, String colorName) {
        this.symbol = symbol;
        this.colorName = colorName;
    }

    public String getColorName() {
        return colorName;
    }

    public static PieceColor getPieceColorEnum(String symbol) {
        for (PieceColor color : values()) {
            if (color.symbol.equalsIgnoreCase(symbol)) {
                return color;
            }
        }
        return null;
    }

}