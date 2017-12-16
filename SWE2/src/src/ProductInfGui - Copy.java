package src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductForm {

	private JFrame frame;
	private JTextField txtID;
	private JTextField txtEnterName;
	private JTextField txtPrice;
	private JTextField txtQuantity;
	StoreUI storeGUI= new StoreUI();
	ProductForm(StoreUI storeUI, boolean addOrSuggest){
		this.storeGUI= storeUI;
		initialize(addOrSuggest);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductForm window = new ProductForm();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public ProductForm() {
		initialize(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(boolean addOrSuggest) {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 454, 388);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblProductName = new JLabel("Name :");
		lblProductName.setBounds(36, 68, 74, 14);
		frame.getContentPane().add(lblProductName);
		
		JLabel lblProductId = new JLabel(" ID :");
		lblProductId.setBounds(36, 34, 46, 14);
		frame.getContentPane().add(lblProductId);
		
		JLabel lblPrice = new JLabel("Price :");
		lblPrice.setBounds(36, 170, 46, 14);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblCategory = new JLabel("Category :");
		lblCategory.setBounds(36, 96, 57, 14);
		frame.getContentPane().add(lblCategory);
		
		JLabel lblBrand = new JLabel("Brand :");
		lblBrand.setBounds(36, 135, 46, 14);
		frame.getContentPane().add(lblBrand);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(36, 198, 46, 14);
		frame.getContentPane().add(lblQuantity);
		
		txtID = new JTextField();
		txtID.setText("enter ID");
		txtID.setBounds(120, 27, 209, 20);
		frame.getContentPane().add(txtID);
		txtID.setColumns(10);
		
		txtEnterName = new JTextField();
		txtEnterName.setText("enter Name");
		txtEnterName.setBounds(120, 61, 209, 20);
		frame.getContentPane().add(txtEnterName);
		txtEnterName.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setText("0");
		txtPrice.setBounds(120, 163, 209, 20);
		frame.getContentPane().add(txtPrice);
		txtPrice.setColumns(10);
		
		txtQuantity = new JTextField();
		txtQuantity.setText("0");
		txtQuantity.setBounds(120, 195, 209, 20);
		frame.getContentPane().add(txtQuantity);
		txtQuantity.setColumns(10);
		
		JComboBox<String> Categories = new JComboBox<String>();
		Categories.setBounds(120, 93, 209, 17);
		frame.getContentPane().add(Categories);
		for(int i=0;i<storeGUI.getStoreUIController().getCategoriesNames().size();i++){
			Categories.addItem(storeGUI.getStoreUIController().getCategoriesNames().get(i));
		}
		JComboBox<String> Brands = new JComboBox<String>();
		Brands.setBounds(120, 132, 209, 20);
		frame.getContentPane().add(Brands);
		for(int i=0;i<storeGUI.getStoreUIController().getBrandsNames().size();i++){
			Brands.addItem(storeGUI.getStoreUIController().getBrandsNames().get(i));
		}
		JButton btnAddProduct = new JButton("Add product");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storeGUI.getStoreUIController().AddProduct(txtID.getText(),txtEnterName.getText(), Float.parseFloat(txtPrice.getText())
						, Integer.parseInt(txtQuantity.getText()), Categories.getSelectedItem().toString(), Brands.getSelectedItem().toString());
			
				frame.setVisible(false);
			}
		});
		btnAddProduct.setBounds(160, 261, 123, 23);
		frame.getContentPane().add(btnAddProduct);
		
		JButton btnSugestProduct = new JButton("Suggest Product");
		btnSugestProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storeGUI.getStoreUIController().SuggestProduct(txtEnterName.getText(), Categories.getSelectedItem().toString(), Brands.getSelectedItem().toString());
			
				
			}
		});
		btnSugestProduct.setBounds(160, 226, 111, 23);
		frame.getContentPane().add(btnSugestProduct);
		btnAddProduct.setVisible(addOrSuggest);
		txtPrice.setVisible(addOrSuggest);
		txtQuantity.setVisible(addOrSuggest);
		txtID.setVisible(addOrSuggest);
		lblProductId.setVisible(addOrSuggest);
		lblQuantity.setVisible(addOrSuggest);
		lblPrice.setVisible(addOrSuggest);
		btnSugestProduct.setVisible(!addOrSuggest);
		
	
	}
}