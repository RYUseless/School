package cviceni01.InternetovyPrehravac;

public class Main {
    public static void main(String[] args) {
        PacketThings pckt1 = new PacketThings();
        PacketThings pckt2 = new PacketThings();
        PacketThings pckt3 = new PacketThings();
        PacketThings pckt4 = new PacketThings();
        pckt1.setPacketName("prvni packet");
        pckt1.setNext(pckt2);
        pckt2.setPacketName("druhy packet");
        pckt2.setNext(pckt3);
        pckt3.setPacketName("treti packet");
        pckt3.setNext(pckt4);
        pckt4.setPacketName("ctvrty packet");
        pckt4.setNext(pckt1);

        System.out.println("pckt1 name: "+pckt1.getPacketName());
        System.out.println("next after pckt1: "+pckt1.getNext().getPacketName());
        System.out.println("pckt2 name: "+pckt2.getPacketName());
        System.out.println("next after pckt2: "+pckt2.getNext().getPacketName());
        System.out.println("pckt3 name: "+pckt3.getPacketName());
        System.out.println("next after pckt3"+pckt3.getNext().getPacketName());
        System.out.println("pckt4 name: "+pckt4.getPacketName());
        System.out.println("next after pckt4"+pckt4.getNext().getPacketName());
    }
}
