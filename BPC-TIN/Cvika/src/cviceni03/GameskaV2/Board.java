package cviceni03.GameskaV2;

import java.util.Arrays;
import java.util.Objects;

public class Board implements Comparable<Board>{
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
    public String toString() {  //Format do prijatelneho printu :)
        String out = "";
        for (int i = 0; i < this.data.length; i++) {
            for (int j = 0; j < this.data[i].length; j++) {
                out += this.data[i][j] + " ";
            }
            out += "\n";
        }
        return "HRACI POLE"
                + "\n" + out + "KONEC HRACIHO POLE\n";
    }

    //@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Arrays.deepEquals(this.data, board.data);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(posY, posX);
        result = 31 * result + Arrays.deepHashCode(data);
        return result;
    }

    public int compareTo(Board o) {
        for (int i = 0; i < this.data.length; i++);
            for (int i2 = 0; i2 < this.data.length;i2++);
                if (this.data[posY][posX] > o.data[posY][posX]){
                    return -1;
                }
                else if (this.data[posY][posX] < o.data[posY][posX]){
                    return 1;
                 }
            return 0;

    }
}
