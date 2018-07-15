package FlightInformation;

import Data.Classes.Flight;
import Data.Converter.DateConverter;
import Data.Converter.IANACodeConverter;
import Data.Database.DataManager;
import Login.LoginController;
import MainScreen.Main;
import WeatherAPI.WeatherRequest;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FlightInformationController implements Initializable {

    @FXML
    private Text userName;
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
    private Text duration;

    @FXML
    private TreeView treeView;


    @FXML
    private ImageView weatherToday;
    @FXML
    private ImageView weatherTomorrow;
    @FXML
    private ImageView weatherFuture;

    @FXML
    private Text tempToday;

    @FXML
    private Text tempTomorrow;

    @FXML
    private Text tempFuture;

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


    public void menuAboutFlightAppClicked() {
        // TODO
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
        duration.setText(DateConverter.getDuration(observableList.get(0).getStartTimeC(), observableList.get(0).getEndTimeC()));
        destination.setText(IANACodeConverter.IANAToCity(observableList.get(0).getStartAirportC()));
        arrival.setText(IANACodeConverter.IANAToCity(observableList.get(0).getEndAirportC()));
        day.setText(DateConverter.getDayOfWeek(observableList.get(0).getStartTimeC()));
    }

    public void bookFlightClicked() {
        DataManager.safeFlightData(destination.getText(), arrival.getText(), departureTime.getText(), -1., -1, "na");
        DataManager.safeBookedFlights(2, 2, -1, -1, "", -1);

    }

    public void favoriteFlightClicked() {
        DataManager.safeFlightData(destination.getText(), arrival.getText(), departureTime.getText(), 2., -1, "na");
        DataManager.safeBookedFlights(2, 2, -1, -1, "favourited", -1);
    }


    public void toMenuButton() throws IOException {
        Main.showMainView();
    }

    public void toMapButton() throws Exception {
        Main.showMapView();
    }

    public void setUserName() {
        userName.setText(LoginController.globalUserName);
    }

    public void setTreeView() throws Exception {
        if (DataManager.flightData(LoginController.globalUserName).size() == 0) {
            treeView.setVisible(false);
            mapButton.setVisible(false);
            rateButton.setVisible(false);
            requestButton.setVisible(false);
            cancelButton.setVisible(false);
            page.setVisible(false);
        } else {
            text.setVisible(false);
            page.setMaxPageIndicatorCount(4);
            page.setPageCount(DataManager.flightData(LoginController.globalUserName).size());
            TreeViewHelper helper = new TreeViewHelper();
            ArrayList<TreeItem> data = helper.getData(DataManager.flightData(LoginController.globalUserName).get(page.getCurrentPageIndex()));

            TreeItem treeItemRoot = new TreeItem("Flight:");
            treeItemRoot.getChildren().addAll(data);
            treeView.setRoot(treeItemRoot);
        }


    }

    public void logOutPressed() throws Exception {
        //TODO
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUserName();
        try {
            setTreeView();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Weather Fetching
        WeatherRequest wr = new WeatherRequest(destination.getText());

        String[] icons = new String[3];
        int[] temperatures = new int[3];
        try {
            // get weather information
            icons = wr.getIcon();
            temperatures = wr.getTemp();
        } catch (Exception e) {
            e.printStackTrace();
        }


        tempToday.setText(Integer.toString(temperatures[0]) + "°C");
        tempTomorrow.setText(Integer.toString(temperatures[1]) + "°C");
        tempFuture.setText(Integer.toString(temperatures[2]) + "°C");

        try {
            Image image1 = new Image("Pictures/weather2/" + icons[0] + ".png");
            weatherToday.setImage(image1);

            Image image2 = new Image("Pictures/weather2/" + icons[1] + ".png");
            weatherTomorrow.setImage(image2);

            Image image3 = new Image("Pictures/weather2/" + icons[2] + ".png");
            weatherFuture.setImage(image3);
        } catch (Exception e) {
            e.printStackTrace();
        }


        // TODO: time fixes (espically reagareding night icons) and adding temperature
    }
}
