package xFactor.infrastructure.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import xFactor.config.AppConfig;

@Repository
@Transactional
public abstract class BaseDao<T> {
	@Autowired
	AppConfig config;

	public BaseDao() {
	}

	public void save(T t) {
		config.getSession().beginTransaction();
		config.getSession().save(t);
		config.getSession().getTransaction().commit();
	}

	public void update(T t) {
		config.getSession().update(t);
	}

	public void remove(T t) {
		config.getSession().delete(t);
	}

	public void closeSession() {
		if (config.getSession() != null) {
			try {
				config.getSession().close();
				config.getSessionFactory().close();
			} catch (Exception e) {
				System.err.println("Could not close session: " + e.getMessage());
			}
		}
	}
}