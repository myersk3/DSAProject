
public class ShoppingCenter {

	private MyCDLS<Customer> shoppingCustomers; //diff, changed to MyCDLS
	private MyCDLS<Items> items; //diff
	private MyCDLS<QueueRA<Customer>> checkoutLines; //diff
	private int minutes;
	private int currentCheckoutLine;

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
	
	public int getMinutes()
	{
		return minutes;
	}

	public MyCDLS<Customer> getShoppingCustomers() { //diff
		return shoppingCustomers;
	}

	public void setShoppingCustomers(MyCDLS<Customer> customers) { //diff
		shoppingCustomers = customers;
	}

	public MyCDLS<Items> getItems() { //diff
		return items;
	}

	public void setItems(MyCDLS<Items> items) { //diff
		this.items = items;
	}

	public MyCDLS<QueueRA<Customer>> getCheckoutLines() { //diff
		return checkoutLines;
	}

	public void setCheckoutLines(MyCDLS<QueueRA<Customer>> checkoutLines) { //diff
		this.checkoutLines = checkoutLines;
	}

	public void increaseMinutes() {
		minutes++;
	}
}
