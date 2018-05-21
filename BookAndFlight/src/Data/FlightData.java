package Data;

import Model.FlightModel;
import Flight.Flight;

public class FlightData {


    /***
     *
     *
     *
     * Sample Data -  will be replaced by API
     *
     *
     *
     */
    private static String[] flightNumber = new String[]{"XQ 133 (B738)",
            "TK 1636 (A332)",
            "A3 502 (A320)",
            "LH 2020 (A320)",
            "LH 119 (A320)",
            "LO 353 (E190)",
            "LH 1615 (E190)",
            "LG 9736 (DH8D)",
            "LG 9735 (DH8D)",
            "BA 953 (A320)",
            "BA 952 (A320)",
            "AF 1823 (A321)",
            "AF 1022 (A319)",
            "TG 925",
            "TG 924 (B744)",
            "S7 898 (A320)"
    };

    private static String[] startTime = new String[]{
            "08.01.2018 18:10",
            "22.01.2018 18:25",
            "29.01.2018 17:30",
            "12.02.2018 19:00",
            "26.02.2018 17:10",
            "12.03.2018 16:50",
            "19.03.2018 16:15",
            "24.03.2018 14:30",
            "09.04.2018 16:25",
            "23.04.2018 12:40",
            "21.05.2018 18:10",
            "28.05.2018 18:05",
            "01.06.2018 14:25",
            "25.06.2018 00:50",
            "23.07.2018 16:45"
    };

    private static String[] startAirport = new String[]{
            "Munich (MUC)",
            "Istanbul (IST)",
            "Thessaloniki (SKG)",
            "Munich (MUC)",
            "Frankfurt (FRA)",
            "Munich (MUC)",
            "Warsaw (WAW)",
            "Munich (MUC)",
            "Luxembourg (LUX)",
            "Munich (MUC)",
            "London (LHR)",
            "Munich (MUC)",
            "Paris (CDG)",
            "Munich (MUC)",
            "Bangkok (BKK)",
            "Munich (MUC)"
    };

    private static String[] endTime = new String[]{"08.01.2018 22:10",
            "22.01.2018 22:05",
            "29.01.2018 18:25",
            "12.02.2018 20:00",
            "26.02.2018 18:50",
            "12.03.2018 18:20",
            "19.03.2018 17:25",
            "24.03.2018 15:40",
            "24.03.2018 17:25",
            "23.04.2018 15:25",
            "21.05.2018 19:35",
            "28.05.2018 19:35",
            "02.06.2018 06:05",
            "25.06.2018 06:45",
            "23.07.2018 20:25"
    };

    private static String[] endAirport = new String[]{"Antalya (AYT)",
            "Munich (MUC)",
            "Munich (MUC)",
            "Dusseldorf (DUS)",
            "Munich (MUC)",
            "Warsaw (WAW)",
            "Munich (MUC)",
            "Luxembourg (LUX)",
            "Munich (MUC)",
            "London (LHR)",
            "Munich (MUC)",
            "Paris (CDG)",
            "Munich (MUC)",
            "Bangkok (BKK)",
            "Munich (MUC)",
            "Moscow (DME)"
    };

    private static String[] terminal = new String[]{
            "T1C",
            "T1C",
            "T2",
            "T2",
            "T2",
            "T2",
            "T2",
            "T2",
            "T2",
            "T1A",
            "T1B",
            "T1D",
            "T1E",
            "T1D",
            "T2",
            "T1B"
    };

    private static Integer[] gate = new Integer[]{
            4,
            2,
            1,
            3,
            5,
            1,
            1,
            3,
            2,
            12,
            15,
            2,
            4,
            3,
            1
    };

    private static String[] seat = new String[]{
            "22C",
            "30A",
            "11B",
            "16F",
            "23D",
            "29E",
            "12A",
            "21A",
            "11A",
            "15D",
            "17B",
            "19A",
            "17C",
            "27B",
            "20A",
            "23D"
    };

    private static String[] airplaneType = new String[]{
            "Airbus A330",
            "Airbus A330",
            "Airbus A320 - 100",
            "Airbus A320 - 100",
            "Airbus A320 - 100",
            "Airbus A330",
            "Airbus A330",
            "De Havilland Canada Dash 8 - 400",
            "De Havilland Canada Dash 8 - 400",
            "Airbus A320 - 100",
            "Airbus A320 - 100",
            "Airbus A330 - 200(332)",
            "Airbus A330 - 200(332)",
            "Boeing 747",
            "Boeing 747",
            "Airbus A320 - 100"
    };

    private static String[] airline = new String[]{
            "SunExpress",
            "Turkish Airlines",
            "AEGEAN",
            "Lufthansa",
            "Lufthansa",
            "LOT",
            "LOT",
            "Luxair",
            "Luxair",
            "British Airways",
            "British Airways",
            "Air France",
            "Air France",
            "Thai Airways International",
            "Thai Airways International",
            "S7"
    };
    private static Integer[] price = new Integer[]{
            86,
            110,
            100,
            110,
            95,
            78,
            78,
            76,
            78,
            110,
            110,
            81,
            80,
            230,
            230,
            135
    };

    private static Boolean[] isFull = new Boolean[]{
            true,
            false,
            false,
            false,
            false,
            true,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            true,
            false
    };


    /**
     *
     * Generation of our Data
     *
     * @return model
     */
    public static FlightModel initiateData() {
        FlightModel model = new FlightModel();
        for (Flight flight : generateFlights(12)) {
            model.addFlight(flight);
        }
        return model;
    }

    public static Flight[] generateFlights(int numberOfFlights) {
        Flight[] flights = new Flight[numberOfFlights];
        for (int i = 0; i < numberOfFlights; i++) {
            flights[i] = new Flight(
                    flightNumber[i],
                    startTime[i],
                    startAirport[i],
                    endTime[i],
                    endAirport[i],
                    terminal[i],
                    gate[i],
                    seat[i],
                    airplaneType[i],
                    airline[i],
                    price[i],
                    isFull[i]);
        }
        return flights;
    }

}


