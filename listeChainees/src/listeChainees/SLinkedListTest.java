package listeChainees;

public class SLinkedListTest {

    public static void main(String[] args) {
        SLinkedList list = new SLinkedList();
        
        Node node1 = new Node("Premier", null);
        Node node2 = new Node("Deuxième", null);
        Node node3 = new Node("Troisième", null);
        
        node1.setNext(node2);
        node2.setNext(node3);
        
        list.setHead(node1);
        
        Node current = list.getHead();
        while (current != null) {
            System.out.println(current.getElement());
            current = current.getNext();
        }
        
        Node penultimateNode = list.findPenultimate(list.getHead());
        
        if (penultimateNode != null) {
            System.out.println("Avant-dernier élément : " + penultimateNode.getElement());
        } else {
            System.out.println("Il n'y a pas d'avant-dernier élément.");
        }
        
        list.reverse();
        list.printList();
        
    }
}