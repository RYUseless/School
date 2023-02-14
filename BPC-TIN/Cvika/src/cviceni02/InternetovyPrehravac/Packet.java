package cviceni02.InternetovyPrehravac;

public class Packet {
    private Packet dalsi;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Packet getDalsi() {
        return dalsi;
    }

    public void setDalsi(Packet dalsi) {
        this.dalsi = dalsi;
    }
}
