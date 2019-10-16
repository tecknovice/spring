package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import hibernate.entity.Course;
import hibernate.entity.Instructor;
import hibernate.entity.InstructorDetail;
import hibernate.entity.Student;

public class FetchJoinDemo {

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
			Query<Instructor> query = session.createQuery(
					"select i from Instructor i JOIN FETCH i.courses where i.id=:id",
					Instructor.class);
			query.setParameter("id", id);
			
			Instructor instructor = query.getSingleResult();
			
			System.out.println(instructor);
			
			//commit
			session.getTransaction().commit();
			session.close();
			

			System.out.println(instructor.getCourses());
		} finally {
			factory.close();
		}
	}

}
