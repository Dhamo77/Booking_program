import java.util.Scanner;

public class TrainTicket {
    public static Scanner scan =new Scanner(System.in);
    public static void main(String[] args) {
        boolean process=true;
        while (process) {
            System.out.println("-------------------------");
            System.out.println("1.TrainBooking\n2.Cancelling\n3.Print Ticket\n4.Tickets Available\n5.Exit");
            System.out.print("Enter the number for the further process: ");
            int n = scan.nextInt();
            System.out.println("-------------------------");
            switch (n) {
                case 1 -> {
                    System.out.println("Enter the booking details :");
                    TrainPassenger p = new TrainPassenger();
                    if (p.getPreference()=='L'||p.getPreference()=='U'||p.getPreference()=='M') {
                        TrainBooking.booking(p);
                    }
                    System.out.println("Enter the correct preference");

                }
                case 2 -> {
                    System.out.print("Enter the passenger details :");
                    int id=scan.nextInt();
                    TrainCancel.cancelling(id);
                }
                case 3 -> {
                    System.out.println("Printing passengers tickets :");
                    TrainBooking b = new TrainBooking();
                    b.print_tickets();
                }
                case 4 ->{
                    System.out.println("Availability");
                    TrainBooking b = new TrainBooking();
                    b.available();
                }
                case 5 -> {
                    System.out.println("Exiting...");
                    process = false;
                }
            }
        }
    }
    // Done
}
