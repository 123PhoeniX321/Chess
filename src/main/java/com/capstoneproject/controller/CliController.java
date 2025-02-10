package com.capstoneproject.controller;

import com.capstoneproject.enums.*;

public class CliController {

    private SortingAlgorithm sortingAlgorithm;
    private ListType listType;
    private PieceColor pieceColor;
    private PieceQuantity pieceQuantity;
    private String stepSpeed;

    public CliController(String[] args) {
        captureParameters(args);
    }

    private void captureParameters(String[] args) {
        for (String arg : args) {
            String[] partsParameter = arg.split("=");
            if (partsParameter.length != 2) continue;
            String key = partsParameter[0];
            String value = partsParameter[1];
            CliParameter parameter = CliParameter.getCliParameterEnum(key);
            if (parameter == null) continue;
            switch (parameter) {
                case SORTING_ALGORITHM:
                    sortingAlgorithm = SortingAlgorithm.getSortingAlgorithmEnum(value);
                    break;
                case LIST_TYPE:
                    listType = ListType.getListTypeEnum(value);
                    break;
                case PIECE_COLOR:
                    pieceColor = PieceColor.getPieceColorEnum(value);
                    break;
                case PIECE_QUANTITY:
                    pieceQuantity = PieceQuantity.getPieceQuantityEnum(value);
                    break;
                case STEP_SPEED:
                    if (StepSpeed.isValid(value)) stepSpeed = value;
                    break;
            }
        }
    }

    /**
     * Validates the parameters entered by CLI.
     * Currently, this method does not take into account the speed of each
     * step of the algorithm, as these were not considered in the examples.
     *
     * @return true if the parameters are valid, false otherwise
     */
    public boolean areValidParameters() {
        return sortingAlgorithm != null &&
                listType != null &&
                pieceColor != null &&
                pieceQuantity != null;
    }

    public SortingAlgorithm getSortingAlgorithm() {
        return sortingAlgorithm;
    }

    public ListType getListType() {
        return listType;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public PieceQuantity getPieceQuantity() {
        return pieceQuantity;
    }

    public String getStepSpeed() {
        return stepSpeed;
    }

    public String getSortingAlgorithmName() {
        try {
            return sortingAlgorithm.getSortingAlgorithmName();
        } catch (Exception e) {
            return "Invalido";
        }
    }

    public String getListTypeName() {
        try {
            return listType.getListTypeName();
        } catch (Exception e) {
            return "Invalido";
        }
    }

    public String getPieceColorName() {
        try {
            return pieceColor.getColorName();
        } catch (Exception e) {
            return "Invalido";
        }
    }

    public void printCliParameters(String[] args) {
        for (String arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println();
    }

}