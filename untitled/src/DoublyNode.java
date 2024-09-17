
public class DoublyNode {
    private String element;
    private DoublyNode next;
    private DoublyNode prev;

    public DoublyNode(String element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public DoublyNode getNext() {
        return next;
    }

    public void setNext(DoublyNode next) {
        this.next = next;
    }

    public DoublyNode getPrev() {
        return prev;
    }

    public void setPrev(DoublyNode prev) {
        this.prev = prev;
    }
}
