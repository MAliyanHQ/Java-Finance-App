
class Node {

    String mode, date, amount, purpose;
    Node next;

    public Node(String mode, String date, String amount, String purpose) {
        this.mode = mode;
        this.date = date;
        this.amount = amount;
        this.purpose = purpose;
        this.next = null;
    }

}

public class StackLinkedList {

    Node head;

    public boolean isEmpty() {
        return head == null;
    }

    public void push(String mode, String date, String amount, String purpose) {
        Node newNode = new Node(mode, date, amount, purpose);
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        } else {
            head = head.next;
            return 1;
        }
    }

    public Node peek() {
        if (isEmpty()) {
            return null; // Return null to indicate underflow
        } else {
            return head; // Return the entire Node
        }
    }
}
