package xFactor.base;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xFactor.config.AppConfig;
import xFactor.infrastructure.dao.JudgeDao;
import xFactor.infrastructure.dao.JudgeFavouriteDao;
import xFactor.infrastructure.dao.ParticipantDao;
import xFactor.infrastructure.dao.StageDao;
import xFactor.infrastructure.dao.VoteDao;
import xFactor.infrastructure.model.Judge;
import xFactor.infrastructure.model.JudgeFavourite;
import xFactor.infrastructure.model.Participant;
import xFactor.infrastructure.model.Person.Gender;
import xFactor.infrastructure.model.Stage;
import xFactor.infrastructure.model.Vote;
import xFactor.service.impl.StageServiceImpl;

@Service
public class Application {
	private String name;
	private int numberOfStages;
	
	private Random random = new Random();

	private ArrayList<Judge> allJudges;
	private ArrayList<Judge> judges;
	private ArrayList<Participant> allParticipants;
	private ArrayList<Participant> participants;
	private ArrayList<Stage> allStages = new ArrayList<Stage>();;
	private ArrayList<String> qualities;

	@Autowired
	private StageServiceImpl stageService;

	@Autowired
	AppConfig config;

	@Autowired
	private ParticipantDao participantDao = new ParticipantDao();
	@Autowired
	private JudgeDao judgeDao = new JudgeDao();
	@Autowired
	private StageDao stageDao = new StageDao();
	@Autowired
	private VoteDao voteDao = new VoteDao();
	@Autowired
	private JudgeFavouriteDao judgeFavouriteDao = new JudgeFavouriteDao();

	public int getNumberOfStages() {
		return numberOfStages;
	}

