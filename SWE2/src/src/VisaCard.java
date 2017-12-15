package src;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisaCard extends PaymentUI {

	private JFrame VisaCard;
	private JTextField username;
	private JTextField password;
	private JTextField cardnumber;

	/**
	 * Create the application.
	 */
	public VisaCard() {
		initialize();
	}

	/**
	 * @wbp.parser.constructor
	 */
	public VisaCard(HomePage homePage) {
		this.homePage = homePage;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		VisaCard = new JFrame();
		VisaCard.getContentPane().setBackground(Color.LIGHT_GRAY);
		VisaCard.setTitle("Visa Card");
		VisaCard.setExtendedState(Frame.MAXIMIZED_BOTH);
		VisaCard.setBounds(100, 100, 888, 493);
		VisaCard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VisaCard.getContentPane().setLayout(null);
		VisaCard.setVisible(true);

		JPanel panel = new JPanel();
		panel.setBounds(439, 146, 577, 369);
		VisaCard.getContentPane().add(panel);
		panel.setLayout(null);

		username = new JTextField();
		username.setBounds(213, 77, 151, 20);
		panel.add(username);
		username.setColumns(10);

		password = new JTextField();
		password.setColumns(10);
		password.setBounds(213, 135, 151, 20);
		panel.add(password);

		cardnumber = new JTextField();
		cardnumber.setColumns(10);
		cardnumber.setBounds(213, 195, 151, 20);
		panel.add(cardnumber);

		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setBounds(214, 52, 100, 14);
		panel.add(lblUserName);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(214, 110, 100, 14);
		panel.add(lblPassword);

		JLabel lblVisaCardnumber = new JLabel("Visa CardNumber :");
		lblVisaCardnumber.setBounds(213, 170, 151, 14);
		panel.add(lblVisaCardnumber);

		JButton Submit = new JButton("Submit");
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (username.getText().equals("") || password.getText().equals("") || cardnumber.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "All information require");
				}
				homePage.getFrmHomepage().setVisible(true);
				VisaCard.setVisible(false);
			}
		});
		Submit.setBounds(241, 274, 100, 23);
		panel.add(Submit);

	}

}
