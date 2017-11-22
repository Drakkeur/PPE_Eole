package PPECode;

public class Outils {
	private double temps;
	private double handicap;
	private int rating;
	private double distance;
	
	private void handicap(){
		handicap = (5143/(Math.sqrt(Voilier.getRatingVoilier())+3.5)*Regate.getDistMilles());
	}
	
	public double calTemps(){
		handicap();
		temps = temps*handicap;
		return temps;
	}
}
