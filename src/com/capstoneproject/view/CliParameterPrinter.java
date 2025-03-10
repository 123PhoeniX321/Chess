package com.capstoneproject.view;

import java.util.List;

/**
 * Utility class for console output.
 * Handles the printing and formatting of lists and parameters.
 */
public class CliParameterPrinter {

    private CliParameterPrinter() {
    }

    public static void printCliParameters(String[] args) {
        System.out.println();
        for (String arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println("\n");
    }

    public static void printListType(String listTypeName) {
        System.out.println("Type: [" + listTypeName + "]\n");
    }

    public static void printSortingAlgorithm(String sortingAlgorithmName) {
        System.out.println("Algorithm: [" + sortingAlgorithmName + "]\n");
    }

    public static void printGeneratedList(List<?> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("Values: []\n");
        } else {
            System.out.print("Values: ");
            printList(list);
        }
    }

    public static void printOrderedList(List<?> list) {
        System.out.print("Ordered: ");
        printList(list);
    }

    public static void printList(List<?> list) {
        try {
            Object firstElement = list.get(0);
            if (firstElement instanceof Integer) {
                System.out.println(list + "\n");
            } else {
                printCharacterList(list);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("List is empty");
        }
    }

    public static void printPieceColor(String pieceColorName) {
        System.out.println("Color: [" + pieceColorName + "]\n");
    }

    public static void printStepSpeed(String stepSpeed) {
        System.out.println("Pause: [" + (stepSpeed.equals("Invalid") ? stepSpeed : stepSpeed + " ms") + "]\n");
    }

    public static void printPieceQuantity(String pieceQuantity) {
        System.out.println("Quantity: [" + pieceQuantity + "]\n");
    }

    public static void printInvalidParameters() {
        System.out.println("Invalid values\n");
    }

    public static void printTotalTime(long totalTime) {
        System.out.println("Total time: " + totalTime + " ms");
    }

    public static void printCharacterList(List<?> list) {
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print("'" + list.get(i) + "'");
        }
        System.out.println("]\n");
    }

}