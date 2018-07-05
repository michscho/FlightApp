package FlightAPI;

import Data.Classes.Flight;
import MainScreen.Main;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XMLReaderTest {

    @Test
    public void testReadInput() throws Exception {
        Main.developerModus = true;
        List<Flight> list = XMLReader.readInput(Request.request(""));
        Flight flight = list.get(0);
        assertEquals(flight.getEndAirportC(),"Berlin");
        assertEquals(flight.getEndTimeC(),"10.06 at 08:05");
        assertEquals(flight.getFlightNumberC(),"2030");
        assertEquals(flight.getStartAirportC(),"Munich");
        assertEquals(flight.getStartTimeC(),"10.06 at 07:00");
        assertEquals(flight.getAirlineC(),"LH");
        assertEquals(flight.getAirplaneTypeC(),"na");

//        Main.developerModus = false;
//        assertNotNull(XMLReader.readInput(Request.request(RequestBuilder.buildRequest("Munich","Berlin", "20.06.2018", true))));

    }
}
