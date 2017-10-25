package xFactor;

public class Judge extends Person {
	private int maxFavourites;
	private boolean isSpecial;
	
	private Competition competition = new Competition();
	
	public Judge() {}
	
	public Judge(String fName, String lName, int age, Gender male, String birthPlace, int max, int id) {
		super(fName, lName, age, male, birthPlace, id);
		initializeJudge();
		this.maxFavourites = max;
	}
	
	private void initializeJudge() {
		Competition.numberOfJudges++;
		competition.getJudges().add(this);
	}
	
	public int getMaxFavourites() {
		return maxFavourites;
	}
	
	public void setMaxFavourites(int maxFavourites) {
		this.maxFavourites = maxFavourites;
	}
	
	public boolean isSpecial() {
		return isSpecial;
	}
	
	public void setSpecial(boolean isSpecial) {
		this.isSpecial = isSpecial;
	}
}