package xFactor.infrastructure.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "judges")
public class Judge extends Person {

	private static final long serialVersionUID = -4738505651127348730L;
	
	@Column
	private int maxFavourites;
	@Column
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