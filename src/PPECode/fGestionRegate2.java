package PPECode;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Eole.EnregistrementVoilier;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class fGestionRegate2 extends JFrame {

	private JPanel contentPane;
	//private int i = 1;
	//private String x;
	private JTable tbleCandidat;
	private String titres[] = {"Voilier","Classe","Rating","Skipper"};
	private Object[][] data;
	EnregistrementVoilier enr = new EnregistrementVoilier();
	
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
		data = new Object[4][20];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListVoilier = new JLabel("Liste des voiliers");
		lblListVoilier.setBounds(20, 178, 100, 14);
		contentPane.add(lblListVoilier);
		
		JLabel lblCourseFin = new JLabel("Course Fini");
		lblCourseFin.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourseFin.setBounds(324, 178, 79, 14);
		contentPane.add(lblCourseFin);
		
		JButton btnArriv = new JButton("Arriver");
		btnArriv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnArriv.setBounds(324, 194, 89, 23);
		contentPane.add(btnArriv);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EnregistrementVoilier f = new EnregistrementVoilier();

				f.setVisible(true);
			}
		});
		btnAjouter.setBounds(20, 194, 89, 23);
		contentPane.add(btnAjouter);
		
		JLabel lblChrnomtre = new JLabel("Chronom\u00E8tre");
		lblChrnomtre.setHorizontalAlignment(SwingConstants.CENTER);
		lblChrnomtre.setBounds(336, 9, 63, 14);
		contentPane.add(lblChrnomtre);
		
		JButton btnDmarer = new JButton("D\u00E9marer");
		btnDmarer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnDmarer.setBounds(324, 56, 89, 23);
		contentPane.add(btnDmarer);
		
		JButton btnArret = new JButton("Arr\u00EAter");
		btnArret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnArret.setBounds(324, 90, 90, 23);
		contentPane.add(btnArret);
		
		JButton btnRsultats = new JButton("R\u00E9sultats");
		btnRsultats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnRsultats.setBounds(324, 228, 89, 23);
		contentPane.add(btnRsultats);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuitter.setBounds(20, 228, 89, 23);
		contentPane.add(btnQuitter);
	    
		
		tbleCandidat = new JTable(data,titres);
		tbleCandidat.setBounds(20, 22, 285, 145);
		contentPane.add(tbleCandidat);
	}
}
