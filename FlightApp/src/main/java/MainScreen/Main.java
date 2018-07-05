package MainScreen;

import Data.Classes.Flight;
import FlightInformation.FlightInformationController;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;


public class Main extends Application {

    // You can toggle developer Modus, if true you don't have to connect to the Flight API
    public static boolean developerModus = false;

    private static Stage primaryStage;

    /**
     * @param primaryStage
     * @throws Exception
     */
    public void start(Stage primaryStage) throws Exception{
        if (developerModus) {
            System.out.println("--------------------------");
            System.out.println("Developer Modus is on!!!");
            System.out.println("--------------------------");
        }
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Flight App");
        showMainView();

    }

    public static void showMainView() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("MainFrame.fxml"));
        primaryStage.setTitle("Flight App - Menu");
        Parent mainLayout = loader.load();
        Scene scene = new Scene(mainLayout,960, 584);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(true);
    }

    /**
     *
     * @throws IOException
     */
    public static void showFlightInformationView(ObservableList<Flight> observableList) throws IOException{
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("FlightInformationFrame.fxml"));
        primaryStage.setTitle("Flight App - Flight Information");
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

    /**
     * Shows MapView
     *
     * @throws Exception
     */
    public static void showMapView() {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("GMaps.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root, 960, 585);
        Stage mapWindow = new Stage();
        mapWindow.setTitle("Flight App - Map");
        mapWindow.setScene(scene);
        mapWindow.initModality(Modality.WINDOW_MODAL);
        mapWindow.initOwner(primaryStage);
        mapWindow.show();
    }


    /**
     * Starts MainView
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
