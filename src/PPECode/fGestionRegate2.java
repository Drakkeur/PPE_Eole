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

public class fGestionRegate2 extends JFrame implements Runnable {
	Thread t;
	int hcnt=0,mcnt=0,scnt=0,mscnt =0;
	String str = "", nstr="",mstr="",dstr="";
	int cnt =0,cnt2=0;
	private JPanel contentPane;
	EnregistrementVoilier enr = new EnregistrementVoilier();
	public static JTable tbleCandidat;
	private static DefaultTableModel mdle;
	private JTextField tfDistReg;
	JLabel tmpsMs = new JLabel("000");
	JLabel tmpsHMS = new JLabel("00:00:00");
	
	
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
		t = new Thread(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCandidat = new JLabel("Candidats");
		lblCandidat.setBounds(313, 291, 56, 14);
		contentPane.add(lblCandidat);
		
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EnregistrementVoilier f = new EnregistrementVoilier();
				f.setVisible(true);
			}
		});
		btnAjouter.setBounds(289, 310, 101, 23);
		contentPane.add(btnAjouter);
		
		JLabel lblChrnomtre = new JLabel("Chronometre");
		lblChrnomtre.setHorizontalAlignment(SwingConstants.CENTER);
		lblChrnomtre.setBounds(400, 314, 95, 14);
		contentPane.add(lblChrnomtre);
		
		JButton btnDmarer = new JButton("Demarer");
		btnDmarer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnDmarer.getText().equals("Demarer")){
					btnDmarer.setText("Arriver");
					cnt++;
					if(cnt==1){
						t.start();
						
					}else{
						t.resume();
						
					}
				}else{
					btnDmarer.setText("Arriver");
					//t.suspend();
					setTime();
				}
			}
		});
		btnDmarer.setBounds(400, 339, 89, 23);
		contentPane.add(btnDmarer);
		
		JButton btnArret = new JButton("Arreter");
		btnArret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
				t.suspend();
				btnDmarer.setText("Demarer");
			}
		});
		btnArret.setBounds(400, 373, 90, 23);
		contentPane.add(btnArret);

		JButton btnRsultats = new JButton("Resultats");
		btnRsultats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnRsultats.setBounds(289, 373, 101, 23);
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
				for(int j = 0;j<fGestionRegate2.tbleCandidat.getRowCount();j++){
					if(j!=(int)fGestionRegate2.tbleCandidat.getModel().getValueAt(j, 0)){
						for(int jSuite = j; jSuite<fGestionRegate2.tbleCandidat.getRowCount();jSuite++){
							fGestionRegate2.tbleCandidat.setValueAt(jSuite+1, jSuite, 0);
						}
						break;
					}
				}
			}
		});
		btnSupprimer.setBounds(289, 339, 101, 23);
		contentPane.add(btnSupprimer);
		
		JButton btnEntr = new JButton("Entrer");
		btnEntr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Regate r = new Regate(Integer.parseInt(tfDistReg.getText()));
			}
		});
		btnEntr.setBounds(190, 339, 89, 23);
		contentPane.add(btnEntr);
		
		tfDistReg = new JTextField();
		tfDistReg.setBounds(134, 340, 46, 20);
		contentPane.add(tfDistReg);
		tfDistReg.setColumns(10);
		
		JLabel lblDistanceRgate = new JLabel("Distance Regate");
		lblDistanceRgate.setBounds(10, 343, 114, 14);
		contentPane.add(lblDistanceRgate);
		
		//Chrono afficheur
		tmpsHMS.setBounds(20, 282, 79, 32);
		contentPane.add(tmpsHMS);
	
		tmpsMs.setBounds(134, 282, 46, 32);
		contentPane.add(tmpsMs);
	}
	
	
	
	
	public void display(){
		tmpsHMS.setText(nstr);
		tmpsMs.setText(mstr);
		
	}
	public void reset(){
		hcnt=0;mcnt=0;scnt=0;mscnt=0;cnt2=0;
		nstr="00:00:00";mstr="000";dstr="";
		display();
	}
	
	public void setTimeCounter(){
		nstr="";
		if(hcnt<10){
			nstr="0"+hcnt;
			
		}else{
			nstr=""+hcnt;
		}
		
		if(mcnt<10){
			nstr+=":0"+mcnt;
		}else{
			nstr+=":"+mcnt;
		}
		if(scnt<10){
			nstr+=":0"+scnt;
		}else{
			nstr+=":"+scnt;
		}
		
	}
	
	public void setMTimeCounter(){
		mstr="";
		if(mscnt<10){
			mstr= "00"+mscnt;
		}else if (mscnt>=10 && mscnt<100){
			mstr="0"+mscnt;
		}else{
			mstr=""+mscnt;
		}
	}
	
	public void setTime(){
		dstr=tmpsHMS.getText()+" "+tmpsMs.getText();
		tbleCandidat.setValueAt(dstr,tbleCandidat.getSelectedRow(),5);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			while(true){
				mscnt++;
				if(mscnt>999){
					mscnt=0;
					scnt++;
				}
					
				if(scnt>59){
					scnt =0;
					mcnt++;
				}
				if(mcnt>59){
					mcnt=0;
					hcnt++;
					
				}
				if(hcnt>99){
					reset();
				}
				setTimeCounter();
				setMTimeCounter();
				display();
				Thread.sleep(1);
				
				
			}
		}catch(Exception e){
			
		}
		
	}
}
