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
        return 6;
    }

    public int getRowCount() {
        return flights.size();
    }

    public String getColumnName( int columnIndex ) {
        switch( columnIndex ){
            case 0: return "Name";
            case 1: return "FlightFrom";
            case 2: return "FlightTo";
            case 3: return "Hours";
            case 4: return "Price";
            case 5: return "FlightIsFull";
            default: throw new IllegalArgumentException( "Wrong column" );
        }
    }

    public boolean isCellEditable( int rowIndex, int columnIndex ) {
        return false;
    }

    public Object getValueAt( int rowIndex, int columnIndex ) {
        Flight flight = flights.get( rowIndex );
        switch( columnIndex ){
            case 0: return flight.getName();
            case 1: return flight.getFlightFrom();
            case 2: return flight.getFlightTo();
            case 3: return Integer.valueOf( flight.getHours() );
            case 4: return Integer.valueOf( flight.getPrice() );
            case 5: return Boolean.valueOf( flight.isFull() );
            default: throw new IllegalArgumentException( "Wrong column" );
        }
    }

    public void setValueAt( Object aValue, int rowIndex, int columnIndex ) {
        Flight flight = flights.get( rowIndex );
        switch( columnIndex ){
            case 0:
                flight.setName( (String)aValue );
                break;
            case 1:
                flight.setFlightFrom( (String)aValue );
                break;
            case 2:
                flight.setFlightTo( (String)aValue );
                break;
            case 3:
                flight.setHours(((Integer)aValue).intValue() );
                break;
            case 4:
                flight.setPrice(((Integer)aValue).intValue() );
                break;
            case 5:
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
            case 3: return Integer.class;
            case 4: return Integer.class;
            case 5: return Boolean.class;
            default: throw new IllegalArgumentException( "Wrong column" );
        }
    }
}