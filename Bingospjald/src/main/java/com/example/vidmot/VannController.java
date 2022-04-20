package com.example.vidmot;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/***
 * VannController heldur utan um FXML vann-view skrána, hvað gerist
 * þegar ýtt er á takkana Nýr leikur og hætta, birtir mynd af verðlauna-
 * bikar sem stækkar þegar maður vinnur, með ScaleTransition.
 *
 * @author Svana Kristín Elísdóttir, ske12@hi.is
 */
public class VannController implements Initializable {
    @FXML
    private AnchorPane fxRoot;
    @FXML
    private ImageView fxBikar;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ScaleTransition scale = new ScaleTransition(Duration.seconds(1));
        scale.setToX(2);
        scale.setToY(2);

        scale.setNode(fxBikar);
        scale.play();
    }

    public void switchToSceneStart(ActionEvent actionEvent) throws IOException {
        SceneController sc = new SceneController();
        sc.switchToSceneStart(actionEvent);
    }

    public void closeHandler(ActionEvent actionEvent) {
        SceneController sc = new SceneController();
        sc.closeHandler(actionEvent);
    }
}
