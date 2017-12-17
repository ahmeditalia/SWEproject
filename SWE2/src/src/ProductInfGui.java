package src;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ProductInfGui {

	private JFrame frame;
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
	private JButton btnClose;
	
	/**
	 * @wbp.parser.constructor
	 */
	public ProductInfGui(Product product,boolean view) {
		this.product = product;
		this.view = view;
		initialize();
	}
	/**
	 * Create the application.
	 */
	public ProductInfGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(255, 153, 153));
		frame.getContentPane().setBackground(new Color(178, 34, 34));
		frame.setBounds(100, 100, 487, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JLabel lblProdcutName = new JLabel("Prodcut Name:");
		lblProdcutName.setForeground(new Color(255, 153, 153));
		lblProdcutName.setBounds(53, 84, 111, 14);
		frame.getContentPane().add(lblProdcutName);
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		btnClose.setBounds(194, 371, 89, 23);
		frame.getContentPane().add(btnClose);
		
		name = new JTextField();
		name.setEditable(false);
		name.setBounds(194, 81, 132, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblProductId = new JLabel("Product ID :");
		lblProductId.setForeground(new Color(255, 153, 153));
		lblProductId.setBounds(53, 40, 111, 14);
		frame.getContentPane().add(lblProductId);
		
		id = new JTextField();
		id.setEditable(false);
		id.setColumns(10);
		id.setBounds(194, 37, 132, 20);
		frame.getContentPane().add(id);
		
		JLabel lblProdcutPrice = new JLabel("Prodcut Price :");
		lblProdcutPrice.setForeground(new Color(255, 153, 153));
		lblProdcutPrice.setBounds(53, 126, 111, 14);
		frame.getContentPane().add(lblProdcutPrice);
		
		price = new JTextField();
		price.setEditable(false);
		price.setColumns(10);
		price.setBounds(194, 123, 132, 20);
		frame.getContentPane().add(price);
		
		JLabel lblQuantity = new JLabel("Quantity :");
		lblQuantity.setForeground(new Color(255, 153, 153));
		lblQuantity.setBounds(53, 167, 111, 14);
		frame.getContentPane().add(lblQuantity);
		
		quantity = new JTextField();
		quantity.setEditable(false);
		quantity.setColumns(10);
		quantity.setBounds(194, 164, 132, 20);
		frame.getContentPane().add(quantity);
		
		JLabel lblCategory = new JLabel("Category :");
		lblCategory.setForeground(new Color(255, 153, 153));
		lblCategory.setBounds(53, 208, 111, 14);
		frame.getContentPane().add(lblCategory);
		
		category = new JTextField();
		category.setEditable(false);
		category.setColumns(10);
		category.setBounds(194, 205, 132, 20);
		frame.getContentPane().add(category);
		
		JLabel lblBrand = new JLabel("Brand :");
		lblBrand.setForeground(new Color(255, 153, 153));
		lblBrand.setBounds(53, 254, 111, 14);
		frame.getContentPane().add(lblBrand);
		
		brand = new JTextField();
		brand.setEditable(false);
		brand.setColumns(10);
		brand.setBounds(194, 251, 132, 20);
		frame.getContentPane().add(brand);
		
		JLabel lblStore = new JLabel("Store :");
		lblStore.setForeground(new Color(255, 153, 153));
		lblStore.setBounds(53, 293, 111, 14);
		frame.getContentPane().add(lblStore);
		
		store = new JTextField();
		store.setEditable(false);
		store.setColumns(10);
		store.setBounds(194, 290, 132, 20);
		frame.getContentPane().add(store);
		JLabel lblviews = new JLabel("#Views :");
		lblviews.setForeground(new Color(255, 153, 153));
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
		else{
			viewsnubmer.setText(Integer.toString(product.getViews()));
		}
		name.setText(product.getName());
		id.setText(product.getID());
		price.setText(Float.toString(product.getPrice()));
		quantity.setText(Integer.toString(product.getQuantity()));
		brand.setText(product.getBrand());
		category.setText(product.getCategory());
		store.setText(product.getStore().getStoreName());
		
		
	}
}
