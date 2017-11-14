package StopWatch;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class fGestionRegate extends JFrame implements Runnable{
	Thread t;
	int hcnt=0,mcnt=0,scnt=0,mscnt =0;
	String str = "", nstr="",mstr="",dstr="";
	int cnt =0,cnt2=0;
	private JPanel contentPane;
	private int i = 1;
	private String x;
	public static JList<String> listCandidats = new JList<String>();
	JLabel label = new JLabel("000");
	JLabel label1 = new JLabel("00:00:00");
	JTextArea textArea = new JTextArea();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fGestionRegate frame = new fGestionRegate();
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
	public fGestionRegate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		listCandidats.setBounds(10, 11, 110, 162);
		contentPane.add(listCandidats);
		
		JLabel lblListVoilier = new JLabel("Liste des voiliers");
		lblListVoilier.setBounds(20, 178, 100, 14);
		contentPane.add(lblListVoilier);
		
		JLabel lblCourseFin = new JLabel("Course Fini");
		lblCourseFin.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourseFin.setBounds(324, 178, 79, 14);
		contentPane.add(lblCourseFin);
		
		JButton btnFinCourse = new JButton("FIN COURSE");
		btnFinCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.suspend();
			}
		});
		btnFinCourse.setBounds(324, 194, 89, 23);
		contentPane.add(btnFinCourse);
		
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
		lblChrnomtre.setBounds(184, 24, 63, 14);
		contentPane.add(lblChrnomtre);
		
		JButton btnStart = new JButton("START");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnStart.getText().equals("START")){
					btnStart.setText("STOP");
					cnt++;
					if(cnt==1){
						t.start();
						
					}else{
						t.resume();
						
					}
				}else{
					btnStart.setText("STOP");
					//t.suspend();
					 printToList();
					
				}
			}
		});
		btnStart.setBounds(122, 71, 89, 23);
		contentPane.add(btnStart);
		
		JButton btnEnd = new JButton("RESET");
		btnEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
				t.suspend();
				btnStart.setText("START");
				textArea.setText("");
				
			}
		});
		btnEnd.setBounds(221, 71, 90, 23);
		contentPane.add(btnEnd);
		
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
		
		
		label.setBounds(221, 37, 46, 23);
		contentPane.add(label);
		
		
		label1.setBounds(156, 37, 55, 23);
		contentPane.add(label1);
		
	
		textArea.setBounds(324, 11, 100, 162);
		contentPane.add(textArea);
		t = new Thread(this);
		reset();
	
	}

	public void display(){
		label1.setText(nstr);
		label.setText(mstr);
		
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
	public void printToList(){
		cnt2++;
		dstr+="\n"+cnt2+") "+label1.getText()+" "+label.getText()+"\n";
		textArea.setText(dstr);
		
	}
}
