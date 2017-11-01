package xFactor.infrastructure.dao;

import org.hibernate.Session;

import xFactor.infrastructure.model.Judge;

public class JudgeDao extends BaseDao {
	private Session session = getSession();
	public void save(Judge judge){
		session.beginTransaction();
		session.save(judge);
		session.update(judge);
		session.getTransaction().commit();
	}
	
	public void update(Judge judge) {
		session.update(judge);
	}
}
