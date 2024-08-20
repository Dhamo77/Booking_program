import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Booking {

   static ArrayList<Passenger> confirmedList=new ArrayList<>();// total confirmed booking in the train
   static ArrayList<Passenger> upperList=new ArrayList<>(); // total confirmed booking in the upper birth
   static ArrayList<Passenger> lowerList=new ArrayList<>(); // total confirmed booking in the lower birth
   static ArrayList<Passenger> middleList=new ArrayList<>(); // total confirmed booking in the middle birth
   static Queue<Passenger> racList=new LinkedList<>();
   static Queue<Passenger> waitingList=new LinkedList<>();

   private final static int berth_limit =3;
   private final static int upper_limit=1;
   private final static int lower_limit=1;
   private final static int middle_limit=1;
   private final static int rac_limit=1;
   private final static int waiting_limit=1;
   private static int lowerSeatNumber=1;
   private static int middleSeatNumber=2;
   private static int upperSeatNumber=3;
   public static void booking(Passenger p){
      if (upperList.size()==upper_limit&&lowerList.size()==lower_limit&&middleList.size()==middle_limit){
         if (racList.size()<rac_limit){
            System.out.println("****** Ticket were booked in the RAC list ******");
            p.setTicket_type("RAC");
            racList.add(p);
         }
         else if (waitingList.size()<waiting_limit){
            System.out.println("****** Ticket were booked in the Waiting list ******");
            p.setTicket_type("WAITING LIST");
            waitingList.add(p);
         }
         else {
            System.out.println("****** Ticket is not available! ******  ");
            p.setId(p.getId()-1);
         }
      }
      else if (checkTicket(p)){
             p.setTicket_type("Berth");
             System.out.println("*****Ticket is confirmed***** ");
             System.out.println("Passenger ID number  is : "+p.getId());
             confirmedList.add(p);
      }
      else {
         System.out.println("Preferred birth is not available place check the Available List :  ");
         p.setId(p.getId() - 1);
      }
   }
   public void available(){
      System.out.println("No.of Seats in UpperBerth : "+ Math.abs(upperList.size()-upper_limit));
      System.out.println("No.of Seats in LowerBerth : "+ Math.abs(lowerList.size()-lower_limit));
      System.out.println("No.of Seats in MiddleBerth : "+ Math.abs(middleList.size()-middle_limit));
      System.out.println("No.of Seats in RAC : "+ Math.abs(racList.size()-rac_limit));
      System.out.println("No.of Seats in Waiting List : "+ Math.abs(waitingList.size()-waiting_limit));
   }
   public void print_tickets(){
      for (Passenger p:confirmedList){
         System.out.println(p.toString());
      }
   }
   private static boolean checkTicket(Passenger p){
      if (confirmedList.size()< berth_limit) {
         if (p.getPreference() == 'U'&&upperList.size()<upper_limit) {
            upperList.add(p);
            p.setSeat_no(upperSeatNumber);
            upperSeatNumber += 3;
            return true;
         } else if (p.getPreference() == 'L'&&lowerList.size()<lower_limit) {
            lowerList.add(p);
            p.setSeat_no(lowerSeatNumber);
            lowerSeatNumber += 3;
            return true;
         } else if (p.getPreference() == 'M'&&middleList.size()<middle_limit) {
            middleList.add(p);
            p.setSeat_no(middleSeatNumber);
            middleSeatNumber += 3;
            return true;
         }
      }
      return false;
   }
}
