package cvika06;

public class Main {
    public static void main(String[] args) {
        //zakladni cesta
        //predpokladany vysledek je 31
        Graf graf = new Graf();
        graf.add(1,6,6); //uzly 1 - 6
        graf.add(6,5,5); //uzly 6 - 5
        graf.add(5,4,11); //uzly 5 - 4
        graf.add(4,3,9); //uzly 4-3
        Cesta path = new Cesta(graf, 1);
        path.addVrchol(6).addVrchol(5).addVrchol(4).addVrchol(3);
        path.printCost("1-6-5-4-3");

        //cesta pro kontrolu
        //predpokladany vysledek je 37
        graf.add(1,2,4); //uzly 1 - 2
        graf.add(2,3,24); //uzly 2 - 3
        graf.add(3,4,9); //uzly 3 - 4
        Cesta newPath = new Cesta(graf,1 );
        newPath.addVrchol(2).addVrchol(3).addVrchol(4);
        newPath.printCost("1-2-3-4");

        // cesta mezi dvema uzly
        graf.add(6,3,23); //pridani vzdalenosti dvou bodu
        Vrchol v1 = graf.getUzel(6);
        Vrchol v2 = graf.getUzel(3);
        System.out.println("Cost cesty mezi 6 a 3 je: "+v1.getCost(v2));


    }
}
