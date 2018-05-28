package Data;

public class Flight{

    private final String flightNumber;
    private final String startTime;
    private final String startAirport;
    private final String endTime;
    private final String endAirport;
    private final String terminal;
    private final int gate;
    private final String seat;
    private final String airplaneType;
    private final String airline;
    private final int price;
    private final boolean isFull;

    /**
     *
     * Construktor
     *
     * @param flightNumber
     * @param startTime
     * @param startAirport
     * @param endTime
     * @param endAirport
     * @param terminal
     * @param gate
     * @param seat
     * @param airplaneType
     * @param airline
     * @param price
     * @param isFull
     */
    private Flight(String flightNumber, String startTime, String startAirport, String endTime, String endAirport, String terminal, int gate, String seat, String airplaneType, String airline, int price, boolean isFull) {
        this.flightNumber = flightNumber;
        this.startTime = startTime;
        this.startAirport = startAirport;
        this.endTime = endTime;
        this.endAirport = endAirport;
        this.terminal = terminal;
        this.gate = gate;
        this.seat = seat;
        this.airplaneType = airplaneType;
        this.airline = airline;
        this.price = price;
        this.isFull = isFull;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getStartAirport() {
        return startAirport;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getEndAirport() {
        return endAirport;
    }

    public String getTerminal() {
        return terminal;
    }

    public int getGate() {
        return gate;
    }

    public String getSeat() {
        return seat;
    }

    public String getAirplaneType() {
        return airplaneType;
    }

    public String getAirline() {
        return airline;
    }

    public int getPrice() {
        return price;
    }

    public boolean isFull() {
        return isFull;
    }
}