package com.capstoneproject.sorting.interfaces;

import java.util.List;

/**
 * Handles the interaction between sorting algorithms and the chessboard.
 * Provides an abstraction for updating the board representation during sorting steps.
 */
public interface SortingBoardUpdater {

    /**
     * Print the updated board state based on the current sorted list.
     *
     * @param list The sorted list representing the updated state of the board.
     * @param isInitial If true, places pieces randomly; otherwise, assigns them to mapped positions.
     */
    void printUpdatedBoard(List<? extends Comparable<?>> list, boolean isInitial);

}