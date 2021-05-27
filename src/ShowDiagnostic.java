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
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ShowDiagnostic extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField division;
	private JTextField contact;
	private JTextField testFee;
	private JTable table;
	private DefaultTableModel model;
	private JTextField txtSeeAParticular;
	private JTextField txtAddAParrticular;
	private JTable table_1;
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
	public ShowDiagnostic(ArrayList<DiagnosticCenter>diagnostic, int i) {
		dcfile = new File("Diagnostic Center.txt");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 983, 636);
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
		name.setEditable(false);
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
		address.setEditable(false);
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
		contact.setEditable(false);
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
		testFee.setEditable(false);
		testFee.setColumns(10);
		testFee.setBounds(133, 253, 136, 33);
		contentPane.add(testFee);
		testFee.setText(String.valueOf(diagnostic.get(i).getTestFee()));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(238, 378, 707, 43);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		model = new DefaultTableModel();
		Object[] column = {"Total Tested","Affected", "Cured", "Death"};
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		model.addRow(row);
		table.setModel(model);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(0, 378, 106, 43);
		contentPane.add(dateChooser);

		txtSeeAParticular = new JTextField();
		txtSeeAParticular.setEditable(false);
		txtSeeAParticular.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtSeeAParticular.setText("See a particular date info:");
		txtSeeAParticular.setBounds(0, 341, 205, 27);
		contentPane.add(txtSeeAParticular);
		txtSeeAParticular.setColumns(10);

		txtAddAParrticular = new JTextField();
		txtAddAParrticular.setText("Add a parrticular date info:");
		txtAddAParrticular.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtAddAParrticular.setEditable(false);
		txtAddAParrticular.setColumns(10);
		txtAddAParrticular.setBounds(0, 442, 211, 27);
		contentPane.add(txtAddAParrticular);

		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(0, 488, 106, 43);
		contentPane.add(dateChooser_1);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Date date = dateChooser_1.getDate();
					GregorianCalendar calendar = new GregorianCalendar();
					calendar.setTime(date);
					boolean add = true;
					for (int j = 0; j < diagnostic.get(i).getCoronaInfo().size(); j++) {
						if (calendar.get(GregorianCalendar.YEAR) == diagnostic.get(i).getCoronaInfo().get(j).getYear() &&
								calendar.get(GregorianCalendar.MONTH) == diagnostic.get(i).getCoronaInfo().get(j).getMonth() &&
								calendar.get(GregorianCalendar.DAY_OF_MONTH) == diagnostic.get(i).getCoronaInfo().get(j).getDay()) {
							model1.setValueAt(diagnostic.get(i).getCoronaInfo().get(j).getTotalTest(), 0, 0);
							model1.setValueAt(diagnostic.get(i).getCoronaInfo().get(j).getTotalAffected(), 0, 1);
							model1.setValueAt(diagnostic.get(i).getCoronaInfo().get(j).getTotalCured(), 0, 2);
							model1.setValueAt(diagnostic.get(i).getCoronaInfo().get(j).getTotalDeath(), 0, 3);
							add = false;
							JOptionPane.showMessageDialog(null, "The information of this date already exists.");
						}
					}
					if(add) {
						diagnostic.get(i).addDate(calendar, Integer.parseInt(model1.getValueAt(0, 0).toString()), Integer.parseInt(model1.getValueAt(0, 1).toString()),
								Integer.parseInt(model1.getValueAt(0, 2).toString()), Integer.parseInt(model1.getValueAt(0, 3).toString()));
						saveToFile(diagnostic,dcfile);
						JOptionPane.showMessageDialog(null, "Information Added Sucessfully.");
						model1.setValueAt("", 0, 0);
						model1.setValueAt("", 0, 1);
						model1.setValueAt("", 0, 2);
						model1.setValueAt("", 0, 3);
					}
				}catch(NullPointerException ex) {
					JOptionPane.showMessageDialog(null, "Please fill all the info.");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(844, 488, 101, 43);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(113, 488, 707, 43);
		contentPane.add(scrollPane_1);

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		model1 = new DefaultTableModel();
		Object[] column1 = {"Total Tested","Affected", "Cured", "Death"};
		Object[] row1 = new Object[0];
		model1.setColumnIdentifiers(column1);
		model1.addRow(row1);
		table_1.setModel(model1);

		JButton btnNewButton_1 = new JButton("Sign Out");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to sign out?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					ShowDiagnostic.this.dispose();
					new MainMenu().setVisible(true);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setBounds(844, 0, 101, 43);
		contentPane.add(btnNewButton_1);

		JButton btnShowInfo = new JButton("Show Info");
		btnShowInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Date date = dateChooser.getDate();
					GregorianCalendar calendar = new GregorianCalendar();
					calendar.setTime(date);
					boolean message = true;
					for (int j = 0; j < diagnostic.get(i).getCoronaInfo().size(); j++) {
						if (calendar.get(GregorianCalendar.YEAR) == diagnostic.get(i).getCoronaInfo().get(j).getYear() &&
								calendar.get(GregorianCalendar.MONTH) == diagnostic.get(i).getCoronaInfo().get(j).getMonth() &&
								calendar.get(GregorianCalendar.DAY_OF_MONTH) == diagnostic.get(i).getCoronaInfo().get(j).getDay()) {
							model.setValueAt(diagnostic.get(i).getCoronaInfo().get(j).getTotalTest(), 0, 0);
							model.setValueAt(diagnostic.get(i).getCoronaInfo().get(j).getTotalAffected(), 0, 1);
							model.setValueAt(diagnostic.get(i).getCoronaInfo().get(j).getTotalCured(), 0, 2);
							model.setValueAt(diagnostic.get(i).getCoronaInfo().get(j).getTotalDeath(), 0, 3);
							message = false;
						}
					}
					if(message) {
						JOptionPane.showMessageDialog(null, "The information of that day is not available. Please select another date.");
					}
				}catch(NullPointerException ex) {
					JOptionPane.showMessageDialog(null, "Please pick a date.");
				}
			}
		});
		btnShowInfo.setHorizontalAlignment(SwingConstants.LEFT);
		btnShowInfo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnShowInfo.setBounds(110, 378, 121, 43);
		contentPane.add(btnShowInfo);

		JButton btnNewButton_2 = new JButton("See All Date Info");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowDiagnostic.this.dispose();
				new DiagnosticAllDateInfo(diagnostic,i).setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_2.setBounds(0, 296, 205, 33);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_1_1 = new JButton("Edit");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowDiagnostic.this.dispose();
				new EditDiagnostic(diagnostic,i).setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1_1.setBounds(703, 0, 101, 43);
		contentPane.add(btnNewButton_1_1);
	}
}
