package queue;


public interface Queue<T> {

    // returns true if empty
    boolean empty();

    // returns next item in queue
    T peek();

    // removes and returns first item in queue
    T dequeue();

    // add to the end of the queue
    void enqueue(T data);

    // make deep copy of queue
    Queue<T> copy();

    // return formatted string of queue
    String toString();

}

