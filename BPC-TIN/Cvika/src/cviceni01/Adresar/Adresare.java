package cviceni01.Adresar;

public class Adresare {
    private String adresarName;
    private Adresare adresarChild;

    public Adresare getAdresareChild1() {
        return adresareChild1;
    }

    public void setAdresareChild1(Adresare adresareChild1) {
        this.adresareChild1 = adresareChild1;
    }

    private Adresare adresareChild1;

    public String getAdresarName() {
        return adresarName;
    }

    public void setAdresarName(String adresarName) {
        this.adresarName = adresarName;
    }

    public Adresare getAdresarChild() {
        return adresarChild;
    }

    public void setAdresarChild(Adresare adresarChild) {
        this.adresarChild = adresarChild;
    }
}
