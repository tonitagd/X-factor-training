/*
 * Creates application for option 1 - 4 Judges, 15 Participants, 5 Stages;
 * */
package xFactor;

import java.util.Set;

public class MainServiceOne {
	Application app = new Application();
	Competition competition = new Competition();
	
	public void doOptionOne() {
		competition.setNumberOfStages(5);
		
		app.createJudges(4);
		competition.printJudges();
		
		app.giveSpecialVote(2);
		app.printSpecialJudge();
		
		app.createParticipants(15);
		
		app.createStage(1, 15);
		
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
		Set<Participant> participantsNext1 = app.getQualifiedParticipants(app.getStage(1));
		app.createStage(2, 10);
		app.getStage(2).setParticipantsInStage(participantsNext1);
		app.printParticipantsInStage(app.getStage(2));
		
		app.judgesVote(app.getStage(2));
		app.qualifyParticipants(app.getStage(2));
		app.checkForWinner(app.getStage(2));
		app.printQualifiedParticipants(app.getStage(2));
		
		Set<Participant> participantsNext2 = app.getQualifiedParticipants(app.getStage(2));
		app.createStage(3, 10);
		app.getStage(3).setParticipantsInStage(participantsNext2);
		app.printParticipantsInStage(app.getStage(3));
		
		app.judgesVote(app.getStage(3));
		app.qualifyParticipants(app.getStage(3));
		app.checkForWinner(app.getStage(3));
		app.printQualifiedParticipants(app.getStage(3));
	}
}