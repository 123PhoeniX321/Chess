package com.capstoneproject.enums;

/**
 * Enumeration representing the available sorting algorithms.
 */
public enum SortingAlgorithm {
    SELECTION_SORT("s", "SelectionSort"),
    BUBBLE_SORT("b", "BubbleSort"),
    INSERTION_SORT("i", "InsertionSort");

    private final String symbol;
    private final String sortingAlgorithmName;

    SortingAlgorithm(String symbol, String sortingAlgorithmName) {
        this.symbol = symbol;
        this.sortingAlgorithmName = sortingAlgorithmName;
    }

    public String getSortingAlgorithmName() {
        return sortingAlgorithmName;
    }

    public static SortingAlgorithm getSortingAlgorithmEnum(String symbol) {
        for (SortingAlgorithm algorithm : values()) {
            if (algorithm.symbol.equalsIgnoreCase(symbol)) {
                return algorithm;
            }
        }
        return null;
    }

}