/**
 * An ADT that is first in first out. This queue is resizeable array based.
 *
 * @author Jared Tebbi
 * @version %I% %G%
 */
public class QueueRA<T> implements QueueInterface<T> {

    protected Object[] list;
    protected int front;
    protected int back;
    protected int numItems;

    /**
     * Constructs an empty queue.
     */
    public QueueRA() {
        list = new Object[3];
        front = 0;
        back = 0;
        numItems = 0;
    }

    /**
     * Returns true if this queue is empty. Otherwise returns false.
     * 
     * @return true if this queue is empty.
     */
    public boolean isEmpty() {
        boolean result = false;
        if(numItems == 0) {
            result = true;
        }
        return result;
    }

    /**
     * Returns the number of objects in this queue.
     * 
     * @return the number of objects in this queue.
     */
    public int size() {
	    return numItems;
    }

    /**
     * Resizes the list used to store objects, increasing it's size by 2*list.length + 1.
     */
    protected void resize() {
        Object[] temp = new Object[2*list.length + 1];
        for(int i = 0; i < list.length; i++) {
            temp[i] = list[front++];
            if(front == list.length) {
                front = 0;
            }
        }
        list = temp;
        front = 0;
        back = numItems;
    }

    /**
     * Puts an object at the back of the queue.
     * 
     * @param newItem the item to be added to the queue.
     */
    public void enqueue(T newItem) throws QueueException {
        if(numItems == list.length) {
            resize();
        }
        list[back++] = newItem;
        if(back == list.length) {
            back = 0;
        }
        numItems++;
    }

    /**
     * Removes an item from the queue and returns the item's value.
     * 
     * @return the item removed from the list.
     */
    public T dequeue() throws QueueException {
        if(!isEmpty()) {
            T result = (T) list[front];
            list[front++] = null;
            if(front == list.length) {
                front = 0;
            }
            numItems--;
            return result;
        } else {
            throw new QueueException("Error while dequeuing");
        }
    }

    /**
     * Removes all objects from the list.
     */
    public void dequeueAll() {
        if(!isEmpty()) {
            while(front != back) {
                list[front++] = null;
                if(front == list.length) {
                    front = 0;
                }
            }
        }
        front = 0;
        back = 0;
        numItems = 0;
    }

    /**
     * Returns the value in the front of this queue.
     * 
     * @return the value in the front of this queue
     */
    public T peek() throws QueueException {
        if(!isEmpty()) {
            return (T) list[front];
        }
        else {
            throw new QueueException("Error while peeking");
        }
    }

    /**
     * Returns the string representation of this queue, including its size and the objects contained in it.
     * 
     * @return the string representation of this queue
     */
    public String toString() {
        String result = ("Queue size: " + numItems + ". Items: ");
        for(int i = front, j = 0; j < numItems; j++) {
            result += list[i++] + ", ";
            if(i == list.length) {
                i = 0;
            }
        }
        return result;
    }
}
