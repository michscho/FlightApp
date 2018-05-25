package Flight;

public class Flight{

    private String flightNumber;
   private String startTime;
   private String startAirport;
   private String endTime;
   private String endAirport;
   private String terminal;
   private int gate;
   private String seat;
   private String airplaneType;
   private String airline;
   private int price;
   private boolean isFull;

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
    public Flight(String flightNumber, String startTime, String startAirport, String endTime, String endAirport, String terminal, int gate, String seat, String airplaneType, String airline, int price, boolean isFull) {
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

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStartAirport() {
        return startAirport;
    }

    public void setStartAirport(String startAirport) {
        this.startAirport = startAirport;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getEndAirport() {
        return endAirport;
    }

    public void setEndAirport(String endAirport) {
        this.endAirport = endAirport;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public int getGate() {
        return gate;
    }

    public void setGate(int gate) {
        this.gate = gate;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(String airplaneType) {
        this.airplaneType = airplaneType;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }
}