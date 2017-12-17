package src;

import javax.swing.*;
import java.awt.event.ActionListener;
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
		sotreController= new StoreUIController(user);
		homeGUI= home;
		initialize();
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
	 private void initialize() {
		frame = new JFrame();
		frame.setForeground(new Color(204, 102, 102));
		frame.getContentPane().setBackground(new Color(178, 34, 34));
		frame.setBounds(100, 100, 1241, 723);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
		
		JComboBox<String> selectStoreToShow = new JComboBox<String>();
		selectStoreToShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(selectStoreToShow.getSelectedItem()!="All stores")
				{
					sotreController.setCurrentStore(selectStoreToShow.getSelectedIndex()-1);
				}
			}
		});
		
		selectStoreToShow.addItem("All stores");

		selectStoreToShow.setBounds(636, 124, 175, 20);
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
				//frame.setVisible(false);
				new  ProductForm(StoreUI.this,false);
				
			}
		});
		btnSugestProduct.setBounds(33, 474, 159, 29);
		frame.getContentPane().add(btnSugestProduct);
		
		JButton btnOGetThe = new JButton("Most viewed product ");
		btnOGetThe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectStoreToShow.getSelectedItem().toString()=="All stores"){
					JOptionPane.showMessageDialog(null, "select a store first!!");
				}else
					new ProductInfGui(sotreController.getCurrentStore().getMostViewedP(),true);
				}
		});
		btnOGetThe.setBounds(34, 425, 158, 29);
		frame.getContentPane().add(btnOGetThe);
		
		txtGetstorename = new JTextField();		
		txtGetstorename.setBounds(214, 324, 144, 26);
		frame.getContentPane().add(txtGetstorename);
		txtGetstorename.setColumns(10);
		for(Store s:sotreController.getCurrentUser().getOwnedStores() ){
			comboMostViewed.addItem(s.getStoreName());
		}
		
		JButton btnHomePage = new JButton("Home Page");
		btnHomePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homeGUI.getFrmHomepage().setVisible(true);
				frame.setVisible(false);
			}
		});
		btnHomePage.setBounds(34, 276, 100, 23);
		frame.getContentPane().add(btnHomePage);
		JLabel IMAGE = new JLabel("");
		IMAGE.setBounds(34, 11, 304, 244);
		frame.getContentPane().add(IMAGE);
		ImageIcon backGround =new ImageIcon("images\\create-your-own-online-store.jpg");
		IMAGE.setIcon(backGround);
		
		
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
		
		JButton btnDisplayStoreProducts = new JButton("Display Products");
		btnDisplayStoreProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		btnDisplayStoreProducts.setBounds(863, 123, 168, 23);
		frame.getContentPane().add(btnDisplayStoreProducts);
		
		
		
		JLabel lblNewLabel = new JLabel("Select Store to get in :");
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 16));
		lblNewLabel.setForeground(new Color(255, 153, 153));
		lblNewLabel.setBounds(436, 124, 158, 17);
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
