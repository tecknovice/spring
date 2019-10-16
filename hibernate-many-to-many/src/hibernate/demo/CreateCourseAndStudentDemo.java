package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Course;
import hibernate.entity.Instructor;
import hibernate.entity.InstructorDetail;
import hibernate.entity.Review;
import hibernate.entity.Student;

public class CreateCourseAndStudentDemo {

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
			
			Course course = new Course("How to become a billionaire");
			session.save(course);
			
			Student student1 = new Student("John", "Doe", "john.doe@gmail.com");
			Student student2 = new Student("Maryn", "Moore", "maryn.moore@gmail.com");
			course.addStudent(student1);
			course.addStudent(student2);
			session.save(student1);
			session.save(student2);
			
			//commit
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}
	}

}
