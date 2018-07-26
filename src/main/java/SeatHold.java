import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SeatHold {

    private Integer id;
    private IDCreator gen = IDCreator.getInstance();
    private long holdTime;
    private String customer;
    private long expirationTime = 15;
    private int numberSeats;
    private List<Integer> holdSeats;


    public SeatHold(int seats, String email){
        this.customer = email;
        this.id = gen.generateNewID();
        this.numberSeats = seats;
        holdSeats = new ArrayList<>();
    }

    public ArrayList<char[]> getListHoldSeats(ArrayList<char[]> stage){
        int value = 0;
        int pos = 1;
        while(value != numberSeats) {
            for (char[] c : stage) {
                for (char n : c) {
                    if (n == 'S') {
                        n = 'H';
                        value++;
                        holdSeats.add(pos);
                    }
                    pos++;
                }

            }
        }

        return stage;
    }



    public int getNumberSeats(){
        return numberSeats;
    }

    public int getid(){
        return id;
    }

    public String getEmail() {
        return customer;
    }


}
