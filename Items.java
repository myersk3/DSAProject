
public class Items {
	private String name;
	private int numItems, restockAmount;
	
	public Items(int restockAmount, String name, int numItems)
	{
		this.restockAmount = restockAmount;
		this.name = name;
		this.numItems = numItems;
	}
	
	public int getAmount()
	{
		return numItems;
	}
	
	public void decrease() //need to check if numItems > 0 in driver
	{
		numItems = numItems - 1;
	}
	
	public void restock(int amount)
	{
		numItems = numItems + amount;
	}
	
	public void printItems()
	{
		if(numItems <= restockAmount)
		{
			System.out.println(name + " with " + numItems + " items.");
		}
	}
}
