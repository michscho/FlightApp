package FlightInformation;

import Data.Classes.Flight;
import Data.Converter.IANACodeConverter;
import Data.Database.DataManager;
import MainScreen.Main;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FlightInformationController implements Initializable {

    @FXML
    private Text flightNumber;
    @FXML
    private Text day;
    @FXML
    private Text arrivalTime;
    @FXML
    private Text departureTime;
    @FXML
    private Text destination;
    @FXML
    private Text arrival;

    @FXML
    private TreeView treeView;

    @FXML
    private Image wheather_today;
    @FXML
    private Image wheather_tomorrow;
    @FXML
    private Image wheather_future;

    @FXML
    private Button cancelButton;
    @FXML
    private Button requestButton;
    @FXML
    private Button rateButton;
    @FXML
    private Button mapButton;

    @FXML
    private Pagination page;

    @FXML
    private Text text;

    public FlightInformationController() {
    }

    public void menuAboutFlightAppClicked() {
    }

    public void menuSettingsClicked() {
        // TODO Setting Frame, for example: Toggle: Search with Case Sensitive
    }

    public void menuUserClicked() {
        // TODO Display UserInformation
    }

    public void menuQuitClicked() {
        Platform.exit();
    }


    public void setText(ObservableList<Flight> observableList) throws Exception {
        flightNumber.setText(observableList.get(0).getFlightNumberC());
        departureTime.setText(observableList.get(0).getStartTimeC());
        arrivalTime.setText(observableList.get(0).getEndTimeC());
        destination.setText(IANACodeConverter.IANAToCity(observableList.get(0).getStartAirportC()));
        arrival.setText(IANACodeConverter.IANAToCity(observableList.get(0).getEndAirportC()));
    }


    public void toMenuButton() throws IOException {
        Main.showMainView();
    }

    public void toMapButton() throws Exception {
        Main.showMapView();
    }

    public void setTreeView() {
        if (DataManager.loadFlightData() == null && Main.developerModus == false) {
            treeView.setVisible(false);
            mapButton.setVisible(false);
            rateButton.setVisible(false);
            requestButton.setVisible(false);
            cancelButton.setVisible(false);
            page.setVisible(false);
        } else {
            text.setVisible(false);
        }


        TreeViewHelper helper = new TreeViewHelper();
        ArrayList<TreeItem> data = helper.getData();

        TreeItem treeItemRoot = new TreeItem("Flight:");
        treeItemRoot.getChildren().addAll(data);
        treeView.setRoot(treeItemRoot);

    }


    // TODO: UserData: @Michael

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setTreeView();
    }
}
