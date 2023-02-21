package cviceni03.ImplementaceDatovehoModelu;

public class Main {
    public static void main(String[] args) {
        Platno platno = new Platno(800,800);
        platno.pridej(new Ctverec(50,50,30));
        platno.pridej(new Kruh(10,16,30));
        platno.pridej(new Kruh(22,4,14));

        Slozenina slozenina = new Slozenina(50,50);
        slozenina.pridani(new Kruh(30,30,100));
        slozenina.pridani(new Ctverec(100,100,80));

        platno.pridej(slozenina);

        platno.vytvorRastr(); //vytvoreni rasteru atd

    }
}
