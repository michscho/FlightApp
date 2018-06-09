package Main;

import Data.Classes.Flight;
import FlightInformation.FlightInformationController;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;


public class Main extends Application {

    public static boolean developerModus = true;

    private static Stage primaryStage;
    public void start(Stage primaryStage) throws Exception{
        if (developerModus) {
            System.out.println("--------------------------");
            System.out.println("Developer Modus is on!!!");
            System.out.println("--------------------------");
        }
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Flight App");
        this.primaryStage.getIcons().add(new Image("file:///" + System.getProperty("user.dir") + "\\resources\\pictures\\plane.png"));
        showMainView();

    }

    public static void showMainView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL url = new URL("file:///" + System.getProperty("user.dir") + "\\resources\\fxml\\MainFrame.fxml");
        System.out.println(url.getFile());
        loader.setLocation(url);
        Parent mainLayout = loader.load();
        Scene scene = new Scene(mainLayout,960, 584);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     *
     * @throws IOException
     */
    public static void showFlightInformationView(ObservableList<Flight> observableList) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        URL url = new URL("file:///" + System.getProperty("user.dir") + "\\resources\\fxml\\FlightInformationFrame.fxml");
        loader.setLocation(url);
        Parent root = loader.load();
        Scene scene = new Scene(root, 960, 585);
        primaryStage.setScene(scene);
        FlightInformationController controller = loader.getController();
        try {
            controller.setText(observableList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    public static void main(String[] args) {
        launch(args);
    }
}
