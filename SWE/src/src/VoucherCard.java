package src;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class VoucherCard extends PaymentUI {

	private JFrame VoucherCard;
	private JTextField cardnumber;
	public VoucherCard() {
		initialize();
	}
	/**
	 * @wbp.parser.constructor
	 */

	public VoucherCard(CartPage cartPage,HomePage homePage) {
		this.homePage = homePage;
		this.cartPage=cartPage;
		initialize();
	}
	
	private void initialize() {
		VoucherCard = new JFrame();
		VoucherCard.getContentPane().setBackground(Color.LIGHT_GRAY);
		VoucherCard.setTitle("Voucher Card");
		VoucherCard.setExtendedState(Frame.MAXIMIZED_BOTH);
		VoucherCard.setBounds(100, 100, 888, 493);
		VoucherCard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VoucherCard.getContentPane().setLayout(null);
		VoucherCard.setVisible(true);
		VoucherCard.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				homePage.getDatabase().writeAll();
			}
		});
		JPanel panel = new JPanel();
		panel.setBounds(460, 202, 488, 303);
		VoucherCard.getContentPane().add(panel);
		panel.setLayout(null);
		JLabel lblNewLabel = new JLabel("Voucher Card Number :");
		lblNewLabel.setBounds(147, 65, 173, 14);
		panel.add(lblNewLabel);
		cardnumber = new JTextField();
		cardnumber.setBounds(147, 106, 173, 20);
		panel.add(cardnumber);
		cardnumber.setColumns(10);
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cardnumber.getText().equals("")
						|| !homePage.getHomepagecontroller().checkVoucherCards(cardnumber.getText())) {
					JOptionPane.showMessageDialog(null, "Incrroect VoucherNumber");
					cardnumber.setText("");
					return;
				}
				JOptionPane.showMessageDialog(null, cartPage.getCartController().EmptyCart(homePage.getDatabase()));
				homePage.getFrmHomepage().setVisible(true);
				VoucherCard.setVisible(false);
			}
		});
		btnSubmit.setBounds(183, 191, 114, 23);
		panel.add(btnSubmit);
		
		JButton btnHomepage = new JButton("HomePage");
		btnHomepage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VoucherCard.setVisible(false);
				homePage.getFrmHomepage().setVisible(true);
			}
		});
		btnHomepage.setBounds(341, 38, 89, 23);
		panel.add(btnHomepage);
	}
}
