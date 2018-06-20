package FlightAPI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestTest {

    @Test
    public void testRequest() throws Exception {
        assertEquals("https://api.lufthansa.com/v1/operations/schedules/MUC/BER/2018-01-23?directFlights=1",(RequestBuilder.buildRequest("Munich","Berlin","23.01.2018", true)));
        assertEquals("",(RequestBuilder.buildRequest("Munich","Berlin","", true)));
    }
}
