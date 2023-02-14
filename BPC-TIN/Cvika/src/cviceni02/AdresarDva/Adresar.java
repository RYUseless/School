package cviceni02.AdresarDva;

import java.util.Iterator;
import java.util.Vector;

public class Adresar {
    private String Jmeno;
    Vector <Adresar> uzel = new Vector<Adresar>();

    public String getJmeno() {
        return Jmeno;
    }

    public void setJmeno(String jmeno) {
        Jmeno = jmeno;
    }

    public Vector<Adresar> getUzel() { //GETNODE
        return uzel;
    }
    public void addUzel(Adresar n){ //ADDNODE
        uzel.add(n);
    }
    public void printUzel(){
       for(Adresar m: uzel){
           System.out.println( m.getJmeno());
       }
    }

}
