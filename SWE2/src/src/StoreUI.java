package src;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.annotation.processing.Messager;
import javax.sound.midi.ShortMessage;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.xml.ws.handler.MessageContext;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class StoreUI {
	private JFrame frame;
	private JTextField txtGetstorename;
	private	StoreUIController sotreController;
	private HomePage homeGUI;
	StoreUI(StoreOwner user,HomePage home){
		sotreController= new StoreUIController(user);
		homeGUI= home;
		initialize();
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

	public JFrame getFrame(){
		return frame;
	}
	 private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 520, 404);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JButton btnAddSotre = new JButton("Add sotre");
		btnAddSotre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sotreController.addNewStore(txtGetstorename.getText());
				frame.setVisible(false);
				initialize();
			}
		});
		
		btnAddSotre.setBounds(32, 96, 272, 23);
		frame.getContentPane().add(btnAddSotre);
		JComboBox<String> StoreList = new JComboBox<String>();
		for(Store s:sotreController.getCurrentUser().getOwnedStores() ){
			StoreList.addItem(s.getStoreName());
		}
		StoreList.setBounds(324, 144, 143, 22);
		frame.getContentPane().add(StoreList);
		JButton btnAddProduct = new JButton("Add product to store");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sotreController.setCurrentStore(StoreList.getSelectedItem().toString());
				frame.setVisible(false);
				ProductForm pForm = new  ProductForm(StoreUI.this,true);
				}
		});
		btnAddProduct.setBounds(32, 143, 272, 23);
		frame.getContentPane().add(btnAddProduct);
		
		JButton btnSugestProduct = new JButton("Sugest product");
		btnSugestProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ProductForm pForm = new  ProductForm(StoreUI.this,false);
				
			}
		});
		btnSugestProduct.setBounds(32, 291, 272, 23);
		frame.getContentPane().add(btnSugestProduct);
		
		JButton btnOExploreNumber = new JButton("Get number of products views");
		btnOExploreNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sotreController.setCurrentStore(StoreList.getSelectedItem().toString());
				frame.setVisible(false);
				ShowPViews pViews= new ShowPViews(StoreUI.this);
				
			}
		});
		btnOExploreNumber.setBounds(32, 188, 272, 23);
		frame.getContentPane().add(btnOExploreNumber);
		
		JButton btnOGetThe = new JButton("Get the most viewed product ");
		btnOGetThe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sotreController.setCurrentStore(StoreList.getSelectedItem().toString());
				ProductInfGui pGui= new ProductInfGui(sotreController.getCurrentStore().getMostViewedP(),true);
			}
		});
		btnOGetThe.setBounds(32, 239, 272, 23);
		frame.getContentPane().add(btnOGetThe);
		
		txtGetstorename = new JTextField();		
		txtGetstorename.setBounds(324, 97, 143, 20);
		frame.getContentPane().add(txtGetstorename);
		txtGetstorename.setColumns(10);
		
		JComboBox<String> comboNumViews = new JComboBox<String>();
		comboNumViews.setBounds(324, 189, 143, 20);
		frame.getContentPane().add(comboNumViews);
		for(Store s:sotreController.getCurrentUser().getOwnedStores() ){
			comboNumViews.addItem(s.getStoreName());
		}
		
		JComboBox<String> comboMostViewed = new JComboBox<String>();
		comboMostViewed.setBounds(324, 240, 143, 20);
		frame.getContentPane().add(comboMostViewed);
		for(Store s:sotreController.getCurrentUser().getOwnedStores() ){
			comboMostViewed.addItem(s.getStoreName());
		}
		
		JButton btnHomePage = new JButton("Home Page");
		btnHomePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homeGUI.getFrmHomepage().setVisible(true);
				frame.setVisible(false);
			}
		});
		btnHomePage.setBounds(32, 35, 122, 23);
		frame.getContentPane().add(btnHomePage);
		
	}
}
