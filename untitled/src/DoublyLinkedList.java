
public class DoublyLinkedList {

    private DoublyNode head;
    private DoublyNode tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(String element) {
        DoublyNode newNode = new DoublyNode(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
    }

    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        DoublyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getElement();
    }

    public void update(int index, String newElement) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        DoublyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        current.setElement(newElement);
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        DoublyNode current = head;
        if (index == 0) {
            head = head.getNext();
            if (head != null) {
                head.setPrev(null);
            } else {
                tail = null;
            }
        } else {
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            DoublyNode previous = current.getPrev();
            DoublyNode next = current.getNext();
            if (previous != null) {
                previous.setNext(next);
            }
            if (next != null) {
                next.setPrev(previous);
            }
            if (current == tail) {
                tail = previous;
            }
        }
        size--;
    }

    // Equals method to compare two doubly linked lists
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        DoublyLinkedList otherList = (DoublyLinkedList) obj;
        if (this.size != otherList.size) return false;

        DoublyNode currentA = this.head;
        DoublyNode currentB = otherList.head;

        while (currentA != null) {
            if (!currentA.getElement().equals(currentB.getElement())) {
                return false;
            }
            currentA = currentA.getNext();
            currentB = currentB.getNext();
        }

        return true;
    }

    public void printList() {
        DoublyNode current = head;
        System.out.println("Liste :");
        while (current != null) {
            System.out.println(current.getElement());
            current = current.getNext();
        }
    }

    public int getSize() {
        return size;
    }
}
