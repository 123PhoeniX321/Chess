package com.capstoneproject.model.list;

import com.capstoneproject.enums.ListType;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the list of values to be sorted.
 * It receives generated values from an external generator.
 *
 * @param <T> the type of elements in the list (Integer or String)
 */
public class SortableList<T extends Comparable<T>> {

    private List<T> values;

    public SortableList() {
        values = new ArrayList<>();
    }

    /**
     * Initializes the sortable list with generated values based on the given type.
     *
     * @param listType      The type of list to generate (numeric or character-based).
     * @param pieceQuantity The number of elements to generate.
     * @throws IllegalArgumentException if the generated values list is empty.
     */
    public void initializeValues(ListType listType, int pieceQuantity) {
        List<T> generatedValues = ValueGenerator.generateTypedValues(listType, pieceQuantity);
        if (generatedValues.isEmpty()) {
            throw new IllegalArgumentException("The generated values list is empty.");
        }
        this.values = new ArrayList<>(generatedValues);
    }

    public List<T> getValuesList() {
        return values;
    }

}