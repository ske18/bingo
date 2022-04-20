package com.example.vidmot;

/**
 * BingoController stýrir viðmótinu innan bingo-view skráarinnar,
 * útfærir hvað gerist ef við ýtum á takka og þess háttar.
 *
 * @author Svana Kristín Elísdóttir, ske12@hi.is
 */

import com.example.vinnsla.Bingospjald;
import com.example.vinnsla.Bingotolur;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Ellipse;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BingoController implements Initializable {

    @FXML
    private GridPane fxGrid;
    @FXML
    private Label fxTala;
    @FXML
    private ImageView fxMynd;
    private Bingospjald spjald;
    private String gerd;
    private Bingotolur tolur;

    public void setGerd(String gerd) {
        this.gerd = gerd;
    }

    public void nyTala(ActionEvent actionEvent){
        String g = tolur.tala();
        if(g != null) {
            fxTala.setText(g);
        }
    }

    /**
     * Útfærsla þess hvað gerist ef ýtt er á takka.
     *
     * @param url Vísun í FXML skjal
     * @param resourceBundle Utanumhald hvers takka fyrir sig
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        spjald = new Bingospjald();
        tolur = new Bingotolur();
        ObservableList<Node> children = fxGrid.getChildren();
        int [][] bSpjald = spjald.getSpjald();
        int a = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++){
                Button b = (Button) children.get(a);
                b.setText(String.valueOf(bSpjald[j][i]));
                a++;
            }
        }
    }

    /**
     * Umsjón Bingó - breytir bakgrunnslit og lögun, birtir BINGO ef fæst bingó,
     * veit hvaða takka hefur verið ýtt á, hvort bingó sé unnið og fer í nýtt
     * scene ef bingó er unnið.
     * @param actionEvent aðgerðin að ýta á takka
     */
    public void bingoHandler(ActionEvent actionEvent) throws IOException {
        Button b = ((Button)actionEvent.getSource());
        b.setStyle("-fx-background-color: #00FFFF");
        b.setShape(new Ellipse(0.5, 0.5));
        b.setDisable(true);

        fxGrid.requestFocus();
        Integer row = GridPane.getRowIndex(b)-1;
        Integer column = GridPane.getColumnIndex(b);
        if(column == null) column = 0;
        spjald.aReit(row, column);

        if (spjald.erBingo(gerd)) {
            System.out.println(gerd);
            SceneController sc = new SceneController();
            sc.switchToSceneVann(actionEvent);

        }
    }

    /**
     * Setur mynd af gerð bingóspjalds sem valið er, á spjaldið sem
     * verið er að spila, ef ske kynni að leikmaður gleymi hvaða gerð
     * þeir völdu sér.
     */
    public void setjaMynd() {
        switch (gerd) {
            case "Velja1":
                fxMynd.setImage(new Image(BingoController.class.getResourceAsStream("Myndir/Diagonal.png")));
                break;
            case "Velja2":
                fxMynd.setImage(new Image(BingoController.class.getResourceAsStream("Myndir/Xxx.png")));
                break;
            case "Velja3":
                fxMynd.setImage(new Image(BingoController.class.getResourceAsStream("Myndir/Rammi.png")));
                break;
            case "Velja4":
                fxMynd.setImage(new Image(BingoController.class.getResourceAsStream("Myndir/Allt.png")));
                break;
        }
    }
}
