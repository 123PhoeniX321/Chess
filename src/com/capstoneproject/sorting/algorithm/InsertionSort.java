package com.capstoneproject.sorting.algorithm;

import com.capstoneproject.sorting.interfaces.SortingBoardUpdater;
import com.capstoneproject.sorting.TimedSortingStrategy;
import java.util.List;

/**
 * Implementation of the Insertion Sort algorithm.
 *
 * @param <T> The type of elements to be sorted.
 */
public class InsertionSort<T extends Comparable<T>> extends TimedSortingStrategy<T> {

    /**
     * Performs the Insertion Sort algorithm, updating the board after each change.
     *
     * @param list The list of elements to be sorted.
     * @param boardUpdater The SortingBoardUpdater responsible for handling board updates.
     */
    @Override
    protected void sortAlgorithm(List<T> list, SortingBoardUpdater boardUpdater) {
        boardUpdater.printUpdatedBoard(list, true);
        int listSize = list.size();
        for (int i = 1; i < listSize; i++) {
            T key = list.get(i);
            int j = i - 1;
            boolean changed = false;
            while (j >= 0 && list.get(j).compareTo(key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
                changed = true;
            }
            list.set(j + 1, key);
            if (changed) {
                boardUpdater.printUpdatedBoard(list, false);
            }
        }
    }

}