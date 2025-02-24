package com.capstoneproject.controller;

import com.capstoneproject.enums.*;

/**
 * Processes command-line parameters for the CHESS application.
 * Maps CLI arguments to corresponding enums and validates them.
 */
public class CliController {

    private SortingAlgorithm sortingAlgorithm;
    private ListType listType;
    private PieceColor pieceColor;
    private PieceQuantity pieceQuantity;
    private String stepSpeed;

    public CliController(String[] args) {
        captureParameters(args);
    }

    /**
     * Processes the command-line arguments and assigns the corresponding values
     * to the controller's fields based on the parameter symbols.
     *
     * @param args the command-line arguments, expected in the format "key=value"
     */
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
     * Validates that all required parameters have been provided and are valid.
     *
     * @return true if sortingAlgorithm, listType, pieceColor, pieceQuantity, and stepSpeed are not null; false otherwise.
     */
    public boolean areValidParameters() {
        return sortingAlgorithm != null &&
                listType != null &&
                pieceColor != null &&
                pieceQuantity != null &&
                stepSpeed != null;
    }


    /**
     * Checks if the necessary parameters for generating the list are available.
     * Typically, these are listType, pieceQuantity, and pieceColor.
     *
     * @return true if listType, pieceQuantity, and pieceColor are not null, false otherwise.
     */
    public boolean listCanBeGenerated() {
        return listType != null &&
                pieceQuantity != null &&
                pieceColor != null;
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

    public String getPieceQuantityValue() {
        try {
            return pieceQuantity.getSymbol();
        } catch (Exception e) {
            return "Invalido";
        }
    }

    public String getStepSpeedValue() {
        if (stepSpeed == null) {
            return "Invalido";
        } else {
            return stepSpeed;
        }
    }

    public void printCliParameters(String[] args) {
        for (String arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println();
    }

}