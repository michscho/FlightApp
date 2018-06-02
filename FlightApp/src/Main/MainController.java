package Main;


import Data.Classes.Flight;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

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
    private DatePicker inputField;
    @FXML
    private TableView table;


    public Parent createContent() {
        final ObservableList<Flight> data = FXCollections.observableArrayList(
                new Flight("48x1t", "2018.12.01 19:20", "München", "2018.12.01 20:30", "Berlin", "8a", 12, "12", "Boeing 727", "Lufthansa", 120, true)
        );
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
        return table;
    }


    public void searchButtonClicked() {

        // TODO Linking to Table
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

    public void hyperlinkClicked() {

    }

    public void tableClicked() throws IOException {
        Main.changeScene();
    }

    public void setDate() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        dateLabel.setText(LocalDateTime.now().format(df));
    }

    public void setUsername() {
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // That's the name of the file which was created for the scene
        String fileName = location.getFile().substring(location.getFile().lastIndexOf('/' + 1), location.getFile().length());
        setDate();
        setUsername();
        createContent();
    }
}

