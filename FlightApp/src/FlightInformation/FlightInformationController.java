package FlightInformation;

import Data.Classes.Flight;
import Data.Converter.IANACodeConverter;
import Main.MainController;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.text.Text;

import javax.swing.text.TableView;
import java.net.URL;
import java.util.List;
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
    private Image wheather_today;
    @FXML
    private Image wheather_tomorrow;
    @FXML
    private Image wheather_future;

    public FlightInformationController(){
    }

    public void setText(ObservableList<Flight> observableList) throws Exception{
        flightNumber.setText(observableList.get(0).getFlightNumberC());
        departureTime.setText(observableList.get(0).getStartTimeC());
        arrivalTime.setText(observableList.get(0).getEndTimeC());
        destination.setText(IANACodeConverter.IANAToCity(observableList.get(0).getStartAirportC()));
        arrival.setText(IANACodeConverter.IANAToCity(observableList.get(0).getEndAirportC()));
    }

    // TODO: Backbutton: @ELI


    // TODO: UserData: @Michael

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
