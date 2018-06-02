package Main;

import FlightInformation.FlightInformationController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;


public class Main extends Application {

    private static Stage primaryStage;
    private Parent mainLayout;
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Flight App");
        this.primaryStage.getIcons().add(new Image("Main/flightIcon.jpg"));
        showMainView();

    }

    private void showMainView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("MainFrame.fxml"));
        mainLayout = loader.load();
        Scene scene = new Scene(mainLayout,960, 584);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     *
     * @throws IOException
     */
    public static void changeScene() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        URL url = new File("resources/fxml/FlightInformationFrame.fxml").toURL();
        loader.setLocation(url);
        Parent root = loader.load(url);
        primaryStage.setScene(new Scene(root, 960, 585));
    }




    public static void main(String[] args) {
        launch(args);
    }
}
