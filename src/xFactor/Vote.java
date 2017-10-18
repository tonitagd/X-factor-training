package xFactor;

public class Vote {
	Participant participant;
	Judge judge;
	int vote;
	
	public Vote(Participant p, Judge j, int vote) {
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
	
	public int getVote() {
		return vote;
	}
}
