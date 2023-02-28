package cvika05.Strom;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(7);
        tree.insert(5);
        tree.insert(14);
        tree.insert(1);
        tree.insert(6);
        tree.insert(16);
        tree.insert(10);
        System.out.println("\n--- PRINT ---");
        tree.print();
        System.out.println("\n--- PRINT REVERSE ---");
        tree.printReverse();
        System.out.println("\n--- CONTAINS ---");
        tree.contains(11);
        System.out.println("smthn");
    }
}
