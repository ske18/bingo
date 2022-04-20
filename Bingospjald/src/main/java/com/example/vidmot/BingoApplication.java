package com.example.vidmot;

/**
 * BingoApplication keyrir FXML gerd-view skrána af stað, og birtir hana.
 *
 * @author Svana Kristín Elísdóttir, ske12@hi.is
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class BingoApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BingoApplication.class.getResource("gerd-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 410);
        stage.setTitle("BINGO!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
