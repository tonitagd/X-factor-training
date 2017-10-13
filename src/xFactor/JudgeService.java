package xFactor;

public interface JudgeService {
	public void addFavourite(Participant participant);
	public void removeFavourite(Participant participant);
	public void printFavourites();
	public void clearFavourites();
	public void vote(Participant participant, int vote, Judge judge);
}
