import java.util.*;
import java.io.*;

public class Driver {
    static BufferedReader stdin = new BufferedReader (new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException throws IOException{
	ShoppingCenter sc = new ShoppingCenter();

        System.out.println("0. Close the Shopping Center.");
	System.out.println("1. Customer enters Shopping Center.");
	System.out.println("2. Customer picks an item and places it in the shopping cart");
	System.out.println("3. Customer removes an item fro mthe shopping cart.");
	System.out.println("4. Customer is done shopping.");
	System.out.println("5. Customer checks out.");
	System.out.println("6. Print info about customers who are shopping.");
	System.out.println("7. Print info about customers in checkout lines.");
	System.out.println("8. Print info about items at or below re-stocking level.");
	System.out.println("9. Reorder and item.");

	boolean done = false;
        int choice = 0;
	do {
		System.out.print("Make your choice now");
		choice = Integer.parseInt(stdin.readLine().trim());
		System.out.println(choice);
		switch(choice) {
			case 0: done = true;
				break;
			case 1: 
				break;
			case 2: 
				break;
			case 3: 
				break;
			case 4:
				break;
			case 5:
				break;
			case 6: 
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				break;
			default: done = true;
				 break;
		}

		System.out.println();
	}while(!done);
    }
	
	private static void addStock() throws IOException
    	{
		MyCDLS<Items> i = new MyCDLS<>();
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
    }


    private static int searchItems(ListCDLBased<Item> items, String itemName) {
	    int result = -1;
	    String key = "";
	    for(int i = 0; i < items.size(); i++) {
		    key = (String) items.get(i).getName();
	    }
    }

    private static ShoppingCenter pickItem(ShoppingCenter sc) {
	    System.out.print("Choose a shopping customer: ");
	    String customerName = stdin.readLine().trim();
	    System.out.println(customer);
	    System.out.print("Choose an item: ");
	    String itemName = stdin.readLine().trim();
	    System.out.println(itemName);
	    int itemNum = items.search(item);
	    if(itemNum >= 0) {
		    Items item = items.get(itemNum);
		    if(item.getAmount() > 0) {
			    item.decrease();
		    }
		    else {
			    System.out.println("Item is out of stock");
		    }
	    }
	    else {
		    System.out.println("Item does not exist");
	    }
	    return items;
    }

    private static AscendinglyOrderedStringList<Customer> finishShopping(AscendinglyOrderedStringList<Customer> shoppingCustomers, ListCDLBased<ListCDLBased<Customer>> checkoutLines) {
	    if(!shoppingCustomers.isEmpty()) {
		    Customer customer = ShoppingCustomers.get(0);
		    if(customer.getTime == time) {
			    System.out.print("Would you like to continue shopping? (Y/N): ");
			    String choice = stdin.readLine.trim();
			    System.out.println(choice);
			    if(choice == "Y") {
				    shoppingCustomers.add(shoppingCustomers.size(), customer);
				    shoppingCustomers.remove(0);
			    }
			    else {
				    if(customer.getNumItems <= 4) {
					    checkoutLines.get(0).add(customer);
					    System.out.println("Customer added to express checkout line.");
				    }
				    else if(checkoutLines.get(1).size() < checkoutLines.get(2).size()) {
					    checkoutLines.get(1).add(customer);
					    System.out.println("Customer added to express checkout line 1.");
				    }
				    else {
					    checkoutLines.get(2).add(customer);
					    System.out.println("Customer added to express checkout line 2.");
				    }
			    }
			    shoppingCustomers.remove(0);
				    


	    
    }

    private static void printItems(AscendinglyOrderedStringList<Items> items) {
	    System.out.println("Printing items...");
	    for(int i = 0; i < items.size(); i++) {
		    System.out.print(item.printItems() + " ");
	    }
    }

    private static AscendinglyOrderedStringList<Items> reorderItem(AscendinglyOrderedStringList<Items> items) {
	    System.out.print("Name the item to be reordered: ");
	    String itemName = stdin.readLine().trim();
	    System.out.println(itemName);
	    System.out.print("Specify the restocking amount: ");
	    int restockNum = Integer.parseInt(stdin.readLine().trim());
	    int itemIndex = items.search(itemName);
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
	    return items;
    }
}
