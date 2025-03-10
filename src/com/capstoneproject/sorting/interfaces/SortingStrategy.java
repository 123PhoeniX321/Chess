package com.capstoneproject.sorting.interfaces;

import java.util.List;

/**
 * Defines the contract for sorting algorithms.
 * Every sorting algorithm must implement this interface.
 *
 * @param <T> The type of elements to be sorted.
 */
public interface SortingStrategy<T extends Comparable<T>> {

    /**
     * Sorts the given list while updating the chessboard.
     *
     * @param list The list of elements to be sorted.
     * @param boardUpdater The SortingBoardUpdater that handles board updates.
     */
    void sort(List<T> list, SortingBoardUpdater boardUpdater);

}