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
public class EditDiagnostic extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField division;
	private JTextField contact;
	private JTextField testFee;
	private DefaultTableModel model;
	private DefaultTableModel model1;
	private File dcfile;

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
	public EditDiagnostic(ArrayList<DiagnosticCenter>diagnostic, int i) {
		dcfile = new File("Diagnostic Center.txt");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 959, 523);
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
		name.setBounds(133, 10, 281, 33);
		contentPane.add(name);
		name.setColumns(10);
		name.setText(diagnostic.get(i).getName());

		JPanel panel = new JPanel();
		panel.setBounds(0, 64, 93, 36);
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
		address.setBounds(132, 71, 390, 65);
		contentPane.add(address);
		address.setText(diagnostic.get(i).getAddress());

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(0, 158, 93, 36);
		contentPane.add(panel_2);

		JLabel lblNewLabel_1_2 = new JLabel("Division:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_2.setBounds(10, 5, 73, 21);
		panel_2.add(lblNewLabel_1_2);

		division = new JTextField();
		division.setEditable(false);
		division.setFont(new Font("Tahoma", Font.PLAIN, 17));
		division.setBounds(133, 161, 189, 33);
		contentPane.add(division);
		division.setColumns(10);
		division.setText(diagnostic.get(i).getDivision());

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(0, 204, 121, 36);
		contentPane.add(panel_3);

		JLabel lblNewLabel_1_3 = new JLabel("Contact No:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_3.setBounds(10, 5, 101, 21);
		panel_3.add(lblNewLabel_1_3);

		contact = new JTextField();
		contact.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contact.setBounds(133, 204, 232, 36);
		contentPane.add(contact);
		contact.setColumns(10);
		contact.setText(diagnostic.get(i).getPhnNo());

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(0, 250, 93, 36);
		contentPane.add(panel_4);

		JLabel lblNewLabel_1_4 = new JLabel("Test Fee");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_4.setBounds(10, 5, 73, 21);
		panel_4.add(lblNewLabel_1_4);

		testFee = new JTextField();
		testFee.setFont(new Font("Tahoma", Font.PLAIN, 17));
		testFee.setColumns(10);
		testFee.setBounds(133, 253, 136, 33);
		contentPane.add(testFee);
		testFee.setText(String.valueOf(diagnostic.get(i).getTestFee()));
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
				EditDiagnostic.this.dispose();
				new ShowDiagnostic(diagnostic,i).setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setBounds(844, 0, 101, 43);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					diagnostic.get(i).setName(name.getText());
					diagnostic.get(i).setAddress(address.getText());
					diagnostic.get(i).setPhnNo(contact.getText());
					diagnostic.get(i).setTestFee(Integer.parseInt(testFee.getText()));
					saveToFile(diagnostic,dcfile);
					JOptionPane.showMessageDialog(null, "Information Saved Successfully.");
					EditDiagnostic.this.dispose();
					new ShowDiagnostic(diagnostic,i).setVisible(true);
				}catch(NullPointerException ex) {
					JOptionPane.showMessageDialog(null, "Please fill all the information.");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(320, 360, 221, 51);
		contentPane.add(btnNewButton);
	}
}
