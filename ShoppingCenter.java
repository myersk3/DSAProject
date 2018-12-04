public class ShoppingCenter {

	private ListCDLBased<Customer> shoppingCustomers;
	private ListCDLBased<Items> items;
	private ListCDLBased<QueueRA<Customer>> checkoutLines;
	private int minutes;

	public ShoppingCenter() {
		shoppingCustomers = new ListCDLBased<Customer>();
		items = new ListCDLBased<Items>();
		checkoutLines = new ListCDLBased<QueueRA<Customer>>();
		checkoutLines.add(0, new QueueRA<Customer>());
		checkoutLines.add(1, new QueueRA<Customer>());
		checkoutLines.add(2, new QueueRA<Customer>());
		minutes = 0;
	}

	public ListCDLBased<Customer> getShoppingCustomers() {
		return shoppingCustomers;
	}

	public void setShoppingCustomers(ListCDLBased<Customer> customers) {
		shoppingCustomers = customers;
	}

	public ListCDLBased<Items> getItems() {
		return items;
	}

	public void setItems(ListCDLBased<Items> items) {
		this.items = items;
	}

	public ListCDLBased<QueueRA<Customer>> getCheckoutLines() {
		return checkoutLines;
	}

	public void setCheckoutLines(ListCDLBased<QueueRA<Customer>> checkoutLines) {
		this.checkoutLines = checkoutLines;
	}

	public void increaseMinutes() {
		minutes++;
	}
}
