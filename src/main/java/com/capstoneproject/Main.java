package com.capstoneproject;

import com.capstoneproject.controller.SortingController;
import com.capstoneproject.controller.CliController;

public class Main {
    public static void main(String[] args) {

        CliController cliController = new CliController(args);
        cliController.printCliParameters(args);

        SortingController sortingController = new SortingController(cliController);
        sortingController.printParametersValues();

    }
}