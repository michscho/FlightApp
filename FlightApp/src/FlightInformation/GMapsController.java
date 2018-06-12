package FlightInformation;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.*;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class GMapsController  implements Initializable, MapComponentInitializedListener {

    @FXML
    private Button backButton;

    @FXML
    private GoogleMapView mapView;

    private GoogleMap map;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mapView.addMapInializedListener(this);
    }

    @Override
    public void mapInitialized() {
        LatLong berlin = new LatLong(52.520008, 13.404954);
        LatLong munich = new LatLong(48.137154, 11.576124);


        //Set the initial properties of the map.
        MapOptions mapOptions = new MapOptions();

        mapOptions.center(new LatLong(49.137154, 12.576124))
                .mapType(MapTypeIdEnum.ROADMAP)
                .overviewMapControl(true)
                .panControl(true)
                .rotateControl(true)
                .scaleControl(true)
                .streetViewControl(false)
                .zoomControl(true)
                .zoom(6);

        map = mapView.createMap(mapOptions);


        //Add markers to the map
        MarkerOptions markerOptionsBerlin = new MarkerOptions();
        markerOptionsBerlin.position(berlin);

        MarkerOptions markerOptionsMunich = new MarkerOptions();
        markerOptionsMunich.position(munich);

        Marker berlinMarker = new Marker(markerOptionsBerlin);
        Marker munichMarker = new Marker(markerOptionsMunich);

        map.addMarker( berlinMarker );
        map.addMarker( munichMarker );

        InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
        infoWindowOptions.content("Departure");

        InfoWindow window = new InfoWindow(infoWindowOptions);
        window.open(map, munichMarker);
    }

    public void backButtonPressed(){
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }



}

