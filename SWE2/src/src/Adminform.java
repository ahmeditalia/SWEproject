package src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class Adminform {

	private JFrame frame;

	AdminController adminCntroller= new AdminController();
	Adminform(Administrator admin){
		
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminform window = new Adminform();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Adminform() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 542, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAddProductTo = new JButton("Add product to the system ");
		btnAddProductTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ProductForm pGui= new ProductForm(Adminform.this);
			}
			
		});
		btnAddProductTo.setBounds(26, 138, 224, 34);
		frame.getContentPane().add(btnAddProductTo);
		
		JButton btnNewButton = new JButton("Add Suggested Products");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton.setBounds(26, 93, 224, 34);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Show Suggested Products");
		btnNewButton_1.setBounds(26, 48, 224, 34);
		frame.getContentPane().add(btnNewButton_1);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		for (int i = 0; i < crunchifyList.size(); i++) {
			System.out.println(crunchifyList.get(i));
		}
		comboBox.setBounds(26, 183, 224, 34);
		frame.getContentPane().add(comboBox);
		
	}
}
