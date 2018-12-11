/**
 * An item that has a name, an amount, and the amount it should always be stocked to.
 * @author Kaitlyn Myers
 * @version %I% %G%
 */
public class Items {
	private String name;
	private int numItems, restockAmount;
	
	/**
	 * Initializes the variables of this class.
	 *
	 * @param restockAmount the max amount of of this item there will be
	 * @param name the name of this item
	 * @param numItems the current number of this item
	 */
	public Items(int restockAmount, String name, int numItems)
	{
		this.restockAmount = restockAmount;
		this.name = name;
		this.numItems = numItems;
	}
	
	/**
	 * Returns the name of this item.
	 *
	 * @return the name of this item 	
	 */
	public String getName()
	{
		return name;	
	}
	
	/**
	 * Returns the current amount of this item.
	 *
	 * @return the current amount of this item 	
	 */
	public int getAmount()
	{
		return numItems;
	}
	
	/**
	 * Returns the amount this item should always be stocked to.
	 *
	 * @return the amount this item should always be stocked to
	 */
	public int getRestock()
	{
		return restockAmount;
	}
	
	/**
	 * Increases the number of this item by 1.
	 */
	public void decrease() //need to check if numItems > 0 in driver
	{
		numItems = numItems - 1;
	}
	
	/**
	 * Decreases the number of this item by 1.
	 */
	public void restock(int amount)
	{
		numItems = numItems + amount;
	}
	
	/**
	 * Prints a representation of this item, consisting of the name and and amount of this item.
	 */
	public void printItems()
	{
		if(numItems <= restockAmount)
		{
			System.out.println(name + " with " + numItems + " items.");
		}
	}
}
