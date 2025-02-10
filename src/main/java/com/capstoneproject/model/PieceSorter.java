package com.capstoneproject.model;

import com.capstoneproject.enums.ListType;
import com.capstoneproject.enums.PieceColor;
import com.capstoneproject.enums.PieceQuantity;
import com.capstoneproject.enums.SortingAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PieceSorter<T extends Comparable<T>> {
    private final SortingAlgorithm sortingAlgorithm;
    private final ListType listType;
    private final PieceColor pieceColor;
    private final PieceQuantity pieceQuantity;
    private final String stepSpeed;
    private final List<T> listValues;

    public PieceSorter(SortingAlgorithm sortingAlgorithm, ListType listType, PieceColor pieceColor, PieceQuantity pieceQuantity, String stepSpeed) {
        this.sortingAlgorithm = sortingAlgorithm;
        this.listType = listType;
        this.pieceColor = pieceColor;
        this.pieceQuantity = pieceQuantity;
        this.stepSpeed = stepSpeed;
        this.listValues = generateValues();
    }

    public List<T> getListValues() {
        return listValues;
    }

    private List<T> generateValues() {
        if (listType != null && pieceColor != null && pieceQuantity != null) {
            List<T> generatedValues = new ArrayList<>();
            int count = Integer.parseInt(pieceQuantity.getSymbol());

            if (listType == ListType.NUMERIC) {
                for (int i = 1; i <= count; i++) {
                    generatedValues.add((T) Integer.valueOf(i));
                }
            } else {
                for (char letter = 'a'; letter < 'a' + count; letter++) {
                    generatedValues.add((T) String.valueOf(letter));
                }
            }
            Collections.shuffle(generatedValues);
            return generatedValues;
        } else {
            return listValues;
        }
    }

    public void sort() {
        switch (sortingAlgorithm) {
            case BUBBLE_SORT:
                bubbleSort();
                break;
            case INSERTION_SORT:
                insertionSort();
                break;
            case QUICK_SORT:
                quickSort(0, listValues.size() - 1);
                break;
            case SELECTION_SORT:  // Nuevo caso agregado
                selectionSort();
                break;
        }
    }

    private void bubbleSort() {
        int n = listValues.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (listValues.get(j).compareTo(listValues.get(j + 1)) > 0) {
                    Collections.swap(listValues, j, j + 1);
                }
            }
        }
    }

    private void insertionSort() {
        int n = listValues.size();
        for (int i = 1; i < n; i++) {
            T key = listValues.get(i);
            int j = i - 1;
            while (j >= 0 && listValues.get(j).compareTo(key) > 0) {
                listValues.set(j + 1, listValues.get(j));
                j--;
            }
            listValues.set(j + 1, key);
        }
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
    }

    private int partition(int low, int high) {
        T pivot = listValues.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (listValues.get(j).compareTo(pivot) < 0) {
                i++;
                Collections.swap(listValues, i, j);
            }
        }
        Collections.swap(listValues, i + 1, high);
        return i + 1;
    }

    private void selectionSort() {
        int n = listValues.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (listValues.get(j).compareTo(listValues.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            Collections.swap(listValues, i, minIndex);
        }
    }


}