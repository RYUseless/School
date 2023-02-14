package cviceni02.GameskaPosun;

public class Board {
    private int [] [] data = {{7,1,2},{3,0,5},{6,7,8}};
    private int posX = 1;
    private int posY = 1;

    public static final int NAHORU = 0;
    public static final int DOLU = 1;
    public static final int DOLEVA = 2;
    public static final int DOPRAVA = 3;

    public void posun(int smer){
        switch (smer) {
            case DOLU:
                if(posX >= 2) break; //ilegal move
                data[posY][posX] = data[posY+1][posX];
                data[posY + 1][posX] = 0;
                posY++;
                break;
            case NAHORU:
                if(posY <= 0) break; //ilegal move
                data[posY][posX] = data[posY-1][posX];
                data[posY-1][posX]=0;
                posY--;
                break;
            case DOLEVA:
                if(posY <= 0) break; //ilegal move
                data[posY][posX] = data[posY][posX-1];
                data[posY][posX- 1] = 0;
                posY--;
                break;
            case DOPRAVA:
                if(posX >= 2) break; //ilegal move
                data[posY][posX] = data[posY][posX+1];
                data[posY][posX+1] = 0;
                posX++;
                break;
        }
    }
    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < this.data.length; i++) {
            for (int j = 0; j < this.data[i].length; j++) {
                out += this.data[i][j] + " ";
            }
            out += "\n";
        }
        return "HRACI POLE \n"
                + "\n" + out + "KONEC HRACIHO POLE\n";
    }
}
