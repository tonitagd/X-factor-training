package xFactor;

public class Vote {
	private Participant participant;
	private Judge judge;
	private boolean vote;
	
	public Vote(Participant p, Judge j, boolean vote) {
		this.participant = p;
		this.judge = j;
		this.vote = vote;
	}

	public Participant getParticipant() {
		return participant;
	}

	public Judge getJudge() {
		return judge;
	}
	
	public boolean getVote() {
		return vote;
	}
	
	@Override
	public String toString() {
		return this.participant.getName() + ": " + this.judge.getName() + " - " + this.vote;
	}
}