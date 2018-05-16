package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SearchEngine.Filter;

import javax.swing.JTextField;
import javax.swing.JTable;

import Data.FlightData;
import Model.FlightModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField input;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("Welcome to FlightApp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSeeSaftyVideo = new JButton("See Safty Video");
		btnSeeSaftyVideo.setBounds(715, 10, 130, 23);
		contentPane.add(btnSeeSaftyVideo);
		
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
		
		FlightModel model = FlightData.initiateData();
		
		table = new JTable(model);
		table.setBounds(10, 42, 835, 373);
		contentPane.add(table);
		
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
		
	}
}
