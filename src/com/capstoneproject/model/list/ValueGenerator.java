package com.capstoneproject.model.list;

import com.capstoneproject.enums.ListType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Generates a list of values based on the given parameters.
 */
public class ValueGenerator {

    /**
     * Generates a fully typed list of values based on the specified type and quantity.
     *
     * @param listType      The type of list to generate (numeric or character-based).
     * @param pieceQuantity The number of elements to generate.
     * @return A shuffled list of generated values.
     * @throws IllegalArgumentException if an unsupported list type is provided.
     */
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> List<T> generateTypedValues(ListType listType, int pieceQuantity) {
        if (listType == ListType.NUMERIC) {
            return (List<T>) generateNumericValues(pieceQuantity);
        } else if (listType == ListType.CHARACTER) {
            return (List<T>) generateCharacterValues(pieceQuantity);
        }
        throw new IllegalArgumentException("Unsupported list type: " + listType);
    }

    private static List<Integer> generateNumericValues(int pieceQuantity) {
        List<Integer> values = new ArrayList<>();
        for (int i = 1; i <= pieceQuantity; i++) {
            values.add(i);
        }
        Collections.shuffle(values);
        return values;
    }

    private static List<Character> generateCharacterValues(int pieceQuantity) {
        List<Character> values = new ArrayList<>();
        for (char letter = 'a'; letter < 'a' + pieceQuantity; letter++) {
            values.add(letter);
        }
        Collections.shuffle(values);
        return values;
    }

}