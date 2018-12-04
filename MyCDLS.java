

public class MyCDLS<T> implements ListInterface<T>{

	//Made generic class
	private DNode<T> tail;
	private int numItems;
	
	public MyCDLS()
	{
		numItems = 0;
		tail = null;
	} // end default constructor
	
	public boolean isEmpty() 
	{
		return numItems == 0;
	} // end isEmpty

	public int size() 
	{
  		return numItems;
	} // end size
	
  	private DNode<T> oldFind(int index) 
  	{
  		DNode<T> curr = tail.getNext();
  		for (int skip = 0; skip < index; skip++) 
  		{
  			curr = curr.getNext();
  		} // end for
  		return curr;
  	} // end find
  	
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

	public void removeAll() 
	{
		tail = null;
		numItems = 0;
	} //end removeAll
	
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
