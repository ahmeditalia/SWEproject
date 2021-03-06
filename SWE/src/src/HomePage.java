package src;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;

public class HomePage {

	private JFrame frmHomepage;
	private JPasswordField password;
	private JTextField user_name;
	private JTextField searchtext;
	private HomePageController homepagecontroller;
	private List<Product> viewedProducts;
	private JTable table;
	private IDataBase dataBase;

	public HomePage() {
		dataBase=new DataBase();
		homepagecontroller = new HomePageController(dataBase);
		viewedProducts = new ArrayList<>();
		initialize();
	}
	
	public HomePageController getHomepagecontroller() {
		return homepagecontroller;
	}

	public IDataBase getDatabase()
	{
		return dataBase;
	}
	public JFrame getFrmHomepage() {
		return frmHomepage;
	}

	private void updatetable(DefaultTableModel model) {
		int rowcount=model.getRowCount();
		for(int i=rowcount-1;i>=0;i--)
		{
			model.removeRow(i);
		}
		for (Product product : viewedProducts) {
			Object[] row = { product.getID(), product.getName(), Float.toString(product.getPrice()),
					Integer.toString(product.getQuantity()), product.getCategory(), product.getBrand(),
					product.getStore().getStoreName(), false };
			model.addRow(row);
		}
	}

