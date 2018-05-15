package Flight;

public class Flight{
    private String name;
    private String flightFrom;
    private String flightTo;
    private int hours;
    private int price;
    private boolean isFull;

//konstruktor
    public Flight( String name, String flightFrom, String flightTo, int hours, int price, boolean isFull ) {
        this.name = name;
        this.flightFrom = flightFrom;
        this.flightTo = flightTo;
        this.hours = hours;
        this.price = price;
        this.isFull = isFull;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlightFrom() {
        return flightFrom;
    }

    public void setFlightFrom(String flightFrom) {
        this.flightFrom = flightFrom;
    }

    public String getFlightTo() {
        return flightTo;
    }

    public void setFlightTo(String flightTo) {
        this.flightTo = flightTo;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
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