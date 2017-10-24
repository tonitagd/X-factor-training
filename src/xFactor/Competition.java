package xFactor;

import java.util.ArrayList;

public class Competition {
	private static ArrayList<Judge> judges = new ArrayList<Judge>();
	private static ArrayList<Participant> participants = new ArrayList<Participant>();
	
	public static int numberOfJudges;
	public static int judgeCountInstances;

	public static int numberOfStages;
	public static int stageCountInstances;
	
	public ArrayList<Judge> getJudges() {
		return judges;
	}
	
	public int getJudgesSize() {
		return judges.size();
	}

	public ArrayList<Participant> getParticipants() {
		return participants;
	}
	
	public int getParticipantsSize() {
		return participants.size();
	}
	
	public int getNumberOfStages() {
		return numberOfStages;
	}

	public void setNumberOfStages(int numberOfStages) {
		Competition.numberOfStages = numberOfStages;
	}
	
	public void printJudges() {
		for(int i = 0; i < getJudgesSize(); i++) {
			System.out.println(getJudges().get(i));
		}
	}
}