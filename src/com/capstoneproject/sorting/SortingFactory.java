package com.capstoneproject.sorting;

import com.capstoneproject.enums.SortingAlgorithm;
import com.capstoneproject.sorting.algorithm.*;

/**
 * Factory class for creating sorting algorithm instances.
 */
public class SortingFactory {

    private SortingFactory() {
    }

    /**
     * Creates and returns an instance of the selected sorting algorithm.
     *
     * @param algorithm The sorting algorithm selected by the user.
     * @return A sorting strategy instance.
     */
    public static <T extends Comparable<T>> TimedSortingStrategy<T> createSorter(SortingAlgorithm algorithm) {
        return switch (algorithm) {
            case BUBBLE_SORT -> new BubbleSort<>();
            case INSERTION_SORT -> new InsertionSort<>();
            case SELECTION_SORT -> new SelectionSort<>();
        };
    }

}
