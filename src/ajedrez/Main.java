package ajedrez;

import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import login.ControllerLogin;

import java.io.IOException;

public class Main extends Application {

    private Stage stage;
    private ControllerLogin CONTROLLER = ControllerLogin.getInstance();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/login/login.fxml"));
        loader.setController(CONTROLLER);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("Ajedrez");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        LauncherImpl.launchApplication(Main.class, args);
    }
}
