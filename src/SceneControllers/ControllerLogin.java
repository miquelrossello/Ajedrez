package SceneControllers;

import com.jfoenix.controls.*;
import connector_mysql.Connector;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerLogin implements Initializable, InterfaceControl{
    ControlledScreens controlledScreens;

    @FXML
    private JFXTextField userInput, r_usernameInput, r_nameInput, r_surnameInput;
    @FXML
    private JFXPasswordField passwordInput, r_passwordInput, r_repeat_passwordInput;
    @FXML
    private JFXButton buttonEnter, buttonGoRegister, r_registerButton;
    @FXML
    private JFXDatePicker birthdayInput;
    @FXML
    private JFXRadioButton radioButton_female, radioButton_male;
    @FXML
    private AnchorPane anchorPane_register, anchorPane_login;

    @FXML
    public void goRegister() {
        controlledScreens.setScreen(Main.registerScreenID);
    }

    @FXML
    public void doRegister() { //Insertar los campos en la BD
        System.out.println("Name: " + r_nameInput.getText() + "\nSurname: " + r_surnameInput.getText() + "\nUsername: " + r_usernameInput.getText() + "\nPassword: " + r_passwordInput.getText()
            + "\nBirtday: " + birthdayInput.getValue().toString());
    }

    //Metodo testing funcional


    @FXML
    public void doEnter() {
        System.out.println("Must implement Login comprovation.");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void setScreenParent(ControlledScreens screen) {
        controlledScreens = screen;
    }
}