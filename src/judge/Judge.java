package judge;

import person.Person;

public class Judge extends Person {
	private int maxFavourites;
	private boolean isSpecial;
	
	public Judge() {}
	
	public Judge(String fName, String lName, int age, Gender male, String birthPlace, int max, int id) {
		super(fName, lName, age, male, birthPlace, id);
		this.maxFavourites = max;
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