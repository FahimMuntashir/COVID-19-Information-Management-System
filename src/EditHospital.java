import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class EditHospital extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField category;
	private JTextField division;
	private JTextField contact;
	private JTextField testFee;
	private JTextField engGenBed;
	private JTextField totIcu;
	private JTextField engIcu;
	private JTextField totGenBed;
	private DefaultTableModel model;
	private DefaultTableModel model1;
	private File hfile;

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
					//ShowHospital frame = new ShowHospital();
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
	public EditHospital(ArrayList<Hospital>hospital, int i) {
		hfile = new File("Hospital.txt");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 923, 595);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBounds(0, 10, 93, 33);
		contentPane.add(panel_2_2);

		JLabel lblNewLabel_1_1_2 = new JLabel("Name:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_2_2.add(lblNewLabel_1_1_2);

		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 17));
		name.setBounds(103, 10, 281, 33);
		contentPane.add(name);
		name.setColumns(10);
		name.setText(hospital.get(i).getName());

		JPanel panel = new JPanel();
		panel.setBounds(0, 53, 93, 36);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Address:");
		lblNewLabel_1.setBounds(10, 5, 73, 21);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel.add(lblNewLabel_1);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(133, 74, -27, -17);
		contentPane.add(textArea);

		JTextArea address = new JTextArea();
		address.setFont(new Font("Courier New", Font.PLAIN, 17));
		address.setBounds(103, 53, 390, 65);
		contentPane.add(address);
		address.setText(hospital.get(i).getAddress());

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 135, 93, 36);
		contentPane.add(panel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Category:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(0, 5, 101, 21);
		panel_1.add(lblNewLabel_1_1);

		category = new JTextField();
		category.setEditable(false);
		category.setFont(new Font("Tahoma", Font.PLAIN, 17));
		category.setBounds(103, 135, 136, 33);
		contentPane.add(category);
		category.setColumns(10);
		category.setText(hospital.get(i).getCategory());

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(0, 181, 93, 36);
		contentPane.add(panel_2);

		JLabel lblNewLabel_1_2 = new JLabel("Division:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_2.setBounds(10, 5, 73, 21);
		panel_2.add(lblNewLabel_1_2);

		division = new JTextField();
		division.setEditable(false);
		division.setFont(new Font("Tahoma", Font.PLAIN, 17));
		division.setBounds(103, 184, 189, 33);
		contentPane.add(division);
		division.setColumns(10);
		division.setText(hospital.get(i).getDivision());

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(312, 181, 121, 36);
		contentPane.add(panel_3);

		JLabel lblNewLabel_1_3 = new JLabel("Contact No:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_3.setBounds(10, 5, 101, 21);
		panel_3.add(lblNewLabel_1_3);

		contact = new JTextField();
		contact.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contact.setBounds(456, 181, 232, 36);
		contentPane.add(contact);
		contact.setColumns(10);
		contact.setText(hospital.get(i).getPhnNo());

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(0, 228, 93, 36);
		contentPane.add(panel_4);

		JLabel lblNewLabel_1_4 = new JLabel("Test Fee");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_4.setBounds(10, 5, 73, 21);
		panel_4.add(lblNewLabel_1_4);

		testFee = new JTextField();
		testFee.setFont(new Font("Tahoma", Font.PLAIN, 17));
		testFee.setColumns(10);
		testFee.setBounds(103, 227, 136, 33);
		contentPane.add(testFee);
		testFee.setText(String.valueOf(hospital.get(i).getTestFee()));

		JPanel panel_2_2_2 = new JPanel();
		panel_2_2_2.setBounds(0, 274, 179, 33);
		contentPane.add(panel_2_2_2);

		JLabel lblNewLabel_1_1_2_2 = new JLabel("Total General Bed:");
		lblNewLabel_1_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_2_2_2.add(lblNewLabel_1_1_2_2);

		JPanel panel_2_2_2_1 = new JPanel();
		panel_2_2_2_1.setBounds(276, 274, 194, 33);
		contentPane.add(panel_2_2_2_1);

		JLabel lblNewLabel_1_1_2_2_1 = new JLabel("Engaged General Bed:");
		lblNewLabel_1_1_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_2_2_2_1.add(lblNewLabel_1_1_2_2_1);

		JPanel panel_2_2_2_2 = new JPanel();
		panel_2_2_2_2.setBounds(0, 317, 101, 33);
		contentPane.add(panel_2_2_2_2);

		JLabel lblNewLabel_1_1_2_2_2 = new JLabel("Total ICU:");
		lblNewLabel_1_1_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_2_2_2_2.add(lblNewLabel_1_1_2_2_2);

		JPanel panel_2_2_2_3 = new JPanel();
		panel_2_2_2_3.setBounds(262, 317, 122, 33);
		contentPane.add(panel_2_2_2_3);

		JLabel lblNewLabel_1_1_2_2_3 = new JLabel("Engaged ICU");
		lblNewLabel_1_1_2_2_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_2_2_2_3.add(lblNewLabel_1_1_2_2_3);

		engGenBed = new JTextField();
		engGenBed.setFont(new Font("Tahoma", Font.PLAIN, 17));
		engGenBed.setBounds(480, 274, 81, 33);
		contentPane.add(engGenBed);
		engGenBed.setColumns(10);
		engGenBed.setText(String.valueOf(hospital.get(i).getEngagedGeneralBed()));

		totIcu = new JTextField();
		totIcu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		totIcu.setColumns(10);
		totIcu.setBounds(121, 317, 81, 33);
		contentPane.add(totIcu);
		totIcu.setText(String.valueOf(hospital.get(i).getTotalIcu()));

		engIcu = new JTextField();
		engIcu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		engIcu.setColumns(10);
		engIcu.setBounds(394, 317, 81, 33);
		contentPane.add(engIcu);
		engIcu.setText(String.valueOf(hospital.get(i).getEngagedIcu()));

		totGenBed = new JTextField();
		totGenBed.setFont(new Font("Tahoma", Font.PLAIN, 17));
		totGenBed.setColumns(10);
		totGenBed.setBounds(189, 274, 75, 33);
		contentPane.add(totGenBed);
		totGenBed.setText(String.valueOf(hospital.get(i).getTotalGeneralBed()));
		model = new DefaultTableModel();
		Object[] column = {"Total Tested","Affected", "Cured", "Death"};
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		model.addRow(row);
		model1 = new DefaultTableModel();
		Object[] column1 = {"Total Tested","Affected", "Cured", "Death"};
		Object[] row1 = new Object[0];
		model1.setColumnIdentifiers(column1);
		model1.addRow(row1);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditHospital.this.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setBounds(786, 10, 101, 43);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					hospital.get(i).setName(name.getText());
					hospital.get(i).setAddress(address.getText());
					hospital.get(i).setPhnNo(contact.getText());
					hospital.get(i).setTestFee(Integer.parseInt(testFee.getText()));
					hospital.get(i).setTotalGeneralBed(Integer.parseInt(totGenBed.getText()));
					hospital.get(i).setEngagedGeneralBed(Integer.parseInt(engGenBed.getText()));
					hospital.get(i).setTotalIcu(Integer.parseInt(totIcu.getText()));
					hospital.get(i).setEngagedIcu(Integer.parseInt(engIcu.getText()));
					saveToFile(hospital,hfile);
					JOptionPane.showMessageDialog(null, "Information Saved Successfully.");
					EditHospital.this.dispose();
					new ShowHospital(hospital,i).setVisible(true);
				}catch(NullPointerException ex) {
					JOptionPane.showMessageDialog(null, "Please fill all the information.");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(208, 394, 309, 43);
		contentPane.add(btnNewButton);
	}
}
