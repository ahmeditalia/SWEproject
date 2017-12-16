package src;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
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
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JSeparator;

public class StoreUI {
	private JFrame frame;
	private	StoreUIController sotreController = new StoreUIController();
	private HomePage homeGUI= new HomePage();
	private JTextField textField;
	/**
	 * @wbp.parser.constructor
	 */
	StoreUI(StoreOwner user,HomePage home){
		sotreController= new StoreUIController(user);
		homeGUI= home;
		initialize();
	}
	public StoreUIController getStoreUIController(){
		return sotreController;
	}
	
	public StoreUI() {
		initialize();
	}

	public JFrame getFrame(){
		return frame;
	}
	 private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setSize(1650, 1080);
		frame.setTitle("Register");
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setBounds(100, 100, 888, 493);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Store", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(245, 121, 844, 529);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton button = new JButton("Sugest product");
		button.setBounds(406, 21, 141, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Get the most viewed product ");
		button_1.setBounds(121, 310, 220, 23);
		panel.add(button_1);
		
		JComboBox<String> comboMostViewed = new JComboBox<String>();
		comboMostViewed.setBounds(361, 311, 143, 20);
		panel.add(comboMostViewed);
		
		JComboBox<String> comboNumViews = new JComboBox<String>();
		comboNumViews.setBounds(361, 260, 143, 20);
		panel.add(comboNumViews);
		
		JButton button_2 = new JButton("Get number of products views");
		button_2.setBounds(121, 259, 220, 23);
		panel.add(button_2);
		
		JButton button_3 = new JButton("Add product to store");
		button_3.setBounds(406, 124, 141, 23);
		panel.add(button_3);
		
		JComboBox<String> StoreList = new JComboBox<String>();
		StoreList.setBounds(404, 92, 143, 22);
		panel.add(StoreList);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(20, 93, 186, 20);
		panel.add(textField);
		
		JButton button_4 = new JButton("Add sotre");
		button_4.setBounds(20, 124, 186, 23);
		panel.add(button_4);
		
		JButton button_5 = new JButton("Home Page");
		button_5.setBounds(87, 21, 141, 23);
		panel.add(button_5);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 55, 579, 2);
		panel.add(separator);
		
		JLabel lblStoreName = new JLabel("Store Name :");
		lblStoreName.setBounds(20, 68, 111, 14);
		panel.add(lblStoreName);
		for(int i=0;i<sotreController.getCurrentUser().getStoresName().size();i++){
			StoreList.addItem(sotreController.getCurrentUser().getStoresName().get(i));
		
		}
		for(int i=0;i<sotreController.getCurrentUser().getStoresName().size();i++){
			comboNumViews.addItem(sotreController.getCurrentUser().getStoresName().get(i));
		
		}
		
		
		for(int i=0;i<sotreController.getCurrentUser().getStoresName().size();i++){
			comboMostViewed.addItem(sotreController.getCurrentUser().getStoresName().get(i));
		
		}
	}
}
