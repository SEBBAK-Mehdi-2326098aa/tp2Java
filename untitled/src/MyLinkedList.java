
import java.util.AbstractList;
import java.util.List;
import java.util.Iterator;

public class MyLinkedList<T> extends AbstractList<T> implements List<T> {

    private class Node {
        T element;
        Node next;
        Node prev;

        Node(T element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public boolean add(T element) {
        Node newNode = new Node(element, null, tail);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(element);
        } else {
            Node nextNode = getNode(index);
            Node prevNode = nextNode.prev;
            Node newNode = new Node(element, nextNode, prevNode);
            if (prevNode != null) {
                prevNode.next = newNode;
            } else {
                head = newNode;
            }
            nextNode.prev = newNode;
            size++;
        }
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).element;
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = getNode(index);
        T oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node nodeToRemove = getNode(index);
        T removedElement = nodeToRemove.element;
        Node prevNode = nodeToRemove.prev;
        Node nextNode = nodeToRemove.next;

        if (prevNode != null) {
            prevNode.next = nextNode;
        } else {
            head = nextNode;
        }

        if (nextNode != null) {
            nextNode.prev = prevNode;
        } else {
            tail = prevNode;
        }

        size--;
        return removedElement;
    }

    @Override
    public int size() {
        return size;
    }

    private Node getNode(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T element = current.element;
                current = current.next;
                return element;
            }
        };
    }
}
