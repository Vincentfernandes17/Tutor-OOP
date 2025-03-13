package blueCloud;

//import java.util.*;

public class CloudManagement {
	 boolean firstRun = true;

	public CloudManagement() {
		DataBase userDataBase = new DataBase();
		VirtualMachineManagement VMs = new VirtualMachineManagement();
		
		Menu menu = new Menu(userDataBase, VMs);
		
		User currentUser = menu.getCurrentUser();
		menu.displayMenu(firstRun);
		firstRun = false;
	}
	
}
