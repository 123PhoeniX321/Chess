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
        final String PARAMETER_DELIMITER = "=";
        final int EXPECTED_PARTS_LENGTH = 2;
        for (String arg : args) {
            String[] partsParameter = arg.split(PARAMETER_DELIMITER);
            if (partsParameter.length != EXPECTED_PARTS_LENGTH) continue;
            String key = partsParameter[0];
            String value = partsParameter[1];
            CliParameter parameter = CliParameter.getCliParameterEnum(key);
            if (parameter.isInvalid()) continue;
            switch (parameter) {
                case SORTING_ALGORITHM -> sortingAlgorithm = SortingAlgorithm.getSortingAlgorithmEnum(value);
                case LIST_TYPE -> listType = ListType.getListTypeEnum(value);
                case PIECE_COLOR -> pieceColor = PieceColor.getPieceColorEnum(value);
                case PIECE_QUANTITY -> pieceQuantity = PieceQuantity.getPieceQuantityEnum(value);
                case STEP_SPEED -> { if (StepSpeed.isValid(value)) stepSpeed = value; }
            }
        }
    }

    /**
     * Validates that all required parameters have been provided and are valid.
     *
     * @return true if listCanBeGenerated is true, sortingAlgorithm and stepSpeed are not null; false otherwise.
     */
    public boolean areValidParameters() {
        return listCanBeGenerated() &&
                sortingAlgorithm != null &&
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

    public String getStepSpeed() {
        return stepSpeed;
    }

    public String getSortingAlgorithmName() {
        return (sortingAlgorithm != null) ? sortingAlgorithm.getSortingAlgorithmName() : InvalidValue.INVALID.getValue();
    }

    public String getListTypeName() {
        return (listType != null) ? listType.getListTypeName() : InvalidValue.INVALID.getValue();
    }

    public String getPieceColorName() {
        return (pieceColor != null) ? pieceColor.getColorName() : InvalidValue.INVALID.getValue();
    }

    public String getPieceQuantityValue() {
        return (pieceQuantity != null) ? pieceQuantity.getSymbol() : InvalidValue.INVALID.getValue();
    }

    public String getStepSpeedValue() {
        return (stepSpeed != null) ? stepSpeed : InvalidValue.INVALID.getValue();
    }
}
