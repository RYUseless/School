package cviceni01.AutikaSousedi;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //objekt 1
        Auto t1 = new Auto();
        t1.setCena(3000);
        t1.setZnacka("Skoda");
        //objekt 2
        Auto t2 = new Auto();
        t2.setCena(623442);
        t2.setZnacka("Audi");
        //objekt 4
        Auto t4 = t1;
        //objekt 3
        Auto t3 = new Auto();
        t3.setCena(300000);
        t3.setZnacka("BMW popelnica");
        //sousedi
        t1.setLeft(t2);
        t2.setLeft(t3);



        System.out.println("ceena t1 je: "+t1.getCena() +" | znacka je: "+t4.getZnacka());
        System.out.println("cena t2 je: "+t2.getCena()+" | znacka je: "+t2.getZnacka());
        System.out.println("cena t3 je: "+t3.getCena()+" | znacka je: "+t3.getZnacka());

        System.out.println("soused t1 ma cenu: "+t1.getLeft().getCena() + " | jmeno je: " + t1.getLeft().getZnacka());
        System.out.println("soused t2 ma cenu: "+t2.getLeft().getCena() + " | jmeno je: " + t2.getLeft().getZnacka());



    }
}
