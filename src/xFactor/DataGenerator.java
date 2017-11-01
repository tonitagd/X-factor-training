/*
 * Creates application for option 1 - 4 Judges, 15 Participants, 5 Stages;
 * */
package xFactor;

import java.util.Set;

import participant.Participant;

public class DataGenerator {
	Application app = new Application();
	
	public void fillData(int numStages, int numJudges, int numParticipants, int specialJudgeId) {
		app.setNumberOfStages(numStages);
		
		app.createJudges(numJudges);
		System.out.println("Judges in the show are:");
		app.printJudges();

		app.giveSpecialVote(specialJudgeId);
		System.out.print("Judge with special vote: ");
		app.printSpecialJudge();
		
		app.createParticipants(numParticipants);
		
		app.createStage(1, numParticipants);
		
		app.addQualitiesForParticipants();
		
		System.out.println("Information about participants:");
		app.printParticipantsInfo();
		System.out.println("Information about judges:");
		app.printJudgesInfo();
		
		app.addJudgesFavourites(app.getStage(1));
		app.printFavourites(app.getStage(1));
		
		app.printParticipantsInStage(app.getStage(1));
		
		app.judgesVote(app.getStage(1));
		app.qualifyParticipants(app.getStage(1), app.getJudges());
		app.checkForWinner(app.getStage(1));
		
		app.printQualifiedParticipants(app.getStage(1));
		Set<Participant> participantsNext1 = app.getQualifiedParticipants(app.getStage(1));
		app.createStage(2, 10);
		app.getStage(2).setParticipantsInStage(participantsNext1);
		app.printParticipantsInStage(app.getStage(2));
		
		app.judgesVote(app.getStage(2));
		app.qualifyParticipants(app.getStage(2), app.getJudges());
		app.checkForWinner(app.getStage(2));
		app.printQualifiedParticipants(app.getStage(2));
		
		Set<Participant> participantsNext2 = app.getQualifiedParticipants(app.getStage(2));
		app.createStage(3, 10);
		app.getStage(3).setParticipantsInStage(participantsNext2);
		app.printParticipantsInStage(app.getStage(3));
		
		app.judgesVote(app.getStage(3));
		app.qualifyParticipants(app.getStage(3), app.getJudges());
		app.checkForWinner(app.getStage(3));
		app.printQualifiedParticipants(app.getStage(3));
	}
}