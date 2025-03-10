package com.capstoneproject.utils;

/**
 * Utility class for sorting-related helper functions.
 */
public final class SortingUtils {

    private static int stepCounter = 0;

    private SortingUtils() {
    }

    /**
     * Resets the step counter. Must be called at the start of each sorting execution.
     */
    public static void resetStepCounter() {
        stepCounter = 0;
    }

    /**
     * Returns the current step counter and increments it.
     *
     * @return The current sorting step number.
     */
    public static int getNextStep() {
        return stepCounter++;
    }

    /**
     * Prints the step number before displaying the board.
     */
    public static void printStepNumber() {
        System.out.println(" - - - - Step " + getNextStep() + " - - - -");
    }

    /**
     * Applies a delay between sorting steps.
     *
     * @param stepSpeed The duration in milliseconds to pause.
     */
    public static void pause(int stepSpeed) {
        try {
            Thread.sleep(stepSpeed);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}