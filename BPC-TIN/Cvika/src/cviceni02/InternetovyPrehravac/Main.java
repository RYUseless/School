package cviceni02.InternetovyPrehravac;

public class Main {
    public static void main(String[] args) {
        //PACKETY NE PREHRAVAC
        Packet p1 = new Packet();
        p1.setName("packet1");
        Packet p2 = new Packet();
        p2.setName("packet1");
        Packet p3 = new Packet();
        p3.setName("packet1");
        Packet p4 = new Packet();
        p4.setName("packet1");

        p1.setDalsi(p2);
        p2.setDalsi(p3);
        p3.setDalsi(p4);
        //zadny loopback na packet1
    }
}
