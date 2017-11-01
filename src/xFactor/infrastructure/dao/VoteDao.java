package xFactor.infrastructure.dao;

import org.hibernate.Session;

import xFactor.infrastructure.model.Vote;

public class VoteDao extends BaseDao {
	private Session session = getSession();
	public void save(Vote vote){
		session.beginTransaction();
		session.save(vote);
		session.update(vote);
		session.getTransaction().commit();
	}
	
	public void update(Vote vote) {
		session.update(vote);
	}
}
