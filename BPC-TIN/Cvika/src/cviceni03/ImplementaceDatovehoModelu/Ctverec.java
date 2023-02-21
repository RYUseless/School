package cviceni03.ImplementaceDatovehoModelu;

public class Ctverec extends GraphicalObject{
    private int sirka;
    public Ctverec(int x, int y, int sirka) {
        super(x, y);
        this.sirka = sirka;
    }

    public int getSirka() {
        return sirka;
    }

    public void setSirka(int sirka) {
        this.sirka = sirka;
    }

    @Override
    public void draw() {
        System.out.println("Vykreslujeme ctverec s rozmery a sirkou: "+this.getX()+" | "+this.getY()+" | "+this.getSirka());
    }
}
