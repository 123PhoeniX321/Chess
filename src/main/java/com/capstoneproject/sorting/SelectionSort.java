package com.capstoneproject.sorting;

import com.capstoneproject.enums.ListType;
import com.capstoneproject.view.ConsoleView;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of Selection Sort algorithm.
 * It prints the list state after each iteration where a change occurs.
 *
 * @param <T> the type of elements to be sorted
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorter<T> {

    @Override
    protected void sortAlgorithm(List<T> list, ListType listType, int stepSpeed) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            boolean changed = false;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Collections.swap(list, i, minIndex);
                changed = true;
            }
            if (changed) {
                ConsoleView.printList(list, listType);
                pause(stepSpeed);
            }
        }
    }
}
