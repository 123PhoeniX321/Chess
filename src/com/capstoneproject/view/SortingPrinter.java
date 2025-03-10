package com.capstoneproject.view;

import com.capstoneproject.model.board.ChessBoard;
import com.capstoneproject.model.PieceManager;
import com.capstoneproject.utils.SortingUtils;
import java.util.List;

/**
 * Handles the visualization of the sorting process during the execution of sorting algorithms.
 */
public class SortingPrinter {

    private SortingPrinter() {
    }

    /**
     * Displays the current sorting step, updating the board and printing it with a pause.
     * This method is meant to be used within sorting algorithms.
     *
     * @param list The list of elements being sorted.
     * @param board The chessboard representation.
     * @param pieceManager The PieceManager responsible for mapping values to pieces.
     * @param stepSpeed The delay in milliseconds between steps.
     * @param isInitial If true, places pieces randomly; otherwise, assigns them to mapped positions.
     */
    public static <T> void displaySortingStep(List<T> list, ChessBoard board, PieceManager pieceManager, int stepSpeed, boolean isInitial) {
        SortingUtils.printStepNumber();
        board.updateBoard(pieceManager.convertListToPieces(list), isInitial);
        BoardPrinter.printBoard(board.getBoardMatrix());
        SortingUtils.pause(stepSpeed);
    }

}