package xFactor.config;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import xFactor.infrastructure.model.Judge;
import xFactor.infrastructure.model.JudgeFavourite;
import xFactor.infrastructure.model.Participant;
import xFactor.infrastructure.model.Stage;
import xFactor.infrastructure.model.Vote;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "xFactor")
public class AppConfig extends WebMvcConfigurerAdapter {
	private SessionFactory sessionFactory = new org.hibernate.cfg.Configuration()
			.addProperties(getProperties())
			.addPackage("xFactor.infrastructure.model")
			.addAnnotatedClass(Participant.class)
			.addAnnotatedClass(Judge.class)
			.addAnnotatedClass(Stage.class)
			.addAnnotatedClass(Vote.class)
			.addAnnotatedClass(JudgeFavourite.class)
			.buildSessionFactory();

	private Session session = sessionFactory.openSession();

	public Session getSession() {
		return session;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
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
		prop.setProperty("hibernate.hbm2ddl.auto", "create-drop");

		return prop;
	}
}