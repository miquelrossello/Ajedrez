package Login;

import ajedrez.InterfaceControl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerLogin implements Initializable, InterfaceControl {
    private static ControllerLogin ourInstance = new ControllerLogin();

    @FXML
    private JFXTextField userInput;
    private JFXPasswordField passwordInput;
    private JFXButton buttonEnter;

    public void doEnter() {
        String username = userInput.getText();
        String password = passwordInput.getText();
        System.out.println("Username: " + username + " Password: " + password);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public static ControllerLogin getInstance() {
        return ourInstance;
    }
}