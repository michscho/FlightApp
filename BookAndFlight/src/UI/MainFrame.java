package UI;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import SearchEngine.Filter;

import Model.FlightModel;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import javafx.scene.control.DatePicker;

import java.awt.Desktop;

import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainFrame extends JFrame {

    private JPanel contentPane;
    private JTextField input;

    /**
     * Creation flow
     */
    public MainFrame(FlightModel model) {
        createJFrame();
        createJPanel();
        createButtons();
        JTable table = createTable(model);
        createFilterButtons(table, model);
        FlightFrame flightFrame = new FlightFrame(table, model);
    }


    /**
     * Creation of JTable
     */
    public JTable createTable(FlightModel model) {
        JTable table = new JTable(model);
        contentPane.add(new JScrollPane(table)).setBounds(10, 42, 835, 373);
        return table;
    }

    /**
     * Configuration of JFrame
     */
    public void createJFrame() {
        setTitle("Welcome to FlightApp");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 871, 530);
        ImageIcon icon = new ImageIcon(System.getProperty("user.dir").concat("/res/flightIcon.jpg").replace('\\', '/'));
        setIconImage(icon.getImage());
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    /**
     * Configuration of JPanel
     */
    public void createJPanel() {
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
    }

    /**
     * Buttons will be created here
     */
    public void createButtons() {

        // Button to Saftey Video
        JButton btnSeeSaftyVideo = new JButton("See Safty Video");
        btnSeeSaftyVideo.setBounds(715, 10, 130, 23);
        contentPane.add(btnSeeSaftyVideo);
        btnSeeSaftyVideo.addActionListener(e -> goWebsite(btnSeeSaftyVideo));

        // Quit Button
        JButton btnQuit = new JButton("Quit");
        btnQuit.addActionListener(e -> System.exit(0));
        btnQuit.setForeground(Color.RED);
        btnQuit.setBounds(756, 445, 89, 23);
        contentPane.add(btnQuit);
    }

    private void goWebsite(JButton btnSeeSaftyVideo) {
        btnSeeSaftyVideo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=QjkreLh24y4"));
                } catch (URISyntaxException | IOException ex) {
                    //It looks like there's a problem
                }
            }

        });
    }

    /**
     * Creation of FilterButtons
     *
     * @param table
     * @param model
     */
    public void createFilterButtons(JTable table, FlightModel model) {
        Filter filter = new Filter(model, table);
        filter.filter("");

        // Input Textfield
        input = new JTextField();
        input.setBounds(10, 11, 86, 20);
        contentPane.add(input);
        input.setColumns(10);


        // JComboBox
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Search all");
        for (int i = 0; i < 12; i++) {
            comboBox.addItem(model.getColumnName(i));
        }
        comboBox.setBounds(106, 10, 89, 23);
        contentPane.add(comboBox);

        // JCalender
        JFrame frame = new JFrame();
        JCalendar calender = new JCalendar();
        comboBox.addActionListener(e -> {
            if (comboBox.getSelectedItem().equals("Start time") || comboBox.getSelectedItem().equals("End Time")) {
                // Date Chooser
                frame.setBounds(210, 165, 200, 200);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setUndecorated(true);
                calender.addPropertyChangeListener(evt -> {
                    Date date = calender.getDate();
                    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");
                    input.setText(dateFormatter.format(date));
                });
                frame.add(calender);
                frame.setAlwaysOnTop(true);
                frame.pack();
                frame.setVisible(true);
            } else {
                frame.remove(calender);
                frame.dispose();
            }
        });


        // search Button
        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(e -> {
            if (frame != null) {
                frame.remove(calender);
                frame.dispose();
            }
            if (comboBox.getSelectedItem().equals("Search all")) {
                filter.filter(input.getText());
            } else {
                filter.filter(input.getText(), comboBox.getSelectedIndex() - 1);
            }
            if (table.getRowCount() <= 0) {
                JOptionPane.showMessageDialog(contentPane,
                        "No matching content found.");
            }
        });
        btnSearch.setBounds(207, 10, 89, 23);
        contentPane.add(btnSearch);

        // reset Button
        JButton btnReset = new JButton("Reset");

        btnReset.addActionListener(e -> {
            frame.remove(calender);
            frame.dispose();
            filter.filter("");
            input.setText("");
            comboBox.setSelectedIndex(0);
        });
        btnReset.setBounds(308, 10, 89, 23);
        contentPane.add(btnReset);

    }


}
