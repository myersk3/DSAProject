/*
 * Purpose: Data Structure and Algorithms Lab 6 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 10/10/18
 * Submitted:  10/11/18
 * Comment: test suite and sample run attached
 * @author: Jared Tebbi
 * @version: 2018.10.10
 */

public class QueueRA<T> implements QueueInterface<T> {

    protected Object[] list;
    protected int front;
    protected int back;
    protected int numItems;

    public QueueRA() {
        list = new Object[3];
        front = 0;
        back = 0;
        numItems = 0;
    }

    public boolean isEmpty() {
        boolean result = false;
        if(numItems == 0) {
            result = true;
        }
        return result;
    }

    public int size() {
	    return numItems;
    }

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

    public T peek() throws QueueException {
        if(!isEmpty()) {
            return (T) list[front];
        }
        else {
            throw new QueueException("Error while peeking");
        }
    }

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
