package UI;

import Model.FlightModel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FlightFrame {

   private JTable table;
   private FlightModel model;

   public FlightFrame(JTable table, FlightModel model, JPanel contentFrame){
       this.table = table;
       this.model = model;
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                getColumnValues();
            }
        });
   }


   public void getColumnValues() {
       int index = table.getSelectedRow();
           for (int i = 0; i < 11; i++) {
               System.out.println(model.getValueAt(index, i).toString());
           }
       }
   }