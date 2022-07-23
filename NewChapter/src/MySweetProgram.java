import java.util.*;

public class MySweetProgram {
	
	public static void main(String[] args) {
		
		User you = new User("Ronnie", "Cutamora");
		User me = new User("asdf", "lkh");
		
		List<User> users = new ArrayList<User>();
		
		users.add(me);
		users.add(you);
		
		for(int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i).getFullName());
		}
		
		for(User u : users)
			System.out.println(u.getFullName());
		

		
	}
	
}
