package PPECode;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class EnregistrementVoilier extends JFrame {


	private JPanel contentPane;
	private JTextField tfNomV;
	private JTextField tfClasse;
	private JTextField tfRating;
	private JTextField tfNomS;
	private ArrayList<Voilier> lesVoiliers;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnregistrementVoilier frame = new EnregistrementVoilier();
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
	public EnregistrementVoilier() {
		lesVoiliers = new ArrayList<>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 205, 179);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomVoiler = new JLabel("Nom Voiler");
		lblNomVoiler.setBounds(10, 11, 57, 14);
		contentPane.add(lblNomVoiler);
		
		JLabel lblClasseVoilier = new JLabel("Classe Voilier");
		lblClasseVoilier.setBounds(10, 36, 67, 14);
		contentPane.add(lblClasseVoilier);
		
		JLabel lblRatingVoilier = new JLabel("Rating Voilier");
		lblRatingVoilier.setBounds(10, 61, 67, 14);
		contentPane.add(lblRatingVoilier);
		
		JLabel lblNomSkipper = new JLabel("Nom Skipper");
		lblNomSkipper.setBounds(10, 86, 67, 14);
		contentPane.add(lblNomSkipper);
		
		tfNomV = new JTextField();
		tfNomV.setBounds(91, 8, 86, 20);
		contentPane.add(tfNomV);
		tfNomV.setColumns(10);
		
		tfClasse = new JTextField();
		tfClasse.setBounds(91, 33, 86, 20);
		contentPane.add(tfClasse);
		tfClasse.setColumns(10);
		
		tfRating = new JTextField();
		tfRating.setColumns(10);
		tfRating.setBounds(91, 58, 86, 20);
		contentPane.add(tfRating);
		
		tfNomS = new JTextField();
		tfNomS.setColumns(10);
		tfNomS.setBounds(91, 83, 86, 20);
		contentPane.add(tfNomS);
		
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				voilier x = new voilier(tfNomV.getText(),Integer.parseInt(tfClasse.getText()),Integer.parseInt(tfRating.getText()),tfNomV.getText());
				lesVoiliers.add(x);
				
				setVisible(false);
			}
		});
		btnEnregistrer.setBounds(41, 107, 105, 23);
		contentPane.add(btnEnregistrer);
	}
	
	public ArrayList<Voilier> getV() {
		return lesVoiliers;
	}

	public void setV(ArrayList<Voilier> v) {
		this.lesVoiliers = v;
	}
}
