package cvika06;

import java.util.HashMap;

public class Vrchol {
    private int label;
    private HashMap<Vrchol, Integer> costs;
    public Vrchol(int label){ //konstruktor
        costs = new HashMap<>();
        this.label = label;
    }


    public int getCost(Vrchol uzel){  //funkce co vybere cenu mezi dvěma uzly
        return costs.get(uzel);
    }

    public  void connect(Vrchol uzel, int cost){ //propojeni dvou uzlů + pridani costu
        costs.put(uzel, cost);

    }
}
