package xFactor.infrastructure.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "judges")
public class Judge extends Person {

	private static final long serialVersionUID = -4738505651127348730L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int judgeId;
	@Column
	private int maxFavourites;
	@Column
	private boolean isSpecial;

	public Judge() {
	}

	public Judge(String fName, String lName, int age, Gender male, String birthPlace, int max) {
		super(fName, lName, age, male, birthPlace);
		this.maxFavourites = max;
	}

	public int getJudgeId() {
		return judgeId;
	}

	public void setJudgeId(int judgeId) {
		this.judgeId = judgeId;
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