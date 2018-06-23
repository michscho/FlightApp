package FlightInformation;

import Data.Classes.Flight;
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

import java.io.File;
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

    public void bookFlightClicked() {
        DataManager.safeFlightData(destination.getText(),arrival.getText(),departureTime.getText(),-1.,-1,"na");
        DataManager.safeBookedFlights(2,2,-1,-1,"",-1);

    }

    public void favoriteFlightClicked() {
        DataManager.safeFlightData(destination.getText(),arrival.getText(),departureTime.getText(),2.,-1,"na");
        DataManager.safeBookedFlights(2,2,-1,-1,"favourited",-1);
    }


    public void toMenuButton() throws IOException {
        Main.showMainView();
    }

    public void toMapButton() throws Exception {
        Main.showMapView();
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
        }

        TreeViewHelper helper = new TreeViewHelper();
        ArrayList<TreeItem> data = helper.getData(DataManager.flightData(LoginController.globalUserName).get(page.getCurrentPageIndex()));

        TreeItem treeItemRoot = new TreeItem("Flight:");
        treeItemRoot.getChildren().addAll(data);
        treeView.setRoot(treeItemRoot);

    }


    // TODO: UserData: @Michael

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            setTreeView();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        weatherToday.setImage();
        WeatherRequest wr = new WeatherRequest(destination.getText());

        String imageWeatherToday = "";
        String imageWeatherIn1Day = "";
        String imageWeatherIn2Days = "";
        try {
            imageWeatherToday = wr.currentWeather();
            imageWeatherIn1Day = wr.weatherForecast(8);
            imageWeatherIn2Days = wr.weatherForecast(16);

            tempToday.setText(Integer.toString(wr.currentTemp()) + "°C");
            tempTomorrow.setText(Integer.toString(wr.tempForecast(8)) + "°C");
            tempFuture.setText(Integer.toString(wr.tempForecast(16)) + "°C");
        } catch (Exception e) {
            e.printStackTrace();
        }

//        Image i1 = new Image("http://openweathermap.org/img/w/" + imageWeatherToday + ".png");
        File todayFile = new File("src/Main/resources/Pictures/weather2/" + imageWeatherToday + ".png");
        Image image1 = new Image(todayFile.toURI().toString());
        weatherToday.setImage(image1);

        File tomorrowFile = new File("src/Main/resources/Pictures/weather2/" + imageWeatherIn1Day + ".png");
        Image image2 = new Image(tomorrowFile.toURI().toString());
        weatherTomorrow.setImage(image2);

        File futureFile = new File("src/Main/resources/Pictures/weather2/" + imageWeatherIn2Days + ".png");
        Image image3 = new Image(futureFile.toURI().toString());
        weatherFuture.setImage(image3);


        // TODO: time fixes (espically reagareding night icons) and adding temperature
    }
}
