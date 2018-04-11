package SceneControllers;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import connector_mysql.Connector;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerRegister implements Initializable, InterfaceControl {
    ControlledScreens controlledScreens;

    @FXML
    private JFXTextField textName, textSurname, textUser;
    @FXML
    private JFXPasswordField textPass;
    @FXML
    private JFXRadioButton radioWomen, radioMen;
    @FXML
    private JFXDatePicker datePicker;

    @Override
    public void setScreenParent(ControlledScreens screen) {
        controlledScreens = screen;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void doRegister() {
        String gender;
        if (radioWomen.isSelected()) {
            gender = radioWomen.getText();
        } else if (radioMen.isSelected()) {
            gender = radioMen.getText();
        } else {
            gender = null;
        }
        if (textName.getText() != null && textName.getText() != "" && textSurname.getText() != null && textSurname.getText() != "" && textUser.getText() != null && textUser.getText() != "" && textPass.getText() != null && textPass.getText() != "") {
            try {
                Connection conn = Connector.connector("root", "1998");
                PreparedStatement st = conn.prepareStatement("INSERT INTO Usuario (nombre, apellido_1, usuario, contraseña, fecha_nacimiento, sexo) " +
                        "values (?, ?, ?, ?, ?, ?)");
                st.setString(1, textName.getText());
                st.setString(2, textSurname.getText());
                st.setString(3, textUser.getText());
                st.setString(4, textPass.getText());
                st.setString(5, datePicker.getValue().toString());
                st.setString(6, gender);

                st.executeUpdate();
                System.out.println("Usuario insertado correctamente!");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
