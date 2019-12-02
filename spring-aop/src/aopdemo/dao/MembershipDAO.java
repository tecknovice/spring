package aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public void addMembership() {
		System.out.println("MembershipDAO.addMembership()");
	}
	public void status() {
		System.out.println("MembershipDAO.status()");
	}
}
