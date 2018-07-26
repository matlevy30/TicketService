import java.util.Scanner;

public class TicketServiceMain {

    public static void main(String[] args) {
        //Read in Values
        Scanner sc = new Scanner(System.in);

        System.out.println("Values to Build Theater");
        System.out.println("Number of Rows: ");
        int rows = sc.nextInt();
        System.out.println("Number of available Seats: ");
        int seats = sc.nextInt();

        Theatre t = new Theatre(rows,seats);
        t.toString();

        TicketService service = new Service(t);

        service.findAndHoldSeats(5,"matlevy@visa.com");
        service.findAndHoldSeats(5,"matlevy01@visa.com");
        service.findAndHoldSeats(5,"matlevy02@visa.com");
        service.findAndHoldSeats(5,"matlevy03@visa.com");

    }
}
