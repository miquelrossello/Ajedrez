package SceneControllers;

import com.jfoenix.controls.*;
import connector_mysql.Connector;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ControllerLogin implements Initializable, InterfaceControl{
    ControlledScreens controlledScreens;

    @FXML
    private JFXTextField userInput;
    @FXML
    private JFXPasswordField passwordInput;
    @FXML
    private JFXButton buttonEnter, buttonGoRegister;

    @FXML
    public void goRegister() {
        controlledScreens.setScreen(Main.registerScreenID);
    }

    @FXML
    public void doEnter() {
        //Consulta a la BD
        if (userInput.getText() != null && userInput.getText() != "" && passwordInput.getText() != null && passwordInput.getText() != "") {
            try {
                Connection conn = Connector.connector("root", "1998");
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery("Select contrasena from usuario where usuario='"+userInput.getText()+"'");
                while(rs.next()) {
                    System.out.println(rs.getString(1));
                    System.out.println(passwordInput.getText());
                    if (rs.getString(1).equals(passwordInput.getText())) {
                        System.out.println("Allright!");
                    }
                }
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void setScreenParent(ControlledScreens screen) {
        controlledScreens = screen;
    }
}