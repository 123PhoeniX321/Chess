package com.capstoneproject.sorting;

import com.capstoneproject.enums.ListType;
import java.util.List;

/**
 * Abstract base class for sorting algorithms. Implements common functionality such as time measurement
 * and pause handling. Concrete sorting classes must implement sortAlgorithm().
 *
 * @param <T> the type of elements to be sorted
 */
public abstract class AbstractSorter<T extends Comparable<T>> implements SortingStrategy<T> {

    protected long totalTime = 0;

    /**
     * Pauses execution for the specified number of milliseconds.
     *
     * @param stepSpeed the duration in milliseconds to pause
     */
    protected void pause(int stepSpeed) {
        try {
            Thread.sleep(stepSpeed);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Template method that measures the total execution time of the sorting process.
     *
     * @param list the list to sort
     * @param listType the type of list for formatting output
     * @param stepSpeed the pause duration in milliseconds between each step
     */
    @Override
    public void sort(List<T> list, ListType listType, int stepSpeed) {
        long startTime = System.currentTimeMillis();
        sortAlgorithm(list, listType, stepSpeed);
        long endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
    }

    /**
     * Returns the total execution time (in milliseconds) of the sorting process.
     *
     * @return the total execution time in ms
     */
    @Override
    public long getTotalTime() {
        return totalTime;
    }

    /**
     * Abstract method that contains the specific sorting logic.
     * Concrete classes must implement this method.
     *
     * @param list the list to sort
     * @param listType the type of list for formatting output
     * @param stepSpeed the pause duration in milliseconds between each step
     */
    protected abstract void sortAlgorithm(List<T> list, ListType listType, int stepSpeed);
}
