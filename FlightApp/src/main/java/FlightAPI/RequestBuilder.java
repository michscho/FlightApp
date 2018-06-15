package main.java.FlightAPI;

import main.java.Data.Converter.IANACodeConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class RequestBuilder {


    /**
     *
     * @param departure
     * @param destination
     * @param date
     * @param directFlight
     * @return
     * @throws Exception
     */
    public static String buildRequest(String departure, String destination, String date, boolean directFlight) throws Exception{

        if (departure.equals("") || destination.equals("") || date.equals("")){
            return "";
        }

        String departureIANA = IANACodeConverter.getIANACode(departure);
        System.out.println("Departure IANA Code: " + departureIANA);
        String destinationIANA = IANACodeConverter.getIANACode(destination);
        System.out.println("Arrival IANA Code: " + destinationIANA);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH);
        LocalDate localDate = LocalDate.parse(date, formatter);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        String dateFormatted = localDate.format(formatter2);

        int directFlightInt = 0;
        if (directFlight){
            directFlightInt = 1;
            }

        return(String.format("https://api.lufthansa.com/v1/operations/schedules/%s/%s/%s?directFlights=%d", departureIANA,destinationIANA,dateFormatted,directFlightInt));

    }


}
