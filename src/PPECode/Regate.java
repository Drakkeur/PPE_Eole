package PPECode;

public class Regate {
	private static int distMilles;

	public Regate(int distMilles){
		Regate.distMilles = distMilles;
	}
	
	public static int getDistMilles() {
		return distMilles;
	}

	public void setDistMilles(int distMilles) {
		Regate.distMilles = distMilles;
	}
	
}
