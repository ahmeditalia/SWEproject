package src;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class CartPage {

	private JFrame frmCartpage;
	private HomePage homePage;
	private CartController cartController;
	private JTable table;

	
	public CartPage(Cart cart,HomePage homepage) {
		this.cartController = new CartController(cart);
		this.homePage = homepage;
		initialize();
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public CartPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public CartController getCartController() {
		return cartController;
	} 
	
	
	private void updatetable(DefaultTableModel model) {
		int rowcount=model.getRowCount();
		for(int i=rowcount-1;i>=0;i--)
		{
			model.removeRow(i);
		}
		for (Product product : cartController.getUserCart().getCartProducts()) {
			Object[] row = {product.getName(), Float.toString(product.getPrice()),
					Integer.toString(product.getQuantity()), product.getCategory(), product.getBrand(),
					product.getStore().getStoreName(), false };
			model.addRow(row);
		}
	}
	

	
	private void initialize() {
		frmCartpage = new JFrame();
		frmCartpage.getContentPane().setBackground(new Color(178, 34, 34));
		frmCartpage.setTitle("CartPage");
		frmCartpage.setSize(new Dimension(1650, 1080));
		frmCartpage.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmCartpage.setBounds(100, 100, 888, 493);
		frmCartpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCartpage.getContentPane().setLayout(null);
		frmCartpage.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cart", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(304, 154, 827, 397);
		frmCartpage.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton ReturnHome = new JButton("Home Page");
		ReturnHome.setBounds(233, 34, 118, 23);
		panel.add(ReturnHome);
		
		JButton Purchase = new JButton("Purchase");
		Purchase.setBounds(474, 34, 101, 23);
		panel.add(Purchase);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 114, 807, 272);
		panel.add(scrollPane);
		String[] columnsnames = {"Product Name", "Price","Quantity","Category", "Brand", "Store" };
		table = new JTable(new DefaultTableModel(new String[][] {},columnsnames));
		scrollPane.setViewportView(table);
		Purchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new PaymentUI(CartPage.this,homePage);
				frmCartpage.setVisible(false);
			}
		});
		ReturnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				homePage.getFrmHomepage().setVisible(true);
				frmCartpage.setVisible(false);
			}
		});
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		updatetable(model);
	}
}
