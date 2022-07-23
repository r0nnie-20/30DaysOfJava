
public class User {
	private String name;
	private String lastname;
	
	public User(String n, String ln) {name = n; lastname = ln;}
	
	public String getFullName() {
		return name+" "+lastname;
	}
}
