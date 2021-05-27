import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


@SuppressWarnings("serial")
public class MainMenu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField totalAffect;
	private JTextField totalDeath;
	private JTextField totalCure;
	private JTextField textField_5;
	private File hfile;
	private File dcfile;
	private ArrayList<Hospital> hospital;
	private ArrayList<DiagnosticCenter> diagnostic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
//					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		hfile = new File("Hospital.txt");
		dcfile = new File("Diagnostic Center.txt");
		hospital = new ArrayList<>();
		diagnostic= new ArrayList<>();

		int affect = 791000;
		int cure = 732000;
		int death = 12401;

		if(hfile.exists()) {
			try {
				Scanner input = new Scanner(hfile);
				while(input.hasNext()) {
					Hospital hos = new Hospital();
					hos.setUserName(input.nextLine());
					hos.setPassword(input.nextLine());
					hos.setName(input.nextLine());
					hos.setAddress(input.nextLine());
					hos.setCategory(input.nextLine());
					hos.setDivision(input.nextLine());
					hos.setPhnNo(input.nextLine());
					hos.setTestFee(input.nextInt());
					hos.setTotalGeneralBed(input.nextInt());
					hos.setEngagedGeneralBed(input.nextInt());
					hos.setTotalIcu(input.nextInt());
					hos.setEngagedIcu(input.nextInt());
					int noOfDate = input.nextInt();
					for(int i = 0; i < noOfDate; i++) {
						hos.addDate(input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt());
					}
					input.nextLine();
					hospital.add(hos);
				}
				input.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if(dcfile.exists()) {
			try {
				Scanner input = new Scanner(dcfile);
				while(input.hasNext()) {
					DiagnosticCenter dc = new DiagnosticCenter();
					dc.setUserName(input.nextLine());
					dc.setPassword(input.nextLine());
					dc.setName(input.nextLine());
					dc.setAddress(input.nextLine());
					dc.setDivision(input.nextLine());
					dc.setPhnNo(input.nextLine());
					dc.setTestFee(input.nextInt());
					int noOfDate = input.nextInt();
					for(int i = 0; i < noOfDate; i++) {
						dc.addDate(input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt());
					}
					input.nextLine();
					diagnostic.add(dc);
				}
				input.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for (int i = 0; i < hospital.size(); i++) {
			affect += hospital.get(i).getTotalAffected();
			cure += hospital.get(i).getTotalCured();
			death += hospital.get(i).getTotalDeath();
		}

		for (int i = 0; i < diagnostic.size(); i++) {
			affect += diagnostic.get(i).getTotalAffected();
			cure += diagnostic.get(i).getTotalCured();
			death += diagnostic.get(i).getTotalDeath();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel jPanel1 = new JPanel();
		jPanel1.setBackground(new Color(0, 51, 51));
		jPanel1.setBounds(0, 0, 314, 481);
		contentPane.add(jPanel1);

		JButton jButton2 = new JButton();
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.this.dispose();
				new LoginReg(hospital, diagnostic).setVisible(true);
			}
		});
		jButton2.setBounds(10, 283, 294, 38);
		jButton2.setText("Login/Registration");
		jButton2.setFont(new Font("Dialog", Font.BOLD, 20));

		JButton jButton1 = new JButton();
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.this.dispose();
				new Service(hospital).setVisible(true);
			}
		});
		jButton1.setBounds(10, 209, 294, 38);
		jButton1.setText("Service Information");
		jButton1.setFont(new Font("Dialog", Font.BOLD, 20));

		JButton jButton3 = new JButton();
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.this.dispose();
				new Contact(hospital,diagnostic).setVisible(true);
			}
		});
		jButton3.setBounds(10, 368, 294, 38);
		jButton3.setText("Contact");
		jButton3.setFont(new Font("Dialog", Font.BOLD, 20));
		jPanel1.setLayout(null);
		jPanel1.add(jButton2);
		jPanel1.add(jButton1);
		jPanel1.add(jButton3);

		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 294, 146);
		jPanel1.add(panel);
		panel.setLayout(null);

		JLabel menuLabel = new JLabel("Menu");
		menuLabel.setHorizontalAlignment(SwingConstants.CENTER);
		menuLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		menuLabel.setBounds(0, 10, 284, 126);
		panel.add(menuLabel);

		JPanel jPanel2 = new JPanel();
		jPanel2.setBackground(new Color(47, 79, 79));
		jPanel2.setLayout(null);
		jPanel2.setBounds(313, 0, 566, 481);
		contentPane.add(jPanel2);

		textField = new JTextField();
		textField.setText("Total Death");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		textField.setEditable(false);
		textField.setBounds(247, 144, 178, 51);
		jPanel2.add(textField);

		textField_1 = new JTextField();
		textField_1.setText("Total Cured");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		textField_1.setEditable(false);
		textField_1.setBounds(247, 83, 178, 51);
		jPanel2.add(textField_1);

		totalAffect = new JTextField();
		totalAffect.setHorizontalAlignment(SwingConstants.LEFT);
		totalAffect.setForeground(Color.BLUE);
		totalAffect.setFont(new Font("Tahoma", Font.PLAIN, 20));
		totalAffect.setEditable(false);
		totalAffect.setBounds(449, 22, 106, 45);
		totalAffect.setText(String.valueOf(affect));
		jPanel2.add(totalAffect);

		totalDeath = new JTextField();
		totalDeath.setHorizontalAlignment(SwingConstants.LEFT);
		totalDeath.setForeground(Color.RED);
		totalDeath.setFont(new Font("Tahoma", Font.PLAIN, 20));
		totalDeath.setEditable(false);
		totalDeath.setBounds(449, 146, 106, 45);
		totalDeath.setText(String.valueOf(death));
		jPanel2.add(totalDeath);

		totalCure = new JTextField();
		totalCure.setHorizontalAlignment(SwingConstants.LEFT);
		totalCure.setForeground(new Color(0, 128, 0));
		totalCure.setFont(new Font("Tahoma", Font.PLAIN, 20));
		totalCure.setEditable(false);
		totalCure.setBounds(449, 86, 106, 45);
		totalCure.setText(String.valueOf(cure));
		jPanel2.add(totalCure);

		textField_5 = new JTextField();
		textField_5.setText("Total Affected");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		textField_5.setEditable(false);
		textField_5.setBounds(246, 22, 178, 51);
		jPanel2.add(textField_5);
	}
}
