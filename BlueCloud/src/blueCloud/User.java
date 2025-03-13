package blueCloud;

import java.util.*;

public class User {
	private String username;
	private String password;
	private Boolean authenticated;
	private VirtualMachineManagement VMs = new VirtualMachineManagement();
	
	Scanner scanner = new Scanner(System.in);
	
	public User(String username, String password, Boolean authenticated) {
		this.username = username;
		this.password = password;
		this.authenticated = authenticated;
	}
	
	public void addVMto(String id, VirtualMachine VM) {
		VMs.addNewVm(id, VM);
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getAuthenticated() {
		return authenticated;
	}
	public void setAuthenticated(Boolean authenticated) {
		this.authenticated = authenticated;
	}
	
	public void addVM() {
		
		int newCore;
		do {
			System.out.printf("Input CPU cores: ");
			newCore = scanner.nextInt();
			scanner.nextLine();
//			System.out.printf("%d\n", newCore);
		} while (newCore != 2 && newCore != 4 && newCore != 8 && newCore != 16);
		
		int newRam;
		do {
			System.out.printf("Input Ram: ");
			newRam = scanner.nextInt();
			scanner.nextLine();
		} while (newRam != 2 && newRam != 4 && newRam != 8 && newRam != 1);
		
		int newStorage;
		do {
			System.out.printf("Input Storage: ");
			newStorage = scanner.nextInt();
			scanner.nextLine();
		} while (newStorage != 20 && newStorage != 40 && newStorage != 60);
		
		String newPrivateIp;
		do {
			System.out.printf("Input privateIp: ");
			newPrivateIp = scanner.nextLine();
		} while (!VMs.ipCheck(newPrivateIp));
		
		String newPublicIp;
		do {
			System.out.printf("Input publicIp: ");
			newPublicIp = scanner.nextLine();
		} while (!VMs.ipCheck(newPublicIp));
		
		String newGateaway;
		do {
			System.out.printf("Input Gateway: ");
			newGateaway = scanner.nextLine();
		} while (!VMs.ipCheck(newGateaway));
		
		String newSubnet;
		do {
			System.out.printf("Input Subnet Mask: ");
			newSubnet = scanner.nextLine();
		} while (!VMs.ipCheck(newSubnet));
		
		String newId = VMs.genId();
		
		VirtualMachine newVM = new VirtualMachine(newCore, newRam, newStorage, newPrivateIp, newPublicIp, newGateaway, newSubnet, newId);
		
		VMs.addNewVm(newId,newVM);
	}
	
	public void listAllVM() {
		VMs.listAllVM();
	}

	public void viewAllVM() {
		VMs.viewAllVM();
		
	}

	public void manageVM() {
		VMs.manageVM();
	}

	public void destroyVM() {
		VMs.destroyVM();
	}
	
}
