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
public class HospitalAllDateInfo extends JFrame {

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
	public HospitalAllDateInfo(ArrayList<Hospital> hospital, int i) {
		hfile = new File("Hospital.txt");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 649);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HospitalAllDateInfo.this.dispose();
				new ShowHospital(hospital, i).setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(0, 10, 110, 39);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(119, 64, 691, 462);
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

		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select = table.getSelectedRow();
				if(select >= 0) {
					if(JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
						hospital.get(i).getCoronaInfo().remove(select);
						int newNoOfDate = hospital.get(i).getNoOfCoronaDate() -1;
						hospital.get(i).setNoOfCoronaDate(newNoOfDate);
						saveToFile(hospital,hfile);
						model.removeRow(select);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Please select a date");
				}
			}
		});
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnRemove.setBounds(0, 271, 110, 39);
		contentPane.add(btnRemove);
		for (int j = 0; j < hospital.get(i).getCoronaInfo().size(); j++) {
			row[0] = hospital.get(i).getCoronaInfo().get(j).getDay() + "/" + hospital.get(i).getCoronaInfo().get(j).getMonth() + 
					"/" + hospital.get(i).getCoronaInfo().get(j).getYear();
			row[1] = hospital.get(i).getCoronaInfo().get(j).getTotalTest();
			row[2] = hospital.get(i).getCoronaInfo().get(j).getTotalAffected();
			row[3] = hospital.get(i).getCoronaInfo().get(j).getTotalCured();
			row[4] = hospital.get(i).getCoronaInfo().get(j).getTotalDeath();
			model.addRow(row);
		}
	}
}
