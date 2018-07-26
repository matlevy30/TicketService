import java.util.ArrayList;
import java.util.Arrays;

public class Theatre {



    public int seats;
    public ArrayList<char[]> stage;

    public Theatre(int row, int seats) {
        //Initialize global variables
        this.row = row;
        this. seats = seats;
        stage =  new ArrayList<>();


        for(int i =row; i!= 1; --i) {
            char[] seat = new char[seats];
            Arrays.fill(seat, 'S');
            stage.add(seat);
        }


        //Todo: Build header for printing purposes
    }

    public ArrayList<char[]> getStage(){
        return stage;
    }

    public int getRow() {
        return row;
    }

    public int row;

    public int getSeats() {
        return seats;
    }

    public String toString(){

        StringBuilder sb = new StringBuilder();
        for (char[]s :stage) {
            sb.append(s);
            sb.append("\n\n");

        }
        return sb.toString();
    }


}
