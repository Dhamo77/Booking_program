import java.util.Scanner;

public class Passenger {
    public static Scanner scan =new Scanner(System.in);
    private static int passenger_id=0;
    private  int id;
    private String name;
    private int age;
    private char preference;
    private int seat_no;
    private String ticket_type;


    public Passenger() {

        System.out.print("Passenger Name : ");
        this.name =scan.next();
        System.out.print("Age : ");
        this.age = scan.nextInt();
        System.out.print("Berth Preference (L or M or U): ");
        this.preference = scan.next().toUpperCase().charAt(0);
        this.id=++passenger_id;
        System.out.println("Passenger ID : "+id);
    }

    public void setId(int id) {
        Passenger.passenger_id=id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setPreference(char preference) {
        this.preference = preference;
    }
    public void setSeat_no(int seat_no) {
        this.seat_no = seat_no;
    }
    public void setTicket_type(String ticket_type) {
        this.ticket_type = ticket_type;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public char getPreference() {
        return preference;
    }
    public int getSeat_no() {
        return seat_no;
    }
    public String getTicket_type() {
        return ticket_type;
    }

    @Override
    public String toString() {
        return "Passenger ID : "+getId() + "\n"+ "name : " + getName()+
                 "\n" + "Age : " + getAge() + "\n" + "Preference : " + getPreference() +
                "\n" + "Seat Number : " + getSeat_no() + "\n" +"Booking Type : " + getTicket_type()+
                "\n"+"------------------------" ;
    }// Done
}
