package cvika04.InformaceVPameti;

public class Uzel {
    private int data;
    private Uzel next;
    private Uzel prev;

    public Uzel getPrev() {
        return prev;
    }

    public void setPrev(Uzel prev) {
        this.prev = prev;
    }

    public Uzel(int data){ //constructor
        this.data = data;
        //this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Uzel getNext() {
        return next;
    }

    public void setNext(Uzel next) {
        this.next = next;
    }
    public boolean hasNext(){
        return !(next == null);
    }
}
