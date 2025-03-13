package blueCloud;

import java.util.*;

public class VirtualMachine {
//	1. **CPU cores** (Options: **2, 4, 8, 16**).
//	2. **RAM (GB)** (Options: **1, 2, 4, 8**).
//	3. **Storage (GB)** (Options: **20, 40, 60**).
//	4. **Private IP** (Must be a **valid IPv4 address**).
//	5. **Public IP** (Must be a **valid IPv4 address**).
//	6. **Gateway** (Must be a **valid IPv4 address**).
//	7. **Subnet Mask** (Must be a **valid IPv4 address**).
	private int cpuCore;
	private int ram;
	private int storage;
	private String privateIP;
	private String publicIP;
	private String gateway;
	private String subnetMask;
	private String Id;
	private boolean running = false;
//	private ArrayList<LogHistory> logHistory;
	
	
	public VirtualMachine(int cpuCore, int ram, int storage, String privateIP, String publicIP, String gateway,
			String subnetMask, String newId) {
		super();
		this.cpuCore = cpuCore;
		this.ram = ram;
		this.storage = storage;
		this.privateIP = privateIP;
		this.publicIP = publicIP;
		this.gateway = gateway;
		this.subnetMask = subnetMask;
		this.Id = newId;
	}
	
	public int getCpuCore() {
		return cpuCore;
	}
	public void setCpuCore(int cpuCore) {
		this.cpuCore = cpuCore;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getStorage() {
		return storage;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
	public String getPrivateIP() {
		return privateIP;
	}
	public void setPrivateIP(String privateIP) {
		this.privateIP = privateIP;
	}
	public String getPublicIP() {
		return publicIP;
	}
	public void setPublicIP(String publicIP) {
		this.publicIP = publicIP;
	}
	public String getGateway() {
		return gateway;
	}
	public void setGateway(String gateway) {
		this.gateway = gateway;
	}
	public String getSubnetMask() {
		return subnetMask;
	}
	public void setSubnetMask(String subnetMask) {
		this.subnetMask = subnetMask;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
	
	
}
