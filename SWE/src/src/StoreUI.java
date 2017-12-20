package src;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StoreUI {
	private JFrame frame;
	private JTextField txtGetstorename;
	private	StoreUIController sotreController;
	private HomePage homeGUI;
	private JTable table;
	String StoreOwnerName="";
	StoreUI(StoreOwner user,HomePage home){
		StoreOwnerName= user.Username;
		sotreController= new StoreUIController(user,home.getDatabase());
		homeGUI= home;
		initialize();
	}
	HomePage getHomePage(){
		return homeGUI;
	}
	public StoreUIController getStoreUIController(){
		return sotreController;
	}
	/**
	 * @wbp.parser.constructor
	 */
	
	public StoreUI() {
		initialize();
	}

	public JFrame getFrame(){
		return frame;
	}
	  void initialize() {
		frame = new JFrame();
		frame.setForeground(new Color(204, 102, 102));
		frame.getContentPane().setBackground(new Color(178, 34, 34));
		frame.setBounds(100, 100, 1241, 723);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				homeGUI.getDatabase().writeAll();
			}
		});
		JButton btnAddSotre = new JButton("Add New sotre");
		btnAddSotre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtGetstorename.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "enter the store name!!");
				}else{
				sotreController.addNewStore(txtGetstorename.getText());
				frame.setVisible(false);
				initialize();
				}
			}
		});
		
		btnAddSotre.setBounds(34, 321, 158, 29);
		frame.getContentPane().add(btnAddSotre);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(396, 155, 958, 550);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		Object[] columnsnames = { "#", "Product Name","Quantity","Price","Category","Brand","#Views","Store"};
		
		DefaultTableModel model= new DefaultTableModel();
		table.setModel(model);
		model.setColumnIdentifiers(columnsnames);
		for(Store s:sotreController.getCurrentUser().getOwnedStores()){
			for(Product p:s.getStoreProducts()){
				Object[] row= {p.getID(),p.getName(),p.getQuantity(),p.getPrice(),p.getCategory(),p.getBrand(),p.getViews(),s.getStoreName()};
				model.addRow(row);
			}
		}
		
		
		JComboBox<String> selectStoreToShow = new JComboBox<String>();
		selectStoreToShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(selectStoreToShow.getSelectedItem()!="All stores")
				{
					sotreController.setCurrentStore(selectStoreToShow.getSelectedIndex()-1);
				}
				model.setRowCount(0);
				if(selectStoreToShow.getSelectedItem().toString()=="All stores"){
					for(Store s:sotreController.getCurrentUser().getOwnedStores()){
						for(Product p:s.getStoreProducts()){
							Object[] row= {p.getID(),p.getName(),p.getQuantity(),p.getPrice(),p.getCategory(),p.getBrand(),p.getViews(),s.getStoreName()};
							model.addRow(row);
						}
					}
				}else{
				for(Product p: sotreController.getCurrentStore().getStoreProducts()){
					Object[] row= {p.getID(),p.getName(),p.getQuantity(),p.getPrice(),p.getCategory(),p.getBrand(),p.getViews(),sotreController.getCurrentStore().getStoreName()};
					model.addRow(row);
				}
				}
			}
		});
		
		selectStoreToShow.addItem("All stores");

		selectStoreToShow.setBounds(781, 124, 175, 20);
		frame.getContentPane().add(selectStoreToShow);
		for(Store s:sotreController.getCurrentUser().getOwnedStores() ){
			selectStoreToShow.addItem(s.getStoreName());
		}
		JButton btnAddProduct = new JButton("Add product to store");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectStoreToShow.getSelectedItem().toString()=="All stores"){
					JOptionPane.showMessageDialog(null, "select a store first!!");

				}else{
					//frame.setVisible(false);
					new  ProductForm(StoreUI.this,true);
				}
				}
		});
		btnAddProduct.setBounds(34, 370, 158, 33);
		frame.getContentPane().add(btnAddProduct);
		
		JButton btnSugestProduct = new JButton("Sugest product");
		btnSugestProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new  ProductForm(StoreUI.this,false);
				
			}
		});
		btnSugestProduct.setBounds(33, 474, 159, 29);
		frame.getContentPane().add(btnSugestProduct);
		
		JButton btnOGetThe = new JButton("Most viewed product ");
		btnOGetThe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sotreController.getCurrentUser().getOwnedStores().isEmpty()){
					JOptionPane.showMessageDialog(null, "add a store first!!");
				}
				else if(sotreController.getCurrentUser().getOwnedStores().get(0).getStoreProducts().isEmpty()){
					JOptionPane.showMessageDialog(null, "add a product first!!");
				}
				else if(selectStoreToShow.getSelectedItem().toString()=="All stores"){
					Product mostViewed = sotreController.getCurrentUser().getOwnedStores().get(0).getStoreProducts().get(0);
					for(Store s:sotreController.getCurrentUser().getOwnedStores()){
						if (s.getMostViewedP().getViews()>mostViewed.getViews()){
							mostViewed=s.getMostViewedP();
						}
					}
					new ProductInfGui(mostViewed,true);

				}
				else
					new ProductInfGui(sotreController.getCurrentStore().getMostViewedP(),true);
				}
		});
		btnOGetThe.setBounds(34, 425, 158, 29);
		frame.getContentPane().add(btnOGetThe);
		
		txtGetstorename = new JTextField();		
		txtGetstorename.setBounds(214, 324, 144, 26);
		frame.getContentPane().add(txtGetstorename);
		txtGetstorename.setColumns(10);
		
		
		JButton btnHomePage = new JButton("Home Page");
		btnHomePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				homeGUI.getFrmHomepage().setVisible(true);
			}
		});
		btnHomePage.setBounds(34, 276, 100, 23);
		frame.getContentPane().add(btnHomePage);
		JLabel IMAGE = new JLabel("");
		IMAGE.setBounds(34, 11, 304, 244);
		frame.getContentPane().add(IMAGE);
		ImageIcon backGround =new ImageIcon("images\\create-your-own-online-store.jpg");
		IMAGE.setIcon(backGround);
		
		
		
		JLabel lblNewLabel = new JLabel("Select Store to get in :");
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 16));
		lblNewLabel.setForeground(new Color(255, 153, 153));
		lblNewLabel.setBounds(581, 124, 158, 17);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblWelcomeHome = new JLabel("Welcome To your Store "+StoreOwnerName);
		lblWelcomeHome.setForeground(new Color(255, 204, 204));
		lblWelcomeHome.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 28));
		lblWelcomeHome.setBounds(638, 26, 393, 58);
		frame.getContentPane().add(lblWelcomeHome);
		
		
	
		//ImageIcon backHome =new ImageIcon("F:\\y3_1\\SW\\proj\\implementation\\SWEproject\\images\\homeIcon.jpg");
		//btnHomePage.setIcon(backHome);
	}
}
