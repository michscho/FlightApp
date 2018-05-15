package SearchEngine;

import Model.FlightModel;

import javax.swing.*;
import javax.swing.table.TableRowSorter;

public class Filter {
    private TableRowSorter sorter;
    private FlightModel model;

    public Filter(FlightModel model, JTable table) {
        this.sorter = new TableRowSorter<FlightModel>(model);
        this.model = model;
        table.setRowSorter(sorter);
    }

    // simple String filter
    public void filter(String query) {
sorter.setRowFilter(RowFilter.regexFilter(query));
}


}
