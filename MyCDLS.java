/**
 * This ADT is a Circularly Doubly Linked Structure. It is node based.
 * 
 * @author Kaitlyn Myers
 * @version 2018.12.03
 */
public class MyCDLS<T> implements ListInterface<T>{

	//Made generic class
	private DNode<T> tail;
	private int numItems;
	
	/**
	 * Constructs an empty list.
	 */ 
	public MyCDLS()
	{
		numItems = 0;
		tail = null;
	} // end default constructor
	
	/** 
	 * Returns true if this list is empty, and false otherwise.
	 * 
	 * @return true if this list is empty
	 */
	public boolean isEmpty() 
	{
		return numItems == 0;
	} // end isEmpty

	/** 
	 * Returns the size of this list.
	 * 
	 * @return the size of this list
	 */
	public int size() 
	{
  		return numItems;
	} // end size
	
	/** 
	 * Finds and returns the item at the specified index.
	 * 
	 * @returns the item at the specified index
	 */
  	private DNode<T> oldFind(int index) 
  	{
  		DNode<T> curr = tail.getNext();
  		for (int skip = 0; skip < index; skip++) 
  		{
  			curr = curr.getNext();
  		} // end for
  		return curr;
  	} // end find
  	
	/** 
	 * Finds and returns the item at the specified index
	 * 
	 * @return the item at the specified index.
	 */
  	private DNode<T> newFind(int index)
  	{
  		int middle = numItems/2;
  		if(index < middle)
  		{
  			DNode<T> curr = tail.getNext();
  			for (int i = 0; i < index; i++) 
  	  		{
  	  			curr = curr.getNext();
  	  		} // end for
  	  		return curr;
  		}
  		else
  		{
  			DNode<T> curr = tail;
  			for (int i = numItems-1; i > index; i--) 
  	  		{
  	  			curr = curr.getBack();
  	  		} // end for
  			return curr;
  		}
  	}

	/** 
	 * Adds the specified item at the specified index of the list.
	 * 
	 * @param index the index the item will be inserted into
	 * @param item the item that will be added to the list
	 */
	public void add(int index, T item) 
			throws ListIndexOutOfBoundsException 
	{
		if (index >= 0 && index < size()+1) 
  		{
  			if (index == 0) 
  			{
  				if(isEmpty() == true)
  				{
  					tail = new DNode<T>(item);
  				}
  				else
  				{
  				// insert the new node containing item at
  	  				// beginning of list
  	  				DNode<T> first = tail.getNext();
  	  				DNode<T> newNode = new DNode<T>(item, first, tail);
  	  				first.setBack(newNode);
  	  				tail.setNext(newNode);
  				}
  			} 
  			else if(index == numItems)
  			{
  				DNode<T> head = tail.getNext();
  				DNode<T> prev = newFind(index-1);
  				tail = new DNode<T>(item, head, prev);
  				
  				prev.setNext(tail);
  			}
  			else 
  			{
  				DNode<T> prev = newFind(index-1);
  				DNode<T> next = prev.getNext();
  				
  				DNode<T> newNode = new DNode<T>(item, next, prev);
  				prev.setNext(newNode);
  				next.setBack(newNode);
  			} // end if
  			numItems++;
  		} 
  		else 
  		{
  			throw new ListIndexOutOfBoundsException(
                    "List index out of bounds exception on add");
  		} // end if
		
	} // end add

	/** 
	 * Returns the object at the specified index.
	 * 
	 * @param index the index at which the object is located
	 * @return 	the object that is found
	 */
	public T get(int index) 
			throws ListIndexOutOfBoundsException 
	{
		if (index >= 0 && index < size()) 
  		{
  			// get reference to node, then data in node
  			DNode<T> curr = newFind(index);
  			T dataItem = curr.getItem();
  			return dataItem;
  		} 
  		else 
  		{
  			throw new ListIndexOutOfBoundsException(
                     "List index out of bounds exception on get");
  		} // end if
	}

	/** 
	 * Deletes an object from the list at the specified index.
	 * 
	 * @param index the index of the item to be removed
	 */
	public void remove(int index) 
			throws ListIndexOutOfBoundsException 
	{
		if (index >= 0 && index < size()) 
  		{
  			if (index == 0) 
  			{
  				// delete the first node from the list
  				DNode<T> first = tail.getNext();
  				DNode<T> next = first.getNext();
  				next.setBack(tail);
  				tail.setNext(next);
  			} 
  			else if (index == numItems-1)
  			{
  				DNode<T> newTail = tail.getBack();
  				DNode<T> head = tail.getNext();
  				newTail.setNext(head);
  				head.setBack(newTail);
  				
  				tail = newTail;
  			}
  			else 
  			{
  				DNode<T> prev = newFind(index-1);
  				DNode<T> curr = prev.getNext(); 
  				prev.setNext(curr.getNext());
  				curr.getNext().setBack(prev);
  			} // end if
  			numItems--;
  		} // end if
  		else 
  		{
  			throw new ListIndexOutOfBoundsException(
                   "List index out of bounds exception on remove");
  		} // end if
	} // end remove

	/** 
	 * Removes all objects from this list.
	 */
	public void removeAll() 
	{
		tail = null;
		numItems = 0;
	} //end removeAll
	
	/** 
	 * Returns the string representation of this list.
	 * 
	 * @return the string representation of this list
	 */
	public String toString()
  	{
		if(size() == 1)
		{
			return (String) tail.getItem();
		}
		else
		{
			String result="";
	  		DNode<T> curr = tail.getNext();
	  		boolean notEnd = true;
	  		while (notEnd) 
	  		{
	  			if(curr == tail)
	  			{
	  				result += curr.getItem();
	  				notEnd = false;
	  			}
	  			else
	  			{
	  				result += curr.getItem() + " ";
	  				curr = curr.getNext();
	  			}
	  		} // end while
	  		return result;
		}
  	} // end toString

}
