package src;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class PaymentUI {

	private JFrame Payment;
	private CartPage cartPage;
	protected HomePage homePage;

	/**
	 * @wbp.parser.constructor
	 */
	public PaymentUI(CartPage cartpage, HomePage homePage) {
		this.homePage = homePage;
		cartPage=cartpage;
		initialize();
	}

	public PaymentUI() {
		//initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Payment = new JFrame();
		Payment.getContentPane().setBackground(new Color(178, 34, 34));
		Payment.setTitle("Payment");
		Payment.setExtendedState(Frame.MAXIMIZED_BOTH);
		Payment.setBounds(100, 100, 888, 493);
		Payment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Payment.getContentPane().setLayout(null);
		Payment.setVisible(true);

		JPanel panel = new JPanel();
		panel.setBounds(384, 161, 627, 400);
		Payment.getContentPane().add(panel);
		panel.setLayout(null);

		JRadioButton visacard = new JRadioButton("Visa Card");
		visacard.setBounds(241, 107, 109, 23);
		panel.add(visacard);

		JRadioButton vouchercard = new JRadioButton("Voucher Card");
		vouchercard.setBounds(241, 143, 109, 23);
		panel.add(vouchercard);

		JRadioButton payondelivary = new JRadioButton("Pay On Delivary");
		payondelivary.setBounds(241, 180, 145, 23);
		panel.add(payondelivary);

		ButtonGroup group = new ButtonGroup();
		group.add(visacard);
		group.add(vouchercard);
		group.add(payondelivary);

		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!visacard.isSelected() && !vouchercard.isSelected() && !payondelivary.isSelected()) {
					return;
				}
					if (visacard.isSelected()) {
						new VisaCard(homePage);
						Payment.setVisible(false);
					} else if (vouchercard.isSelected()) {
						new VoucherCard(homePage);
						Payment.setVisible(false);
					} else {
						cartController.EmptyCart();
						homePage.getFrmHomepage().setVisible(true);
						Payment.setVisible(false);
					}
			}
		});
		submit.setBounds(241, 251, 109, 23);
		panel.add(submit);

		JLabel lblChooseYourPayment = new JLabel("Choose your payment Method :");
		lblChooseYourPayment.setBounds(214, 75, 211, 14);
		panel.add(lblChooseYourPayment);
	}

}
