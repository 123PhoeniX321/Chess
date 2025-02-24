package com.capstoneproject.controller;

import com.capstoneproject.enums.SortingAlgorithm;
import com.capstoneproject.model.PieceList;
import com.capstoneproject.sorting.*;
import com.capstoneproject.view.ConsoleView;

/**
 * Main controller for the CHESS application.
 * Coordinates parameter reading, list generation, sorting, and output.
 *
 * @param <T> the type of elements in the list
 */
public class ChessController<T extends Comparable<T>> {
    private CliController cliController;
    private PieceList<T> pieceList;
    private SortingStrategy<T> sorter;
    private ConsoleView view;
    private String[] cliStringArray;
    private long totalOrderingTime;

    public ChessController(String[] args) {
        cliController = new CliController(args);
        pieceList = new PieceList<>();
        view = new ConsoleView();
        cliStringArray = args;
    }

    /**
     * Starts the CHESS process:
     * - Prints CLI parameters.
     * - Generates and displays the list of pieces.
     * - Executes the selected sorting algorithm with step pauses.
     * - Displays the final sorted list and total execution time.
     */
    public void start() {
        cliController.printCliParameters(cliStringArray);
        view.printListType(cliController.getListTypeName());
        pieceList.generateValues(cliController);
        view.printGeneratedList(pieceList.getValuesList(), cliController.getListType());
        if (cliController.areValidParameters()) {
            sorter = createSorter(cliController.getSortingAlgorithm());
            int speed = Integer.parseInt(cliController.getStepSpeed());
            sorter.sort(pieceList.getValuesList(), cliController.getListType(), speed);
            totalOrderingTime = sorter.getTotalTime();
            view.printOrderedList(pieceList.getValuesList(), cliController.getListType());
        } else {
            view.printPieceColor(cliController.getPieceColorName());
            view.printPieceQuantity(cliController.getPieceQuantityValue());
            view.printStepSpeed(cliController.getStepSpeedValue());
            view.printInvalidParameters();
        }
        view.printSortingAlgorithm(cliController.getSortingAlgorithmName());
        view.printTotalTime(totalOrderingTime);
    }

    private SortingStrategy<T> createSorter(SortingAlgorithm algorithm) {
        switch (algorithm) {
            case BUBBLE_SORT:
                return new BubbleSort<>();
            case INSERTION_SORT:
                return new InsertionSort<>();
            case SELECTION_SORT:
                return new SelectionSort<>();
            default:
                throw new UnsupportedOperationException("Algoritmo no soportado: " + algorithm);
        }
    }
}
