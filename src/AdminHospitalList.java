import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AdminHospitalList extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
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
					//AdminHospitalList frame = new AdminHospitalList();
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
	public AdminHospitalList(ArrayList<Hospital> hospital, ArrayList<DiagnosticCenter> diagnostic) {
		hfile = new File("Hospital.txt");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 836, 635);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("View Full Details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select = table.getSelectedRow();
				if(select >= 0) {
					AdminHospitalList.this.dispose();
					new AdminShowHospital(hospital,diagnostic,select).setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Please select a hospital");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(34, 273, 173, 36);
		contentPane.add(btnNewButton);

		JButton btnRemove = new JButton("Remove\r\n");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select = table.getSelectedRow();
				if(select >= 0) {
					if(JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
						hospital.remove(select);
						saveToFile(hospital,hfile);
						model.removeRow(select);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Please select a hospital");
				}
			}
		});
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnRemove.setBounds(34, 336, 173, 36);
		contentPane.add(btnRemove);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(288, 10, 525, 576);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(new Color(169, 169, 169));
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		model = new DefaultTableModel();
		Object[] column = {"Name","Division","Contact"};
		Object[] row = new Object[3];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		for(int i = 0; i < hospital.size(); i++) {
			row[0] = hospital.get(i).getName();
			row[1] = hospital.get(i).getDivision();
			row[2] = hospital.get(i).getPhnNo();
			model.addRow(row);
		}

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminHospitalList.this.dispose();
				new AdminOption(hospital,diagnostic).setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBack.setBounds(34, 408, 173, 36);
		contentPane.add(btnBack);
	}
}
