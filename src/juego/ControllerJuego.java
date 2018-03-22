package juego;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerJuego implements Initializable {
    private static ControllerJuego ourInstance = new ControllerJuego();

    @FXML
    private
    AnchorPane anchorPane_lienzo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public static ControllerJuego getInstance() {
        return ourInstance;
    }
}