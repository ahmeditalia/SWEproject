package src;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
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
		adminController = new AdminController();
		initialize();
	}

	Adminform(Administrator admin, HomePage homePage) {
		retreiveCategoryProducts = new ArrayList<>();
		adminController = new AdminController(admin,homePage.getDatabase());
		this.homePage = homePage;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(178, 34, 34));
		frame.setBounds(100, 100, 794, 496);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				homePage.getDatabase().writeAll();
			}
		});
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		JLabel productlabel = new JLabel("Product");
		productlabel.setForeground(new Color(178, 34, 34));
		productlabel.setBounds(642, 340, 46, 14);
		frame.getContentPane().add(productlabel);

		JLabel categorylabel = new JLabel("Category :");
		categorylabel.setForeground(new Color(178, 34, 34));
		categorylabel.setBounds(642, 365, 66, 21);
		frame.getContentPane().add(categorylabel);

		JLabel brandlabel = new JLabel("Brand :");
		brandlabel.setForeground(new Color(178, 34, 34));
		brandlabel.setBounds(642, 400, 46, 14);
		frame.getContentPane().add(brandlabel);

		product = new JTextField();
		product.setBounds(709, 337, 131, 20);
		frame.getContentPane().add(product);
		product.setColumns(10);

		Brand = new JTextField();
		Brand.setBounds(709, 397, 131, 20);
		frame.getContentPane().add(Brand);
		Brand.setColumns(10);

		JComboBox<String> Category = new JComboBox<String>();
		Category.setBounds(709, 365, 131, 21);
		frame.getContentPane().add(Category);
		Category.addItem("none");
		for (String category : adminController.getCategories()) {
			Category.addItem(category);
		}

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBox.getSelectedItem() != "Suggested Products") {
					product.setText(retreiveCategoryProducts.get(comboBox.getSelectedIndex() - 1).getName());
					product.setEditable(false);
					Category.setSelectedItem(
							retreiveCategoryProducts.get(comboBox.getSelectedIndex() - 1).getCategory());
					Brand.setText(retreiveCategoryProducts.get(comboBox.getSelectedIndex() - 1).getBrand());
				}
			}
		});

		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (product.isVisible()) {
					if (!Category.getSelectedItem().equals("Suggested Products"))
						adminController.AddProductToSystem(product.getText(),
								String.valueOf(Category.getSelectedItem()), Brand.getText());
					else
						JOptionPane.showMessageDialog(null, "pls enter the category");
					product.setText("");
					Category.setSelectedIndex(0);
					Brand.setText("");
					if (comboBox.getSelectedItem() != "Suggested Products") {
						retreiveCategoryProducts.remove(comboBox.getSelectedIndex() - 1);
						comboBox.removeItemAt(comboBox.getSelectedIndex());
						product.setEditable(true);
						comboBox.setSelectedIndex(0);
					}
				} else {
					adminController.addBrandToSystem(Brand.getText());
					Brand.setText("");
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
		addproduct.setBounds(376, 347, 212, 23);
		frame.getContentPane().add(addproduct);

		add.setBounds(709, 427, 73, 23);
		frame.getContentPane().add(add);

		retreiveCategoryProducts = adminController.getSuggestedProducts();
		comboBox.addItem("Suggested Products");
		for (int i = 0; i < retreiveCategoryProducts.size(); i++) {
			comboBox.addItem(retreiveCategoryProducts.get(i).getName());
		}
		comboBox.setBounds(850, 337, 186, 21);
		frame.getContentPane().add(comboBox);

		JButton btnAddBrandTosystem = new JButton("Add Brand ToSystem");
		btnAddBrandTosystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				brandlabel.setVisible(true);
				Brand.setVisible(true);
				add.setVisible(true);
				productlabel.setVisible(false);
				categorylabel.setVisible(false);
				brandlabel.setVisible(false);
				product.setVisible(false);
				Category.setVisible(false);
				comboBox.setVisible(false);
			}
		});
		btnAddBrandTosystem.setBounds(378, 396, 210, 23);
		frame.getContentPane().add(btnAddBrandTosystem);

		JButton btnAddVoucherCard = new JButton("Add Voucher Card Number");
		btnAddVoucherCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, adminController.voucherGenerator());
			}
		});
		btnAddVoucherCard.setBounds(376, 445, 212, 23);
		frame.getContentPane().add(btnAddVoucherCard);

		JButton hompage = new JButton("Hompage");
		hompage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				homePage.getFrmHomepage().setVisible(true);
			}
		});
		hompage.setBounds(376, 307, 89, 23);
		frame.getContentPane().add(hompage);

		JLabel AdminLabs = new JLabel("");
		AdminLabs.setIcon(new ImageIcon("images\\adminlabs.png"));
		AdminLabs.setBounds(461, 123, 489, 114);
		frame.getContentPane().add(AdminLabs);

		JButton button = new JButton("");
		button.setBackground(new Color(102, 153, 255));
		button.setBounds(326, 120, 753, 490);
		frame.getContentPane().add(button);
		button.setEnabled(false);

	}
}