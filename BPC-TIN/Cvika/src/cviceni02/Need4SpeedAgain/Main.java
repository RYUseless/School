package cviceni02.Need4SpeedAgain;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Mapa mapa = new Mapa();
        Auta auto1 = new Auta();
        Auta auto2 = new Auta();
        Auta auto3 = new Auta();
        Auta auto4 = new Auta();
        mapa.setAuto1(auto1);
        mapa.setAuto2(auto2);
        mapa.setAuto3(auto3);
        mapa.setAuto4(auto4);

        System.out.println("auto je: "+auto1.getName());
    }
}
