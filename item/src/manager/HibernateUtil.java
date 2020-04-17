package manager;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import domain.Item;

public class HibernateUtil {
	 private static SessionFactory sessionFactory;

	 public static SessionFactory getSessionFactory() {
	  if (sessionFactory == null) {
	   try {
	    Configuration configuration = new Configuration();

	   
	    Properties settings = new Properties();
	    settings.put(Environment.DRIVER, "oracle.jdbc.driver.OracleDriver");
	    settings.put(Environment.URL, "jdbc:oracle:thin:@localhost:1521:ORCL");
	    settings.put(Environment.USER, "user");
	    settings.put(Environment.PASS, "password321#");
	    settings.put(Environment.DIALECT, "org.hibernate.dialect.Oracle10gDialect");

	    settings.put(Environment.SHOW_SQL, "true");

	    settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
	    //validate | update | create | create-drop 
	    settings.put(Environment.HBM2DDL_AUTO, "update");

	    configuration.setProperties(settings);
	    configuration.addAnnotatedClass(Item.class);

	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	    System.out.println("Hibernate Java Config serviceRegistry created");
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;

	   } catch (Exception e) {
	    e.printStackTrace();
	   }
	  }
	  return sessionFactory;
	 }
	}
