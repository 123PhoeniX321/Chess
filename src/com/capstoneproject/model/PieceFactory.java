package com.capstoneproject.model;

import com.capstoneproject.enums.PieceColor;
import com.capstoneproject.model.piece.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Factory class for creating chess pieces based on the required quantity.
 */
public class PieceFactory {

    /**
     * Creates and returns a map containing the required chess pieces based on the given quantity.
     *
     * @param color The color of the pieces.
     * @param pieceQuantity The number of pieces to create.
     * @return A map of pieces with their assigned indexes.
     */
    public static Map<Integer, Piece> createPieces(PieceColor color, int pieceQuantity) {
        Map<Integer, Piece> pieceMapping = new HashMap<>();
        int index = 1;
        if (pieceQuantity >= 1) addPieces(pieceMapping, index++, 1, new King(color));
        if (pieceQuantity >= 2) addPieces(pieceMapping, index++, 1, new Queen(color));
        if (pieceQuantity >= 4) {addPieces(pieceMapping, index, 2, new Bishop(color)); index += 2;}
        if (pieceQuantity >= 6) {addPieces(pieceMapping, index, 2, new Knight(color)); index += 2;}
        if (pieceQuantity >= 8) {addPieces(pieceMapping, index, 2, new Rook(color)); index += 2;}
        if (pieceQuantity >= 10) addPieces(pieceMapping, index, pieceQuantity - 8, new Pawn(color));
        return pieceMapping;
    }

    /**
     * Adds multiple instances of the same piece to the provided mapping.
     *
     * @param mapping The map where the pieces will be stored.
     * @param startIndex The starting index for placing the pieces.
     * @param count The number of pieces to add.
     * @param piece The piece to be added multiple times.
     */
    private static void addPieces(Map<Integer, Piece> mapping, int startIndex, int count, Piece piece) {
        for (int i = 0; i < count; i++) {
            mapping.put(startIndex++, piece);
        }
    }

}