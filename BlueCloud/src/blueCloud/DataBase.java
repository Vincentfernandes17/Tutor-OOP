package blueCloud;

import java.util.HashMap;

public class DataBase {
	private HashMap<String, User> users = new HashMap<String, User>();
	
	public boolean checkUserPassword(String username, String password) {
		if(users.containsKey(username) && users.get(username).getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
	public boolean checkUser(String username) {
		if(users.containsKey(username))return true;
		return false;
	}
	
	public boolean checkUniqueUsername(String username) {
		if(users.containsKey(username))return false;
		return true;
	}
	
	public void addUser(User user) {
		users.put(user.getUsername(), user);
	}
	
	public void removeUser(User user) {
		users.remove(user.getUsername());
	}
	
	public User getUser(String username) {
		return users.get(username);
	}
	
	public HashMap<String, User> getUsers() {
		return users;
	}

	public void setUsers(HashMap<String, User> users) {
		this.users = users;
	}
	
	
	
}
