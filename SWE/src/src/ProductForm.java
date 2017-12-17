package src;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class ProductForm {

	private JFrame frame;
	private JTextField txtPrice;
	private JTextField txtQuantity;
	StoreUI storeGUI;
	private JTextField SuggestedPName;
	private List<Product> products=new ArrayList<>();
	
	/**
	 * @wbp.parser.constructor
	 */
	ProductForm(StoreUI storeUI, boolean addOrSuggest){
		this.storeGUI= storeUI;
		initialize(addOrSuggest);
	}
	
	/**
	 * Create the application.
	 */
	public ProductForm() {
		initialize(true);
	}

	
	private void initialize(boolean addOrSuggest) {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(255, 153, 153));
		frame.getContentPane().setBackground(new Color(178, 34, 34));
		frame.setBounds(100, 100, 454, 388);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		JLabel lblProductName = new JLabel("Name :");
		lblProductName.setForeground(new Color(255, 153, 153));
		lblProductName.setBounds(498, 355, 74, 14);
		frame.getContentPane().add(lblProductName);
		
		JLabel lblPrice = new JLabel("Price :");
		lblPrice.setForeground(new Color(255, 153, 153));
		lblPrice.setBounds(498, 407, 46, 14);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblCategory = new JLabel("Category :");
		lblCategory.setForeground(new Color(255, 153, 153));
		lblCategory.setBounds(498, 291, 57, 14);
		frame.getContentPane().add(lblCategory);
		
		JLabel lblBrand = new JLabel("Brand :");
		lblBrand.setForeground(new Color(255, 153, 153));
		lblBrand.setBounds(498, 324, 46, 14);
		frame.getContentPane().add(lblBrand);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setForeground(new Color(255, 153, 153));
		lblQuantity.setBounds(498, 435, 46, 14);
		frame.getContentPane().add(lblQuantity);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(582, 400, 209, 20);
		frame.getContentPane().add(txtPrice);
		txtPrice.setColumns(10);
		
		txtQuantity = new JTextField();
		txtQuantity.setBounds(582, 432, 209, 20);
		frame.getContentPane().add(txtQuantity);
		txtQuantity.setColumns(10);

		JComboBox<String> Categories = new JComboBox<String>();
		Categories.setBounds(582, 288, 209, 17);
		frame.getContentPane().add(Categories);
		Categories.addItem("select category");
		for(int i=0;i<storeGUI.getStoreUIController().getCategoriesNames().size();i++){
			Categories.addItem(storeGUI.getStoreUIController().getCategoriesNames().get(i));
		}
		JComboBox<String> Brands = new JComboBox<String>();
		Brands.setBounds(582, 321, 209, 20);
		frame.getContentPane().add(Brands);
		Brands.addItem("");
		for(int i=0;i<storeGUI.getStoreUIController().getBrandsNames().size();i++){
			Brands.addItem(storeGUI.getStoreUIController().getBrandsNames().get(i));
		}
		
		JComboBox<String> productName = new JComboBox<String>();
		productName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(productName.getSelectedItem()!="")
				{	Categories.setSelectedItem(products.get(productName.getSelectedIndex()-1).getCategory());
					Brands.setSelectedItem(products.get(productName.getSelectedIndex()-1).getBrand());
				}
			}
		});
		products=storeGUI.getStoreUIController().GetSystemProducts();
		productName.addItem("");
		for(Product p: products){
			productName.addItem(p.getName());
		}
		
		
		JButton btnAddProduct = new JButton("Add product");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtQuantity.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "enter the quantity !!");

				}
				else if (txtPrice.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "enter the price !!");

				}else{
				storeGUI.getStoreUIController().AddProduct(productName.getSelectedItem().toString(), Float.parseFloat(txtPrice.getText())
						, Integer.parseInt(txtQuantity.getText()), Categories.getSelectedItem().toString(), Brands.getSelectedItem().toString());
				JOptionPane.showMessageDialog(null, "succsesfully added product ..");
				}
			}
		});
		btnAddProduct.setBounds(622, 498, 123, 23);
		frame.getContentPane().add(btnAddProduct);
		
		JButton btnSugestProduct = new JButton("Suggest Product");
		btnSugestProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (SuggestedPName.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Enter the product name");
				}else{
				storeGUI.getStoreUIController().SuggestProduct(SuggestedPName.getText(), Categories.getSelectedItem().toString(), Brands.getSelectedItem().toString());		
				JOptionPane.showMessageDialog(null, "succsesfully suggested product ..");
				}
			}
		});
		btnSugestProduct.setBounds(622, 463, 111, 23);
		frame.getContentPane().add(btnSugestProduct);
		JButton btnStorePage = new JButton("Back to store");
		btnStorePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		
		btnStorePage.setBounds(498, 245, 111, 23);
		frame.getContentPane().add(btnStorePage);
		productName.setBounds(582, 352, 209, 20);
		frame.getContentPane().add(productName);
		SuggestedPName = new JTextField();
		SuggestedPName.setBounds(582, 352, 209, 20);
		frame.getContentPane().add(SuggestedPName);
		SuggestedPName.setColumns(10);
		
		JLabel lblEnterProductInformation = new JLabel("                               Enter product information");
		lblEnterProductInformation.setVerticalAlignment(SwingConstants.TOP);
		lblEnterProductInformation.setBackground(new Color(255, 153, 153));
		lblEnterProductInformation.setForeground(Color.BLACK);
		lblEnterProductInformation.setBounds(396, 132, 458, 467);
		frame.getContentPane().add(lblEnterProductInformation);
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