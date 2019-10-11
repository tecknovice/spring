package hibernate.demo;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Student;

public class QueryStudentDemo {
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
			
			//query student
			List<Student> students;
			
			students = session.createQuery("from Student").getResultList();

			for (Student student : students) {
				System.out.println(student.toString());
			}
			
			//query student with last name = 'Doe'
			students = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			
			for (Student student : students) {
				System.out.println(student.toString());
			}
			
			//query student with last name = 'Doe' or first name = 'jim'
			students = session.createQuery("from Student s where s.lastName='Doe' or s.firstName='jim'").getResultList();
			
			for (Student student : students) {
				System.out.println(student.toString());
			}
			
			//query student with last name = 'Doe' or first name = 'jim'
			students = session.createQuery("from Student s where s.email LIKE '%email.com'").getResultList();
			
			for (Student student : students) {
				System.out.println(student.toString());
			}
			
			//commit
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
}
