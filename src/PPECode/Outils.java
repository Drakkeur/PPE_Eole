package PPECode;

import java.math.BigDecimal;

import com.sun.javafx.css.CalculatedValue;

public class Outils {
	

	private String temps;
	private double tempsHeure;
	private double tempsMin;
	private double tempsSeconde;
	private float t; //secondes
	private double ratingvoilier = 1.5;
	private String sTemps = "01:10:07";
	private String sHeure = "";
	private String sMinute = "";
	private String sSeconde = "";

	public static void main(String[] args){
		Outils O = new Outils();
		O.calTemps();
	}
	
	
	public double traitementTemps(){
		for(int j = 0; j<2;j++){
			sHeure += sTemps.substring(j,j+1);
		}
		t = Integer.parseInt(sHeure)*3600;
		for(int j = 3; j<5;j++){
			sMinute += sTemps.substring(j,j+1);
		}
		t += Integer.parseInt(sMinute)*60;
		for(int j = 6; j<8;j++){
			sSeconde += sTemps.substring(j,j+1);
		}
		t+= Double.parseDouble(sSeconde);
		return t + handicap();
	}

	public double handicap(){
		 return (5143/(Math.sqrt(ratingvoilier)+3.5)*1/*Regate.getDistMilles()*/);
	}
	
	public String calTemps(){
		tempsHeure = traitementTemps()/60;
		System.out.println(tempsHeure);
		int i = 0;
		while(tempsHeure>60){
			tempsHeure -= 60;
			i++;
		}
		tempsMin = tempsHeure;
		tempsHeure = i;
		int tmp = (int) tempsMin;
		tempsSeconde = (tempsMin - tmp)*100;
		tempsMin = tmp;
		temps = (int)tempsHeure + ":"+(int)tempsMin+":"+(int)tempsSeconde;
		System.out.println(temps);
		return temps;
		
	}

	public void setRatingvoilier() {
		ratingvoilier = (int) fGestionRegate.tbleCandidat.getValueAt(fGestionRegate.tbleCandidat.getSelectedRow(),3);
	}


	public void setStemps() {
		sTemps = (String) fGestionRegate.tbleCandidat.getValueAt(fGestionRegate.tbleCandidat.getSelectedRow(),5);
	}
	
}
