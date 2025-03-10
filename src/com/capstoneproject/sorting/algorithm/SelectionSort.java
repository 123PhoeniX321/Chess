package com.capstoneproject.sorting.algorithm;

import com.capstoneproject.sorting.interfaces.SortingBoardUpdater;
import com.capstoneproject.sorting.TimedSortingStrategy;
import java.util.List;

/**
 * Implementation of the Selection Sort algorithm.
 *
 * @param <T> The type of elements to be sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends TimedSortingStrategy<T> {

    /**
     * Performs the Selection Sort algorithm, updating the board after each swap.
     *
     * @param list The list of elements to be sorted.
     * @param boardUpdater The SortingBoardUpdater responsible for handling board updates.
     */
    @Override
    protected void sortAlgorithm(List<T> list, SortingBoardUpdater boardUpdater) {
        boardUpdater.printUpdatedBoard(list, true);
        int listSize = list.size();
        for (int i = 0; i < listSize - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < listSize; j++) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(list, i, minIndex);
                boardUpdater.printUpdatedBoard(list, false);
            }
        }
    }

}