import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Rectangle;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AdminAddingHospital extends JFrame {

	private JPanel contentPane;
	private JTextField nameTxt;
	private JTextField userNameTxt;
	private JTextField passTxt;
	private JTextField contactTxt;
	private JTextField testFeeTxt;
	private JTextField totalIcu;
	private JTextField engIcu;
	private JTextField totalGenBedTxt;
	private JTextField engGenBedTxt;
	private File hfile;
	private JTextField alert;

	public void saveToFile(ArrayList<Hospital> hospital, File file) {
		try {
			PrintWriter output = new PrintWriter(file);
			for (int i = 0; i < hospital.size(); i++) {
				output.println(hospital.get(i).getUserName());
				output.println(hospital.get(i).getPassword());
				output.println(hospital.get(i).getName());
				output.println(hospital.get(i).getAddress());
				output.println(hospital.get(i).getCategory());
				output.println(hospital.get(i).getDivision());
				output.println(hospital.get(i).getPhnNo());
				output.println(hospital.get(i).getTestFee());
				output.println(hospital.get(i).getTotalGeneralBed());
				output.println(hospital.get(i).getEngagedGeneralBed());
				output.println(hospital.get(i).getTotalIcu());
				output.println(hospital.get(i).getEngagedIcu());
				output.println(hospital.get(i).getNoOfCoronaDate());
				for (int j = 0; j < hospital.get(i).getNoOfCoronaDate(); j++) {
					output.print( hospital.get(i).getCoronaInfo().get(j).getYear());
					output.print(" ");
					output.print( hospital.get(i).getCoronaInfo().get(j).getMonth());
					output.print(" ");
					output.print( hospital.get(i).getCoronaInfo().get(j).getDay());
					output.print(" ");
					output.print( hospital.get(i).getCoronaInfo().get(j).getTotalTest());
					output.print(" ");
					output.print( hospital.get(i).getCoronaInfo().get(j).getTotalAffected());
					output.print(" ");
					output.print( hospital.get(i).getCoronaInfo().get(j).getTotalCured());
					output.print(" ");
					output.println( hospital.get(i).getCoronaInfo().get(j).getTotalDeath());
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
					//AddingHospital frame = new AddingHospital();
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
	public AdminAddingHospital(ArrayList<Hospital> hospital, ArrayList<DiagnosticCenter> diagnostic) {
		hfile = new File("Hospital.txt");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 793, 745);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBounds(new Rectangle(0, 0, 20, 20));
		contentPane_1.setBorder(new LineBorder(Color.BLUE, 2));
		contentPane_1.setBackground(new Color(105, 105, 105));
		contentPane_1.setAutoscrolls(true);
		contentPane.add(contentPane_1, BorderLayout.CENTER);

		nameTxt = new JTextField();
		nameTxt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		nameTxt.setColumns(10);
		nameTxt.setBounds(103, 12, 243, 36);
		contentPane_1.add(nameTxt);

		JPanel panel = new JPanel();
		panel.setBounds(0, 60, 93, 36);
		contentPane_1.add(panel);

		JLabel lblNewLabel_1 = new JLabel("Address:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel.add(lblNewLabel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 291, 122, 33);
		contentPane_1.add(panel_2);

		JLabel lblNewLabel_1_1 = new JLabel("User Name:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_2.add(lblNewLabel_1_1);

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
					alert.setText("Username already exist try another one and then press Enter");
				}
				else {
					alert.setText("");
				}
			}
		});
		userNameTxt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		userNameTxt.setColumns(10);
		userNameTxt.setBounds(132, 291, 139, 33);
		contentPane_1.add(userNameTxt);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(314, 291, 111, 33);
		contentPane_1.add(panel_2_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Password:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1_1.setBounds(12, 5, 98, 21);
		panel_2_1.add(lblNewLabel_1_1_1);

		passTxt = new JTextField();
		passTxt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		passTxt.setColumns(10);
		passTxt.setBounds(435, 288, 160, 36);
		contentPane_1.add(passTxt);

		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBounds(0, 13, 93, 33);
		contentPane_1.add(panel_2_2);

		JLabel lblNewLabel_1_1_2 = new JLabel("Name:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_2_2.add(lblNewLabel_1_1_2);

		JPanel panel_2_3 = new JPanel();
		panel_2_3.setBounds(0, 378, 122, 33);
		contentPane_1.add(panel_2_3);

		JLabel lblNewLabel_1_1_3 = new JLabel("Contact No:");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_2_3.add(lblNewLabel_1_1_3);

		contactTxt = new JTextField();
		contactTxt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contactTxt.setColumns(10);
		contactTxt.setBounds(132, 378, 174, 33);
		contentPane_1.add(contactTxt);

		JPanel panel_2_4 = new JPanel();
		panel_2_4.setBounds(-8, 421, 101, 33);
		contentPane_1.add(panel_2_4);

		JLabel lblNewLabel_1_1_4 = new JLabel("Division:");
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_2_4.add(lblNewLabel_1_1_4);

		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBox.setBounds(132, 421, 139, 33);
		comboBox.addItem("Dhaka");
		comboBox.addItem("Chattogram");
		comboBox.addItem("Rajshahi");
		comboBox.addItem("Khulna");
		comboBox.addItem("Barisal");
		comboBox.addItem("Sylhet");
		comboBox.addItem("Rangpur");
		comboBox.addItem("Mymensingh");
		comboBox.setSelectedItem(null);		
		contentPane_1.add(comboBox);

		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBounds(0, 480, 101, 33);
		contentPane_1.add(panel_2_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Test Fee:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1_1_1.setBounds(12, 5, 98, 21);
		panel_2_1_1.add(lblNewLabel_1_1_1_1);

		testFeeTxt = new JTextField();
		testFeeTxt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		testFeeTxt.setColumns(10);
		testFeeTxt.setBounds(135, 478, 79, 35);
		contentPane_1.add(testFeeTxt);

		JTextArea addressTxt = new JTextArea();
		addressTxt.setFont(new Font("Courier New", Font.PLAIN, 17));
		addressTxt.setBounds(103, 58, 265, 90);
		contentPane_1.add(addressTxt);

		JPanel panel_2_2_1 = new JPanel();
		panel_2_2_1.setBounds(8, 182, 93, 33);
		contentPane_1.add(panel_2_2_1);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Category:");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_2_2_1.add(lblNewLabel_1_1_2_1);

		ButtonGroup bg1 = new ButtonGroup();

		JRadioButton publicButton = new JRadioButton("Public");
		publicButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		publicButton.setBounds(122, 174, 79, 29);
		contentPane_1.add(publicButton);

		JRadioButton privateButton = new JRadioButton("Private");
		privateButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		privateButton.setBounds(122, 210, 79, 29);
		contentPane_1.add(privateButton);

		JRadioButton ngoButton = new JRadioButton("NGO");
		ngoButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		ngoButton.setBounds(122, 251, 79, 29);
		contentPane_1.add(ngoButton);

		bg1.add(publicButton);
		bg1.add(privateButton);
		bg1.add(ngoButton);

		JPanel panel_2_2_2 = new JPanel();
		panel_2_2_2.setBounds(0, 535, 179, 33);
		contentPane_1.add(panel_2_2_2);

		JLabel lblNewLabel_1_1_2_2 = new JLabel("Total General Bed:");
		lblNewLabel_1_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_2_2_2.add(lblNewLabel_1_1_2_2);

		JPanel panel_2_2_2_1 = new JPanel();
		panel_2_2_2_1.setBounds(276, 535, 194, 33);
		contentPane_1.add(panel_2_2_2_1);

		JLabel lblNewLabel_1_1_2_2_1 = new JLabel("Engaged General Bed:");
		lblNewLabel_1_1_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_2_2_2_1.add(lblNewLabel_1_1_2_2_1);

		JPanel panel_2_2_2_2 = new JPanel();
		panel_2_2_2_2.setBounds(-8, 589, 101, 33);
		contentPane_1.add(panel_2_2_2_2);

		JLabel lblNewLabel_1_1_2_2_2 = new JLabel("Total ICU:");
		lblNewLabel_1_1_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_2_2_2_2.add(lblNewLabel_1_1_2_2_2);

		JPanel panel_2_2_2_3 = new JPanel();
		panel_2_2_2_3.setBounds(211, 589, 122, 33);
		contentPane_1.add(panel_2_2_2_3);

		JLabel lblNewLabel_1_1_2_2_3 = new JLabel("Engaged ICU");
		lblNewLabel_1_1_2_2_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_2_2_2_3.add(lblNewLabel_1_1_2_2_3);

		totalIcu = new JTextField();
		totalIcu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		totalIcu.setBounds(118, 590, 61, 32);
		contentPane_1.add(totalIcu);
		totalIcu.setColumns(10);

		engIcu = new JTextField();
		engIcu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		engIcu.setColumns(10);
		engIcu.setBounds(364, 590, 61, 32);
		contentPane_1.add(engIcu);

		totalGenBedTxt = new JTextField();
		totalGenBedTxt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		totalGenBedTxt.setColumns(10);
		totalGenBedTxt.setBounds(197, 536, 61, 32);
		contentPane_1.add(totalGenBedTxt);

		engGenBedTxt = new JTextField();
		engGenBedTxt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		engGenBedTxt.setColumns(10);
		engGenBedTxt.setBounds(491, 536, 61, 32);
		contentPane_1.add(engGenBedTxt);

		JButton btnNewButton = new JButton("Registar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(alert.getText().equals("")) {
						Hospital h = new Hospital();
						h.setName(nameTxt.getText());
						h.setAddress(addressTxt.getText());
						h.setDivision(comboBox.getSelectedItem().toString());
						h.setUserName(userNameTxt.getText());
						h.setPassword(passTxt.getText());
						h.setPhnNo(contactTxt.getText());
						h.setTestFee(Integer.parseInt(testFeeTxt.getText()));
						h.setTotalGeneralBed(Integer.parseInt(totalGenBedTxt.getText()));
						h.setEngagedGeneralBed(Integer.parseInt(engGenBedTxt.getText()));
						h.setTotalIcu(Integer.parseInt(totalIcu.getText()));
						h.setEngagedIcu(Integer.parseInt(engIcu.getText()));
						if(publicButton.isSelected()) {
							h.setCategory("Public");
						}
						else if(privateButton.isSelected()) {
							h.setCategory("Private");
						}
						else if(ngoButton.isSelected()) {
							h.setCategory("NGO");
						}
						hospital.add(h);
						saveToFile(hospital,hfile);
						JOptionPane.showMessageDialog(null, "Registered Successfully. Now you can login using your username and password.");
						AdminAddingHospital.this.dispose();
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
		btnNewButton.setBounds(246, 648, 179, 44);
		contentPane_1.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminAddingHospital.this.dispose();
				new AdminOption(hospital, diagnostic).setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_2.setBounds(0, 653, 78, 35);
		contentPane_1.add(btnNewButton_2);

		alert = new JTextField();
		alert.setEditable(false);
		alert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		alert.setForeground(new Color(255, 0, 0));
		alert.setBounds(132, 334, 420, 33);
		contentPane_1.add(alert);
		alert.setColumns(10);

	}
}
