package blueCloud;

import java.util.*;

public class Menu {
	private User currentUser = null;
	private String newUsername;
	private String newPassword;
	DataBase userDataBase;
	VirtualMachineManagement VMs;
	
	Scanner scanner = new Scanner(System.in);
	
	public Menu(DataBase userData, VirtualMachineManagement VMs) {
		this.userDataBase = userData;
		this.VMs = VMs;
	}
	
	private void loginMenu() {
		System.out.println("Login!");
		
		do {
			System.out.printf("Input username: ");
			newUsername = scanner.nextLine();
			System.out.printf("Input password: ");
			newPassword = scanner.nextLine();
			if(!userDataBase.checkUserPassword(newUsername, newPassword))System.out.println("Invalid username or password!");
		}while(!userDataBase.checkUserPassword(newUsername, newPassword));
		
		setCurrentUser(userDataBase.getUser(newUsername));
		System.out.printf("%s is logged in!\n", currentUser.getUsername());
		currentUser.setAuthenticated(true);
	}
	
	private void registerMenu() {
		System.out.println("Register!");
		
		do {
			System.out.printf("Input new username: ");
			newUsername = scanner.nextLine();
			if(newUsername.length() < 5 || !userDataBase.checkUniqueUsername(newUsername))System.out.println("Invalid username or username already registered!");
		} while (newUsername.length() < 5 || !userDataBase.checkUniqueUsername(newUsername));
		
		do {
			System.out.printf("Input new password: ");
			newPassword = scanner.nextLine();
		}while(newPassword.length()< 8);
		
		User newUser = new User(newUsername, newPassword, true);
		System.out.println("User successfully registered!");		
		userDataBase.addUser(newUser);
		setCurrentUser(newUser);
		System.out.printf("%s : %b\n", currentUser.getUsername(), currentUser.getAuthenticated());
		
	}

	public void displayMenu(boolean firstRun) {
		while(true) {
			boolean isAuthenticated;
	
			if(currentUser == null) {
				isAuthenticated = false;
			}else {
				isAuthenticated = currentUser.getAuthenticated();
			}
			
			if(isAuthenticated == false) {
				unauthenticatedMenu();
				
			}else {
				authenticatedMenu();
			}
		}
	}
	
	private void unauthenticatedMenu() {
			
			System.out.println("Unauthenticated User!");
			int opt = -1;
			do {
				System.out.println("1. Register");
				System.out.println("2. Login");
				opt = scanner.nextInt();
				scanner.nextLine();
			} while (opt < 1 || opt > 2);
			
			if(opt == 1)registerMenu();
			else if(opt == 2)loginMenu();
		
		
		
	}
	
	private void authenticatedMenu() {
		System.out.println("Authenticated User!");
		int opt = -1;
		do {
			System.out.println("1. Add VM");
			System.out.println("2. View All VM");
			System.out.println("3. Manage VM");
			System.out.println("4. Destroy VM");
			System.out.println("5. Logout");
			opt = scanner.nextInt();
			scanner.nextLine();
		} while (opt < 1 || opt > 5);
		
		if(opt == 1)currentUser.addVM();
		else if(opt == 2)currentUser.viewAllVM();
		else if(opt == 3)currentUser.manageVM();
		else if(opt == 4)currentUser.destroyVM();
		else if(opt == 5) {
			logout();
			return;
		}
	}

	private void logout() {
		System.out.println("thank you!");
		currentUser.setAuthenticated(false);
		
	}
	
	
		
	public String getNewUsername() {
		return newUsername;
	}

	public void setNewUsername(String newUsername) {
		this.newUsername = newUsername;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
}
