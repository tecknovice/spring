package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Course;
import hibernate.entity.Instructor;
import hibernate.entity.InstructorDetail;
import hibernate.entity.Student;

public class EagerLazyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {			
			//begin transaction
			session.beginTransaction();
			
			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);
			
			System.out.println(instructor);
			
			//commit
			session.getTransaction().commit();
			session.close();
			
			//since the courses is lazy loading, this will be failed!
			System.out.println(instructor.getCourses());
		} finally {
			factory.close();
		}
	}

}
