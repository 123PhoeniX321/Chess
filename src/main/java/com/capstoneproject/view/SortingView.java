package com.capstoneproject.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SortingView extends Application{

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sorting Pieces");
        VBox root = new VBox();
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
