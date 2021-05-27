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
public class ShowHospital extends JFrame {

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
	private JTable table;
	private DefaultTableModel model;
	private JTextField txtSeeAParticular;
	private JTextField txtAddAParrticular;
	private JTable table_1;
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
	public ShowHospital(ArrayList<Hospital>hospital, int i) {
		hfile = new File("Hospital.txt");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 665);
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
		address.setEditable(false);
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
		category.setFont(new Font("Tahoma", Font.PLAIN, 17));
		category.setEditable(false);
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
		contact.setEditable(false);
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
		testFee.setEditable(false);
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
		engGenBed.setEditable(false);
		engGenBed.setFont(new Font("Tahoma", Font.PLAIN, 17));
		engGenBed.setBounds(480, 274, 81, 33);
		contentPane.add(engGenBed);
		engGenBed.setColumns(10);
		engGenBed.setText(String.valueOf(hospital.get(i).getEngagedGeneralBed()));

		totIcu = new JTextField();
		totIcu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		totIcu.setEditable(false);
		totIcu.setColumns(10);
		totIcu.setBounds(121, 317, 81, 33);
		contentPane.add(totIcu);
		totIcu.setText(String.valueOf(hospital.get(i).getTotalIcu()));

		engIcu = new JTextField();
		engIcu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		engIcu.setEditable(false);
		engIcu.setColumns(10);
		engIcu.setBounds(394, 317, 81, 33);
		contentPane.add(engIcu);
		engIcu.setText(String.valueOf(hospital.get(i).getEngagedIcu()));

		totGenBed = new JTextField();
		totGenBed.setFont(new Font("Tahoma", Font.PLAIN, 17));
		totGenBed.setEditable(false);
		totGenBed.setColumns(10);
		totGenBed.setBounds(189, 274, 75, 33);
		contentPane.add(totGenBed);
		totGenBed.setText(String.valueOf(hospital.get(i).getTotalGeneralBed()));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(250, 464, 637, 43);
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
		dateChooser.setBounds(0, 464, 106, 43);
		contentPane.add(dateChooser);

		txtSeeAParticular = new JTextField();
		txtSeeAParticular.setEditable(false);
		txtSeeAParticular.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtSeeAParticular.setText("See a particular date info:");
		txtSeeAParticular.setBounds(0, 425, 205, 27);
		contentPane.add(txtSeeAParticular);
		txtSeeAParticular.setColumns(10);

		txtAddAParrticular = new JTextField();
		txtAddAParrticular.setText("Add a parrticular date info:");
		txtAddAParrticular.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtAddAParrticular.setEditable(false);
		txtAddAParrticular.setColumns(10);
		txtAddAParrticular.setBounds(0, 518, 211, 27);
		contentPane.add(txtAddAParrticular);

		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(0, 555, 106, 43);
		contentPane.add(dateChooser_1);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Date date = dateChooser_1.getDate();
					GregorianCalendar calendar = new GregorianCalendar();
					calendar.setTime(date);
					boolean add = true;
					for (int j = 0; j < hospital.get(i).getCoronaInfo().size(); j++) {
						if (calendar.get(GregorianCalendar.YEAR) == hospital.get(i).getCoronaInfo().get(j).getYear() &&
								calendar.get(GregorianCalendar.MONTH) == hospital.get(i).getCoronaInfo().get(j).getMonth() &&
								calendar.get(GregorianCalendar.DAY_OF_MONTH) == hospital.get(i).getCoronaInfo().get(j).getDay()) {
							model1.setValueAt(hospital.get(i).getCoronaInfo().get(j).getTotalTest(), 0, 0);
							model1.setValueAt(hospital.get(i).getCoronaInfo().get(j).getTotalAffected(), 0, 1);
							model1.setValueAt(hospital.get(i).getCoronaInfo().get(j).getTotalCured(), 0, 2);
							model1.setValueAt(hospital.get(i).getCoronaInfo().get(j).getTotalDeath(), 0, 3);
							add = false;
							JOptionPane.showMessageDialog(null, "The information of this date already exists.");
						}
					}
					if(add) {
						hospital.get(i).addDate(calendar, Integer.parseInt(model1.getValueAt(0, 0).toString()), Integer.parseInt(model1.getValueAt(0, 1).toString()),
								Integer.parseInt(model1.getValueAt(0, 2).toString()), Integer.parseInt(model1.getValueAt(0, 3).toString()));
						saveToFile(hospital,hfile);
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
		btnNewButton.setBounds(786, 555, 101, 43);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(133, 555, 637, 43);
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
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want sign out?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					ShowHospital.this.dispose();
					new MainMenu().setVisible(true);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setBounds(786, 10, 101, 43);
		contentPane.add(btnNewButton_1);

		JButton btnShowInfo = new JButton("Show Info");
		btnShowInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Date date = dateChooser.getDate();
					GregorianCalendar calendar = new GregorianCalendar();
					calendar.setTime(date);
					boolean message = true;
					for (int j = 0; j < hospital.get(i).getCoronaInfo().size(); j++) {
						if (calendar.get(GregorianCalendar.YEAR) == hospital.get(i).getCoronaInfo().get(j).getYear() &&
								calendar.get(GregorianCalendar.MONTH) == hospital.get(i).getCoronaInfo().get(j).getMonth() &&
								calendar.get(GregorianCalendar.DAY_OF_MONTH) == hospital.get(i).getCoronaInfo().get(j).getDay()) {
							model.setValueAt(hospital.get(i).getCoronaInfo().get(j).getTotalTest(), 0, 0);
							model.setValueAt(hospital.get(i).getCoronaInfo().get(j).getTotalAffected(), 0, 1);
							model.setValueAt(hospital.get(i).getCoronaInfo().get(j).getTotalCured(), 0, 2);
							model.setValueAt(hospital.get(i).getCoronaInfo().get(j).getTotalDeath(), 0, 3);
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
		btnShowInfo.setBounds(118, 464, 121, 43);
		contentPane.add(btnShowInfo);

		JButton btnNewButton_2 = new JButton("Show All Date Info\r\n");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowHospital.this.dispose();
				new HospitalAllDateInfo(hospital,i).setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_2.setBounds(0, 366, 259, 49);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_1_1 = new JButton("Edit");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowHospital.this.dispose();
				new EditHospital(hospital,i).setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1_1.setBounds(639, 14, 101, 43);
		contentPane.add(btnNewButton_1_1);
	}
}
