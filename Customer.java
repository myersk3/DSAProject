/**
 * A class that imitates a customer in a shopping center
 *
 * @author Jared Tebbi
 * @version %I% %G%
 */
public class Customer {

	private String name;
	private int numItems;
	private int timeEntered;

	/**
	 * The constructor for this class.
	 *
	 * @param name the name of this customer
	 * @param timeEntered the time in minutes that this customer enter the shop
	 */
	public Customer(String name, int timeEntered) {
		this.name = name;
		numItems = 0;
		this.timeEntered = timeEntered;
	}

	/**
	 * Returns the name of this customer.
	 *
	 * @return the name of the customer
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of this customer to a new name
	 *
	 * @param name the new name for this customer
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the number of items this customer has
	 *
	 * @return the number of items this customer has
	 */
	public int getNumItems() {
		return numItems;
	}
	
	/**
	 * Sets the number of items the customer has.
	 *
	 * @param numItems the new number of items this customer has
	 */
	public void setNumItems(int numItems) {
		this.numItems = numItems;
	}

	/**
	* Increases the number of items this customer has in their cart by 1.
	*/
	public void increaseNumItems() { //added
		numItems++;
	}
	
	/**
	* Decreases the number of items this customer has in their cart by 1.
	*/
	public void decreaseNumItems() { //added
		numItems--;
	}

	/**
	 * Returns the time this customer entered the shop, in minutes.
	 *
	 * @return the time this customer entered the shop.
	 */
	public int getTimeEntered() {
		return timeEntered;
	}
}
