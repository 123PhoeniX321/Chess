package com.capstoneproject.enums;

/**
 * Enum representing the available sorting algorithms.
 */
public enum SortingAlgorithm {

    SELECTION_SORT("s", "Selection Sort"),
    BUBBLE_SORT("b", "Bubble Sort"),
    INSERTION_SORT("i", "Insertion Sort");

    private final String symbol;
    private final String sortingAlgorithmName;

    SortingAlgorithm(String symbol, String sortingAlgorithmName) {
        this.symbol = symbol;
        this.sortingAlgorithmName = sortingAlgorithmName;
    }

    public String getSortingAlgorithmName() {
        return sortingAlgorithmName;
    }

    /**
     * Retrieves the corresponding SortingAlgorithm for a given symbol.
     *
     * @param symbol The symbol to match.
     * @return The corresponding SortingAlgorithm, or null if not found.
     */
    public static SortingAlgorithm getSortingAlgorithmEnum(String symbol) {
        for (SortingAlgorithm algorithm : values()) {
            if (algorithm.symbol.equalsIgnoreCase(symbol)) {
                return algorithm;
            }
        }
        return null;
    }

}