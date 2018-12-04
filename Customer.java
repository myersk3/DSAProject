public class Customer {

	private String name;
	private int numItems;
	private int timeEntered;

	public Customer(String name, int timeEntered) {
		this.name = name;
		numItems = 0;
		this.timeEntered = timeEntered;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumItems() {
		return numItems;
	}

	public void setNumItems(int numItems) {
		this.numItems = numItems;
	}

	public int getTimeEntered() {
		return timeEntered;
	}
}
