package Model;

import Flight.Flight;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

// this class creates a custom JTable Model
public class FlightModel implements TableModel {

    private List<TableModelListener> listeners = new ArrayList<TableModelListener>();

    // datamodel
    private List<Flight> flights = new ArrayList<Flight>();

    public void addTableModelListener( TableModelListener l ) {
        listeners.add( l );
    }

    public void removeTableModelListener( TableModelListener l ) {
        listeners.remove( l );
    }

    // add Flight
    public void addFlight( Flight flight ){
        int row = flights.size();
        flights.add(flight);

        TableModelEvent event = new TableModelEvent( this, row, row,
                TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT );
        for( TableModelListener listener : listeners )
            listener.tableChanged( event );
    }

    public int getColumnCount() {
        return 12;
    }

    public int getRowCount() {
        return flights.size();
    }

    public String getColumnName( int columnIndex ) {
        switch( columnIndex ){
            case 0: return "Flight Number";
            case 1: return "Start time";
            case 2: return "Start Airport";
            case 3: return "End Time";
            case 4: return "End Airport";
            case 5: return "Terminal";
            case 6: return "Gate";
            case 7: return "Seat";
            case 8: return "Airplane Type";
            case 9: return "Airline";
            case 10: return "Price";
            case 11: return "Flight is Full?";
            default: throw new IllegalArgumentException( "Wrong column" );
        }
    }

    public boolean isCellEditable( int rowIndex, int columnIndex ) {
        return false;
    }

    public Object getValueAt( int rowIndex, int columnIndex ) {
        Flight flight = flights.get( rowIndex );
        switch( columnIndex ){
            case 0: return flight.getFlightNumber();
            case 1: return flight.getStartTime();
            case 2: return flight.getStartAirport();
            case 3: return flight.getEndTime();
            case 4: return flight.getEndAirport();
            case 5: return flight.getTerminal();
            case 6: return Integer.valueOf(flight.getGate());
            case 7: return flight.getSeat();
            case 8: return flight.getAirplaneType();
            case 9: return flight.getAirline();
            case 10: return Integer.valueOf( flight.getPrice() );
            case 11: return Boolean.valueOf( flight.isFull() );
            default: throw new IllegalArgumentException( "Wrong column" );
        }
    }

    public void setValueAt( Object aValue, int rowIndex, int columnIndex ) {
        Flight flight = flights.get( rowIndex );
        switch( columnIndex ){
            case 0:
                flight.setFlightNumber((String)aValue );
                break;
            case 1:
                flight.setStartTime((String)aValue );
                break;
            case 2:
                flight.setStartAirport((String)aValue );
                break;
            case 3:
                flight.setEndTime((String)aValue );
                break;
            case 4:
                flight.setEndAirport((String)aValue );
                break;
            case 5:
                flight.setTerminal((String)aValue );
                break;
            case 6:
                flight.setGate(((Integer)aValue).intValue() );
                break;
            case 7:
                flight.setSeat((String)aValue );
                break;
            case 8:
                flight.setAirplaneType((String)aValue );
                break;
            case 9:
                flight.setAirline((String)aValue );
                break;
            case 10:
                flight.setPrice(((Integer)aValue).intValue() );
                break;
            case 11:
                flight.setFull(((Boolean)aValue).booleanValue() );
                break;
            default:
                throw new IllegalArgumentException( "Wrong column" );
        }
        TableModelEvent event = new TableModelEvent(
                this, rowIndex, rowIndex, columnIndex, TableModelEvent.UPDATE );
        for( TableModelListener listener : listeners )
            listener.tableChanged( event );
    }


    public Class<?> getColumnClass( int columnIndex ) {
        switch( columnIndex ){
            case 0: return String.class;
            case 1: return String.class;
            case 2: return String.class;
            case 3: return String.class;
            case 4: return String.class;
            case 5: return String.class;
            case 6: return Integer.class;
            case 7: return String.class;
            case 8: return String.class;
            case 9: return String.class;
            case 10: return Integer.class;
            case 11: return Boolean.class;
            default: throw new IllegalArgumentException( "Wrong column" );
        }
    }
}