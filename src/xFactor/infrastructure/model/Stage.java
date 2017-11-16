package xFactor.infrastructure.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "stages")
public class Stage implements Serializable {

	private static final long serialVersionUID = 4720828404954251575L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stageId;
	
	@Column(name = "stage_number", nullable = false, unique = true)
	private int stageNumber;
	
	@Column(name = "max_participants", nullable = false)
	private int maxParticipants;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "participants_in_stage")
	@JoinColumns({ @JoinColumn(name = "stageId", insertable = false, updatable = false),
			@JoinColumn(name = "participantId", insertable = false, updatable = false) })
	private Set<Participant> participantsInStage = new HashSet<Participant>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "stage_qualified_participants")
	@JoinColumns({ @JoinColumn(name = "stageId", insertable = false, updatable = false),
			@JoinColumn(name = "participantId", insertable = false, updatable = false) })
	private Set<Participant> qualifiedParticipants = new HashSet<Participant>();
	
	@ManyToMany(targetEntity = JudgeFavourite.class, cascade = CascadeType.ALL)
	@JoinTable(name = "stage_favourite_participants")
	@JoinColumns({ @JoinColumn(name = "stageId", insertable = true, updatable = true),
			@JoinColumn(name = "judgeFavouriteId", insertable = true, updatable = true) })
	private List<JudgeFavourite> judgeFavourites = new ArrayList<JudgeFavourite>();
	
	@OneToMany
	private List<Vote> votes = new ArrayList<Vote>();

	public Stage() {
	}

	public Stage(int stageNum, int max) throws IllegalArgumentException {
		this.stageNumber = stageNum;
	}

	public int getStageId() {
		return stageId;
	}

	public void setStageId(int stageId) {
		this.stageId = stageId;
	}

	public int getStageNumber() {
		return stageNumber;
	}

	public void setStageNumber(int stageNumber) {
		this.stageNumber = stageNumber;
	}

	public int getMaxParticipants() {
		return maxParticipants;
	}

	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}

	public Set<Participant> getParticipantsInStage() {
		return participantsInStage;
	}

	public void setParticipantsInStage(Set<Participant> participantsInStage) {
		this.participantsInStage = participantsInStage;
	}

	public Set<Participant> getQualifiedParticipants() {
		return qualifiedParticipants;
	}

	public void setQualifiedParticipants(Set<Participant> qualifiedParticipants) {
		this.qualifiedParticipants = qualifiedParticipants;
	}

	public List<JudgeFavourite> getJudgeFavourites() {
		return judgeFavourites;
	}

	public void setJudgeFavourites(List<JudgeFavourite> judgeFavourites) {
		this.judgeFavourites = judgeFavourites;
	}

	public List<Vote> getVotes() {
		return votes;
	}

	public void setVotes(ArrayList<Vote> votes) {
		this.votes = votes;
	}

	public Vote vote(Judge judge, Participant participant, boolean voteValue) {
		Vote vote = new Vote(participant, judge, voteValue, this);
		this.getVotes().add(vote);
		return vote;
	}

	public Participant checkForWinner() {
		if (this.getQualifiedParticipants().size() == 1) {
			ArrayList<Participant> list = new ArrayList<Participant>();
			list.addAll(qualifiedParticipants);
			list.get(0).setWinner(true);
			return list.get(0);
		}
		return null;
	}

	public void addFavourite(Participant participant, Judge judge) {
		for (JudgeFavourite judgeFavourite : judgeFavourites) {
			Judge favouritesJudge = judgeFavourite.getJudge();
			Set<Participant> favourites = judgeFavourite.getFavourites();

			if (favouritesJudge.equals(judge)) {
				if (favourites.size() >= judge.getMaxFavourites()) {
					System.out.println("Your list of favourites is full. Cannot add " + participant.getName() + ".");
					return;
				}
				judgeFavourite.getFavourites().add(participant);
				return;
			}
		}
		judgeFavourites.add(new JudgeFavourite(participant, judge));
	}
}