package sample;

import javafx.fxml.FXML;

import java.awt.*;
import java.awt.event.ActionEvent;

public class Controller {

    @FXML
    private TextField inputUser;
    private TextField inputPassword;
    private Label labelUser;
    private Label labelPassword;
    private Button loginButton;

    @FXML
    private void doLogin(ActionEvent evento) {
        String username = inputUser.getText();
        String password = inputPassword.getText();

        System.out.println("Usuario: " + username + " Contraseña: " + password);
    }
}
