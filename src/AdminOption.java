import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AdminOption extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//AdminOption frame = new AdminOption();
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
	public AdminOption(ArrayList<Hospital> hospital, ArrayList<DiagnosticCenter> diagnostic) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 648);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton_1 = new JButton("Add Hospital");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminOption.this.dispose();
				new AdminAddingHospital(hospital,diagnostic).setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setBounds(244, 48, 272, 95);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("Add Diagnostic Center");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminOption.this.dispose();
				new AdminAddingDiagnosticCenter(hospital,diagnostic).setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1_1.setBounds(244, 161, 272, 95);
		contentPane.add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("View Hospitals");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminOption.this.dispose();
				new AdminHospitalList(hospital,diagnostic).setVisible(true);
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1_2.setBounds(244, 277, 272, 95);
		contentPane.add(btnNewButton_1_2);

		JButton btnNewButton_1_3 = new JButton("View Diagnostic Centers");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminOption.this.dispose();
				new AdminDiagnosticList(hospital,diagnostic).setVisible(true);
			}
		});
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1_3.setBounds(244, 394, 272, 95);
		contentPane.add(btnNewButton_1_3);

		JButton btnNewButton_1_3_1 = new JButton("Sign Out");
		btnNewButton_1_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to sign out?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					AdminOption.this.dispose();
					new MainMenu().setVisible(true);
				}
			}
		});
		btnNewButton_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1_3_1.setBounds(244, 510, 272, 59);
		contentPane.add(btnNewButton_1_3_1);
	}
}
