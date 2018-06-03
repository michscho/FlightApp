package Main;

import Data.Classes.Flight;
import FlightAPI.Request;
import FlightInformation.FlightInformationController;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


import java.io.IOException;



public class Main extends Application {

    private static Stage primaryStage;
    private Parent mainLayout;
    public void start(Stage primaryStage) throws Exception{
        Request request = new Request();
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
    public static void changeScene(ObservableList<Flight> observableList) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("FlightInformationFrame.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 960, 585);
        primaryStage.setScene(scene);
        FlightInformationController controller = loader.getController();
        controller.setText(observableList);
    }





    public static void main(String[] args) {
        launch(args);
    }
}
