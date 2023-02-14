package cviceni01.AutikaSousedi;

public class Auto {
    private int cena;
    private String znacka;

    private Auto left;

    public Auto getLeft() {
        return left;
    }

    public void setLeft(Auto left) {
        this.left = left;
    }

    public String getZnacka() {
        return znacka;
    }

    public void setZnacka(String znacka) {
        this.znacka = znacka;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
}
