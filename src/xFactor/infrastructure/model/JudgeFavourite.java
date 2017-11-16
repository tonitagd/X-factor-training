package xFactor.infrastructure.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "judge_favourites")
public class JudgeFavourite implements Serializable {

	private static final long serialVersionUID = 5166629253347479466L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int judgeFavouriteId;
	@ManyToOne
	@JoinColumn(name = "judgeId")
	private Judge judge;
	@ManyToMany(targetEntity = Participant.class, cascade = CascadeType.ALL)
	@JoinTable(name = "judge_fav_part")
	@JoinColumns({ @JoinColumn(name = "judgeFavouriteId", insertable = false, updatable = false),
			@JoinColumn(name = "participantId", insertable = false, updatable = false) })
	private Set<Participant> favourites;

	public JudgeFavourite() {
	}

	public int getJudgeFavouriteId() {
		return judgeFavouriteId;
	}

	public void setJudgeFavouriteId(int id) {
		this.judgeFavouriteId = id;
	}

	public JudgeFavourite(Participant participant, Judge judge) {
		if (favourites == null) {
			favourites = new HashSet<Participant>();
		}
		this.judge = judge;
		favourites.add(participant);
	}

	public Judge getJudge() {
		return judge;
	}

	public void setJudge(Judge judge) {
		this.judge = judge;
	}

	public Set<Participant> getFavourites() {
		return favourites;
	}

	public void setFavourites(Set<Participant> favourites) {
		this.favourites = favourites;
	}

	@Override
	public String toString() {
		return this.getJudge() + ": " + this.getFavourites();
	}
}