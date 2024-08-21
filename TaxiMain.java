import java.util.Scanner;

public class TaxiMain {
    public static Scanner scan =new Scanner(System.in);
    public static void main(String[] args) throws CloneNotSupportedException {
        boolean process=true;
        while (process) {
            System.out.println("-------------------------");
            System.out.println("1.Taxi Booking\n2.Taxi Details\n3.Exit");
            System.out.print("Enter the number for the continue process: ");
            int n = scan.nextInt();
            System.out.println("-------------------------");
            switch (n) {
                case 1 -> {
                    System.out.println("Enter the booking details :");
                    System.out.println("--------------------------");
                    System.out.print("Pickup Location :");
                    char p=scan.next().toUpperCase().charAt(0);
                    System.out.print("Drop Location :");
                    char d=scan.next().toUpperCase().charAt(0);
                    System.out.print("Pickup Timing(Railway Timing) :");
                    int t=scan.nextInt();
                    System.out.println(TaxiBooking.booking(p,d,t));

                }
                case 2 -> {
                    System.out.print("Taxi booking History:");
                    TaxiBooking.history();
                }
                case 3 -> {
                    System.out.println("Exiting...");
                    process = false;
                }
            }
        }
    }
}
