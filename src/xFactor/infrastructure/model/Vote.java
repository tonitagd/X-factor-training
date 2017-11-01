package xFactor.infrastructure.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "votes")
public class Vote {
	@Id
	@GeneratedValue
	private int id;
	@Column
	private Participant participant;
	@Column
	private Judge judge;
	@Column
	private boolean vote;

	public Vote() {
	}

	public Vote(Participant participant, Judge judge, boolean vote) {
		this.participant = participant;
		this.judge = judge;
		this.vote = vote;
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

	@Override
	public String toString() {
		return this.participant.getName() + ": " + this.judge.getName() + " - " + this.vote;
	}
}