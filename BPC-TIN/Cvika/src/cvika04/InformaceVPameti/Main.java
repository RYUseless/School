package cvika04.InformaceVPameti;

public class Main {
    public static void main(String[] args) {
        List list = new List();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.print(list,"Original");

        //ADD a REMOVE first
        list.addFirst(5);
        list.print(list ,"AddFirst");
        list.removeFirst();
        list.print(list ,"RemoveFirst");

        //ADD a REMOVE last
        list.addLast(6);
        list.print(list ,"AddLast");
        list.removeLast();
        list.print(list ,"RemoveLast");

        //smthn
        System.out.println("\n");
        list.contains(0,1);
        list.contains(2,2);


    }
}
