package com.capstoneproject;

import com.capstoneproject.controller.ChessController;

/**
 * Main class for the CHESS application.
 * Entry point that initializes and starts the ChessController.
 */
public class Main {

    public static void main(String[] args) {

        ChessController<?> controller = new ChessController<>(args);
        controller.start();

    }

}