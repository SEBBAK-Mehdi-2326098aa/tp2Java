
public class MyLinkedListTest {

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("Premier");
        list.add("Deuxième");
        list.add("Troisième");

        System.out.println("Liste après ajout :");
        list.forEach(System.out::println);

        System.out.println("Élément à l'indice 1 : " + list.get(1));
        list.set(1, "Modifié");
        System.out.println("Liste après modification de l'indice 1 :");
        list.forEach(System.out::println);

        list.remove(1);
        System.out.println("Liste après suppression de l'indice 1 :");
        list.forEach(System.out::println);

        MyLinkedList<String> anotherList = new MyLinkedList<>();
        anotherList.add("Premier");
        anotherList.add("Modifié");

        System.out.println("Les listes sont-elles égales ? " + list.equals(anotherList));
    }
}
