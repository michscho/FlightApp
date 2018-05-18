package Main;

import Data.FlightData;
import Model.FlightModel;
import SearchEngine.Filter;
import UI.MainFrame;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main( String[] args ){

        FlightModel model = FlightData.initiateData();

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame frame = new MainFrame(model);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}