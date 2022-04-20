package com.example.vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/***
 * SceneController skiptir á milli scene-a til bingo-view, vann-view og
 * gerd-view þegar nýr leikur er valinn. Útfærir handler til að
 * loka forriti.
 *
 * @author Svana Kristín Elísdóttir, ske12@hi.is
 */
public class SceneController {
    public Button fxEinn;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToSceneGerd(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("bingo-view.fxml")));
        root = loader.load();
        BingoController controller = loader.getController();
        controller.setGerd(((Button) actionEvent.getSource()).getText());
        controller.setjaMynd();
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene((root));
        stage.setTitle("Bingo gerð");
        stage.setScene(scene);
        stage.show();
    }
    public void switchToSceneVann(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("vann-view.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene((root));
        stage.setTitle("Bingo vinningur");
        stage.setScene(scene);
        stage.show();
    }

    public void closeHandler(ActionEvent actionEvent) {
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void switchToSceneStart(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("gerd-view.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene((root));
        stage.setTitle("Bingo gerð");
        stage.setScene(scene);
        stage.show();
    }

}
