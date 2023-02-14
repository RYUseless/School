package cviceni02.GameskaPosun;

public class Main {
    public static void main(String[] args) {
        Board b1 = new Board();

        System.out.println("puvodni pole: \n"+b1.toString()); //to string je přepsaný v BOARD classe
        b1.posun(Board.DOPRAVA);
        System.out.println("DOPRAVA: \n"+b1.toString());
        b1.posun(Board.NAHORU);
        System.out.println("NAHORU: \n"+b1.toString());



    }
}
