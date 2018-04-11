package SceneControllers;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static String loginScreenID = "login";
    public static String loginScreenFile = "/login/login.fxml";
    public static String registerScreenID = "register";
    public static String registerScreenFile = "/login/register.fxml";
    public static String gameScreenID = "game";
    public static String gameScreenFile = "/ajedrez/frame.fxml";

    @Override
    public void start(Stage primaryStage) {
        ControlledScreens controlledScreens = new ControlledScreens();
        controlledScreens.loadScreen(loginScreenID, loginScreenFile);
        controlledScreens.loadScreen(registerScreenID, registerScreenFile);
        controlledScreens.loadScreen(gameScreenID, gameScreenFile);

        controlledScreens.setScreen(loginScreenID);

        Group root = new Group();
        root.getChildren().add(controlledScreens);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ajedrez");
        primaryStage.show();
    }
}
