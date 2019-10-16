package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Instructor;
import hibernate.entity.InstructorDetail;
import hibernate.entity.Student;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {			
			//begin transaction
			session.beginTransaction();
			
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 222);
			
			System.out.println(instructorDetail);
			System.out.println(instructorDetail.getInstructor());
			
			//commit
			session.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
