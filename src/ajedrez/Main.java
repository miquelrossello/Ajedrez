package ajedrez;

import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {

    private Stage stage;
    private final Controller CONTROLLER = Controller.getInstance();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("frame.fxml"));
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
