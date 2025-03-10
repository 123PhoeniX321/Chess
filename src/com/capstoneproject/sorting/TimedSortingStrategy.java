package com.capstoneproject.sorting;

import com.capstoneproject.sorting.interfaces.SortingBoardUpdater;
import com.capstoneproject.sorting.interfaces.SortingStrategy;
import com.capstoneproject.utils.SortingUtils;

import java.util.List;

/**
 * Abstract base class for sorting algorithms.
 * Provides a structure for all sorting implementations and measures execution time.
 *
 * @param <T> The type of elements to be sorted.
 */
public abstract class TimedSortingStrategy<T extends Comparable<T>> implements SortingStrategy<T> {

    private long totalTime = 0;

    /**
     * Sorts the given list while updating the chessboard.
     * Measures the total execution time, including pauses between sorting steps.
     *
     * @param list The list of elements to be sorted.
     * @param boardUpdater The SortingBoardUpdater that handles board updates.
     */
    @Override
    public void sort(List<T> list, SortingBoardUpdater boardUpdater) {
        SortingUtils.resetStepCounter();
        long startTime = System.currentTimeMillis();
        sortAlgorithm(list, boardUpdater);
        totalTime = System.currentTimeMillis() - startTime;
    }

    /**
     * Defines the sorting logic that must be implemented by each sorting algorithm.
     * Sorting algorithms must update the board at each step and respect step speed delays.
     *
     * @param list The list of elements to be sorted.
     * @param boardUpdater The SortingBoardUpdater that handles board updates.
     */
    protected abstract void sortAlgorithm(List<T> list, SortingBoardUpdater boardUpdater);

    /**
     * Returns the total execution time of the sorting algorithm,
     * including pauses between sorting steps.
     *
     * @return Execution time in milliseconds.
     */
    public long getTotalTime() {
        return totalTime;
    }

    /**
     * Swaps two elements in the list.
     *
     * @param list The list where elements will be swapped.
     * @param i The index of the first element.
     * @param j The index of the second element.
     */
    protected void swap(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

}