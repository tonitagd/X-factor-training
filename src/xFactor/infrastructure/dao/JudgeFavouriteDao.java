package xFactor.infrastructure.dao;

import org.hibernate.Session;

import xFactor.infrastructure.model.JudgeFavourite;

public class JudgeFavouriteDao extends BaseDao {
	private Session session = getSession();

	public void save(JudgeFavourite judgeFav) {
		session.beginTransaction();
		session.save(judgeFav);
		session.getTransaction().commit();
	}

	public void update(JudgeFavourite judgeFav) {
		session.update(judgeFav);
	}
	
	public void remove(JudgeFavourite judgeFav) {
		session.delete(judgeFav);
	}
}
