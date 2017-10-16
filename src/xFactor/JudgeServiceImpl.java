package xFactor;

public class JudgeServiceImpl implements JudgeService {
	
	protected JudgeServiceImpl() {};
	
	@Override
	public void addFavourite(Participant participant, Judge judge) {
		if(judge.getFavourites().size() < judge.getMaxFavourites()) {
			judge.getFavourites().add(participant);
		} else {
			System.out.println("Your list of favourites is full. Cannot add " + participant.getName() + ".");	
		}
	}
	
	@Override
	public void removeFavourite(Participant participant, Judge judge) {
		judge.getFavourites().remove(participant);
	}
	
	@Override
	public void printFavourites(Judge judge) {
		if(judge.getFavourites().size() > 0) {
			System.out.println(judge.getFavourites());
		}
	}
	
	@Override
	public void clearFavourites(Judge judge) {
		judge.getFavourites().clear();
		if(judge.getFavourites().size() == 0) {
			System.out.println("Your list of favourites is empty.");
		}
	}
	
	@Override
	public void vote(Participant participant, int vote, Judge judge) {
		judge.getVotes().put(participant, vote);
		
		if(vote == 1) {
			participant.getPositiveVotes().add(judge);
			return;
		}
		
		judge.setVote(vote);
	}
	
	@Override
	public void printJudges() {
		for(int i = 0; i < Competition.getJudgesSize(); i++) {
			System.out.println(Competition.getJudges().get(i));
		}
	}
}