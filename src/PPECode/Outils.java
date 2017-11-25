package PPECode;

import java.math.BigDecimal;

import com.sun.javafx.css.CalculatedValue;

public class Outils {
	

	private String temps;
	private double tempsHeure;
	private double tempsMin;
	private double tempsSeconde;
	private float t; //secondes
	private double ratingvoilier;
	private String sTemps;
	private String sHeure = "";
	private String sMinute = "";
	private String sSeconde = "";
	private double distMille = Regate.getDistMilles();

	public double traitementTemps(){
		t = 0;
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
		 return (5143/(Math.sqrt(ratingvoilier)+3.5)*distMille);
	}
	
	public String calTemps(){
		temps = "";
		tempsHeure = traitementTemps()/60;
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
		return temps = (int)tempsHeure + ":"+(int)tempsMin+":"+(int)tempsSeconde;
		
	}

	public void setRatingvoilier(int i) {
		ratingvoilier = 0;
		ratingvoilier = Integer.parseInt((String) fGestionRegate.tbleCandidat.getModel().getValueAt(i,3));
	}


	public void setStemps(int i) {
		sTemps = "";
		sTemps = (String) fGestionRegate.tbleCandidat.getModel().getValueAt(i,5);
	}
	
}
