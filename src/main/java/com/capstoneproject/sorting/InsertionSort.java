package com.capstoneproject.sorting;

import com.capstoneproject.enums.ListType;
import com.capstoneproject.view.ConsoleView;
import java.util.List;

/**
 * Implementation of Insertion Sort algorithm.
 * It prints the list state after each iteration where a change occurs.
 *
 * @param <T> the type of elements to be sorted
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorter<T> {

    @Override
    public void sortAlgorithm(List<T> list, ListType listType, int stepSpeed) {
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
                ConsoleView.printList(list, listType);
                pause(stepSpeed);
            }
        }
    }

}