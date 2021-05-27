import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class Service extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel model;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Service frame = new Service();
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
	public Service(ArrayList<Hospital> hospital) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 963, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(Color.LIGHT_GRAY);
		contentPane_1.setBounds(0, 0, 937, 529);
		contentPane.add(contentPane_1);

		JLabel lblServiceInformation = new JLabel("Service Information");
		lblServiceInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblServiceInformation.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblServiceInformation.setBounds(312, 10, 328, 49);
		contentPane_1.add(lblServiceInformation);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Service.this.dispose();
				new MainMenu().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(10, 21, 116, 29);
		contentPane_1.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 96, 874, 379);
		contentPane_1.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(new Color(238, 232, 170));
		model = new DefaultTableModel();
		Object[] column = {"Hospital Name","Total General Bed", "Engaged General Bed","Vacant General Bed","Total ICU","Engaged ICU", "Vacant ICU"};
		model.setColumnIdentifiers(column);
		Object[] row = new Object[7];
		table.setModel(model);
		for(int i = 0; i < hospital.size(); i++) {
			row[0] = hospital.get(i).getName();
			row[1] = hospital.get(i).getTotalGeneralBed();
			row[2] = hospital.get(i).getEngagedGeneralBed();
			row[3] = hospital.get(i).getVacantGeneralBed();
			row[4] = hospital.get(i).getTotalIcu();
			row[5] = hospital.get(i).getEngagedIcu();
			row[6] = hospital.get(i).getVacantIcu();
			model.addRow(row);
		}
	}
}
