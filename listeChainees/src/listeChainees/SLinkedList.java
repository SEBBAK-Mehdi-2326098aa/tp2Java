package listeChainees;

public class SLinkedList {
	
	private Node head;
	private long size;
	
	public SLinkedList() {
		head = null;
		size = 0;
	}

	public Node getHead() {
		return head;
	}
	
	public void setHead(Node head) {
		this.head = head;
		if(head != null) {
			size = 1;
		}
	}
	
	public Node findPenultimate(Node head) {

		if (head == null || head.getNext() == null) {
	        return null;
	    }
	    
	    Node current = head;
	    
	    while (current.getNext().getNext() != null) {
	        current = current.getNext();
	    }
	    
	    return current;
	}
    public void reverse() {
        Node previous = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;           
            current = next;
        }
        head = previous;
    }
    
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.getElement());
            current = current.getNext();
        }
    }
}