package com.capstoneproject.sorting.algorithm;

import com.capstoneproject.sorting.interfaces.SortingBoardUpdater;
import com.capstoneproject.sorting.TimedSortingStrategy;
import java.util.List;

/**
 * Implementation of the Bubble Sort algorithm.
 *
 * @param <T> The type of elements to be sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends TimedSortingStrategy<T> {

    /**
     * Performs the Bubble Sort algorithm, updating the board after each swap.
     *
     * @param list The list of elements to be sorted.
     * @param boardUpdater The SortingBoardUpdater responsible for handling board updates.
     */
    @Override
    protected void sortAlgorithm(List<T> list, SortingBoardUpdater boardUpdater) {
        boardUpdater.printUpdatedBoard(list, true);
        int listSize = list.size();
        for (int i = 0; i < listSize - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < listSize - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    swap(list, j, j + 1);
                    swapped = true;
                }
            }
            if (swapped) {
                boardUpdater.printUpdatedBoard(list, false);
            } else {
                break;
            }
        }
    }

}