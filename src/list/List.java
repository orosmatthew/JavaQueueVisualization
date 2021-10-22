package list;

public interface List<T> {

    // Get data stored in head node of list
    T getFirst();

    // Get the head node of list
    ListNode<T> getFirstNode();

    // Get data stored in tail node of list
    T getLast();

    // Insert a new node with data at the head of the list
    void insertFirst(T data);

    // Insert a new node with data after currentNode
    void insertAfter(ListNode<T> currentNode, T data);

    // Insert a new node with data at the tail of list
    void insertLast(T data);

    // Remove head node
    void deleteFirst();

    // Remove tail node
    void deleteLast();

    // Remove node following currentNode
    // If no node exists, do nothing
    void deleteNext(ListNode<T> currentNode);

    // Get number of elements in list
    int size();

    // Check if the list is empty
    boolean isEmpty();

}
