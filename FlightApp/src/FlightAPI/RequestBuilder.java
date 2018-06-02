package FlightAPI;

import javax.xml.crypto.dsig.XMLObject;
import java.util.Date;

public class RequestBuilder {


    public static void testRequest() throws Exception {
        XMLReader xmlReader = new XMLReader();
        xmlReader.readInput(Request.request("https://api.lufthansa.com/v1/operations/schedules/ZRH/FRA/2018-06-02?directFlights=0"));
    }

    public static void buildRequest(String departure, String destination, String date, boolean directFlight) throws Exception{

        // TODO: Data Formater
        // TODO: departure to IANA Code Converter
        // TODO: destination to INANA Code Converter

        int directFlightInt = 0;
        if (directFlight){
            directFlightInt = 1;
            }
        System.out.println(String.format("https://api.lufthansa.com/v1/operations/schedules/%s/%s/%s?directFlights=%d", departure,destination,date,directFlightInt));

        // TODO: Dependecy to Request -> Build Request

    }

    public void readXML(){

    }


    public static void main(String[] args) throws Exception {
        testRequest();
    }



}
