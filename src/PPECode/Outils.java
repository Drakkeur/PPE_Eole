package PPECode;

import java.math.BigDecimal;

public class Outils {
	

	private double temps;
	private float t;
	private int ratingvoilier;
	private String s= "05:05:05 129";
	private String sHeure = "";
	private String sMinute = "";
	private String sSeconde = "";
	private String sMillisec = "";
	
	
	public static void main(String[] agrs){
		Outils O = new Outils();
		O.traitementTemps();
	}
	
	
	public double traitementTemps(){
		for(int j = 0; j<2;j++){
			sHeure += s.substring(j,j+1);
		}
		t = Integer.parseInt(sHeure)*60;
		System.out.println(t);
		for(int j = 3; j<5;j++){
			sMinute += s.substring(j,j+1);
		}
		t += Integer.parseInt(sMinute);
		System.out.println(t);
		for(int j = 6; j<8;j++){
			sSeconde += s.substring(j,j+1);
		}
		t+= Double.parseDouble(sSeconde)/100;
		System.out.println(t);
		for(int j =9; j<s.length();j++){
			sMillisec += s.substring(j,j+1);
		}
		System.out.println(Double.parseDouble(sMillisec)/100000);
		t+= Double.parseDouble(sMillisec)/100000;
		System.out.println(t);
		return t;
	}
	
	public double handicap(){
		 return (5143/(Math.sqrt(2)+3.5)*Regate.getDistMilles());
	}
	
	public double calTemps(){
		return temps *= handicap();
	}

	public void setS() {
		s = (String) fGestionRegate.tbleCandidat.getValueAt(fGestionRegate.tbleCandidat.getSelectedRow(),5);
	}
	
}
