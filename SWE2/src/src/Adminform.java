package src;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Adminform {

	private JFrame frame;
	private AdminController adminController;
	private HomePage homePage;
	private JTextField Category;
	private JTextField Brand;
	private JTextField product;
	List<Product> retreiveCategoryProducts;
/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminform window = new Adminform();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the application.
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 729, 464);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel productlabel = new JLabel("Product");
		productlabel.setBounds(60, 172, 46, 14);
		frame.getContentPane().add(productlabel);

		JLabel categorylabel = new JLabel("Category :");
		categorylabel.setBounds(60, 197, 66, 21);
		frame.getContentPane().add(categorylabel);

		JLabel brandlabel = new JLabel("Brand :");
		brandlabel.setBounds(60, 232, 46, 14);
		frame.getContentPane().add(brandlabel);

		product = new JTextField();
		product.setBounds(127, 169, 131, 20);
		frame.getContentPane().add(product);
		product.setColumns(10);

		Category = new JTextField();
		Category.setBounds(127, 197, 131, 20);
		frame.getContentPane().add(Category);
		Category.setColumns(10);

		Brand = new JTextField();
		Brand.setBounds(127, 229, 131, 20);
		frame.getContentPane().add(Brand);
		Brand.setColumns(10);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBox.getSelectedItem()!="Suggested Products")
				{
					product.setText(retreiveCategoryProducts.get(comboBox.getSelectedIndex()-1).getName());
					product.setEditable(false);
					Category.setText(retreiveCategoryProducts.get(comboBox.getSelectedIndex()-1).getCategory());
					Brand.setText(retreiveCategoryProducts.get(comboBox.getSelectedIndex()-1).getBrand());
				}
			}
		});

		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adminController.AddProductToSystem(product.getText(), Category.getText(), Brand.getText());
				product.setText("");
				Category.setText("");
				Brand.setText("");
				if(comboBox.getSelectedItem()!="Suggested Products")
				{
					retreiveCategoryProducts.remove(comboBox.getSelectedIndex()-1);
					comboBox.removeItemAt(comboBox.getSelectedIndex());
					product.setEditable(true);
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
		addproduct.setBounds(10, 27, 180, 23);
		frame.getContentPane().add(addproduct);

		add.setBounds(60, 270, 73, 23);
		frame.getContentPane().add(add);


		retreiveCategoryProducts = adminController.getSuggestedProducts();
		comboBox.addItem("Suggested Products");
		for (int i = 0; i < retreiveCategoryProducts.size(); i++) {
			comboBox.addItem(retreiveCategoryProducts.get(i).getName());
		}
		comboBox.setBounds(268, 169, 186, 21);
		frame.getContentPane().add(comboBox);

		JButton btnAddBrandTosystem = new JButton("Add Brand ToSystem");
		btnAddBrandTosystem.setBounds(209, 27, 147, 23);
		frame.getContentPane().add(btnAddBrandTosystem);

		JButton btnAddVoucherCard = new JButton("Add Voucher Card Number");
		btnAddVoucherCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adminController.voucherGenerator();
			}
		});
		btnAddVoucherCard.setBounds(378, 27, 168, 23);
		frame.getContentPane().add(btnAddVoucherCard);
		
		JButton hompage = new JButton("Hompage");
		hompage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				homePage.getFrmHomepage().setVisible(true);
			}
		});
		hompage.setBounds(469, 367, 89, 23);
		frame.getContentPane().add(hompage);

	}
}
