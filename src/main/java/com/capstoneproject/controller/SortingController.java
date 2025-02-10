package com.capstoneproject.controller;

import com.capstoneproject.model.PieceSorter;

public class SortingController {
    private final PieceSorter<?> pieceSorter;
    private final CliController cliController;

    public SortingController(CliController cliController) {
        this.cliController = cliController;
        this.pieceSorter = new PieceSorter<>(
                cliController.getSortingAlgorithm(),
                cliController.getListType(),
                cliController.getPieceColor(),
                cliController.getPieceQuantity(),
                cliController.getStepSpeed()
        );
    }

    public void printParametersValues() {
        System.out.println("Ordenamiento: [" + cliController.getSortingAlgorithmName() + "]");
        System.out.println("Tipo: [" + cliController.getListTypeName() + "]");
        System.out.println("Color: [" + cliController.getPieceColorName() + "]");
        if (pieceSorter.getListValues() != null) {
            System.out.println("Valores: " + pieceSorter.getListValues());
        } else {
            System.out.println("Valores: []" );
        }
        if (cliController.areValidParameters()) {
            pieceSorter.sort();
            System.out.println("Ordenamiento: " + pieceSorter.getListValues());
        }
        if (!cliController.areValidParameters()) {
            System.out.println("Valores Invalidos");
        }
    }

}