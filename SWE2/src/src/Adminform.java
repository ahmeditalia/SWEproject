package src;

import java.awt.EventQueue;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Adminform {

	private JFrame frame;
	private AdminController adminController = new AdminController();
	private IDataBase iDataBase = new DataBase();
	private JTextField Category;
	private JTextField Brand;
	Adminform(Administrator admin) {

	}

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

	/**
	 * Create the application.
	 */
	public Adminform() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 542, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		JButton btnAddProductTo = new JButton("Add product to the system ");
		btnAddProductTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ProductForm pGui= new ProductForm(Adminform.this);
				String x = comboBox.getSelectedItem().toString();
				
				iDataBase.InsertSuggestedProduct(product);
				
			}

		});
		btnAddProductTo.setBounds(26, 34, 224, 34);
		frame.getContentPane().add(btnAddProductTo);

		JButton btnNewButton = new JButton("Add Suggested Products");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnNewButton.setBounds(131, 253, 224, 34);
		frame.getContentPane().add(btnNewButton);

		List<Product> retreiveCategoryProducts = adminController.getSuggestedProducts();
		for (int i = 0; i < retreiveCategoryProducts.size(); i++) {
			comboBox.addItem(retreiveCategoryProducts.get(i).getName());
		}
		comboBox.setBounds(260, 34, 224, 34);
		frame.getContentPane().add(comboBox);
		
		JLabel lblCategory = new JLabel("Category :");
		lblCategory.setBounds(41, 90, 66, 21);
		frame.getContentPane().add(lblCategory);
		
		Category = new JTextField();
		Category.setBounds(108, 90, 86, 20);
		frame.getContentPane().add(Category);
		Category.setColumns(10);
		
		JLabel lblBrand = new JLabel("Brand :");
		lblBrand.setBounds(41, 125, 46, 14);
		frame.getContentPane().add(lblBrand);
		
		Brand = new JTextField();
		Brand.setBounds(108, 122, 86, 20);
		frame.getContentPane().add(Brand);
		Brand.setColumns(10);
	}
}
