package PPECode;

public class Outils {
	private double temps;
	private double handicap;
	private int rating;
	private double distance;
	
	private void handicap(){
		handicap = (5143/(Math.sqrt(rating)+3.5)*distance);
	}
	
	public double calTemps(){
		temps = temps*handicap;
		return temps;
	}
}
