package list;


public class ListNode<T> {

    // data stored in node
    private T data;

    // the next node that this node points to
    private ListNode<T> next;

    // constructor takes in data
    public ListNode(T data) {
        this.setData(data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> nextNode) {
        this.next = nextNode;
    }

}

