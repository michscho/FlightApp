package Main;

import Data.FlightData;
import Model.FlightModel;
import SearchEngine.Filter;

import javax.swing.*;

public class Main {
    public static void main( String[] args ){

        //getting Data
        FlightModel model = FlightData.initiateData();

        //initiate Classes
        JTable table = new JTable(model);
        Filter filter = new Filter(model, table);
        filter.filter("");

        //getting jFrame
        JFrame frame = new JFrame( "BookAndFlight" );
        frame.getContentPane().add( new JScrollPane( table ) );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.pack();
        frame.setVisible( true );
    }
}