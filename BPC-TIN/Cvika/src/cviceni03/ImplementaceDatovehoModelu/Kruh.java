package cviceni03.ImplementaceDatovehoModelu;

public class Kruh extends GraphicalObject{
    public Kruh(int x, int y, int polomer) {
        super(x, y);
        this.polomer = polomer;
    }
    private int polomer;

    public int getPolomer() {
        return polomer;
    }
    @Override
    public void draw() {
        System.out.println("Vykreslujeme kruh s rozmery a sirkou: "+this.getX()+" | "+this.getY()+" | "+ this.getPolomer());
    }
}
