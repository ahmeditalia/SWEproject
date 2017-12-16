package src;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class StoreUI {
	private JFrame frame;
	private JTextField txtGetstorename;
	private	StoreUIController sotreController = new StoreUIController();
	StoreUI(StoreOwner user){
		sotreController= new StoreUIController(user);
	}
	public StoreUIController getStoreUIController(){
		return sotreController;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
		
			public void run() {
				try {
					StoreUI window = new StoreUI();
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
	public StoreUI() {
		initialize();
	}

	
	 void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 514, 317);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAddSotre = new JButton("Add sotre");
		btnAddSotre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sotreController.addNewStore(txtGetstorename.getText());
			}
		});
		
		btnAddSotre.setBounds(28, 11, 272, 23);
		frame.getContentPane().add(btnAddSotre);
		JComboBox<String> StoreList = new JComboBox<String>();
		for(int i=0;i<sotreController.getCurrentUser().getStoresName().size();i++){
			StoreList.addItem(sotreController.getCurrentUser().getStoresName().get(i));
		
		}
		StoreList.setBounds(320, 59, 143, 22);
		frame.getContentPane().add(StoreList);
		JButton btnAddProduct = new JButton("Add product to store");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//sotreController.setCurrentStore(StoreList.getSelectedItem().toString());
				ProductForm pForm = new  ProductForm(StoreUI.this,true);
				frame.setVisible(false);
				}
		});
		btnAddProduct.setBounds(28, 58, 272, 23);
		frame.getContentPane().add(btnAddProduct);
		
		JButton btnSugestProduct = new JButton("Sugest product");
		btnSugestProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductForm pForm = new  ProductForm(StoreUI.this,false);
				frame.setVisible(false);
			}
		});
		btnSugestProduct.setBounds(28, 206, 272, 23);
		frame.getContentPane().add(btnSugestProduct);
		
		JButton btnOExploreNumber = new JButton("Get number of products views");
		btnOExploreNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowPViews pViews= new ShowPViews(StoreUI.this);
				
			}
		});
		btnOExploreNumber.setBounds(28, 103, 272, 23);
		frame.getContentPane().add(btnOExploreNumber);
		
		JButton btnOGetThe = new JButton("Get the most viewed product ");
		btnOGetThe.setBounds(28, 154, 272, 23);
		frame.getContentPane().add(btnOGetThe);
		
		txtGetstorename = new JTextField();		
		txtGetstorename.setBounds(320, 12, 143, 20);
		frame.getContentPane().add(txtGetstorename);
		txtGetstorename.setColumns(10);
		
		JComboBox<String> comboNumViews = new JComboBox<String>();
		comboNumViews.setBounds(320, 104, 143, 20);
		frame.getContentPane().add(comboNumViews);
		for(int i=0;i<sotreController.getCurrentUser().getStoresName().size();i++){
			comboNumViews.addItem(sotreController.getCurrentUser().getStoresName().get(i));
		
		}
		JComboBox<String> comboMostViewed = new JComboBox<String>();
		comboMostViewed.setBounds(320, 155, 143, 20);
		frame.getContentPane().add(comboMostViewed);
		for(int i=0;i<sotreController.getCurrentUser().getStoresName().size();i++){
			comboMostViewed.addItem(sotreController.getCurrentUser().getStoresName().get(i));
		
		}
	}
}
