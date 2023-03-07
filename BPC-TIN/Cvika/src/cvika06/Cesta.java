package cvika06;

import java.util.ArrayList;
import java.util.List;

public class Cesta {
    private List<Vrchol> uzly = new ArrayList<>();
    private int cost;
    private Graf graf;
    public Cesta(Graf graff, int label) { //konstruktor
        this.graf = graff;
        uzly.add(graff.getUzel(label));
    }

    public Cesta addVrchol(int label) {
        Vrchol vrchol = graf.getUzel(label);
        Vrchol posledniVrchol = uzly.get(uzly.size() - 1);
        uzly.add(vrchol);
        cost = cost +  posledniVrchol.getCost(vrchol); //this sčítá veškeré costy v daném runu
        return this;

    }
    public void printCost(String jmeno) {
        System.out.println("Cesta je: "+jmeno+ " | cost je: "+cost);
    }

}
