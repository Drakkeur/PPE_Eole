package PPECode;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.sound.midi.Transmitter;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollBar;

public class fGestionRegate2 extends JFrame {

	private JPanel contentPane;
	//private int i = 1;
	//private String x;
	private JTable tbleCandidat;
	private String titresColone[] = {"Voilier","Classe","Rating","Skipper","Temps"};
	private final Class[] classColone = new Class[] { String.class, String.class,int.class, String.class };
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
		data = new Object[20][5];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCandidat = new JLabel("Candidats");
		lblCandidat.setBounds(319, 314, 56, 14);
		contentPane.add(lblCandidat);
		
		JLabel lblCourseFin = new JLabel("Course Fini");
		lblCourseFin.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourseFin.setBounds(505, 314, 79, 14);
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
		btnAjouter.setBounds(301, 339, 89, 23);
		contentPane.add(btnAjouter);
		
		JLabel lblChrnomtre = new JLabel("Chronom\u00E8tre");
		lblChrnomtre.setHorizontalAlignment(SwingConstants.CENTER);
		lblChrnomtre.setBounds(414, 314, 63, 14);
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
		btnQuitter.setBounds(15, 373, 89, 23);
		contentPane.add(btnQuitter);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 9, 569, 272);
		contentPane.add(scrollPane);
	    
		
		tbleCandidat = new JTable(data,titresColone);
		scrollPane.setViewportView(tbleCandidat);
		
	}
}
