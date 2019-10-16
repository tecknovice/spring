package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Course;
import hibernate.entity.Instructor;
import hibernate.entity.InstructorDetail;
import hibernate.entity.Student;

public class CreateCourseDemo {

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
			
			Course course1 = new Course("java");
			Course course2 = new Course("angular");
			
			instructor.add(course1);
			instructor.add(course2);
			
			session.save(course1);
			session.save(course2);
			
			//commit
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}
	}

}
