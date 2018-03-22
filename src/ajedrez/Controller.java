package ajedrez;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private static Controller ourInstance = new Controller();

    @FXML
    private
    AnchorPane anchorPane_lienzo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public static Controller getInstance() {
        return ourInstance;
    }
}