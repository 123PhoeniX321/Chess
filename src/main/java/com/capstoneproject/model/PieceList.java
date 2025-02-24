package com.capstoneproject.model;

import com.capstoneproject.controller.CliController;
import com.capstoneproject.enums.ListType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents the list of pieces to be sorted.
 * Provides a method to generate a shuffled list of pieces based on CLI parameters.
 *
 * @param <T> the type of elements in the list
 */
public class PieceList<T extends Comparable<T>> {
    private List<T> values;

    public PieceList() {
        values = new ArrayList<>();
    }

    public void generateValues(CliController cliController /*ListType listType, PieceColor pieceColor, PieceQuantity pieceQuantity*/) {
        if(!cliController.listCanBeGenerated()) {
            return;
        }
        ListType listType = cliController.getListType();
        String pieceQuantityString = cliController.getPieceQuantity().getSymbol();
        int pieceQuantity = Integer.parseInt(pieceQuantityString);
        if (listType == ListType.NUMERIC) {
            for (int i = 1; i <= pieceQuantity; i++) {
                values.add((T) Integer.valueOf(i));
            }
        } else {
            for (char letter = 'a'; letter < 'a' + pieceQuantity; letter++) {
                values.add((T) String.valueOf(letter));
            }
        }
        Collections.shuffle(values);
    }

    public List<T> getValuesList() {
        return values;
    }

}
