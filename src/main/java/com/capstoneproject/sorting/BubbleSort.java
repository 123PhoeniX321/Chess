package com.capstoneproject.sorting;

import com.capstoneproject.enums.ListType;
import com.capstoneproject.view.ConsoleView;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of Bubble Sort algorithm.
 * It prints the list state after each iteration where a change occurs.
 *
 * @param <T> the type of elements to be sorted
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorter<T> {

    @Override
    protected void sortAlgorithm(List<T> list, ListType listType, int stepSpeed) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            boolean changed = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    Collections.swap(list, j, j + 1);
                    changed = true;
                }
            }
            if (changed) {
                ConsoleView.printList(list, listType);
                pause(stepSpeed);
            }
        }
    }
}

