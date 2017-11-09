package xFactor.infrastructure.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "votes")
public class Vote implements Serializable {

	private static final long serialVersionUID = -837755725884857316L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int voteId;
	@ManyToOne
	@JoinColumn(name = "participantId")
	private Participant participant;
	@ManyToOne
	@JoinColumn(name = "judgeId")
	private Judge judge;
	@Column
	private boolean vote;
	@ManyToOne
	@JoinColumn(name = "stageId")
	private Stage stage;

	public Vote() {
	}

	public Vote(Participant participant, Judge judge, boolean vote, Stage stage) {
		this.participant = participant;
		this.judge = judge;
		this.vote = vote;
		this.stage = stage;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public Judge getJudge() {
		return judge;
	}

	public void setJudge(Judge judge) {
		this.judge = judge;
	}

	public boolean getVote() {
		return vote;
	}

	public void setVote(boolean vote) {
		this.vote = vote;
	}

	public int getVoteId() {
		return voteId;
	}

	public void setVoteId(int voteId) {
		this.voteId = voteId;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	@Override
	public String toString() {
		return this.participant.getName() + ": " + this.judge.getName() + " - " + this.vote;
	}
}