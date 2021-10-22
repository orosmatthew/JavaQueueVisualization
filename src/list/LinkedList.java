package list;

public class LinkedList<T> implements List<T> {

    // first node of list
    private ListNode<T> head;

    // returns data in first node
    @Override
    public T getFirst() {
        // return null if empty since head is null
        if (isEmpty()) {
            return null;
        }
        // return data from first node
        return getFirstNode().getData();
    }

    // returns first node in list
    @Override
    public ListNode<T> getFirstNode() {
        return head;
    }

    // returns data from last node
    @Override
    public T getLast() {
        // return null if empty since there are no nodes
        if (isEmpty()) {
            return null;
        }

        // find the last node
        ListNode<T> lastNode = getFirstNode();
        while (lastNode.getNext() != null) {
            lastNode = lastNode.getNext();
        }

        // return data from last node
        return lastNode.getData();
    }

    // inserts data at the beginning of list
    @Override
    public void insertFirst(T data) {
        // create new node with data
        ListNode<T> node = new ListNode<>(data);
        // point node to original first node
        node.setNext(getFirstNode());
        // set head to the newly created node
        head = node;
    }

    // insert data after passed-in currentNode
    @Override
    public void insertAfter(ListNode<T> currentNode, T data) {
        // create new node with data
        ListNode<T> node = new ListNode<>(data);
        // point node to currentNode's next node
        node.setNext(currentNode.getNext());
        // have current node point to newly created node
        currentNode.setNext(node);
    }

    // insert data at the end of list
    @Override
    public void insertLast(T data) {
        // create new node with data
        ListNode<T> node = new ListNode<>(data);
        // make head the newly created node if list is empty
        if (isEmpty()) {
            head = node;
            return;
        }
        // find last node
        ListNode<T> lastNode = head;
        while (lastNode.getNext() != null) {
            lastNode = lastNode.getNext();
        }
        // have original last node point to the newly created node
        lastNode.setNext(node);
    }

    // deletes first node in list
    @Override
    public void deleteFirst() {
        // if list is empty then do nothing
        if (isEmpty()) {
            return;
        }
        // make head the second item in list
        head = head.getNext();
    }

    // deletes last node in list
    @Override
    public void deleteLast() {
        // if list is empty then do nothing
        if (isEmpty()) {
            return;
        }
        // find the second last node
        ListNode<T> secondLastNode = head;
        while (secondLastNode.getNext() != null) {
            if (secondLastNode.getNext().getNext() == null) {
                break;
            } else {
                secondLastNode = secondLastNode.getNext();
            }
        }
        // remove pointer of second last node
        secondLastNode.setNext(null);
    }

    // deletes the node after currentNode
    @Override
    public void deleteNext(ListNode<T> currentNode) {

        // get the node after currentNode
        ListNode<T> nextNode = currentNode.getNext();

        // if nextNode exists, then have currentNode point to the node after nextNode
        if (nextNode != null) {
            currentNode.setNext(nextNode.getNext());
        }
    }

    // return the size of the list
    @Override
    public int size() {
        // if the list is empty then the size is 0
        if (isEmpty()) {
            return 0;
        }
        // loop through all elements in list while adding to count
        int count = 0;
        ListNode<T> node = head;
        while (node.getNext() != null) {
            node = node.getNext();
            count++;
        }
        return count;
    }

    // returns true if the list is empty
    @Override
    public boolean isEmpty() {
        // if head node does not exist then the list is empty
        return head == null;
    }

    // returns a formatted string for the list
    // example: a -> b -> c -> d
    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        }

        ListNode<T> lastNode = head;

        StringBuilder string = new StringBuilder(head.getData().toString());

        while (lastNode.getNext() != null) {
            lastNode = lastNode.getNext();
            string.append(" -> ").append(lastNode.getData().toString());
        }
        return string.toString();
    }
}

