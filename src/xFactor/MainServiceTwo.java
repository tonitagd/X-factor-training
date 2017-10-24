/*
 * Creates application for option 2 - 3 Judges, 8 Participants, 3 Stages;
 * */
package xFactor;

import java.util.Set;

public class MainServiceTwo {
	Application app = new Application();
	Competition competition = new Competition();

	public void doOptionTwo() {
		competition.setNumberOfStages(3);
		
		app.createJudges(3);
		competition.printJudges();
		
		app.createParticipants(8);
		
		app.createStage(1, 8);
		
		app.addQualitiesForParticipants();
		
		app.printParticipantsInfo();
		app.printJudgesInfo();
		
		app.addJudgesFavourites(app.getStage(1));
		app.printFavourites(app.getStage(1));
		
		app.printParticipantsInStage(app.getStage(1));
		
		app.judgesVote(app.getStage(1));
		app.qualifyParticipants(app.getStage(1));
		app.checkForWinner(app.getStage(1));
		app.printQualifiedParticipants(app.getStage(1));
		
		Set<Participant> participantsNext1 = app.getQualified(app.getStage(1));
		app.createStage(2, 5);
		app.getStage(2).setParticipantsInStage(participantsNext1);
		app.printParticipantsInStage(app.getStage(2));
		
		app.judgesVote(app.getStage(2));
		app.qualifyParticipants(app.getStage(2));
		app.checkForWinner(app.getStage(2));
		app.printQualifiedParticipants(app.getStage(2));
		
		Set<Participant> participantsNext2 = app.getQualified(app.getStage(2));
		app.createStage(3, 2);
		app.getStage(3).setParticipantsInStage(participantsNext2);
		app.printParticipantsInStage(app.getStage(3));
		
		app.judgesVote(app.getStage(3));
		app.qualifyParticipants(app.getStage(3));
		app.checkForWinner(app.getStage(3));
		app.printQualifiedParticipants(app.getStage(3));
	}
}
