import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Contact extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	private DefaultTableModel model;
	private DefaultTableModel model1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Contact frame = new Contact();
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
	public Contact(ArrayList<Hospital> hospital, ArrayList<DiagnosticCenter> diagnostic) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 951, 566);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Contact List");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(312, 10, 328, 49);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Emergency Contact:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(10, 82, 179, 29);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setEditable(false);
		textField.setText("16263");
		textField.setBounds(196, 83, 88, 34);
		contentPane.add(textField);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 121, 450, 378);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(new Color(211, 211, 211));
		model = new DefaultTableModel();
		Object[] column = {"Hospital Name","Contact No"};
		model.setColumnIdentifiers(column);
		Object[] row = new Object[2];
		table.setModel(model);
		for(int i = 0; i < hospital.size(); i++) {
			row[0] = hospital.get(i).getName();
			row[1] = hospital.get(i).getPhnNo();
			model.addRow(row);
		}

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(478, 121, 450, 378);
		contentPane.add(scrollPane_1);

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setBackground(new Color(211, 211, 211));
		model1 = new DefaultTableModel();
		Object[] column1 = {"Diagnostic Center Name","Contact No"};
		model1.setColumnIdentifiers(column1);
		Object[] row1 = new Object[2];
		table_1.setModel(model1);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contact.this.dispose();
				new MainMenu().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(10, 10, 116, 29);
		contentPane.add(btnNewButton);
		for(int i = 0; i < diagnostic.size(); i++) {
			row1[0] = diagnostic.get(i).getName();
			row1[1] = diagnostic.get(i).getPhnNo();
			model1.addRow(row1);
		}
	}
}
