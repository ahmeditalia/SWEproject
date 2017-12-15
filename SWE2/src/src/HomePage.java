package src;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class HomePage extends JFrame {

	private JFrame frmHomepage;
	private JPasswordField password;
	private JTextField user_name;
	private JTextField searchtext;
	private HomePageController homepagecontroller;
	private List<Product> viewedProducts;
	private JTable table;

	public HomePageController getHomepagecontroller() {
		return homepagecontroller;
	}

	public JFrame getFrmHomepage() {
		return frmHomepage;
	}

	private void updatetable(List<Product> products, DefaultTableModel model) {
		int i = 1;
		for (Product product : products) {
			String[] row = { Integer.toString(i), product.getName(), Float.toString(product.getPrice()),
					Integer.toString(product.getQuantity()), product.getCategory(), product.getBrand(),
					product.getStore().getStoreName() ,product.getID()};
			model.addRow(row);
		}
	}

	private void updateproducts(String categoryname, String storename) {
		viewedProducts = homepagecontroller.getproducts(categoryname, storename);
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
		viewedProducts = new ArrayList<>();
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
		cart.setVisible(false);
		JButton login = new JButton("login");
		login.setBounds(1263, 11, 89, 23);
		frmHomepage.getContentPane().add(login);
		JButton register = new JButton("Register");
		register.setBounds(1263, 45, 89, 23);
		frmHomepage.getContentPane().add(register);
		JButton search = new JButton("Search");
		search.setBounds(782, 27, 117, 23);
		frmHomepage.getContentPane().add(search);
		JButton addtocart = new JButton("Add To Cart");
		addtocart.setBounds(945, 11, 117, 23);
		frmHomepage.getContentPane().add(addtocart);
		addtocart.setVisible(false);
		password = new JPasswordField();
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
		JComboBox<String> boxcategory = new JComboBox<>();
		boxcategory.setToolTipText("Categories");
		boxcategory.setBounds(10, 119, 150, 20);
		boxcategory.addItem("All");
		boxcategory.addItem("1");
		frmHomepage.getContentPane().add(boxcategory);
		JComboBox<String> boxstores = new JComboBox<>();
		boxstores.setToolTipText("stores");
		boxstores.setBounds(10, 245, 150, 20);
		boxstores.addItem("All");
		boxstores.addItem("2");
		frmHomepage.getContentPane().add(boxstores);
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(1072, 0, 2, 77);
		frmHomepage.getContentPane().add(separator);
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(919, 0, 2, 77);
		frmHomepage.getContentPane().add(separator_1);
		searchtext = new JTextField();
		searchtext.setBounds(243, 28, 529, 20);
		frmHomepage.getContentPane().add(searchtext);
		searchtext.setColumns(10);
		JLabel lblNewLabel_2 = new JLabel("Categories :");
		lblNewLabel_2.setFont(new Font("Sitka Banner", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 94, 89, 14);
		frmHomepage.getContentPane().add(lblNewLabel_2);
		Object[] columnsnames = { "#", "Product Name", "Price", "Quantity", "Category", "Brand", "Store", "Select" };
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(231, 0, 2, 77);
		frmHomepage.getContentPane().add(separator_2);
		JLabel userlogin = new JLabel("");
		userlogin.setHorizontalAlignment(SwingConstants.CENTER);
		userlogin.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		userlogin.setBounds(1083, 0, 269, 68);
		frmHomepage.getContentPane().add(userlogin);
		JButton Logout = new JButton("LogOut");
		Logout.setBounds(1167, 51, 89, 23);
		frmHomepage.getContentPane().add(Logout);
		Logout.setVisible(false);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(231, 79, 1121, 625);
		frmHomepage.getContentPane().add(scrollPane);
		table = new JTable(new DefaultTableModel(new Object[][] {}, columnsnames));
		scrollPane.setViewportView(table);
		DefaultTableModel model = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}

			public boolean isCellEditable(int row, int column) {
				if(column != 7)
					return false;
				return true;
			}
		};
		updatetable(viewedProducts, model);
		table.setModel(model);
		model.setColumnIdentifiers(columnsnames);
		model.addRow(new Object[] { 1, "adsfasdf", 85643, 120, "SADS", "EWREWRw", "sdfer", false});
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 75, 1342, 2);
		frmHomepage.getContentPane().add(separator_3);
		JLabel logolabel = new JLabel("ICON");
		logolabel.setHorizontalAlignment(SwingConstants.CENTER);
		logolabel.setFont(new Font("Source Sans Pro", Font.BOLD, 11));
		logolabel.setBounds(0, 0, 233, 77);
		frmHomepage.getContentPane().add(logolabel);
		JLabel storelabel = new JLabel("Stores :");
		storelabel.setFont(new Font("Sitka Banner", Font.BOLD, 16));
		storelabel.setBounds(18, 220, 89, 14);
		frmHomepage.getContentPane().add(storelabel);
		JButton ControllPanel = new JButton("Controll Panel");
		ControllPanel.setBounds(945, 27, 117, 23);
		frmHomepage.getContentPane().add(ControllPanel);
		ControllPanel.setVisible(false);
		JButton OpenStore = new JButton("Open Store");
		OpenStore.setBounds(943, 27, 119, 23);
		frmHomepage.getContentPane().add(OpenStore);
		OpenStore.setVisible(false);
		if (homepagecontroller.getUser() != null) {
			login.setVisible(false);
			user_name.setVisible(false);
			register.setVisible(false);
			password.setVisible(false);
			lblNewLabel.setVisible(false);
			lblNewLabel_1.setVisible(false);
			Logout.setVisible(true);
			userlogin.setText("Welcome " + homepagecontroller.getUser().getUsername());
			if (homepagecontroller.getUser().getType() == 1) {
				addtocart.setVisible(true);
				cart.setVisible(true);
				Logout.setVisible(true);
			} else if (homepagecontroller.getUser().getType() == 2) {
				OpenStore.setVisible(true);
				Logout.setVisible(true);
			} else if (homepagecontroller.getUser().getType() == 3) {
				ControllPanel.setVisible(true);
				Logout.setVisible(true);
			}
		}
		/// implementation Button Pressed
		// adminpage
		ControllPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AdminPage();
			}
		});
		// adminpage
		OpenStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new StoreUI();
			}
		});
		// changecategory
		boxcategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateproducts(boxcategory.getSelectedItem().toString(), boxstores.getSelectedItem().toString());
				updatetable(viewedProducts, model);
			}
		});
		// changestore
		boxstores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateproducts(boxcategory.getSelectedItem().toString(), boxstores.getSelectedItem().toString());
				updatetable(viewedProducts, model);
			}
		});
		// Cart
		cart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NormalUser user = (NormalUser) homepagecontroller.getUser();
				new CartPage(user.getCart(), HomePage.this);
				frmHomepage.setVisible(false);
			}
		});
		// Login
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = user_name.getText();
				String pass = password.getPassword().toString();
				homepagecontroller.LogIn(username, pass);
				if (homepagecontroller.getUser() != null) {
					login.setVisible(false);
					user_name.setVisible(false);
					register.setVisible(false);
					password.setVisible(false);
					lblNewLabel.setVisible(false);
					lblNewLabel_1.setVisible(false);
					Logout.setVisible(true);
					userlogin.setText("Welcome " + homepagecontroller.getUser().getUsername());
					if (homepagecontroller.getUser().getType() == 1) {
						addtocart.setVisible(true);
						cart.setVisible(true);
						Logout.setVisible(true);
					} else if (homepagecontroller.getUser().getType() == 2) {
						OpenStore.setVisible(true);
						Logout.setVisible(true);
					} else if (homepagecontroller.getUser().getType() == 3) {
						ControllPanel.setVisible(true);
						Logout.setVisible(true);
					}
					return;
				}
				JOptionPane.showMessageDialog(null, "UserName OR Password Incorrect");
			}
		});
		// addtocart
		addtocart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Product> products = new ArrayList<>();
				for (int i = 0; i < table.getRowCount(); i++) {
					String name = table.getModel().getValueAt(i, 1).toString();
					String cat = table.getModel().getValueAt(i, 4).toString();
					String brand = table.getModel().getValueAt(i, 5).toString();
					String store = table.getModel().getValueAt(i, 6).toString();
					float price  = Float.parseFloat(table.getModel().getValueAt(i, 2).toString());
					int q = Integer.parseInt(table.getModel().getValueAt(i, 1).toString());
					String id = table.getModel().getValueAt(i, 1).toString();
					boolean select = Boolean.parseBoolean(table.getModel().getValueAt(i, 1).toString());
					if(select) {
						Product product = new Product(id,name,price,q,cat,brand,store);
						products.add(product);
					}
				}
			}
		});
		// search
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String textsearch = searchtext.getText();
				List<Product> searchresult = homepagecontroller.DirectSearch(textsearch);
				if (searchresult == null || searchresult.isEmpty()) {
					JOptionPane.showMessageDialog(null, "NOT EXCITE !");
					return;
				}
			}
		});
		// register
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new RegisterPage(HomePage.this);
				frmHomepage.setVisible(false);
			}
		});
		// logOut
		Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				homepagecontroller.setUser(null);
				login.setVisible(true);
				user_name.setVisible(true);
				register.setVisible(true);
				password.setVisible(true);
				lblNewLabel.setVisible(true);
				lblNewLabel_1.setVisible(true);
				userlogin.setText("");
				addtocart.setVisible(false);
				cart.setVisible(false);
				Logout.setVisible(false);
				ControllPanel.setVisible(false);
				OpenStore.setVisible(false);
			}
		});
	}
}
