/**
 * Holds all of the information for the shopping center, including lists.
 *
 * @author Jared Tebbi
 * @version %I% %G%
 */
public class ShoppingCenter {

	private MyCDLS<Customer> shoppingCustomers; //diff, changed to MyCDLS
	private MyCDLS<Items> items; //diff
	private MyCDLS<QueueRA<Customer>> checkoutLines; //diff
	private int minutes;
	private int currentCheckoutLine;

	/**
	 * A constructor for this class.
	 * 
	 * @param firstLine the first line that a customer will check out from.
	 */
	public ShoppingCenter(int firstLine) {
		shoppingCustomers = new MyCDLS<Customer>(); //diff
		items = new MyCDLS<Items>(); //diff
		checkoutLines = new MyCDLS<QueueRA<Customer>>(); //diff
		checkoutLines.add(0, new QueueRA<Customer>());
		checkoutLines.add(1, new QueueRA<Customer>());
		checkoutLines.add(2, new QueueRA<Customer>());
		minutes = 0;
		currentCheckoutLine = firstLine;
	}
	
	/**
	 * Returns the checkout line that a customer will be checked out of next.
	 *
	 * @return the current checkout line that will have a customer checked out from
	 */
	public QueueRA<Customer> getCurrentCheckoutLine() {
		QueueRA<Customer> line = checkoutLines.get(currentCheckoutLine);
		if(currentCheckoutLine < 3) {
			currentCheckoutLine++;
		}
		else {
			currentCheckoutLine = 0;
		}
		return line;
	}
	
	/**
	* Returns the amount of minutes this shopping center has been open.
	*
	* @return the amount of minutes
	*/
	public int getMinutes()
	{
		return minutes;
	}

	/**
	 * Returns the list of currently shopping customers.
	 * @return the list of currently shopping custoemrs
	 */
	public MyCDLS<Customer> getShoppingCustomers() { //diff
		return shoppingCustomers;
	}

	/**
	 * Sets the list of currently shopping customers.
	 *
	 * @param customers the new list of shopping customers
	 */
	public void setShoppingCustomers(MyCDLS<Customer> customers) { //diff
		shoppingCustomers = customers;
	}

	/**
	 * Returns the list of items. 
	 *
	 * @return the list of items
	 */
	public MyCDLS<Items> getItems() { //diff
		return items;
	}

	/**
	 * Sets the list of items.
	 *
	 * @param items the new list of items
	 */
	public void setItems(MyCDLS<Items> items) { //diff
		this.items = items;
	}

	/**
	 * Returns the list of checkout lines.
	 * 
	 * @return the list of checkout lines
	 */
	public MyCDLS<QueueRA<Customer>> getCheckoutLines() { //diff
		return checkoutLines;
	}

	/**
	 * Sets the list of checkout lines.
	 *
	 * @param the new list of checkout lines
	 */
	public void setCheckoutLines(MyCDLS<QueueRA<Customer>> checkoutLines) { //diff
		this.checkoutLines = checkoutLines;
	}

	/**
	 * Increase the minutes the shopping center has been opened by 1
	 */
	public void increaseMinutes() {
		minutes++;
	}
}
