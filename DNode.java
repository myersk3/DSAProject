/**
 * A node with two links.
 *
 * @author: Jared Tebbi
 * @version: 2018.10.02
 */
public class DNode<T> 
{
  private T item;
  private DNode<T> next;
  private DNode<T> back;

  /**
   * Constructs a new node with itself as its links, and the specified items as its item.
   * 
   * @param newItem the item that will be held by this node
   */
  public DNode(T newItem) 
  {
    item = newItem;
    next = this;
    back = this;

  } // end constructor

  /**
   * Constructs a new node with specified links and a specified item.
   * 
   * @param newItem the item that will be held by this node
   * @param nextNode the node that will be linked in front of this node
   * @param backNode the node that will be linked behind this node
   */
  public DNode(T newItem, DNode<T> nextNode, DNode<T> backNode)
  {
	  item = newItem;
	  next = nextNode;
	  back = backNode;
  }

  /**
   * Sets a new item for this node to contain.
   * 
   * @param newItem the new item this node will contain
   */
  public void setItem(T newItem) 
  {
    item = newItem;
  } // end setItem

  /** 
   * Returns the item contained in this node.
   * 
   * @return the item contained in this node
   */
  public T getItem() 
  {
    return item;
  } // end getItem

  /**
   * Sets the link in front of this node into a new node.
   * 
   * @param nextNode the node to be in front of this node
  public void setNext(DNode<T> nextNode) 
  {
    next = nextNode;
  } // end setNext

  /** 
   * Returns the node in front of this node.
   *
   * @return the node in front of this node
   */
  public DNode<T> getNext() 
  {
    return next;
  } // end getNext

  /**
   * Sets the node behind this node into a new node.
   * 
   * @param backNode the node to be behind this node
  public void setBack(DNode<T> backNode) {
	  back = backNode;
  }

  /**
   * Returns the node behind this node.
   * 
   * @return the node behind this node
   */
  public DNode getBack() {
	  return back;
  }

} // end class Node

