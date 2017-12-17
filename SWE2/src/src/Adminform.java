package src;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;

public class Adminform {

	private JFrame frame;
	private AdminController adminController;
	private HomePage homePage;
	private JTextField Brand;
	private JTextField product;
	List<Product> retreiveCategoryProducts;
	/**
	 * @wbp.parser.constructor
	 */
	
	public Adminform() {
		retreiveCategoryProducts = new ArrayList<>();
		adminController=new AdminController();
		initialize();
	}

	Adminform(Administrator admin,HomePage homePage) {
		retreiveCategoryProducts = new ArrayList<>();
		adminController=new AdminController(admin);
		this.homePage=homePage;
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(51, 153, 204));
		frame.setBounds(100, 100, 794, 496);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JLabel productlabel = new JLabel("Product");
		productlabel.setForeground(new Color(255, 153, 153));
		productlabel.setBounds(112, 257, 46, 14);
		frame.getContentPane().add(productlabel);

		JLabel categorylabel = new JLabel("Category :");
		categorylabel.setForeground(new Color(255, 153, 153));
		categorylabel.setBounds(112, 282, 66, 21);
		frame.getContentPane().add(categorylabel);

		JLabel brandlabel = new JLabel("Brand :");
		brandlabel.setForeground(new Color(255, 153, 153));
		brandlabel.setBounds(112, 317, 46, 14);
		frame.getContentPane().add(brandlabel);

		product = new JTextField();
		product.setBounds(179, 254, 131, 20);
		frame.getContentPane().add(product);
		product.setColumns(10);

		Brand = new JTextField();
		Brand.setBounds(179, 314, 131, 20);
		frame.getContentPane().add(Brand);
		Brand.setColumns(10);

		JComboBox<String> Category = new JComboBox<String>();
		Category.setBounds(179, 282, 131, 21);
		frame.getContentPane().add(Category);
		Category.addItem("none");
		for(String category:adminController.getCategories())
		{
			Category.addItem(category);
		}
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBox.getSelectedItem()!="Suggested Products")
				{
					product.setText(retreiveCategoryProducts.get(comboBox.getSelectedIndex()-1).getName());
					product.setEditable(false);
					Brand.setText(retreiveCategoryProducts.get(comboBox.getSelectedIndex()-1).getBrand());
				}
			}
		});

		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adminController.AddProductToSystem(product.getText(), String.valueOf(Category.getSelectedItem()), Brand.getText());
				product.setText("");
				Category.setSelectedIndex(0);
				Brand.setText("");
				if(comboBox.getSelectedItem()!="Suggested Products")
				{
					retreiveCategoryProducts.remove(comboBox.getSelectedIndex()-1);
					comboBox.removeItemAt(comboBox.getSelectedIndex());
					product.setEditable(true);
					retreiveCategoryProducts = adminController.getSuggestedProducts();
					comboBox.addItem("Suggested Products");
					for (int i = 0; i < retreiveCategoryProducts.size(); i++) {
						comboBox.addItem(retreiveCategoryProducts.get(i).getName());
					}
					comboBox.setSelectedIndex(0);
				}
					
			}
		});

		productlabel.setVisible(false);
		categorylabel.setVisible(false);
		brandlabel.setVisible(false);
		product.setVisible(false);
		Category.setVisible(false);
		Brand.setVisible(false);
		add.setVisible(false);
		comboBox.setVisible(false);

		JButton addproduct = new JButton("Add product to the system ");
		addproduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productlabel.setVisible(true);
				categorylabel.setVisible(true);
				brandlabel.setVisible(true);
				product.setVisible(true);
				Category.setVisible(true);
				Brand.setVisible(true);
				add.setVisible(true);
				comboBox.setVisible(true);
			}

		});
		addproduct.setBounds(74, 162, 180, 23);
		frame.getContentPane().add(addproduct);

		add.setBounds(112, 355, 73, 23);
		frame.getContentPane().add(add);


		retreiveCategoryProducts = adminController.getSuggestedProducts();
		comboBox.addItem("Suggested Products");
		for (int i = 0; i < retreiveCategoryProducts.size(); i++) {
			comboBox.addItem(retreiveCategoryProducts.get(i).getName());
		}
		comboBox.setBounds(320, 254, 186, 21);
		frame.getContentPane().add(comboBox);

		JButton btnAddBrandTosystem = new JButton("Add Brand ToSystem");
		btnAddBrandTosystem.setBounds(273, 162, 147, 23);
		frame.getContentPane().add(btnAddBrandTosystem);

		JButton btnAddVoucherCard = new JButton("Add Voucher Card Number");
		btnAddVoucherCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, adminController.voucherGenerator());
			}
		});
		btnAddVoucherCard.setBounds(442, 162, 168, 23);
		frame.getContentPane().add(btnAddVoucherCard);
		
		JButton hompage = new JButton("Hompage");
		hompage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				homePage.getFrmHomepage().setVisible(true);
			}
		});
		hompage.setBounds(331, 367, 89, 23);
		frame.getContentPane().add(hompage);
		
		JLabel AdminLabs = new JLabel("");
		AdminLabs.setIcon(new ImageIcon("F:\\y3_1\\SW\\proj\\implementation\\SWEproject\\SWE2\\images\\adminlabs.png"));
		AdminLabs.setBounds(141, 11, 489, 114);
		frame.getContentPane().add(AdminLabs);
		


	}
}