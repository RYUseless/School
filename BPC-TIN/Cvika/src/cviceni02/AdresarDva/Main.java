package cviceni02.AdresarDva;

public class Main {

    public static void main(String[] args) {
        Adresar uzel1 = new Adresar();
        Adresar uzel2 = new Adresar();
        Adresar uzel3 = new Adresar();
        Adresar uzel4 = new Adresar();
        Adresar uzel5 = new Adresar();
        Adresar uzel6 = new Adresar();

        uzel1.setJmeno("uzel 1");
        uzel2.setJmeno("uzel 2");
        uzel3.setJmeno("uzel 3");
        uzel4.setJmeno("uzel 4");
        uzel4.setJmeno("uzel 5");
        uzel6.setJmeno("uzel 6");

        uzel1.addUzel(uzel2);
        uzel1.addUzel(uzel4);
        uzel1.addUzel(uzel6);

        uzel2.addUzel(uzel1);
        uzel2.addUzel(uzel5);
        uzel2.addUzel(uzel3);

        uzel5.addUzel(uzel4);

        System.out.println("jmeno adresare je :"+uzel1.getJmeno());
        uzel1.printUzel();
        System.out.println("jmeno adresare je :"+uzel2.getJmeno() );
        uzel2.printUzel();
        System.out.println("jmeno adresare je :"+uzel5.getJmeno());
        uzel5.printUzel();




    }
}
