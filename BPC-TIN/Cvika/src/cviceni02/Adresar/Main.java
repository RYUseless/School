package cviceni02.Adresar;
public class Main {
    public static void main(String[] args) {
        Adresar adresar1 = new Adresar();
        Adresar adresar2 = new Adresar();
        Adresar adresar3 = new Adresar();
        Adresar adresar4 = new Adresar();
        Adresar adresar5 = new Adresar();
        adresar1.setAdresarName("Adresar cislo 1"); //adresar1
        adresar1.setPravy(adresar2);
        adresar1.setLevy(adresar4);
        adresar2.setAdresarName("Adresar cislo 2"); //addresar2
        adresar2.setPravy(adresar3);
        adresar2.setLevy(adresar5);
        adresar3.setAdresarName("Adresar cislo 3"); //treti
        adresar4.setAdresarName("Adresar cislo 4"); //ctvrty
        adresar5.setAdresarName("Adresar cislo 5"); //paty

        System.out.println("adresar name: "+adresar1.getAdresarName() + " | podadresare: "+adresar1.getPravy().getAdresarName() + " , "+adresar1.getLevy().getAdresarName());
        System.out.println("adresar name: "+adresar2.getAdresarName() + " | podadresare: "+adresar2.getPravy().getAdresarName() + " , "+adresar2.getLevy().getAdresarName());
    }
}
