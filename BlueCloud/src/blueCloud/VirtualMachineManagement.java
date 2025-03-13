package blueCloud;

import java.util.*;

public class VirtualMachineManagement {
	private HashMap<String, VirtualMachine> VMs = new HashMap<String, VirtualMachine>();
	
	Scanner scanner = new Scanner(System.in);
	
	public void addNewVm(String id, VirtualMachine VM) {
		VMs.put(id, VM);
	}
	
	public VirtualMachine getVm(String id) {
		return VMs.get(id);
	}


	public String genId() {
		Random random = new Random();
		char[] tempId = new char[6];
		tempId[0] = 'V';
		tempId[1] = 'M';
		for (int i = 2; i < 6; i++) {
			tempId[i] = (char) ('0'+ random.nextInt(10));
		}
//		tempId[6] = '\0';
		
		String newId = new String(tempId);
		System.out.printf("Id: %s\n", newId);
		while(VMs.containsKey(newId)) {
			int index = 2 + random.nextInt(3);
			tempId[index] = (char) ('0'+ random.nextInt(10));
			newId = new String(tempId);
		}
//		System.out.printf("a%sa\n", newId);
		return newId;
	}
	   

	public boolean ipCheck(String newPrivateIp) {
		int dotCounter = 0 ;
		if(newPrivateIp.charAt(0) == '.' || newPrivateIp.charAt(newPrivateIp.length()-1) == '.')return false;
		for (int i = 0; i < newPrivateIp.length(); i++) {
			if(dotCounter > 3)return false;
			if(newPrivateIp.charAt(i) == '.' && newPrivateIp.charAt(i+1) == '.')return false;
			if(newPrivateIp.charAt(i) == '.')dotCounter++;
		}
		if(dotCounter < 3)return false;
		
		return true;
	}


//	1. **CPU cores** (Options: **2, 4, 8, 16**).
//	2. **RAM (GB)** (Options: **1, 2, 4, 8**).
//	3. **Storage (GB)** (Options: **20, 40, 60**).
//	4. **Private IP** (Must be a **valid IPv4 address**).
//	5. **Public IP** (Must be a **valid IPv4 address**).
//	6. **Gateway** (Must be a **valid IPv4 address**).
//	7. **Subnet Mask** (Must be a **valid IPv4 address**).
	
	public void listAllVM() {
		for (Map.Entry<String, VirtualMachine> vm : VMs.entrySet()) {
			System.out.printf("VM Id: %s\n", vm.getValue().getId());
			System.out.printf("VM CPU cores: %s\n", vm.getValue().getCpuCore());
			System.out.printf("VM RAM: %s\n", vm.getValue().getRam());
			System.out.printf("VM Storage: %s\n", vm.getValue().getStorage());
			System.out.printf("VM Private IP: %s\n", vm.getValue().getPrivateIP());
			System.out.printf("VM Public IP: %s\n", vm.getValue().getPublicIP());
			System.out.printf("VM Gateway: %s\n", vm.getValue().getGateway());
			System.out.printf("VM Subnet Mask: %s\n", vm.getValue().getSubnetMask());
			System.out.printf("VM Status: %b\n", vm.getValue().isRunning());
			
			System.out.println("-----------------------------------------------------------");
		}
	}
	
	public void viewAllVM() {
		System.out.println("View All VMs!");
		System.out.println("-----------------------------------------------------------");
		
		listAllVM();
	}

	public void manageVM() {
		System.out.println("Manage VM");
		System.out.println("-----------------------------------------------------------");
		
		listAllVM();
		
		int opt = -1;
		do {
			System.out.println("1. Modify Properties");
			System.out.println("2. Toggle Status");
			opt = scanner.nextInt();
			scanner.nextLine();
		} while (opt < 1 || opt > 2);
		
		if(opt == 1)modifyVM();
		else if(opt == 2)toggleVM();
		
	}

	private void toggleVM() {
		System.out.println("Toggle VM");
		System.out.println("-----------------------------------------------------------");
		
		listAllVM();
		
		String targetId;
		do {
			System.out.printf("Input VM id: ");
			targetId = scanner.nextLine().trim();
//			System.out.printf("%s %b\n", targetId, !VMs.containsKey(targetId));
//			VirtualMachine temp = VMs.get(targetId);
//			System.out.printf("%s %d\n", temp.getId(), temp.getCpuCore());

			
		}while(!VMs.containsKey(targetId));
		
		VirtualMachine targetVM = VMs.get(targetId);
		
		if(targetVM.isRunning()) {
			System.out.printf("%s toggled stop\n", targetVM.getId());
			targetVM.setRunning(false);
		}else {
			System.out.printf("%s toggled running\n", targetVM.getId());
			targetVM.setRunning(true);
		}
	}

	private void modifyVM() {
		System.out.println("Modify VM");
		System.out.println("-----------------------------------------------------------");
		
		listAllVM();
		
		String targetId;
		do {
			System.out.printf("Input VM id: ");
			targetId = scanner.nextLine();
		}while(!VMs.containsKey(targetId));
		
		int newCore;
		do {
			System.out.printf("Input new CPU cores: ");
			newCore = scanner.nextInt();
			scanner.nextLine();
		} while (newCore != 2 && newCore != 4 && newCore != 8 && newCore != 16);
		
		int newRam;
		do {
			System.out.printf("Input new ram: ");
			newRam = scanner.nextInt();
			scanner.nextLine();
		} while (newRam != 2 && newRam != 4 && newRam != 8 && newRam != 1);
		
		int newStorage;
		do {
			System.out.printf("Input new storage: ");
			newStorage = scanner.nextInt();
			scanner.nextLine();
		} while (newStorage != 20 && newStorage != 40 && newStorage != 60);
		
		String newPrivateIp;
		do {
			System.out.printf("Input new privateIp: ");
			newPrivateIp = scanner.nextLine();
		} while (!ipCheck(newPrivateIp));
		
		String newPublicIp;
		do {
			System.out.printf("Input new publicIp: ");
			newPublicIp = scanner.nextLine();
		} while (!ipCheck(newPublicIp));
		
		String newGateaway;
		do {
			System.out.printf("Input new Gateway: ");
			newGateaway = scanner.nextLine();
		} while (!ipCheck(newGateaway));
		
		String newSubnet;
		do {
			System.out.printf("Input new Subnet Mask: ");
			newSubnet = scanner.nextLine();
		} while (!ipCheck(newSubnet));
		
		VirtualMachine targetVM = VMs.get(targetId);
		targetVM.setCpuCore(newCore);
		targetVM.setStorage(newStorage);
		targetVM.setRam(newRam);
		targetVM.setGateway(newGateaway);
		targetVM.setPrivateIP(newPrivateIp);
		targetVM.setPublicIP(newPublicIp);
		targetVM.setSubnetMask(newSubnet);
		System.out.printf("%s updated\n", targetId);

	}

	public void destroyVM() {
		System.out.println("Destroy VM");
		System.out.println("-----------------------------------------------------------");
		
		listAllVM();
		
		String targetId;
		do {
			System.out.printf("Input VM id: ");
			targetId = scanner.nextLine();
		}while(!VMs.containsKey(targetId));
		
		VMs.remove(targetId);
		System.out.printf("%s removed\n", targetId);
	}
}
