package Main;


import Data.Classes.Flight;
import Data.Classes.User;
import Data.Converter.IANACodeConverter;
import FlightAPI.Request;
import FlightAPI.XMLReader;
import Login.UserLogin;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static FlightAPI.RequestBuilder.buildRequest;


public class MainController implements Initializable {

    /**
     * For the Table
     */
    @FXML
    private TableColumn flightNumberC;
    @FXML
    private TableColumn startTimeC;
    @FXML
    private TableColumn startAirportC;
    @FXML
    private TableColumn endTimeC;
    @FXML
    private TableColumn endAirportC;
    @FXML
    private TableColumn terminalC;
    @FXML
    private TableColumn gateC;
    @FXML
    private TableColumn seatC;
    @FXML
    private TableColumn airplaneTypeC;
    @FXML
    private TableColumn airlineC;
    @FXML
    private TableColumn priceC;
    @FXML
    private TableColumn isFullC;

    @FXML
    private Label dateLabel;
    @FXML
    private Label usernameLabel;
    @FXML
    private TableView table;
    @FXML
    private TextField departure;
    @FXML
    private TextField arrival;
    @FXML
    private DatePicker date;
    @FXML
    private CheckBox directFlight;
    @FXML
    private ProgressIndicator progressIndicator;


    @FXML
    private Text userName;


    public void setTable(List<Flight> flightList) {
        ObservableList<Flight> data = FXCollections.observableList(flightList);
        flightNumberC.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("flightNumberC"));
        startTimeC.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("startTimeC"));
        startAirportC.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("startAirportC"));
        endTimeC.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("endTimeC"));
        endAirportC.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("endAirportC"));
        terminalC.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("terminalC"));
        gateC.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("gateC"));
        seatC.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("seatC"));
        airplaneTypeC.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("airplaneTypeC"));
        airlineC.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("airlineC"));
        priceC.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("priceC"));
        isFullC.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("isFullC"));

        table.setItems(data);
    }


    public void searchButtonClicked() throws Exception {
        progressIndicator.setVisible(true);
        String string = buildRequest(departure.getText(), arrival.getText(), date.getEditor().getText(), directFlight.isSelected());
        if (string.equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Search Incorrect");
            alert.setHeaderText("Please fill your search request.");
            alert.setContentText("You have to fill in the departure, arrival and the date textfield to make a search");

            alert.showAndWait();
        }
                List<Flight> flightList = XMLReader.readInput(Request.request(string));
                setTable(flightList);
        progressIndicator.setVisible(false);
            }





    public void menuAboutFlightAppClicked() {
        // TODO Small Frame with some Information
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

    // TODO
    public void hyperlinkClicked() {

    }

    // TODO Table just opens after two clicks
    public void tableClicked() throws IOException {
        List<String> stringList = new ArrayList<>();
        ObservableList<Flight> observableList = table.getSelectionModel().getSelectedItems();
        Main.changeScene(observableList);
    }

    public void setDate() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        dateLabel.setText("Current Time: " + LocalDateTime.now().format(df));
    }

    public void setUsername() {
        usernameLabel.setText("Current User: " + User.getUsername());
        userName.setText(User.getUsername());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // That's the name of the file which was created for the scene
        UserLogin userLogin = new UserLogin();
        userLogin.createUserLogin();
        setUsername();
        String fileName = location.getFile().substring(location.getFile().lastIndexOf('/' + 1), location.getFile().length());
        setDate();
        try {
            TextFields.bindAutoCompletion(departure, new HashSet<String>(Arrays.asList(IANACodeConverter.getAllAttributes())).toArray(new String[0]));
            TextFields.bindAutoCompletion(arrival, new HashSet<String>(Arrays.asList(IANACodeConverter.getAllAttributes())).toArray(new String[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // NOT WORKING SO FAR

//        TimerTask timerTask = new TimerTask() {
//            @Override
//            public void run() {
//                setDate();
//            }
//        };
//        Timer timer = new Timer();
//        timer.schedule(timerTask, 20000, 20000);
//        timerTask.run();


    }
}

