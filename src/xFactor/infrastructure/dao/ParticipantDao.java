package xFactor.infrastructure.dao;

import org.hibernate.Session;

import xFactor.infrastructure.model.Participant;

public class ParticipantDao extends BaseDao {
	private Session session = getSession();

	public void save(Participant participant) {
		session.beginTransaction();
		session.save(participant);
		session.getTransaction().commit();
	}

	public void update(Participant participant) {
		session.update(participant);
	}
	
	public void remove(Participant participant) {
		session.delete(participant);
	}
}
