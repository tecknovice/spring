package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Student;

public class UpdateStudentDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			//begin transaction
			session.beginTransaction();
			
			//update 1 student
			Student s = session.get(Student.class, 1);
			if(s!=null)
				System.out.println("Student info: " + s.toString());
			s.setEmail("new@email.com");
			
			//update many
			session.createQuery("update Student set email='skew.driver@gmail.com' where email='tecknovice@gmail.com'")
			.executeUpdate();
			
			//commit
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}
