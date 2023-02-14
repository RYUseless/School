package cviceni02.Vektor;


import java.util.Map;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        /*
        Vector<Auto> mujVektor = new Vector<Auto>();
        mujVektor.add(new Auto());
        mujVektor.add(new Auto());
        mujVektor.add(new Auto());
        mujVektor.add(new Auto());

        System.out.println("pocet auto je:"+mujVektor.size());
        System.out.println("nazev auta je:"+mujVektor.get(0).getName());

         */
        Mapa mapa = new Mapa();
        Auto a1 = new Auto();
        Auto a2 = new Auto();
        Auto a3 = new Auto();
        Auto a4 = new Auto();

        mapa.addAuto(a1);
        mapa.addAuto(a2);
        mapa.addAuto(a3);
        mapa.addAuto(a4);

        System.out.println("");


    }
}
