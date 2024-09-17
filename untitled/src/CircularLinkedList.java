
public class CircularLinkedList {
    private CNode head;
    private long size;

    public CircularLinkedList() {
        head = null;
        size = 0;
    }

    public void append(String element) {
        CNode newNode = new CNode(element, null);

        if (head == null) {
            head = newNode;
            newNode.setNext(head);
        } else {
            CNode current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }
            current.setNext(newNode);
            newNode.setNext(head);
        }
        size++;
    }

    public int countNodes() {
        if (head == null) {
            return 0;
        }

        int count = 1;
        CNode current = head;

        while (current.getNext() != head) {
            count++;
            current = current.getNext();
        }

        return count;
    }

    public void printList() {
        if (head == null) {
            System.out.println("La liste est vide.");
            return;
        }

        CNode current = head;
        do {
            System.out.println(current.getElement());
            current = current.getNext();
        } while (current != head);
    }
}
