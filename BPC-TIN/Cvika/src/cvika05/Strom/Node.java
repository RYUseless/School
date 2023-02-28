package cvika05.Strom;

public class Node {
    private int data;
    private Node levo;
    private Node pravo;


    //constructor
    public Node(int data){
        this.data = data;
        levo = null;
        pravo = null;

    }

    public Node getLevo() {
        return levo;
    }

    public void setLevo(Node levo) {
        this.levo = levo;
    }

    public Node getPravo() {
        return pravo;
    }

    public void setPravo(Node pravo) {
        this.pravo = pravo;
    }
    public int getData() {
        return data;
    }

}
