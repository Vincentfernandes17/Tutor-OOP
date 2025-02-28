package kiosTalenta;

public class Buyer {
	private String name;
	private String classroom;
	private int cash;
	
	public Buyer(String name, String classroom, int cash) {
		this.name = name;
		this.classroom = classroom;
		this.cash = cash;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

}
