package SceneControllers;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerFrame implements Initializable, InterfaceControl {

    ControlledScreens controlledScreens;

    @Override
    public void setScreenParent(ControlledScreens screen) {
        controlledScreens = screen;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
