import animatefx.animation.FadeIn;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Steuerung extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Grafik.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Textlines: Citiziens Sanctuary");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
}
