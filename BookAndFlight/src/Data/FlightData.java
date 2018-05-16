package Data;

import Model.FlightModel;
import Flight.Flight;

public class FlightData {

    //our database
    public static FlightModel initiateData(){
        FlightModel model = new FlightModel();

        model.addFlight( new Flight( "M\u00FCnchenBerlin",  "M\u00FCnchen", "Berlin", 2, 50, false));
        model.addFlight( new Flight( "FrankfurtUSA",  "Frankfurt", "USA", 10, 550, false));
        model.addFlight( new Flight( "FrankfurtAustralia",  "Frankfurt", "Australia", 12, 750, true));

        return model;
    }

}
