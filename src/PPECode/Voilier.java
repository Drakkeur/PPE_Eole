package PPECode;

public class Voilier {
	
	private static String nomVoilier;
	private static int classeVoilier;
	private static int ratingVoilier;
	private static String nomSkipper;
	private String statut = "";
	private int Temps;
	private int index;
	
	public Voilier( String nom, int classe, int rating, String nomSkipper){
		
		Voilier.nomVoilier = nom;
		Voilier.classeVoilier = classe;
		Voilier.ratingVoilier = rating;
		Voilier.nomSkipper = nomSkipper;	
	}

	public static String getNomVoilier() {
		return nomVoilier;
	}

	public static void setNomVoilier(String classeVoilier) {
		Voilier.nomVoilier = classeVoilier;
	}

	public int getClasseVoilier() {
		return classeVoilier;
	}

	public static void setClasseVoilier(int classeVoilier) {
		Voilier.classeVoilier = classeVoilier;
	}

	public int getRatingVoilier() {
		return ratingVoilier;
	}

	public static void setRatingVoilier(int ratingVoilier) {
		Voilier.ratingVoilier = ratingVoilier;
	}

	public String getNomSkipper() {
		return nomSkipper;
	}

	public static void setNomSkipper(String nomSkipper) {
		Voilier.nomSkipper = nomSkipper;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
	
}
