package PPECode;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdk.nashorn.internal.scripts.JS;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
		setBounds(100, 100, 260, 179);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomVoiler = new JLabel("Nom Voiler");
		lblNomVoiler.setBounds(10, 11, 86, 14);
		contentPane.add(lblNomVoiler);
		
		JLabel lblClasseVoilier = new JLabel("Classe Voilier");
		lblClasseVoilier.setBounds(10, 36, 86, 14);
		contentPane.add(lblClasseVoilier);
		
		JLabel lblRatingVoilier = new JLabel("Rating Voilier");
		lblRatingVoilier.setBounds(10, 61, 86, 14);
		contentPane.add(lblRatingVoilier);
		
		JLabel lblNomSkipper = new JLabel("Nom Skipper");
		lblNomSkipper.setBounds(10, 86, 86, 14);
		contentPane.add(lblNomSkipper);
		
		tfNomV = new JTextField();
		tfNomV.setBounds(148, 11, 86, 20);
		contentPane.add(tfNomV);
		tfNomV.setColumns(10);
		
		tfClasse = new JTextField();
		tfClasse.setBounds(148, 36, 86, 20);
		contentPane.add(tfClasse);
		tfClasse.setColumns(10);
		
		tfRating = new JTextField();
		tfRating.setColumns(10);
		tfRating.setBounds(148, 61, 86, 20);
		contentPane.add(tfRating);
		
		tfNomS = new JTextField();
		tfNomS.setColumns(10);
		tfNomS.setBounds(148, 86, 86, 20);
		contentPane.add(tfNomS);
		
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = fGestionRegate2.tbleCandidat.getRowCount()+1;
				if(fGestionRegate2.tbleCandidat.getRowCount()<=19){
					fGestionRegate2.getMdle().addRow(new Object[]{i,tfNomV.getText(),tfClasse.getText(),tfRating.getText(),tfNomV.getText()});
					//Voilier x = new Voilier(tfNomV.getText(),Integer.parseInt(tfClasse.getText()),Integer.parseInt(tfRating.getText()),tfNomV.getText());
					//lesVoiliers.add(x);
				}else{
					System.out.println("Nombre Maximum de participant atteint, veuillez en suprimer pour en ajouter de nouveaux");
				}
				setVisible(false);
			}
		});
		btnEnregistrer.setBounds(41, 107, 105, 23);
		contentPane.add(btnEnregistrer);
	}
	
	/*public ArrayList<Voilier> getV() {
		return lesVoiliers;
	}

	public void setV(ArrayList<Voilier> v) {
		this.lesVoiliers = v;
	}*/
}

