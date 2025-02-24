package com.capstoneproject.view;

import com.capstoneproject.enums.ListType;
import java.util.List;

/**
 * Utility class for console output.
 * Handles the printing and formatting of lists and parameters.
 */
public class ConsoleView {

    public void printListType(String listTypeName) {
        System.out.println("\nTipo: [" + listTypeName + "]\n");
    }

    public void printSortingAlgorithm(String sortingAlgorithmName) {
        System.out.println("Algoritmo: " + sortingAlgorithmName + "\n");
    }

    public void printGeneratedList(List<?> list, ListType listType) {
        if (list == null || list.isEmpty()) {
            System.out.println("Valores: []\n");
        } else {
            System.out.print("Valores: ");
            printList(list, listType);
        }

    }

    public void printOrderedList(List<?> list, ListType listType) {
        System.out.print("Ordenamiento: ");
        printList(list, listType);
    }

    /**
     * Prints the list with appropriate formatting based on the ListType.
     * For CHARACTER lists, each element is printed with single quotes.
     *
     * @param list the list to print
     * @param listType the type of list (CHARACTER or NUMERIC)
     */
    public static void printList(List<?> list, ListType listType) {
        if (listType == ListType.CHARACTER) {
            printCharacterList(list);
        } else {
            System.out.println(list + "\n");
        }
    }

    public void printPieceColor(String pieceColorName) {
        System.out.println("Color: [" + pieceColorName + "]\n");
    }

    public void printStepSpeed(String stepSpeed) {
        if (stepSpeed.equals("Invalido")) {
            System.out.println("Pausa: [" + stepSpeed + "]\n");
        } else {
            System.out.println("Pausa: [" + stepSpeed + " ms]\n");
        }
    }

    public void printPieceQuantity(String pieceQuantity) {
        System.out.println("Cantidad: [" + pieceQuantity + "]\n");
    }

    public void printInvalidParameters() {
        System.out.println("Valores Invalidos\n");
    }

    public void printTotalTime(long totalTime) {
        System.out.println("Tiempo total: " + totalTime + " ms");
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
