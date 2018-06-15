package main.java.Data.Classes;

import javafx.beans.property.*;

public class Flight{

    private StringProperty flightNumberC;
    private StringProperty startTimeC;
    private StringProperty startAirportC;
    private StringProperty endTimeC;
    private StringProperty endAirportC;
    private StringProperty terminalC;
    private IntegerProperty gateC;
    private StringProperty seatC;
    private StringProperty airplaneTypeC;
    private StringProperty airlineC;
    private IntegerProperty priceC;
    private BooleanProperty isFullC;

/**
 *
 * Construktor
 *
 * @param flightNumberC
 * @param startTimeC
 * @param startAirportC
 * @param endTimeC
 * @param endAirportC
 * @param terminalC
 * @param gateC
 * @param seatC
 * @param airplaneTypeC
 * @param airlineC
 * @param priceC
 * @param isFullC
 */

public Flight(String flightNumberC, String startTimeC, String startAirportC, String endTimeC, String endAirportC, String terminalC, int gateC, String seatC, String airplaneTypeC, String airlineC, int priceC, boolean isFullC) {
    this.flightNumberC = new SimpleStringProperty(flightNumberC);
    this.startTimeC = new SimpleStringProperty(startTimeC);
    this.startAirportC = new SimpleStringProperty(startAirportC);
    this.endTimeC = new SimpleStringProperty(endTimeC);
    this.endAirportC = new SimpleStringProperty(endAirportC);
    this.terminalC = new SimpleStringProperty(terminalC);
    this.gateC = new SimpleIntegerProperty(gateC);
    this.seatC = new SimpleStringProperty(seatC);
    this.airplaneTypeC = new SimpleStringProperty(airplaneTypeC);
    this.airlineC = new SimpleStringProperty(airlineC);
    this.priceC = new SimpleIntegerProperty(priceC);
    this.isFullC = new SimpleBooleanProperty(isFullC);
}

    public String getFlightNumberC() {
        return flightNumberC.get();
    }


    public void setFlightNumberC(String flightNumberC) {
        this.flightNumberC.set(flightNumberC);
    }

    public String getStartTimeC() {
        return startTimeC.get();
    }

    public void setStartTimeC(String startTimeC) {
        this.startTimeC.set(startTimeC);
    }

    public String getStartAirportC() {
        return startAirportC.get();
    }


    public void setStartAirportC(String startAirportC) {
        this.startAirportC.set(startAirportC);
    }

    public String getEndTimeC() {
        return endTimeC.get();
    }


    public void setEndTimeC(String endTimeC) {
        this.endTimeC.set(endTimeC);
    }

    public String getEndAirportC() {
        return endAirportC.get();
    }


    public void setEndAirportC(String endAirportC) {
        this.endAirportC.set(endAirportC);
    }

    public String getTerminalC() {
        return terminalC.get();
    }


    public void setTerminalC(String terminalC) {
        this.terminalC.set(terminalC);
    }

    public int getGateC() {
        return gateC.get();
    }


    public void setGateC(int gateC) {
        this.gateC.set(gateC);
    }

    public String getSeatC() {
        return seatC.get();
    }


    public void setSeatC(String seatC) {
        this.seatC.set(seatC);
    }

    public String getAirplaneTypeC() {
        return airplaneTypeC.get();
    }

    public void setAirplaneTypeC(String airplaneTypeC) {
        this.airplaneTypeC.set(airplaneTypeC);
    }

    public String getAirlineC() {
        return airlineC.get();
    }



    public void setAirlineC(String airlineC) {
        this.airlineC.set(airlineC);
    }

    public int getPriceC() {
        return priceC.get();
    }



    public void setPriceC(int priceC) {
        this.priceC.set(priceC);
    }

    public boolean isIsFullC() {
        return isFullC.get();
    }


    public void setIsFullC(boolean isFullC) {
        this.isFullC.set(isFullC);
    }
}