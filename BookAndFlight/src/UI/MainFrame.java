package UI;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import SearchEngine.Filter;

import Data.FlightData;
import Model.FlightModel;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField input;

	/**
	 * Create the frame.
	 */
	public MainFrame(FlightModel model) {

		createWindow();
	    createButtons();

	    // JTable
        JTable table = new JTable(model);

        contentPane.add(new JScrollPane(table)).setBounds(10, 42, 835, 373);

		createFilterButtons(table, model);
	}

	public void createWindow(){
		setTitle("Welcome to FlightApp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public void createButtons() {
		JButton btnSeeSaftyVideo = new JButton("See Safty Video");
		btnSeeSaftyVideo.setBounds(715, 10, 130, 23);
		contentPane.add(btnSeeSaftyVideo);
		btnSeeSaftyVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goWebsite(btnSeeSaftyVideo);
			}
		});
		

		JButton btnExport = new JButton("Export");
		btnExport.setBounds(10, 445, 89, 23);
		contentPane.add(btnExport);

		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
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

	public void createFilterButtons(JTable table, FlightModel model){
		Filter filter = new Filter(model, table);
		filter.filter("");

		input = new JTextField();
		input.setBounds(10, 11, 86, 20);
		contentPane.add(input);
		input.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(input.getText());
				filter.filter(input.getText());
			}
		});

		btnSearch.setBounds(106, 10, 89, 23);
		contentPane.add(btnSearch);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filter.filter("");
			}
		});
		btnReset.setBounds(207, 10, 89, 23);
		contentPane.add(btnReset);

	}



}
