import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class DiagnosticAllDateInfo extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private File dcfile;
	private JButton btnRemove;

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
					//AllDateInfo frame = new AllDateInfo();
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
	public DiagnosticAllDateInfo(ArrayList<DiagnosticCenter> diagnostic, int i) {
		dcfile = new File("Diagnostic Center.txt");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 927, 598);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DiagnosticAllDateInfo.this.dispose();
				new ShowDiagnostic(diagnostic, i).setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(0, 10, 110, 39);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(151, 65, 706, 462);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(new Color(112, 128, 144));
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		model = new DefaultTableModel();
		Object[] column = {"Date","Total Tested","Total Affected","Total Cured","Total Death"};
		Object[] row = new Object[5];
		model.setColumnIdentifiers(column);
		table.setModel(model);

		btnRemove = new JButton("Remove\r\n");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select = table.getSelectedRow();
				if(select >= 0) {
					if(JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
						diagnostic.get(i).getCoronaInfo().remove(select);
						int newNoOfDate = diagnostic.get(i).getNoOfCoronaDate() -1;
						diagnostic.get(i).setNoOfCoronaDate(newNoOfDate);
						saveToFile(diagnostic,dcfile);
						model.removeRow(select);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Please select a date");
				}
			}
		});
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnRemove.setBounds(0, 277, 110, 39);
		contentPane.add(btnRemove);
		for (int j = 0; j < diagnostic.get(i).getCoronaInfo().size(); j++) {
			row[0] = diagnostic.get(i).getCoronaInfo().get(j).getDay() + "/" + diagnostic.get(i).getCoronaInfo().get(j).getMonth() + 
					"/" + diagnostic.get(i).getCoronaInfo().get(j).getYear();
			row[1] = diagnostic.get(i).getCoronaInfo().get(j).getTotalTest();
			row[2] = diagnostic.get(i).getCoronaInfo().get(j).getTotalAffected();
			row[3] = diagnostic.get(i).getCoronaInfo().get(j).getTotalCured();
			row[4] = diagnostic.get(i).getCoronaInfo().get(j).getTotalDeath();
			model.addRow(row);
		}
	}
}
