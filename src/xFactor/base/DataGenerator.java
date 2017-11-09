/*
 * Creates application for option 1 - 4 Judges, 15 Participants, 5 Stages;
 * */
package xFactor.base;

import java.util.HashSet;
import java.util.Set;

import xFactor.infrastructure.model.Participant;
import xFactor.infrastructure.model.Stage;

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

		Stage stage = app.getStage(1);
		app.addJudgesFavourites(stage);
		app.printFavourites(app.getStage(1));

		app.printParticipantsInStage(app.getStage(1));

		app.judgesVote(app.getStage(1));
		app.qualifyParticipants(app.getStage(1), app.getJudges());
		app.checkForWinner(app.getStage(1));

		app.printQualifiedParticipants(app.getStage(1));
		Set<Participant> participantsNext1 = app.getQualifiedParticipants(app.getStage(1));
		app.createStage(2, 10);
		Stage stage2 = app.getStage(2);
		stage2.setParticipantsInStage(new HashSet<>());
		stage2.getParticipantsInStage().addAll(participantsNext1);
		app.printParticipantsInStage(stage2);

		app.judgesVote(stage2);
		app.qualifyParticipants(stage2, app.getJudges());
		app.checkForWinner(stage2);
		app.printQualifiedParticipants(stage2);

		Set<Participant> participantsNext2 = app.getQualifiedParticipants(stage2);
		app.createStage(3, 10);
		Stage stage3 = app.getStage(3);
		stage3.setParticipantsInStage(new HashSet<>());
		stage3.getParticipantsInStage().addAll(participantsNext2);
		app.printParticipantsInStage(app.getStage(3));

		app.judgesVote(app.getStage(3));
		app.qualifyParticipants(app.getStage(3), app.getJudges());
		app.checkForWinner(app.getStage(3));
		app.printQualifiedParticipants(app.getStage(3));
	}
}