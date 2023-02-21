package cviceni03.ImplementaceDatovehoModelu;

import java.util.LinkedList;

public class Slozenina extends GraphicalObject{

    private LinkedList<GraphicalObject> grObject = new LinkedList<>();
    public Slozenina(int x, int y) {
        super(x, y);
    }
    public void pridani(GraphicalObject o){
        this.grObject.add(o);
    }

    @Override
    public void draw() {  //vykresleni
        System.out.println("Vykreslujeme kruh s rozmerem "+this.getX()+" | "+this.getY());
        //super.draw(x, y);
        for (GraphicalObject graphObject: grObject){
            graphObject.draw();
        }
    }
}