	public void setNumberOfStages(int numberOfStages) {
		this.numberOfStages = numberOfStages;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Participant> getParticipants() {
		return participants;
	}
	
	public Stage findStage(int stageNum) {
		String hql = "FROM judges j WHERE j.stage_number = " + stageNum;
		TypedQuery<Stage> query = config.getSession().createQuery(hql);
		Stage result = query.getSingleResult();
		return result;
	}

	private void addJudges() {
		allJudges = new ArrayList<Judge>();
		allJudges.add(new Judge("Martin", "Momov", 36, Gender.Male, "Sofia", 3));
		allJudges.add(new Judge("Elena", "Marinova", 36, Gender.Female, "Sofia", 3));
		allJudges.add(new Judge("Delyan", "Lilov", 36, Gender.Male, "Sofia", 3));
		allJudges.add(new Judge("Stanislav", "Ovcharov", 36, Gender.Male, "Sofia", 3));
	}

	private void addParticipants() {
		allParticipants = new ArrayList<Participant>();
		allParticipants.add(new Participant("Velina", "Kraeva", 25, Gender.Female, "Plovdiv"));
		allParticipants.add(new Participant("Doroteya", "Mitova", 25, Gender.Female, "Kyustendil"));
		allParticipants.add(new Participant("Veliko", "Velichkov", 25, Gender.Male, "Petrich"));
		allParticipants.add(new Participant("Elizabet", "Pavlova", 25, Gender.Female, "Sofia"));
		allParticipants.add(new Participant("Yana", "Koleva", 25, Gender.Female, "Plovdiv"));
		allParticipants.add(new Participant("Lachezar", "Balabanov", 25, Gender.Male, "Varna"));
		allParticipants.add(new Participant("Martin", "Grigorov", 25, Gender.Male, "Sofia"));
		allParticipants.add(new Participant("Nataliya", "Vasileva", 25, Gender.Female, "Burgas"));
		allParticipants.add(new Participant("Nayden", "Nikolov", 25, Gender.Male, "Varna"));
		allParticipants.add(new Participant("Yasen", "Gurvanov", 25, Gender.Male, "Blagoevgrad"));
		allParticipants.add(new Participant("Grudi", "Radev", 25, Gender.Male, "Stara Zagora"));
		allParticipants.add(new Participant("Dilyana", "Stolarova", 25, Gender.Female, "Varna"));
		allParticipants.add(new Participant("Toni", "Ilieva", 25, Gender.Female, "Troyan"));
		allParticipants.add(new Participant("Zdravko", "Kostadinov", 25, Gender.Male, "Sofia"));
		allParticipants.add(new Participant("Kristiyan", "Srebrev", 25, Gender.Male, "Purvomay"));
	}

	private void fillQualities() {
		qualities = new ArrayList<String>();
		qualities.add("Dancing");
		qualities.add("Painting");
		qualities.add("Playing the guitar");
		qualities.add("Playing the piano");
		qualities.add("Playing the viola");
		qualities.add("Playing the drums");
	}

	private void initializeStage(int stageNum, int max, Stage stage) {
		if (stageNum < 1 || stageNum > numberOfStages) {
			throw new IllegalArgumentException("The number of stage must be between 1 and " + numberOfStages);
		}

		if (allStages.size() - 1 == numberOfStages) {
			throw new IllegalArgumentException("Maximum number of stages reached! Cannot create a new one.");
		} else if (allStages.size() == 1) {
			stage.setMaxParticipants(allParticipants.size());
			stage.getParticipantsInStage().addAll(participants);
		} else {
			stage.setMaxParticipants(max);
		}
		
		stageDao.save(stage);
	}

	public void createJudges(int number) {
		judges = new ArrayList<Judge>();
		addJudges();
		for (int i = 0; i < number; i++) {
			judges.add(allJudges.get(i));
		}

		for (int i = 0; i < judges.size(); i++) {
			judgeDao.save(judges.get(i));
		}
	}

	public ArrayList<Judge> getJudges() {
		return judges;
	}

	public void giveSpecialVote(int id) {
		for (Judge judge : judges) {
			if (judge.getJudgeId() == id) {
				judge.setSpecial(true);
				judgeDao.save(judge);
			}
		}
	}

	public Judge getSpecialJudge() {
		for (Judge judge : judges) {
			if (judge.isSpecial()) {
				return judge;
			}
		}
		return null;
	}

	public void createParticipants(int number) {
		participants = new ArrayList<Participant>();
		addParticipants();
		for (int i = 0; i < number; i++) {
			participants.add(allParticipants.get(i));
		}

		for (int i = 0; i < participants.size(); i++) {
			participantDao.save(participants.get(i));
		}
	}

	public Stage createStage(int stageNum, int max) {
		Stage stage = new Stage(stageNum, max);
		allStages.add(stage);
		initializeStage(stageNum, max, stage);
		stageDao.save(stage);
		return stage;
	}

	public Set<Participant> getParticipantsInStage(Stage stage) {
		stageDao.save(stage);
		return stage.getParticipantsInStage();
	}
	
	public void addQualitiesForParticipants() {
		fillQualities();
		for (Participant participant : participants) {
			int i = random.nextInt(qualities.size() - 1);
			participant.addQuality(qualities.get(i));
			participantDao.update(participant);
		}
	}

	public void addJudgesFavourites(Stage stage) {
		for (Judge judge : judges) {
			for (int i = 1; i <= judge.getMaxFavourites(); i++) {
				int rand = random.nextInt(participants.size());
				Participant participant = participants.get(rand);
				stage.addFavourite(participant, judge);
				stageDao.update(stage);
				judgeFavouriteDao.save(new JudgeFavourite(participant, judge));
			}
		}
	}

	public void judgesVote(Stage stage) {
		for (Participant participant : stage.getParticipantsInStage()) {
			for (Judge judge : judges) {
				Vote vote = new Vote();
				vote = stage.vote(judge, participant, random.nextBoolean());
				voteDao.save(vote);
			}
		}
	}

	public void qualifyParticipants(Stage stage, ArrayList<Judge> judges) {
		stageService.qualifyParticipants(stage, judges);
		stageDao.save(stage);
	}

	public Set<Participant> getQualifiedParticipants(Stage stage) {
		return stage.getQualifiedParticipants();
	}

	public Participant checkForWinner(Stage stage) {
		Participant winner = stage.checkForWinner();
		if (winner != null) {
			participantDao.save(winner);
			return winner;
		}
		return null;
	}
}