package PPECode;

public class Outils {
	private double temps;
	
	
	
	private double handicap(){
		 return (5143/(Math.sqrt(Voilier.getRatingVoilier())+3.5)*Regate.getDistMilles());
	}
	
	public double calTemps(){
		return temps *= handicap();
	}
}
