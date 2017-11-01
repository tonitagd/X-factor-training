package xFactor.infrastructure.dao;

import org.hibernate.Session;

import xFactor.infrastructure.model.Stage;

public class StageDao extends BaseDao {
	private Session session = getSession();
	public void save(Stage stage){
		session.beginTransaction();
		session.save(stage);
		session.update(stage);
		session.getTransaction().commit();
	}
	
	public void update(Stage stage) {
		session.update(stage);
	}
}
