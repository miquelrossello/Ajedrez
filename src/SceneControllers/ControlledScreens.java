package SceneControllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.Node;

import java.io.IOException;
import java.util.HashMap;

public class ControlledScreens extends StackPane {

    private HashMap<String, Node> screens = new HashMap<>();

    public ControlledScreens() {
        super();
    }

    private void addScreen(String name, Node node) {
        screens.put(name, node);
    }

    public Node getScreen(String name) {
        return screens.get(name);
    }

    public boolean loadScreen(String name, String ruta) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(ruta));
            Parent parent = loader.load();
            InterfaceControl interfaceControl = loader.getController();
            interfaceControl.setScreenParent(this);
            addScreen(name, parent);
            return true;
        } catch (IOException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public boolean setScreen(String name) {
        if (screens.get(name) != null) {
            if (getChildren().isEmpty()) {
                getChildren().add(screens.get(name));
                return true;
            } else {
                getChildren().remove(0);
                getChildren().add(screens.get(name));
                return true;
            }
        }
        return false;
    }
}
