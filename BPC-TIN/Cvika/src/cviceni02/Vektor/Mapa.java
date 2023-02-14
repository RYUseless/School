package cviceni02.Vektor;

import java.util.Vector;

public class Mapa {
    private Vector<Auto> auta = new Vector<Auto>();
    public Vector<Auto> getAuta() {
        return auta;
    }
    public void addAuta(Auto a1){
        this.auta.add(a1);
    }
    public void setAuta(Vector<Auto> mujVektorMapa) {
        this.auta = mujVektorMapa;
    }
    public int getPocetAut(){
        auta.size();
        return auta.size();
    }
    public void removeAuto(int index){
        auta.remove(index);
    }

    public void addAuto(Auto a1) {
        this.auta.add(a1);
    }
}
