package xFactor;

public class Vote {
	private Participant participant;
	private Judge judge;
	private boolean vote;
	
	public Vote() {}
	
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