package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Student;

public class PrimaryKeyDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			Student student1 = new Student("jonny", "english", "jonny@email.com");
			Student student2 = new Student("jim", "stewart", "jim@email.com");
			Student student3 = new Student("jean", "stuborn", "jean@email.com");
			//begin transaction
			session.beginTransaction();
			//save
			session.save(student1);
			session.save(student2);
			session.save(student3);
			//commit
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}
