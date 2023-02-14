package cviceni02.Adresar;


public class Adresar {
    private String adresarName;
    private Adresar pravy;

    public String getAdresarName() {
        return adresarName;
    }

    public void setAdresarName(String adresarName) {
        this.adresarName = adresarName;
    }

    public Adresar getPravy() {
        return pravy;
    }

    public void setPravy(Adresar pravy) {
        this.pravy = pravy;
    }

    public Adresar getLevy() {
        return levy;
    }

    public void setLevy(Adresar levy) {
        this.levy = levy;
    }

    private Adresar levy;


}
