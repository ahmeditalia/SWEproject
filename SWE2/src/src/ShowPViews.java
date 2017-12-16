package src;

import java.awt.EventQueue;

import javax.management.modelmbean.ModelMBean;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.util.*;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowPViews {

	private JFrame frame;
	StoreUI storeGui;
	private JTable table;
	private JButton btnStorePage;
	/**
	 * Launch the application.
	 */
	/**
	 * @wbp.parser.constructor
	 */
	ShowPViews(StoreUI Sgui){
		storeGui =  Sgui;
		initialize();
	}
	/*public static void main(String[] args) {
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
	}*/

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
		frame.setBounds(100, 100, 425, 399);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 42, 301, 338);
		frame.getContentPane().add(scrollPane);
		Object[] columnsnames = {  "Product Name","#Views"};
		table = new JTable();
		scrollPane.setViewportView(table);
		
		DefaultTableModel model = new DefaultTableModel() ;
		table.setModel(model);
		model.setColumnIdentifiers(columnsnames);

		List<Product> storeProducts= storeGui.getStoreUIController().getCurrentStore().getStoreProducts();
		for(Product p:storeProducts){
			Object[] row={p.getName(),p.getViews()};
			model.addRow(row);
		}
		

		btnStorePage = new JButton("Store page");
		btnStorePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				storeGui.getFrame().setVisible(true);
			}
		});
		btnStorePage.setBounds(21, 11, 89, 23);
		frame.getContentPane().add(btnStorePage);
		model.setColumnIdentifiers(columnsnames);
	
		
	}
}
