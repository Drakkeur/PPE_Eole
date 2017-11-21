package PPECode;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;


public class fGestionRegate2 extends JFrame {

	private JPanel contentPane;
	EnregistrementVoilier enr = new EnregistrementVoilier();
	private JTable tbleCandidat;
	private static DefaultTableModel mdle;
	private JTextField textField;
	
	
	public static DefaultTableModel getMdle() {
		return mdle;
	}

	public static void setMdle(DefaultTableModel mdle) {
		fGestionRegate2.mdle = mdle;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fGestionRegate2 frame = new fGestionRegate2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public fGestionRegate2() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCandidat = new JLabel("Candidats");
		lblCandidat.setBounds(313, 314, 56, 14);
		contentPane.add(lblCandidat);
		
		JLabel lblCourseFin = new JLabel("Course Fini");
		lblCourseFin.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourseFin.setBounds(505, 314, 84, 14);
		contentPane.add(lblCourseFin);
		
		JButton btnArriv = new JButton("Arriver");
		btnArriv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnArriv.setBounds(500, 339, 89, 23);
		contentPane.add(btnArriv);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EnregistrementVoilier f = new EnregistrementVoilier();
				
				f.setVisible(true);
			}
		});
		btnAjouter.setBounds(289, 339, 101, 23);
		contentPane.add(btnAjouter);
		
		JLabel lblChrnomtre = new JLabel("Chronom\u00E8tre");
		lblChrnomtre.setHorizontalAlignment(SwingConstants.CENTER);
		lblChrnomtre.setBounds(400, 314, 95, 14);
		contentPane.add(lblChrnomtre);
		
		JButton btnDmarer = new JButton("D\u00E9marer");
		btnDmarer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnDmarer.setBounds(400, 339, 89, 23);
		contentPane.add(btnDmarer);
		
		JButton btnArret = new JButton("Arr\u00EAter");
		btnArret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnArret.setBounds(400, 373, 90, 23);
		contentPane.add(btnArret);
		
		JButton btnRsultats = new JButton("R\u00E9sultats");
		btnRsultats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnRsultats.setBounds(500, 373, 89, 23);
		contentPane.add(btnRsultats);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuitter.setBounds(10, 373, 89, 23);
		contentPane.add(btnQuitter);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 579, 260);
		contentPane.add(scrollPane);
		
		tbleCandidat = new JTable(new DefaultTableModel());
		mdle = (DefaultTableModel) tbleCandidat.getModel();
		mdle.addColumn("N°");
		mdle.addColumn("Voilier");
		mdle.addColumn("Classe");
		mdle.addColumn("Rating");
		mdle.addColumn("Skipper");
		mdle.addColumn("Temps");
		scrollPane.setViewportView(tbleCandidat);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel)tbleCandidat.getModel()).removeRow(tbleCandidat.getSelectedRow());
			}
		});
		btnSupprimer.setBounds(289, 373, 101, 23);
		contentPane.add(btnSupprimer);
		
		JButton btnEntr = new JButton("Entr\u00E9");
		btnEntr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Regate r = new Regate();
			}
		});
		btnEntr.setBounds(190, 339, 89, 23);
		contentPane.add(btnEntr);
		
		textField = new JTextField();
		textField.setBounds(134, 340, 46, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDistanceRgate = new JLabel("Distance R\u00E9gate");
		lblDistanceRgate.setBounds(10, 343, 114, 14);
		contentPane.add(lblDistanceRgate);
		
		
		
	}
}
