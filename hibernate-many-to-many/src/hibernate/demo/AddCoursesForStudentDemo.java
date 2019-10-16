package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Course;
import hibernate.entity.Instructor;
import hibernate.entity.InstructorDetail;
import hibernate.entity.Review;
import hibernate.entity.Student;

public class AddCoursesForStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Student.class)
									.addAnnotatedClass(Review.class)
									.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {			
			//begin transaction
			session.beginTransaction();
			
			int id = 2;
			Student student = session.get(Student.class, id);

			System.out.println(student);
			System.out.println(student.getCourses());
			
			Course course1 = new Course("How to crush people?");
			Course course2 = new Course("How to have an eternal life");
			
			course1.addStudent(student);
			course2.addStudent(student);
			
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
