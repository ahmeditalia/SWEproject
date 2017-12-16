package src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductForm {

	private JFrame frame;
	private JTextField txtPrice;
	private JTextField txtQuantity;
	StoreUI storeGUI;
	private JTextField SuggestedPName;
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
		initialize(true);
	}

	
	private void initialize(boolean addOrSuggest) {
		frame = new JFrame();
		frame.setBounds(100, 100, 454, 388);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JLabel lblProductName = new JLabel("Name :");
		lblProductName.setBounds(36, 54, 74, 14);
		frame.getContentPane().add(lblProductName);
		
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
		JComboBox<String> productName = new JComboBox<String>();
		for(Product p: storeGUI.getStoreUIController().GetSystemProducts()){
			productName.addItem(p.getName());
		}
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
				
				storeGUI.getStoreUIController().AddProduct(productName.getSelectedItem().toString(), Float.parseFloat(txtPrice.getText())
						, Integer.parseInt(txtQuantity.getText()), Categories.getSelectedItem().toString(), Brands.getSelectedItem().toString());
				JOptionPane.showMessageDialog(null, "succsesfully added product ..");
			}
		});
		btnAddProduct.setBounds(160, 261, 123, 23);
		frame.getContentPane().add(btnAddProduct);
		
		JButton btnSugestProduct = new JButton("Suggest Product");
		btnSugestProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storeGUI.getStoreUIController().SuggestProduct(SuggestedPName.getText(), Categories.getSelectedItem().toString(), Brands.getSelectedItem().toString());		
				JOptionPane.showMessageDialog(null, "succsesfully suggested product ..");
			}
		});
		btnSugestProduct.setBounds(160, 226, 111, 23);
		frame.getContentPane().add(btnSugestProduct);
		JButton btnStorePage = new JButton("Store Page");
		btnStorePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storeGUI.getFrame().setVisible(true);
				frame.setVisible(false);
			}
		});
		btnStorePage.setBounds(21, 315, 123, 23);
		frame.getContentPane().add(btnStorePage);
		
		
		productName.setBounds(120, 51, 209, 20);
		frame.getContentPane().add(productName);
		
		SuggestedPName = new JTextField();
		SuggestedPName.setBounds(120, 51, 209, 20);
		frame.getContentPane().add(SuggestedPName);
		SuggestedPName.setColumns(10);
		btnAddProduct.setVisible(addOrSuggest);
		productName.setVisible(addOrSuggest);
		txtPrice.setVisible(addOrSuggest);
		txtQuantity.setVisible(addOrSuggest);
		lblQuantity.setVisible(addOrSuggest);
		lblPrice.setVisible(addOrSuggest);
		btnSugestProduct.setVisible(!addOrSuggest);	
		SuggestedPName.setVisible(!addOrSuggest);
	}
}