import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class LoginReg extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordTxt;
	private JTextField userNameTxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//LoginReg frame = new LoginReg(hospital,diagnostic);
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginReg(ArrayList<Hospital> hospital, ArrayList<DiagnosticCenter> diagnostic) {
		//setUndecorated(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 835, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel.setBackground(new Color(0, 139, 139));
		contentPane.add(panel, BorderLayout.SOUTH);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(318, 151, 350, 53);
		panel.add(panel_1);

		textField = new JTextField();
		textField.setText("UserName");
		textField.setColumns(10);
		textField.setBounds(10, 10, 179, 33);
		panel_1.add(textField);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(318, 240, 350, 53);
		panel.add(panel_1_1);

		textField_1 = new JTextField();
		textField_1.setText("Password");
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		textField_1.setColumns(10);
		textField_1.setBounds(10, 10, 179, 33);
		panel_1_1.add(textField_1);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(373, 325, 253, 35);
		panel.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setSize(new Dimension(2, 2));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setBounds(929, 0, 20, 20);
		panel.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		panel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_2.setLayout(null);
		panel_2.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel_2.setBackground(new Color(0, 51, 51));
		contentPane.add(panel_2, BorderLayout.CENTER);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBounds(199, 168, 350, 53);
		panel_2.add(panel_1_2);

		userNameTxt = new JTextField();
		userNameTxt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		userNameTxt.setBounds(110, 0, 240, 53);
		panel_1_2.add(userNameTxt);
		userNameTxt.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("User Name:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(0, 0, 110, 53);
		panel_1_2.add(lblNewLabel_2);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBounds(199, 233, 350, 53);
		panel_2.add(panel_1_1_1);

		passwordTxt = new JPasswordField();
		passwordTxt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		passwordTxt.setBounds(109, 0, 241, 53);
		panel_1_1_1.add(passwordTxt);

		JLabel lblNewLabel_2_1 = new JLabel("Password:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_1.setBounds(0, 0, 105, 53);
		panel_1_1_1.add(lblNewLabel_2_1);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean message = true;
				if(userNameTxt.getText().equals("admin") && passwordTxt.getText().equals("admin123")) {
					message = false;
					LoginReg.this.dispose();
					new AdminOption(hospital,diagnostic).setVisible(true);
				}
				else {
					for (int i = 0; i < hospital.size(); i++) {
						if (userNameTxt.getText().equals(hospital.get(i).getUserName()) && passwordTxt.getText().equals(hospital.get(i).getPassword())) {
							message = false;
							LoginReg.this.dispose();
							new ShowHospital(hospital,i).setVisible(true);
						}
					}
					for (int i = 0; i < diagnostic.size(); i++) {
						if (userNameTxt.getText().equals(diagnostic.get(i).getUserName()) && passwordTxt.getText().equals(diagnostic.get(i).getPassword())) {
							message = false;
							LoginReg.this.dispose();
							new ShowDiagnostic(diagnostic,i).setVisible(true);
						}
					}
					if(message) {
						JOptionPane.showMessageDialog(null, "UnserName or Password Incorrect. Please Try Again.");
						userNameTxt.setText("");
						passwordTxt.setText("");
					}
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLogin.setBounds(277, 308, 239, 47);
		panel_2.add(btnLogin);

		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setSize(new Dimension(2, 2));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBackground(Color.RED);
		lblNewLabel_1.setBounds(929, 0, 20, 20);
		panel_2.add(lblNewLabel_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(351, 123, 45, 35);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("OR");
		lblNewLabel_3.setBounds(0, 0, 42, 35);
		panel_3.add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginReg.this.dispose();
				new RegOption(hospital,diagnostic).setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setBounds(259, 50, 239, 63);
		panel_2.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginReg.this.dispose();
				new MainMenu().setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_2.setBounds(0, 6, 78, 35);
		panel_2.add(btnNewButton_2);
	}
}
