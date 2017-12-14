package src;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class CartPage {

	private JFrame frmCartpage;
	private HomePage homePage;
	private CartController cartController;
	private JTable table;

	
	public CartPage(Cart cart,HomePage homepage) {
		initialize();
		cartController = new CartController(homepage.getHomepagecontroller().getUser());
		cartController.setUserCart(cart);
		this.homePage = homepage;
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
	private void initialize() {
		frmCartpage = new JFrame();
		frmCartpage.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmCartpage.setTitle("CartPage");
		frmCartpage.setSize(new Dimension(1650, 1080));
		frmCartpage.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmCartpage.setBounds(100, 100, 888, 493);
		frmCartpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCartpage.getContentPane().setLayout(null);
		frmCartpage.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "ViewCart", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(304, 154, 827, 397);
		frmCartpage.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton ReturnHome = new JButton("Home Page");
		ReturnHome.setBounds(233, 34, 118, 23);
		panel.add(ReturnHome);
		
		JButton Purchase = new JButton("Purchase");
		Purchase.setBounds(474, 34, 101, 23);
		panel.add(Purchase);
		
		table = new JTable();
		table.setBounds(10, 68, 807, 318);
		panel.add(table);
		Purchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				float balance = cartController.EmptyCart();
				new PaymentUI(balance,homePage);
				frmCartpage.setVisible(false);
			}
		});
		ReturnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				homePage.getFrmHomepage().setVisible(true);
				frmCartpage.setVisible(false);
			}
		});
	}
}
