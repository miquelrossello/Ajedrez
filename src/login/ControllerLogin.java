package login;

import ajedrez.InterfaceControl;
import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerLogin implements Initializable, InterfaceControl {
    private static ControllerLogin ourInstance = new ControllerLogin();

    @FXML
    private JFXTextField userInput, r_usernameInput, r_nameInput, r_surnameInput;
    @FXML
    private JFXPasswordField passwordInput, r_passwordInput, r_repeat_passwordInput;
    @FXML
    private JFXButton buttonEnter, r_registerButton;
    @FXML
    private JFXDatePicker birthdayInput;
    @FXML
    private JFXRadioButton radioButton_female, radioButton_male;

    @FXML
    public void doRegister() {
        String gender;
        if (radioButton_female.isSelected()) {
            gender = radioButton_female.getText();
        } else if (radioButton_male.isSelected()) {
            gender = radioButton_male.getText();
        } else {
            gender = "Género no especificado.";
        }
        System.out.println("Name: " + r_nameInput.getText() + "\nSurname: " + r_surnameInput.getText() + "\nUsername: " + r_usernameInput.getText() + "\nPassword: " + r_passwordInput.getText()
            + "\nBirtday: " + birthdayInput.getValue().toString() + "\nGender: " + gender);
    }

    @FXML
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