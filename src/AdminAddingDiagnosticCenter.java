import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Rectangle;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AdminAddingDiagnosticCenter extends JFrame {

	private JPanel contentPane;
	private final JTextField nameTxt = new JTextField();
	private JTextField userNameTxt;
	private JTextField passTxt;
	private JTextField contactTxt;
	private JTextField testFeeTxt;
	private File dcfile;	
	private JTextField alert;

	public void saveToFile(ArrayList<DiagnosticCenter> diagnostic, File file) {
		try {
			PrintWriter output = new PrintWriter(file);
			for (int i = 0; i < diagnostic.size(); i++) {
				output.println(diagnostic.get(i).getUserName());
				output.println(diagnostic.get(i).getPassword());
				output.println(diagnostic.get(i).getName());
				output.println(diagnostic.get(i).getAddress());
				output.println(diagnostic.get(i).getDivision());
				output.println(diagnostic.get(i).getPhnNo());
				output.println(diagnostic.get(i).getTestFee());
				output.println(diagnostic.get(i).getNoOfCoronaDate());
				for (int j = 0; j < diagnostic.get(i).getNoOfCoronaDate(); j++) {
					output.print( diagnostic.get(i).getCoronaInfo().get(j).getYear());
					output.print(" ");
					output.print( diagnostic.get(i).getCoronaInfo().get(j).getMonth());
					output.print(" ");
					output.print( diagnostic.get(i).getCoronaInfo().get(j).getDay());
					output.print(" ");
					output.print( diagnostic.get(i).getCoronaInfo().get(j).getTotalTest());
					output.print(" ");
					output.print( diagnostic.get(i).getCoronaInfo().get(j).getTotalAffected());
					output.print(" ");
					output.print( diagnostic.get(i).getCoronaInfo().get(j).getTotalCured());
					output.print(" ");
					output.println( diagnostic.get(i).getCoronaInfo().get(j).getTotalDeath());
				}
			}
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print("Error");
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//AddingDiagnosticCenter frame = new AddingDiagnosticCenter();
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
	@SuppressWarnings("unchecked")
	public AdminAddingDiagnosticCenter(ArrayList<Hospital> hospital, ArrayList<DiagnosticCenter> diagnostic) {
		dcfile = new File("Diagnostic Center.txt");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 752, 552);
		contentPane = new JPanel();
		contentPane.setAutoscrolls(true);
		contentPane.setBounds(new Rectangle(0, 0, 20, 20));
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new LineBorder(Color.BLUE, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		nameTxt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		nameTxt.setBounds(136, 13, 243, 36);
		contentPane.add(nameTxt);
		nameTxt.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBounds(0, 60, 93, 36);
		contentPane.add(panel);

		JLabel lblNewLabel_1 = new JLabel("Address:");
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 174, 122, 33);
		contentPane.add(panel_2);

		JLabel lblNewLabel_1_1 = new JLabel("User Name:");
		panel_2.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));

		userNameTxt = new JTextField();
		userNameTxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean print = false;
				for (int i = 0; i < hospital.size(); i++) {
					if (userNameTxt.getText().equals(hospital.get(i).getUserName())) {
						print = true;
					}
				}
				for (int i = 0; i < diagnostic.size(); i++) {
					if (userNameTxt.getText().equals(diagnostic.get(i).getUserName())) {
						print = true;
					}
				}
				if(print) {
					alert.setText("Username already exist try another one and then press Enter.");
				}
				else {
					alert.setText("");
				}
			}
		});
		userNameTxt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		userNameTxt.setBounds(136, 174, 139, 33);
		contentPane.add(userNameTxt);
		userNameTxt.setColumns(10);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(285, 174, 111, 33);
		contentPane.add(panel_2_1);
		panel_2_1.setLayout(null);

		JLabel lblNewLabel_1_1_1 = new JLabel("Password:");
		lblNewLabel_1_1_1.setBounds(12, 5, 98, 21);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_2_1.add(lblNewLabel_1_1_1);

		passTxt = new JTextField();
		passTxt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		passTxt.setBounds(406, 174, 160, 36);
		contentPane.add(passTxt);
		passTxt.setColumns(10);

		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBounds(0, 13, 93, 33);
		contentPane.add(panel_2_2);

		JLabel lblNewLabel_1_1_2 = new JLabel("Name:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_2_2.add(lblNewLabel_1_1_2);

		JPanel panel_2_3 = new JPanel();
		panel_2_3.setBounds(0, 257, 122, 33);
		contentPane.add(panel_2_3);

		JLabel lblNewLabel_1_1_3 = new JLabel("Contact No:");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_2_3.add(lblNewLabel_1_1_3);

		contactTxt = new JTextField();
		contactTxt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contactTxt.setBounds(136, 257, 174, 33);
		contentPane.add(contactTxt);
		contactTxt.setColumns(10);

		JPanel panel_2_4 = new JPanel();
		panel_2_4.setBounds(0, 300, 101, 33);
		contentPane.add(panel_2_4);

		JLabel lblNewLabel_1_1_4 = new JLabel("Division:");
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_2_4.add(lblNewLabel_1_1_4);

		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBox.setBounds(136, 300, 122, 33);
		comboBox.addItem("Dhaka");
		comboBox.addItem("Chattogram");
		comboBox.addItem("Rajshahi");
		comboBox.addItem("Khulna");
		comboBox.addItem("Barisal");
		comboBox.addItem("Sylhet");
		comboBox.addItem("Rangpur");
		comboBox.addItem("Mymensingh");
		comboBox.setSelectedItem(null);
		contentPane.add(comboBox);

		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBounds(0, 346, 101, 33);
		contentPane.add(panel_2_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Test Fee:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1_1_1.setBounds(12, 5, 98, 21);
		panel_2_1_1.add(lblNewLabel_1_1_1_1);

		testFeeTxt = new JTextField();
		testFeeTxt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		testFeeTxt.setBounds(136, 344, 79, 35);
		contentPane.add(testFeeTxt);
		testFeeTxt.setColumns(10);

		JTextArea addressTxt = new JTextArea();
		addressTxt.setFont(new Font("Courier New", Font.PLAIN, 17));
		addressTxt.setBounds(136, 61, 265, 90);
		contentPane.add(addressTxt);

		JButton btnNewButton = new JButton("Registar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(alert.getText().equals("")) {
						DiagnosticCenter dc = new DiagnosticCenter();
						dc.setName(nameTxt.getText());
						dc.setAddress(addressTxt.getText());
						dc.setDivision(comboBox.getSelectedItem().toString());
						dc.setUserName(userNameTxt.getText());
						dc.setPassword(passTxt.getText());
						dc.setPhnNo(contactTxt.getText());
						dc.setTestFee(Integer.parseInt(testFeeTxt.getText()));
						diagnostic.add(dc);
						saveToFile(diagnostic,dcfile);
						JOptionPane.showMessageDialog(null, "Registered Successfully. Now you can login using your username and password.");
						AdminAddingDiagnosticCenter.this.dispose();
						new AdminOption(hospital,diagnostic).setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Please select another username.");	
					}
				}catch(NullPointerException ex) {
					JOptionPane.showMessageDialog(null, "Please fill all the information.");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(215, 396, 179, 44);
		contentPane.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminAddingDiagnosticCenter.this.dispose();
				new AdminOption(hospital,diagnostic).setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_2.setBounds(0, 401, 78, 35);
		contentPane.add(btnNewButton_2);

		alert = new JTextField();
		alert.setForeground(Color.RED);
		alert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		alert.setEditable(false);
		alert.setColumns(10);
		alert.setBounds(136, 214, 430, 33);
		contentPane.add(alert);
	}
}
