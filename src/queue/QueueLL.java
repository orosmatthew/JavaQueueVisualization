package queue;


import list.LinkedList;
import list.ListNode;

public class QueueLL<T> implements Queue<T> {

    private final LinkedList<T> list = new LinkedList<>();

    @Override
    public boolean empty() {
        return list.isEmpty();
    }

    @Override
    public T peek() {
        return list.getFirst();
    }

    @Override
    public T dequeue() {
        T data = list.getFirst();
        list.deleteFirst();
        return data;
    }

    @Override
    public void enqueue(T data) {
        list.insertLast(data);
    }

    @Override
    public String toString() {
        return list.toString();
    }

    @Override
    public Queue<T> copy() {
        Queue<T> q = new QueueLL<>();
        ListNode<T> node = list.getFirstNode();
        while (node != null) {
            q.enqueue(node.getData());
            node = node.getNext();
        }
        return q;
    }
}

