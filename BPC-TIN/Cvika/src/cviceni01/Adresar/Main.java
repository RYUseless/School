package cviceni01.Adresar;

public class Main {
    public static void main(String[] args) {
        Adresare adresar1 = new Adresare();
        Adresare adresar2 = new Adresare();
        Adresare adresar3 = new Adresare();
        Adresare adresar4 = new Adresare();
        Adresare adresar5 = new Adresare();
        adresar1.setAdresarName("Adresar cislo 1"); //adresar1
        adresar1.setAdresarChild(adresar2);
        adresar1.setAdresareChild1(adresar4);
        adresar2.setAdresarName("Adresar cislo 2"); //addresar2
        adresar2.setAdresarChild(adresar3);
        adresar2.setAdresareChild1(adresar5);
        adresar3.setAdresarName("Adresar cislo 3"); //treti
        adresar4.setAdresarName("Adresar cislo 4"); //ctvrty
        adresar5.setAdresarName("Adresar cislo 5"); //paty

        System.out.println("adresar name: "+adresar1.getAdresarName() + " | podadresare: "+adresar1.getAdresarChild().getAdresarName() + " , "+adresar1.getAdresareChild1().getAdresarName());
        System.out.println("adresar name: "+adresar2.getAdresarName() + " | podadresare: "+adresar2.getAdresarChild().getAdresarName() + " , "+adresar2.getAdresareChild1().getAdresarName());




    }
}
