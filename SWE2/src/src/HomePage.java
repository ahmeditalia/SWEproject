package src;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class HomePage {

	private JFrame frmHomepage;
	private JTable tableviewed;
	private JTextField password;
	private JTextField user_name;
	private JTextField searchtext;
	private HomePageController homepagecontroller;
	private List<Product> viewedProducts;

	public HomePageController getHomepagecontroller() {
		return homepagecontroller;
	}

	public JFrame getFrmHomepage() {
		return frmHomepage;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new HomePage();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomePage() {
		homepagecontroller = new HomePageController();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHomepage = new JFrame();
		frmHomepage.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmHomepage.setTitle("HomePage");
		frmHomepage.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmHomepage.setBounds(100, 100, 888, 493);
		frmHomepage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHomepage.getContentPane().setLayout(null);
		frmHomepage.setVisible(true);
		JButton cart = new JButton("Cart");
		cart.setBounds(945, 45, 117, 23);
		frmHomepage.getContentPane().add(cart);
		JButton login = new JButton("login");
		login.setBounds(1263, 11, 89, 23);
		frmHomepage.getContentPane().add(login);
		JButton register = new JButton("Register");
		register.setBounds(1263, 45, 89, 23);
		frmHomepage.getContentPane().add(register);
		JButton search = new JButton("Search");
		search.setBounds(781, 26, 117, 23);
		frmHomepage.getContentPane().add(search);
		JButton addtocart = new JButton("Add To Cart");
		addtocart.setBounds(945, 11, 117, 23);
		frmHomepage.getContentPane().add(addtocart);
		
		
		password = new JTextField();
		password.setBounds(1167, 48, 86, 20);
		frmHomepage.getContentPane().add(password);
		password.setColumns(10);
		user_name = new JTextField();
		user_name.setBounds(1167, 11, 86, 20);
		frmHomepage.getContentPane().add(user_name);
		user_name.setColumns(10);
		JLabel lblNewLabel = new JLabel("User Name:");
		lblNewLabel.setBounds(1083, 14, 74, 14);
		frmHomepage.getContentPane().add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setBounds(1083, 51, 74, 14);
		frmHomepage.getContentPane().add(lblNewLabel_1);
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Categories");
		comboBox.setBounds(10, 99, 117, 20);
		frmHomepage.getContentPane().add(comboBox);
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(1072, 0, 2, 77);
		frmHomepage.getContentPane().add(separator);
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(919, 0, 2, 77);
		frmHomepage.getContentPane().add(separator_1);
		searchtext = new JTextField();
		searchtext.setBounds(183, 27, 565, 20);
		frmHomepage.getContentPane().add(searchtext);
		searchtext.setColumns(10);
		JLabel lblNewLabel_2 = new JLabel("Categories");
		lblNewLabel_2.setBounds(35, 75, 74, 14);
		frmHomepage.getContentPane().add(lblNewLabel_2);
		
		DefaultTableModel model = new DefaultTableModel();
		JPanel panel = new JPanel();
		panel.setBounds(136, 75, 1216, 629);
		frmHomepage.getContentPane().add(panel);
		tableviewed = new JTable(model);
		panel.add(tableviewed);
		/// implementation Button Pressed

		// Cart
		cart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CartPage(homepagecontroller.getUser().getCart(), HomePage.this);
				frmHomepage.setVisible(false);
			}
		});
		// Login
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = user_name.getText();
				String pass = password.getText();
				homepagecontroller.LogIn(username, pass);
			}
		});
		// addtocart
		addtocart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// homepagecontroller.AddToCart(new Product());
			}
		});
		// search
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String textsearch = searchtext.getText();
				homepagecontroller.DirectSearch(textsearch);
			}
		});
		// register
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new RegisterPage(HomePage.this);
				frmHomepage.setVisible(false);
			}
		});
	}
}
