package com.capstoneproject.sorting;

import com.capstoneproject.model.PieceManager;
import com.capstoneproject.model.board.ChessBoard;
import com.capstoneproject.sorting.interfaces.SortingBoardUpdater;
import com.capstoneproject.view.CliParameterPrinter;
import com.capstoneproject.view.SortingPrinter;
import java.util.List;

/**
 * Class responsible for updating and displaying the chessboard state during sorting steps.
 */
public class BoardUpdater implements SortingBoardUpdater {

    private final ChessBoard board;
    private final PieceManager pieceManager;
    private final int stepSpeed;

    public BoardUpdater(ChessBoard board, PieceManager pieceManager, int stepSpeed) {
        this.board = board;
        this.pieceManager = pieceManager;
        this.stepSpeed = stepSpeed;
    }

    /**
     * Print the updated board state based on the current sorted list.
     *
     * @param list The sorted list representing the updated state of the board.
     * @param isInitial If true, places pieces randomly; otherwise, assigns them to mapped positions.
     */
    @Override
    public void printUpdatedBoard(List<? extends Comparable<?>> list, boolean isInitial) {
        if (isInitial) {
            SortingPrinter.displaySortingStep(list, board, pieceManager, stepSpeed, isInitial);
            SortingPrinter.displaySortingStep(list, board, pieceManager, stepSpeed, false);
        } else {
            SortingPrinter.displaySortingStep(list, board, pieceManager, stepSpeed, isInitial);
        }
    }

}