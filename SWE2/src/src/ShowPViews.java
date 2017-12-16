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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 11, 301, 338);
		frame.getContentPane().add(scrollPane);
		Object[] columnsnames = {  "Product Name","#Views"};
		table = new JTable(new DefaultTableModel(new Object[][] {}, columnsnames));
		scrollPane.setViewportView(table);
		scrollPane.setViewportView(table);
		
		DefaultTableModel model = new DefaultTableModel() ;
		List<Product> storeProducts= storeGui.getStoreUIController().getCurrentStore().getStoreProducts();
		for(int i=0;i<storeProducts.size();i++){
			Object[] row={storeProducts.get(i).getName(),storeProducts.get(i).getViews()};
			model.addRow(row);
		}
		table.setModel(model);
		model.setColumnIdentifiers(columnsnames);
	
		
	}
}
