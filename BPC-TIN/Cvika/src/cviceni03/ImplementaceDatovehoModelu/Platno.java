package cviceni03.ImplementaceDatovehoModelu;


import java.util.ArrayList;

public class Platno {
    private int sirka;
    private int vyska;
    ArrayList <GraphicalObject> platnoArr = new ArrayList<>();


    public int getSirka() {  //delete later
        return sirka;
    }

    public int getVyska() { //delete later
        return vyska;
    }


    public Platno(int sirka, int vyska){
        this.sirka = sirka;
        this.vyska = vyska;

    }
    public void pridej(GraphicalObject o){
        this.platnoArr.add(o);
    }
    public void vytvorRastr(){  //rastr thingy
        System.out.println("Vykresleni platna: ");
        for (GraphicalObject graphObject: platnoArr){
            graphObject.draw();
        }
    }
}
