import java.util.*;
import java.io.*;

public class Driver {
    static BufferedReader stdin = new BufferedReader (new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException throws IOException{
	MyCDLS<Items> i = new MyCDLS<>();
    	int result = 0;
    	System.out.println("Welcome to the Shopping Center!!!");
    	System.out.println("");
    	System.out.println("Please specify stock.");
    	System.out.print("How many items do you have? ");
    	String number = stdin.readLine().trim();
    	int num = Integer.parseInt(number);
    	
    	System.out.print("Please specify restocking amount: ");
    	String restock = stdin.readLine().trim();
    	int restockNum = Integer.parseInt(restock);
    	int count = 1;
    	int size = i.size();
    	while(count <= num)
    	{
    		System.out.print("Enter item name: ");
    		String name = stdin.readLine().trim();
    		System.out.print("How many " + name + "s? ");
    		String s = stdin.readLine().trim();
    		int numItems = Integer.parseInt(s);
    		Items curr = new Items(restockNum, name, numItems);
    		i.add(size, curr);
    		System.out.println(numItems + " items of " + name + " have been placed in stock.");
    		count++;
    	}
    	System.out.println("Please select the checkout line that should check out customers first");
    	System.out.print("(regular1 / regular2 / express): ");
    	String answer = stdin.readLine().trim();
    	System.out.println("");
    	
    	if(answer.equals("regular1"))
    	{
    		result = 0;
    	}
    	else if(answer.equals("regular2"))
    	{
    		result = 1;
    	}
    	else if(answer.equals("express"))
    	{
    		result = 2;
    	}
    	ShoppingCenter sc = new ShoppingCenter(result);
    	sc.setItems(i); //setting Items list

	System.out.println("Here are the choices to select from: ");
        System.out.println("	0. Close the Shopping Center.");
	System.out.println("	1. Customer enters Shopping Center.");
	System.out.println("	2. Customer picks an item and places it in the shopping cart.");
	System.out.println("	3. Customer removes an item from the shopping cart.");
	System.out.println("	4. Customer is done shopping.");
	System.out.println("	5. Customer checks out.");
	System.out.println("	6. Print info about customers who are shopping.");
	System.out.println("	7. Print info about customers in checkout lines.");
	System.out.println("	8. Print info about items at or below re-stocking level.");
	System.out.println("	9. Reorder and item.");

	boolean done = false;
        int choice = 0;
	do {
		System.out.print("Make your choice now");
		choice = Integer.parseInt(stdin.readLine().trim());
		System.out.println(choice);
		switch(choice) {
			case 0: done = true;
				break;
			case 1: addCustomer(sc);
				break;
			case 2: 
				break;
			case 3: removeItem(sc);
				break;
			case 4:
				break;
			case 5:
				break;
			case 6: printCustomers(sc);
				break;
			case 7:
				break;
			case 8: printItems(sc);
				break;
			case 9:
				break;
			default: done = true;
				 break;
		}

		System.out.println();
	}while(!done);
    }
	
	private static void addCustomer(ShoppingCenter sc) throws IOException
    	{
    	MyCDLS<Customer> shoppingCust = sc.getShoppingCustomers();
    	System.out.print("Enter customer name: ");
		String name = stdin.readLine().trim();
		int index = searchName(name, shoppingCust);
		if(index < shoppingCust.size())
		{
			System.out.println("Customer " + name + " is already in the Shopping Center!");
		}
		else
		{
			Customer c = new Customer(name, sc.getMinutes());
			shoppingCust.add(shoppingCust.size(), c);
			System.out.println("Customer " + name + " is now in the Shopping Center.");
		}
		sc.setShoppingCustomers(shoppingCust);
    	}


    /**
     * Searches a list of items by an item's name, and returns the index where that item is. 
     *
     * @param items the list of items to be searched
     * @param itemName the name of the item that will be used to search the list
     * @return the index in the list where the item with the name resides, or -1 if the item is not in the list
     */
    private static int searchItems(MyCDLS<Items> items, String itemName) {
	    int result = -1;
	    String key = "";
	    for(int i = 0; i < items.size(); i++) {
		    key = (String) items.get(i).getName();
		    if(key.equals(itemName)) {
			    result = i;
			    i = items.size();
		    }

	    }
	    return result;
    }
	
    /**
     * Searches a list of customers by an customer's name, and returns the index where that customer is in the list.
     *
     * @param customers the list of customers to be searched
     * @param customerName the name of the customer that will be used to search the list
     * @return the index in the list where the customer with the name resides, or -1 if the customer is not in the list
     */
    private static int searchCustomers(MyCDLS<Customer> customers, String customerName) {
            int result = -1;
            String key = "";
            for(int i = 0; i < customers.size(); i++) {
                    key = (String) customers.get(i).getName();
                    if(customerName.equals(key)) {
                            result = i;
                            i = customers.size();
                    }

            }
            return result;
    }

	
	private static int searchName(String name, MyCDLS sc) //Kaitlyn's search method
	{
		int index=0;
		boolean notFound = true;
		
		while(notFound&&(index < sc.size()))
		{
			Customer curr = (Customer) sc.get(index);
			String next = curr.getName();
			if(next.equals(name))
			{
				notFound = false;
			}
			else
			{
				index++;
			}
		}
		if(notFound)
		{
			//not found
			return index; //will return collection size
		}
		else
		{
			//found
			return index; //will return correct index
		}
	}


    /**
     * Picks an item to be placed into a customers shopping cart. The customer may not exist, or the item may not exist or be stocked based on user input. 
     *
     * @param sc a shoppingcenter which will contain the customers items that may be updated inside this method.
     * @return returns a shopping center that may have been updated.
     */
    private static ShoppingCenter pickItem(ShoppingCenter sc) throws IOException {
	    System.out.print("Choose a shopping customer: ");
	    String customerName = stdin.readLine().trim();
	    System.out.println(customerName);
	    System.out.print("Choose an item: ");
	    String itemName = stdin.readLine().trim();
	    System.out.println(itemName);
	    MyCDLS<Items> items = sc.getItems();
	    int itemNum = searchItems(items, itemName);
	    if(itemNum >= 0) {
		    Items item = items.get(itemNum);
		    if(item.getAmount() > 0) {
			    ListCDLBased<Customer> customers = sc.getShoppingCustomers();
			    int customerNum = searchCustomers(customers, customerName);
			    if(customerNum >= 0) {
				item.decrease();
			    	customers.get(customerNum).setNumItems(customers.get(customerNum).getNumItems() + 1);
				sc.setShoppingCustomers(customers);
				sc.setItems(items);
			    }
			    else {
				    System.out.println("Customer is not in shopping");
			    }
		    }
		    else {
			    System.out.println("Item is out of stock");
		    }
	    }
	    else {
		    System.out.println("Item does not exist");
	    }
	    return sc;
    }
	
	private static void removeItem(ShoppingCenter sc) throws IOException
    	{
    		MyCDLS<Customer> shoppingCust = sc.getShoppingCustomers();
    		if(shoppingCust.isEmpty())
    		{
    			System.out.println("No one is in the Shopping Center!");
    		}
    		else
    		{
    			System.out.print("Enter Customer name: ");
    			String name = stdin.readLine().trim();
    			int index = searchName(name, shoppingCust);
    			if(index == shoppingCust.size())
    			{
    				System.out.println("There is no customer by that name.");
    			}
    			else
    			{
    				Customer curr = shoppingCust.get(index);
    				if(curr.getNumItems() == 0)
    				{
    					System.out.println("Customer has 0 items, cannot remove anymore.");
    				}
    				else
    				{
    					curr.decreaseNumItems();
            				System.out.print("Customer " + curr.getName() + " now has ");
            				System.out.println(curr.getNumItems() + " items in the shopping cart.");
    				}
    			}
    		}
    		sc.setShoppingCustomers(shoppingCust);
    	}


    /**
     * The first customer to have entered the shopping center finishes shopping. 
     * If the customer has 0 items, they will be asked if they want to continue shopping. 
     * If yes, they are put back into the line and their time is reset. If no, the customer 
     * will leave the shopping center.
     * If the customer has more than 1 item, they will be put in a checkout line.
     * If the customer has less or equal to 4 items, they will be put in the express line, 
     * unless the express line is twice as long as a regular line, where the customer will 
     * then enter the shortest regular line.
     * If the customer has more than 4 items, they will be put into the shortest regular line.
     *
     * @param sc the shopping center which contains the list of customers shopping and checking out, which may be updated
     * @return a shopping center that may have been updated.
     */
    private static ShoppingCenter finishShopping(ShoppingCenter sc) throws IOException {
	    //make the use be able to decide which checkout line is first
	    MyCDLS<Customer> shoppingCustomers = sc.getShoppingCustomers();
	    if(!shoppingCustomers.isEmpty()) {
		    Customer customer = shoppingCustomers.get(0);
		    if(customer.getNumItems() == 0) {
			    System.out.print("You have no items. Would you like to continue shopping? (Y/N): ");
			    String choice = stdin.readLine().trim();
			    System.out.println(choice);
			    if(choice.equals("Y")) {
				    shoppingCustomers.add(shoppingCustomers.size(), customer);
				    System.out.println("First customer reentered the shopping area");
			    }
			    else {
				    System.out.println("The first customer left the store");
			    }
			    //if N removes customer from store (look way down). 
			    //if Y removes customer from front of line after putting them at the back.
		    }	    
		    else {
			    MyCDLS<QueueRA<Customer>> checkoutLines = sc.getCheckoutLines();
			    if((customer.getNumItems()) <= 4 && (2*checkoutLines.get(0).size() < checkoutLines.get(1).size()) && (2*checkoutLines.get(0).size() < checkoutLines.get(2).size())) {
				    checkoutLines.get(0).enqueue(customer);
				    System.out.println("Customer added to express checkout line.");
			    }
			    else if(checkoutLines.get(1).size() < checkoutLines.get(2).size()) {
				    checkoutLines.get(1).enqueue(customer);
				    System.out.println("Customer added to express checkout line 1.");
			    }
			    else {
				    checkoutLines.get(2).enqueue(customer);
				    System.out.println("Customer added to express checkout line 2.");
			    }
			    sc.setCheckoutLines(checkoutLines);
		    }
		    shoppingCustomers.remove(0);
		    
	    }
	    else {
		    System.out.println("There are no customer shopping!");
	    }
	    sc.setShoppingCustomers(shoppingCustomers);
	    return sc;
    }
	
	private static void printCustomers(ShoppingCenter sc)
    	{
    		MyCDLS<Customer> shoppingCust = sc.getShoppingCustomers();
    		if(shoppingCust.isEmpty())
    		{
    			System.out.println("No customers are in the Shopping Center!");
    		}
    		else
    		{
    			int size = shoppingCust.size();
        		System.out.print("The following "+ size + " customers");
        		System.out.println(" are in the Shopping Center.");
        		int index = 0;
        		while(index < size)
        		{
        			Customer curr = shoppingCust.get(index);
        			System.out.println("Customer " + curr.getName() + " with " + curr.getNumItems() + " items.");
        			index++;
        		}
    		}
    	}

    private static void printItems(ShoppingCenter sc) {
	    MyCDLS<Items> items = sc.getItems();
	    System.out.println("Printing items...");
	    for(int i = 0; i < items.size(); i++) {
		    items.get(i).printItems();
		    System.out.print(" ");
	    }
    }
	
	private static void printItems(ShoppingCenter sc) { //Kaitlyn's adjusted printItems
    		MyCDLS<Items> items = sc.getItems();
    		int restock = items.get(0).getRestock();
    	
	    	System.out.println("Items at restocking level: ");
	    	for(int i = 0; i < items.size(); i++) {
	    		Items curr = items.get(i);
		    	if(curr.getAmount() <= restock)
		    	{
		    		System.out.println(curr.getName() + " with " + curr.getAmount() + " items.");
		    	}
	    	}
    	}

    private static ShoppingCenter reorderItem(ShoppingCenter sc) throws IOException {
	    System.out.print("Name the item to be reordered: ");
	    String itemName = stdin.readLine().trim();
	    System.out.println(itemName);
	    System.out.print("Specify the restocking amount: ");
	    int restockNum = Integer.parseInt(stdin.readLine().trim());
	    ListCDLBased<Items> items = sc.getItems();
	    int itemIndex = searchItems(items, itemName);
	    if(restockNum > 0) {
	    	if(itemIndex >= 0) {
			items.get(itemIndex).restock(restockNum);
		}
		else {
			System.out.println("Index out of bounds.");
		}
	    }
	    else {
		    System.out.println("Cannot restock less than 1 item.");
	    }
	    return sc;
    }
}
