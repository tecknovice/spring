package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			Student s = new Student("abc", "def", "tecknovice@gmail.com");
			//begin transaction
			session.beginTransaction();
			//save
			session.save(s);
			//commit
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}
