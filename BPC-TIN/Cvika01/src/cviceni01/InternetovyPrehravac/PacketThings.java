package cviceni01.InternetovyPrehravac;

public class PacketThings {
    private String packetName;
    private PacketThings next;

    public PacketThings getNext() {
        return next;
    }

    public void setNext(PacketThings next) {
        this.next = next;
    }

    public String getPacketName() {
        return packetName;
    }

    public void setPacketName(String packetName) {
        this.packetName = packetName;
    }


}
