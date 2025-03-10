package com.capstoneproject.controller;

import com.capstoneproject.model.PieceManager;
import com.capstoneproject.model.board.ChessBoard;
import com.capstoneproject.model.list.SortableList;
import com.capstoneproject.sorting.SortingFactory;
import com.capstoneproject.sorting.BoardUpdater;
import com.capstoneproject.sorting.interfaces.SortingBoardUpdater;
import com.capstoneproject.sorting.TimedSortingStrategy;
import com.capstoneproject.view.CliParameterPrinter;

/**
 * Main controller for the CHESS application.
 * Coordinates parameter reading, list generation, sorting, and output.
 */
public class ChessController<T extends Comparable<T>> {

    private final CliController cliController;
    private final SortableList<T> sortableList;
    private final String[] cliStringArray;

    public ChessController(String[] args) {
        cliController = new CliController(args);
        sortableList = new SortableList<>();
        cliStringArray = args;
    }

    /**
     * Starts the CHESS process:
     * - Prints CLI parameters.
     * - Generates and displays the list of values.
     * - Executes the selected sorting algorithm with step pauses.
     * - Converts and displays the final sorted list as a board.
     */
    public void start() {
        printCliParameters();
        printGeneratedList();
        if (!validateParameters()) return;
        executeSortingProcess();
    }

    /**
     * Prints all CLI parameters and their parsed values.
     */
    private void printCliParameters() {
        CliParameterPrinter.printCliParameters(cliStringArray);
        CliParameterPrinter.printSortingAlgorithm(cliController.getSortingAlgorithmName());
        CliParameterPrinter.printListType(cliController.getListTypeName());
        CliParameterPrinter.printPieceColor(cliController.getPieceColorName());
        CliParameterPrinter.printPieceQuantity(cliController.getPieceQuantityValue());
        CliParameterPrinter.printStepSpeed(cliController.getStepSpeedValue());
    }

    /**
     * Print the generated list of values based on user input.
     */
    private void printGeneratedList() {
        if (cliController.listCanBeGenerated()) {
            int pieceQuantity = Integer.parseInt(cliController.getPieceQuantityValue());
            sortableList.initializeValues(cliController.getListType(), pieceQuantity);
            CliParameterPrinter.printGeneratedList(sortableList.getValuesList());
        }
    }

    /**
     * Validates if all required parameters are correctly set.
     *
     * @return true if parameters are valid, false otherwise.
     */
    private boolean validateParameters() {
        if (!cliController.areValidParameters()) {
            CliParameterPrinter.printInvalidParameters();
            return false;
        }
        return true;
    }

    /**
     * Executes the sorting process, updating the board, and printing results.
     */
    private void executeSortingProcess() {
        TimedSortingStrategy<T> sorter = SortingFactory.createSorter(cliController.getSortingAlgorithm());
        int stepSpeed = Integer.parseInt(cliController.getStepSpeed());
        int pieceQuantity = Integer.parseInt(cliController.getPieceQuantityValue());
        PieceManager pieceManager = new PieceManager(cliController.getPieceColor(), pieceQuantity);
        ChessBoard chessBoard = new ChessBoard();
        SortingBoardUpdater boardUpdater = new BoardUpdater(chessBoard, pieceManager, stepSpeed);
        sorter.sort(sortableList.getValuesList(), boardUpdater);
        CliParameterPrinter.printOrderedList(sortableList.getValuesList());
        CliParameterPrinter.printTotalTime(sorter.getTotalTime());
    }

}