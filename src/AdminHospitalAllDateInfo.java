import java.awt.EventQueue;
import javax.swing.JFrame;
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
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class AdminHospitalAllDateInfo extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;

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
	public AdminHospitalAllDateInfo(ArrayList<Hospital> hospital,ArrayList<DiagnosticCenter> diagnostic, int i) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 630);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminHospitalAllDateInfo.this.dispose();
				new AdminShowHospital(hospital, diagnostic,i).setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(0, 10, 110, 39);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 59, 691, 462);
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
