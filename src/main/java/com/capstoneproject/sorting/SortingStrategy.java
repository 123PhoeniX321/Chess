package com.capstoneproject.sorting;

import com.capstoneproject.enums.ListType;
import java.util.List;

/**
 * Interface that defines the contract for sorting algorithms.
 *
 * @param <T> the type of elements to be sorted, must implement Comparable
 */
public interface SortingStrategy<T extends Comparable<T>> {

    /**
     * Sorts the provided list, displaying intermediate steps with pauses.
     *
     * @param list the list to sort
     * @param listType the type of the list (e.g., CHARACTER or NUMERIC) used for formatting
     * @param stepSpeed the pause duration in milliseconds between each step
     */
    void sort(List<T> list, ListType listType, int stepSpeed);

    /**
     * Returns the total time taken by the sorting algorithm, including pauses.
     *
     * @return total execution time in milliseconds
     */
    long getTotalTime();
}
