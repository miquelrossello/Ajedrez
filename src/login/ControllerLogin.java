package login;

import ajedrez.InterfaceControl;
import com.jfoenix.controls.*;
import connector_mysql.Connector;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ControllerLogin implements Initializable, InterfaceControl {
    private static ControllerLogin ourInstance = new ControllerLogin();

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
    public void doRegister() { //Insertar los campos en la BD
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
        insertData(r_nameInput.getText(), r_surnameInput.getText(), r_usernameInput.getText(), r_passwordInput.getText(), birthdayInput.getValue().toString(), gender);
    }

    //Metodo testing
    private void insertData(String nombre, String apellido, String username, String password, String birthday, String gender) {
        if (nombre != null && nombre != "" && apellido != null && apellido != "" && username != null && username != "" && password != null && password != ""
                && birthday != null && birthday != "" && gender != null && gender != "") {
            try {
                Connection conn = Connector.connector("root", "1998");
                PreparedStatement st = conn.prepareStatement("INSERT INTO Usuario (nombre, apellido_1, usuario, contraseña, fecha_nacimiento, sexo) " +
                        "values (?, ?, ?, ?, ?, ?)");
                st.setString(1, nombre);
                st.setString(2, apellido);
                st.setString(3, username);
                st.setString(4, password);
                st.setString(5, birthday);
                st.setString(6, gender);

                st.executeUpdate();
                System.out.println("Usuario insertado correctamente!");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    @FXML
    public void doEnter() {
        String username = userInput.getText();
        String password = passwordInput.getText();
        System.out.println("Username: " + username + " Password: " + password);
    }

    @FXML
    public void goRegister() {
        System.out.println("Going to register pane.");
        disableLogin();
        enableRegister();
        System.out.println("On register pane.");
    }

    @FXML
    private void disableLogin() {
        if (!anchorPane_login.isDisabled()) {
            anchorPane_login.setVisible(false);
        }
    }

    @FXML
    private void disableRegister() {
        if (!anchorPane_register.isDisabled()) {
            anchorPane_register.setVisible(false);
        }
    }

    @FXML
    private void enableLogin() {
        if (anchorPane_login.isDisabled()) {
            anchorPane_login.setVisible(true);
        }
    }

    @FXML
    private void enableRegister() {
        if (anchorPane_register.isDisabled()) {
            anchorPane_register.setVisible(true);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public static ControllerLogin getInstance() {
        return ourInstance;
    }
}