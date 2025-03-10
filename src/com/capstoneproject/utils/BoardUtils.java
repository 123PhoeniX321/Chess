package com.capstoneproject.utils;

import java.util.Arrays;

/**
 * Utility class for board-related operations.
 * Provides helper methods for handling chessboard positions.
 */
public final class BoardUtils {

    private BoardUtils() {
    }

    /**
     * Constant representing an invalid board position.
     * Used when a piece's position is not found.
     */
    public static final int[] POSITION_NOT_FOUND = {-1, -1};

    /**
     * Checks if the given position is valid.
     * A position is considered valid if it is not equal to NOT_FOUND.
     *
     * @param position The array containing the board coordinates (row, col).
     * @return true if the position is valid, false otherwise.
     */
    public static boolean isValidPosition(int[] position) {
        return !Arrays.equals(position, POSITION_NOT_FOUND);
    }

}