package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class RegisterPage {

	private JFrame frmRegister;
	private JTextField usernametext;
	private JPasswordField passowrdtext;
	private JTextField mailtext;
	private JTextField gendertext;
	private JTextField phonenumbertext;
	private JTextField addresstext;
	private HomePage homePage;

	/**
	 * @wbp.parser.constructor
	 */

	public RegisterPage(HomePage homePage) {
		this.homePage = homePage;
		initialize();
	}

	public RegisterPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegister = new JFrame();
		frmRegister.getContentPane().setBackground(new Color(178, 34, 34));
		frmRegister.setSize(1650, 1080);
		frmRegister.setTitle("Register");
		frmRegister.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmRegister.setBounds(100, 100, 888, 493);
		frmRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegister.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 153, 153));
		panel.setBorder(
				new TitledBorder(null, "Register", TitledBorder.CENTER, TitledBorder.TOP, null, Color.DARK_GRAY));
		panel.setBounds(430, 60, 521, 644);
		frmRegister.getContentPane().add(panel);
		panel.setLayout(null);

		usernametext = new JTextField();
		usernametext.setBounds(176, 54, 172, 20);
		panel.add(usernametext);
		usernametext.setColumns(10);

		passowrdtext = new JPasswordField();
		passowrdtext.setBounds(176, 138, 172, 20);
		panel.add(passowrdtext);
		passowrdtext.setColumns(10);

		mailtext = new JTextField();
		mailtext.setBounds(176, 222, 172, 20);
		panel.add(mailtext);
		mailtext.setColumns(10);

		gendertext = new JTextField();
		gendertext.setBounds(176, 306, 172, 20);
		panel.add(gendertext);
		gendertext.setColumns(10);

		phonenumbertext = new JTextField();
		phonenumbertext.setBounds(176, 390, 172, 20);
		panel.add(phonenumbertext);
		phonenumbertext.setColumns(10);

		addresstext = new JTextField();
		addresstext.setBounds(176, 474, 172, 20);
		panel.add(addresstext);
		addresstext.setColumns(10);

		JLabel username = new JLabel("User Name : ");
		username.setBounds(176, 29, 121, 14);
		panel.add(username);

		JLabel Password = new JLabel("Passowrd :");
		Password.setBounds(176, 113, 121, 14);
		panel.add(Password);

		JLabel email = new JLabel("Email :");
		email.setBounds(176, 197, 121, 14);
		panel.add(email);

		JLabel gender = new JLabel("Gender :");
		gender.setBounds(176, 281, 121, 14);
		panel.add(gender);

		JLabel phone_number = new JLabel("Phone Number :");
		phone_number.setBounds(176, 365, 121, 14);
		panel.add(phone_number);

		JLabel address = new JLabel("Address :");
		address.setBounds(176, 449, 121, 14);
		panel.add(address);

		JButton submit = new JButton("Submit");
		submit.setBounds(188, 603, 109, 30);
		panel.add(submit);

		JLabel lblAccontType = new JLabel("Accont Type :");
		lblAccontType.setBounds(80, 525, 100, 14);
		panel.add(lblAccontType);

		JRadioButton normaluser = new JRadioButton("Normal user");
		normaluser.setBounds(188, 521, 109, 23);
		panel.add(normaluser);

		JRadioButton storeowner = new JRadioButton("Store Owner");
		storeowner.setBounds(188, 547, 109, 23);
		panel.add(storeowner);
		frmRegister.setVisible(true);

		JRadioButton Adminitrator = new JRadioButton("Adminitrator");
		Adminitrator.setBounds(188, 573, 109, 23);
		panel.add(Adminitrator);

		ButtonGroup check = new ButtonGroup();
		check.add(normaluser);
		check.add(storeowner);
		check.add(Adminitrator);

		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((!normaluser.isSelected() && !storeowner.isSelected() && !Adminitrator.isSelected())
						|| usernametext.getText().equals("") || !(passowrdtext.getPassword().length > 0)
						|| mailtext.getText().equals("") || phonenumbertext.getText().equals("")
						|| gendertext.getText().equals("") || addresstext.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "All information require");
					return;
				}
				int type = (normaluser.isSelected() ? 1 : (storeowner.isSelected() ? 2 : 3));
				String password = String.valueOf(passowrdtext.getPassword());
				homePage.getHomepagecontroller().Register(usernametext.getText(), password, mailtext.getText(),
						phonenumbertext.getText(), gendertext.getText(), addresstext.getText(), type);
				homePage.getFrmHomepage().setVisible(true);
				frmRegister.setVisible(false);
			}
		});
	}
}
