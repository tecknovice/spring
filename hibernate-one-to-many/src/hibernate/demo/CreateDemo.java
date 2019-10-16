package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Course;
import hibernate.entity.Instructor;
import hibernate.entity.InstructorDetail;
import hibernate.entity.Student;

public class CreateDemo {

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
			Instructor instructor = new Instructor("Hung", "Nguyen", "tecknovice@gmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail(
					"https://www.youtube.com/channel/UCSKBLsqTBGiAgyoIMYjnApw", 
					"gaming");
			
			instructor.setInstructorDetail(instructorDetail);
			
			//begin transaction
			session.beginTransaction();
			
			System.out.println("instructor: "+instructor);
			session.save(instructor);//will also create detail object
			
			//commit
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}
	}

}
