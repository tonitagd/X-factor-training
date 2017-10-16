package xFactor;

import java.util.ArrayList;

public class ParticipantServiceImpl implements ParticipantService {
	
	protected ParticipantServiceImpl() {};
	
	@Override
	public void printVotes(Participant participant) {
		System.out.println("Judges who voted with \"YES\" for " + participant.getName() + ":");
		
		int size = participant.getPositiveVotes().size();
		if(size > 0 && size != Competition.getJudgesSize()) {
			for(int i = 0; i < size; i++) {
				System.out.println(participant.getPositiveVotes().get(i));
			}
		} else if(size == Competition.getJudgesSize()) {
			System.out.println("Everybody.");
		} else {
			System.out.println("Nobody.");
		}
	}
	
	@Override
	public ArrayList<Participant> removeParticipant(Participant participant) {
		Competition.getParticipants().remove(participant);
		return Competition.getParticipants();
	}
}
