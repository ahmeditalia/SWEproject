package src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.util.*;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class ShowPViews {

	private JFrame frame;
	StoreUI storeGui;
	private JTable table;
	/**
	 * Launch the application.
	 */
	ShowPViews(StoreUI Sgui){
		storeGui =  Sgui;
		initialize();
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowPViews window = new ShowPViews();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShowPViews() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 355);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(69, 23, 282, 282);
		frame.getContentPane().add(scrollPane);
		Object[] columnsnames = {  "Product Name","#Views"};
		table = new JTable(new DefaultTableModel(new Object[][] {}, columnsnames));
		scrollPane.setViewportView(table);
		scrollPane.setViewportView(table);
		List<String>s= new ArrayList<>();
		DefaultTableModel model = new DefaultTableModel() ;
		table.setModel(model);
		model.setColumnIdentifiers(columnsnames);
	
		
	}
}
