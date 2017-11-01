package xFactor.infrastructure.dao;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import xFactor.infrastructure.model.Stage;
import xFactor.infrastructure.model.Judge;
import xFactor.infrastructure.model.Participant;
import xFactor.infrastructure.model.Vote;

public abstract class BaseDao {

	private Session session;

	private SessionFactory sessionFactory;

	public BaseDao() {
		this.sessionFactory = new Configuration()
				.addProperties(getProperties())
				.addPackage("xFactor.infrastructure.model")
				.addAnnotatedClass(Participant.class)
				.addAnnotatedClass(Judge.class)
				.addAnnotatedClass(Stage.class)
				.addAnnotatedClass(Vote.class)
				.buildSessionFactory();
		this.session = sessionFactory.openSession();
	}
	
	private Properties getProperties() {
		Properties prop = new Properties();
		
		prop.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		
		prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/x-factor");
		prop.setProperty("hibernate.default_schema", "x-factor");
		prop.setProperty("hibernate.connection.username", "root");
		prop.setProperty("hibernate.connection.password", "root");
		
		prop.setProperty("hibernate.connection.pool_size", "5");
		
		prop.setProperty("hibernate.show_sql", "true");
		prop.setProperty("hibernate.hbm2ddl.auto", "update");
		
		return prop;
	}

	public Session getSession(){
		return session;
	}

	public void closeSession() {
		if (session != null) {
			try {
				session.close();
				sessionFactory.close();
			} catch (Exception e) {
				System.err.println("Could not close session: " + e.getMessage());
			}
		}
	}
}
