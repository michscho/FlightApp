package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainFrame.fxml"));
        primaryStage.setTitle("Flight App");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("flightIcon.jpg")));
        primaryStage.setScene(new Scene(root, 960, 585));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
