package com.capstoneproject.enums;

public enum SortingAlgorithm {
    SELECTION_SORT("s", "Selection sort"),
    BUBBLE_SORT("b", "Bubble sort"),
    INSERTION_SORT("i", "Insertion sort"),
    MERGE_SORT("m", "Merge sort"),
    QUICK_SORT("q", "Quick sort"),
    HEAP_SORT("h", "Heap sort"),
    COUNTING_SORT("c", "Counting sort"),
    RADIX_SORT("r", "Radix sort");

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