package cviceni03.GameskaV2;


import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Board b1 = new Board();
        Board b2 = new Board();

        System.out.println("puvodni pole: \n"+b1.toString()); //to string je přepsaný v BOARD classe
        b1.posun(Board.DOPRAVA);
        System.out.println("DOPRAVA b1: \n"+b1.toString());
        b2.posun(Board.DOPRAVA);
        System.out.println("DOPRAVA b2: \n"+b2.toString());

        //Hash set
        HashSet<Board> mnozinaHash = new HashSet<>();
        mnozinaHash.add(b1);
        mnozinaHash.add(b2);

        System.out.println("HashSet print: Hashcode b1: "+b1.hashCode());
        System.out.println("HashSet print: Hashcode b2: "+b2.hashCode());
        System.out.println("equlas: "+b1.equals(b2));
        System.out.println("equlas: "+b2.equals(b1));
        System.out.println("compare to: "+b2.compareTo(b1));
        System.out.println("compare to: "+b1.compareTo(b2));
        System.out.println(mnozinaHash.size());

        //Tree set
        TreeSet<Board> mnozina = new TreeSet<>();
        mnozina.add(b1);
        mnozina.add(b2);

        System.out.println("TreeSet print: Hashcode b1: "+b1.hashCode());
        System.out.println("TreeSet print: Hashcode b2: "+b2.hashCode());
        System.out.println("equlas: "+b1.equals(b2));
        System.out.println("equlas: "+b2.equals(b1));
        System.out.println("compare to: "+b2.compareTo(b1));
        System.out.println("compare to: "+b1.compareTo(b2));


        System.out.println(mnozina.size());



    }
}
