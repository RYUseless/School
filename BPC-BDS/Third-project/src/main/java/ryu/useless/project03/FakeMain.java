package ryu.useless.project03;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;

public class FakeMain extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        URL fxmlLocation = getClass().getResource("FXML/Login.fxml");
        FXMLLoader loader = new FXMLLoader(fxmlLocation);
        VBox mainStage = loader.load();
        Scene scene = new Scene(mainStage);
        setUserAgentStylesheet(STYLESHEET_MODENA);
        stage.setTitle("help");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public static void main(String[] args) {
        System.out.println("\n---------- FROM HERE STARTS FAKE MAIN SECTION ----------\n");
        launch(args);
    }
}
