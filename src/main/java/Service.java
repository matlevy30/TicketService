import java.nio.CharBuffer;
import java.util.*;
import java.util.stream.IntStream;

public class Service implements TicketService {

    private ArrayList<char[]> stage;
    private Map<Integer,SeatHold> HoldSeats = new HashMap<>();
    private IDCreator id = IDCreator.getInstance();
    private int SeatsTaken  = 0;
    private Map<String,Set<Integer>> TakenSeats = new HashMap<>();

    public Service(Theatre t){
        stage = t.getStage();

    }

    //Returns the number of seats available/values that have a Char value of S
    public int numSeatsAvailable() {
        int  av_seats = 0;
        for (char[] seats:stage) {
            IntStream stream = CharBuffer.wrap(seats).chars();
            av_seats += stream.filter(seat -> seat == 'S').count();
        }
        return av_seats - seatHolds()- SeatsTaken;
    }

    private  int seatHolds() {
        return HoldSeats.entrySet().stream().mapToInt(e -> e.getValue().getNumberSeats()).sum();
    }

    @Override
    public SeatHold findAndHoldSeats(int numSeats, String customerEmail) {
        if (numSeats < 1) {
            throw new IllegalArgumentException("Please hold at least a seat");
        } else if (numSeats > numSeatsAvailable()) {
            throw new IllegalArgumentException("Number of seats not available");
        }
        //long start = System.currentTimeMillis();
        //long sec = TimeUnit.MILLISECONDS.toSeconds(start);
        SeatHold hold = new SeatHold(numSeats, customerEmail);
        HoldSeats.put(hold.getid(), hold);
        return hold;
    }

    public String reserveSeats(int seatHoldId, String customerEmail) {
        SeatHold reserve = HoldSeats.get(seatHoldId);

        if (reserve == null) {
            System.out.println("Seats have not been held");
            return null;
        }

        int numberSeats = reserve.getNumberSeats();
        SeatsTaken += numberSeats;

        List<Integer> seats = new ArrayList<>();

        String confirmation = Integer.toString(id.generateNewID());


        HoldSeats.remove(seatHoldId);

        return confirmation;
    }
}