	private void updateproducts(String categoryname, String storename) {
		viewedProducts = new ArrayList<>(homepagecontroller.getProducts(categoryname, storename));
	}

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				HomePage homePage = null;
				try {
					homePage = new HomePage();
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					homePage.dataBase.writeAll();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		dataBase.readAll();
		frmHomepage = new JFrame();
		frmHomepage.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				dataBase.writeAll();
			}
		});
		frmHomepage.getContentPane().setBackground(new Color(178, 34, 34));
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
		lblNewLabel.setForeground(new Color(255, 153, 153));
		lblNewLabel.setBounds(1083, 14, 74, 14);
		frmHomepage.getContentPane().add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setForeground(new Color(255, 153, 153));
		lblNewLabel_1.setBounds(1083, 51, 74, 14);
		frmHomepage.getContentPane().add(lblNewLabel_1);
		JComboBox<String> boxcategory = new JComboBox<>();
		boxcategory.setToolTipText("Categories");
		boxcategory.setBounds(20, 265, 150, 20);
		// italia modification
		List<String> categories = new ArrayList<>();
		categories = homepagecontroller.getCategoriesNames();
		boxcategory.addItem("All");
		for (String a : categories) {
			boxcategory.addItem(a);

		}
		// end modification
		frmHomepage.getContentPane().add(boxcategory);
		JComboBox<String> boxstores = new JComboBox<>();
		boxstores.setToolTipText("stores");
		boxstores.setBounds(20, 391, 150, 20);
		// italia modification
		boxstores.addItem("All");
		List<String> stores = new ArrayList<>();
		stores = homepagecontroller.RetreiveStoreNames();
		for (String a : stores) {
			boxstores.addItem(a);

		}
		// end modification
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
		searchtext.setBounds(273, 28, 499, 20);
		frmHomepage.getContentPane().add(searchtext);
		searchtext.setColumns(10);
		JLabel lblNewLabel_2 = new JLabel("Categories :");
		lblNewLabel_2.setForeground(new Color(255, 153, 153));
		lblNewLabel_2.setFont(new Font("Sitka Banner", Font.BOLD, 16));
		lblNewLabel_2.setBounds(20, 240, 89, 14);
		frmHomepage.getContentPane().add(lblNewLabel_2);
		Object[] columnsnames = { "#", "Product Name", "Price", "Quantity", "Category", "Brand", "Store", "Select" };
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(231, 0, 2, 704);
		frmHomepage.getContentPane().add(separator_2);
		JLabel userlogin = new JLabel("");
		userlogin.setHorizontalAlignment(SwingConstants.CENTER);
		userlogin.setFont(new Font("Goudy Old Style", Font.PLAIN, 24));
		userlogin.setBounds(1083, 0, 269, 68);
		frmHomepage.getContentPane().add(userlogin);
		JButton Logout = new JButton("LogOut");
		Logout.setBounds(1273, 48, 79, 23);
		frmHomepage.getContentPane().add(Logout);
		Logout.setVisible(false);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(233, 79, 1119, 625);
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
				if (column != 7)
					return false;
				return true;
			}
		};
		table.setModel(model);
		model.setColumnIdentifiers(columnsnames);
		viewedProducts = new ArrayList<>(homepagecontroller.getAllProducts());
		updatetable(model);
		//model.addRow(new Object[] {"sdsa","sdsa","asd","asds","sdsa","sdsa","asd","asds"});
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(233, 75, 1119, 2);
		frmHomepage.getContentPane().add(separator_3);
		JLabel logolabel = new JLabel("");
		ImageIcon backGround =new ImageIcon("images\\images.png");
		logolabel.setIcon(backGround);
		logolabel.setHorizontalAlignment(SwingConstants.CENTER);
		logolabel.setFont(new Font("Source Sans Pro", Font.BOLD, 11));
		logolabel.setBounds(0, 0, 230, 211);
		frmHomepage.getContentPane().add(logolabel);
		JLabel storelabel = new JLabel("Stores :");
		storelabel.setForeground(new Color(255, 153, 153));
		storelabel.setFont(new Font("Sitka Banner", Font.BOLD, 16));
		storelabel.setBounds(28, 366, 89, 14);
		frmHomepage.getContentPane().add(storelabel);
		JButton ControllPanel = new JButton("Controll Panel");
		ControllPanel.setBounds(945, 27, 117, 23);
		frmHomepage.getContentPane().add(ControllPanel);
		ControllPanel.setVisible(false);
		JButton OpenStore = new JButton("Open Store");
		OpenStore.setBounds(943, 27, 119, 23);
		frmHomepage.getContentPane().add(OpenStore);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(0, 209, 233, 2);
		frmHomepage.getContentPane().add(separator_4);
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
				frmHomepage.setVisible(false);
				new Adminform((Administrator)homepagecontroller.getUser(),HomePage.this);
			}
		});
		// StoreUI
		OpenStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (homepagecontroller.getUser() instanceof StoreOwner) {
					frmHomepage.setVisible(false);
					new StoreUI((StoreOwner) homepagecontroller.getUser(),HomePage.this);
				}
			}
		});
		// changecategory
		boxcategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateproducts(boxcategory.getSelectedItem().toString(), boxstores.getSelectedItem().toString());
				updatetable(model);
			}
		});
		// changestore
		boxstores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateproducts(boxcategory.getSelectedItem().toString(), boxstores.getSelectedItem().toString());
				updatetable(model);
			}
		});
		// Cart
		cart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NormalUser user = (NormalUser) homepagecontroller.getUser();
				frmHomepage.setVisible(false);
				new CartPage(user.getCart(), HomePage.this);
				
			}
		});
		// Login
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = user_name.getText();
				String pass = String.valueOf(password.getPassword());
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
					user_name.setText("");
					password.setText("");
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
				for (int i = 0; i < table.getRowCount(); i++) {
					boolean select = Boolean.parseBoolean(table.getModel().getValueAt(i, 7).toString());
					if (select) {
						homepagecontroller.AddToCart(viewedProducts.get(i));
					}
				}
				updateproducts("All", "All");
				updatetable(model);
			}
		});
		// search
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String textsearch = searchtext.getText();
				viewedProducts = homepagecontroller.DirectSearch(textsearch);
				if (viewedProducts == null || viewedProducts.isEmpty()) {
					JOptionPane.showMessageDialog(null, "NOT EXCITE !");
					return;
				}
				updatetable(model);
				searchtext.setText("");
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
