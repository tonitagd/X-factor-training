package xFactor;

import java.util.ArrayList;

public abstract class Competition {
	private static ArrayList<Judge> judges = new ArrayList<Judge>();
	private static ArrayList<Participant> participants = new ArrayList<Participant>();
	
	public static int numberOfJudges;
	public static int judgeCountInstances;

	public static int numberOfStages;
	public static int stageCountInstances;
	
	public static ArrayList<Judge> getJudges() {
		return Competition.judges;
	}
	
	public static int getJudgesSize() {
		return Competition.judges.size();
	}

	public static ArrayList<Participant> getParticipants() {
		return participants;
	}
	
	public int getParticipantsSize() {
		return participants.size();
	}
	
	public static int getNumberOfStages() {
		return numberOfStages;
	}

	public static void setNumberOfStages(int numberOfStages) {
		Competition.numberOfStages = numberOfStages;
	}
	
	public static void printJudges() {
		for(int i = 0; i < getJudgesSize(); i++) {
			System.out.println(getJudges().get(i));
		}
	}
}