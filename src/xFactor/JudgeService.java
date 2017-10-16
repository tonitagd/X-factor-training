package xFactor;

public interface JudgeService {
	public void addFavourite(Participant participant, Judge judge);
	public void removeFavourite(Participant participant, Judge judge);
	public void printFavourites(Judge judge);
	public void clearFavourites(Judge judge);
	public void vote(Participant participant, int vote, Judge judge);
	public void printJudges();
}