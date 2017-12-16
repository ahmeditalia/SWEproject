package src;

<<<<<<< HEAD
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
=======

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
>>>>>>> 80ae83157e0116ef97d88d886e56bdd2c24d06ee
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductForm {

	private JFrame frame;
<<<<<<< HEAD
	private JTextField txtID;
	private JTextField txtEnterName;
	private JTextField txtPrice;
	private JTextField txtQuantity;
	StoreUI storeGUI= new StoreUI();
	ProductForm(StoreUI storeUI){
		this.storeGUI= storeUI;
		initialize();
	}
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductForm window = new ProductForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

=======
	private JTextField name;
	private JTextField id;
	private JTextField price;
	private JTextField quantity;
	private JTextField category;
	private JTextField brand;
	private JTextField store;
	private JTextField viewsnubmer;
	private boolean view;
	private Product product;
	
	/**
	 * @wbp.parser.constructor
	 */
	public ProductForm(Product product,boolean view) {
		this.product = product;
		this.view = view;
		initialize();
	}
>>>>>>> 80ae83157e0116ef97d88d886e56bdd2c24d06ee
	/**
	 * Create the application.
	 */
	public ProductForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
<<<<<<< HEAD
		frame.setBounds(100, 100, 454, 388);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblProductName = new JLabel("Name :");
		lblProductName.setBounds(36, 68, 74, 14);
		frame.getContentPane().add(lblProductName);
		
		JLabel lblProductId = new JLabel(" ID :");
		lblProductId.setBounds(36, 34, 46, 14);
		frame.getContentPane().add(lblProductId);
		
		JLabel lblNewLabel = new JLabel("Price :");
		lblNewLabel.setBounds(36, 100, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCategory = new JLabel("Category :");
		lblCategory.setBounds(36, 159, 57, 14);
		frame.getContentPane().add(lblCategory);
		
		JLabel lblBrand = new JLabel("Brand :");
		lblBrand.setBounds(36, 198, 46, 14);
		frame.getContentPane().add(lblBrand);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(36, 128, 46, 14);
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
		txtPrice.setBounds(120, 93, 209, 20);
		frame.getContentPane().add(txtPrice);
		txtPrice.setColumns(10);
		
		txtQuantity = new JTextField();
		txtQuantity.setText("0");
		txtQuantity.setBounds(120, 125, 209, 20);
		frame.getContentPane().add(txtQuantity);
		txtQuantity.setColumns(10);
		
		JComboBox<String> Categories = new JComboBox<String>();
		Categories.setBounds(120, 156, 209, 17);
		frame.getContentPane().add(Categories);
		for(int i=0;i<storeGUI.getStoreUIController().getCategoriesNames().size();i++){
			Categories.addItem(storeGUI.getStoreUIController().getCategoriesNames().get(i));
		}
		JComboBox<String> Brands = new JComboBox<String>();
		Brands.setBounds(120, 195, 209, 20);
		frame.getContentPane().add(Brands);
		for(int i=0;i<storeGUI.getStoreUIController().getBrandsNames().size();i++){
			Brands.addItem(storeGUI.getStoreUIController().getBrandsNames().get(i));
		}
		JButton btnAddProduct = new JButton("Add product");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storeGUI.getStoreUIController().AddProduct(txtID.getText(),txtEnterName.getText(), Float.parseFloat(txtPrice.getText())
						, Integer.parseInt(txtQuantity.getText()), Categories.getSelectedItem().toString(), Brands.getSelectedItem().toString());
			}
		});
		btnAddProduct.setBounds(76, 257, 123, 23);
		frame.getContentPane().add(btnAddProduct);
		
		JButton btnSugestProduct = new JButton("Suggest Product");
		btnSugestProduct.addActionListener(new ActionListener() {
=======
		frame.setBounds(100, 100, 487, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblProdcutName = new JLabel("Prodcut Name:");
		lblProdcutName.setBounds(53, 84, 111, 14);
		frame.getContentPane().add(lblProdcutName);
		
		name = new JTextField();
		name.setEditable(false);
		name.setBounds(194, 81, 132, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblProductId = new JLabel("Product ID :");
		lblProductId.setBounds(53, 40, 111, 14);
		frame.getContentPane().add(lblProductId);
		
		id = new JTextField();
		id.setEditable(false);
		id.setColumns(10);
		id.setBounds(194, 37, 132, 20);
		frame.getContentPane().add(id);
		
		JLabel lblProdcutPrice = new JLabel("Prodcut Price :");
		lblProdcutPrice.setBounds(53, 126, 111, 14);
		frame.getContentPane().add(lblProdcutPrice);
		
		price = new JTextField();
		price.setEditable(false);
		price.setColumns(10);
		price.setBounds(194, 123, 132, 20);
		frame.getContentPane().add(price);
		
		JLabel lblQuantity = new JLabel("Quantity :");
		lblQuantity.setBounds(53, 167, 111, 14);
		frame.getContentPane().add(lblQuantity);
		
		quantity = new JTextField();
		quantity.setEditable(false);
		quantity.setColumns(10);
		quantity.setBounds(194, 164, 132, 20);
		frame.getContentPane().add(quantity);
		
		JLabel lblCategory = new JLabel("Category :");
		lblCategory.setBounds(53, 208, 111, 14);
		frame.getContentPane().add(lblCategory);
		
		category = new JTextField();
		category.setEditable(false);
		category.setColumns(10);
		category.setBounds(194, 205, 132, 20);
		frame.getContentPane().add(category);
		
		JLabel lblBrand = new JLabel("Brand :");
		lblBrand.setBounds(53, 254, 111, 14);
		frame.getContentPane().add(lblBrand);
		
		brand = new JTextField();
		brand.setEditable(false);
		brand.setColumns(10);
		brand.setBounds(194, 251, 132, 20);
		frame.getContentPane().add(brand);
		
		JLabel lblStore = new JLabel("Store :");
		lblStore.setBounds(53, 293, 111, 14);
		frame.getContentPane().add(lblStore);
		
		store = new JTextField();
		store.setEditable(false);
		store.setColumns(10);
		store.setBounds(194, 290, 132, 20);
		frame.getContentPane().add(store);
		
		JLabel lblviews = new JLabel("#Views :");
		lblviews.setBounds(53, 335, 111, 14);
		frame.getContentPane().add(lblviews);
		
		viewsnubmer = new JTextField();
		viewsnubmer.setEditable(false);
		viewsnubmer.setColumns(10);
		viewsnubmer.setBounds(194, 332, 132, 20);
		frame.getContentPane().add(viewsnubmer);
		
		if(!view) {
			id.setVisible(false);
			viewsnubmer.setVisible(false);
			lblviews.setVisible(false);
			lblProductId.setVisible(false);
		}
		name.setText(product.getName());
		id.setText(product.getID());
		price.setText(Float.toString(product.getPrice()));
		quantity.setText(Integer.toString(product.getQuantity()));
		brand.setText(product.getBrand());
		category.setText(product.getCategory());
		viewsnubmer.setText(Integer.toString(product.getView()));
		store.setText(product.getStore().getStoreName());
		
		JButton close = new JButton("Close");
		close.addActionListener(new ActionListener() {
>>>>>>> 80ae83157e0116ef97d88d886e56bdd2c24d06ee
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
<<<<<<< HEAD
		btnSugestProduct.setBounds(219, 257, 111, 23);
		frame.getContentPane().add(btnSugestProduct);
=======
		close.setBounds(194, 371, 89, 23);
		frame.getContentPane().add(close);
>>>>>>> 80ae83157e0116ef97d88d886e56bdd2c24d06ee
	}
}
