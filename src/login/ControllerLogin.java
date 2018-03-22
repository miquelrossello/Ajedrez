package login;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerLogin implements Initializable {
    private static ControllerLogin ourInstance = new ControllerLogin();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public static ControllerLogin getInstance() {
        return ourInstance;
    }
}