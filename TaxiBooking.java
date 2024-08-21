import java.util.ArrayList;

public class TaxiBooking {
    private static ArrayList<TaxiDetails> taxi=new ArrayList<>();
    private static int taxiLimit=4;
    private static int idGenerator=1;
    private static ArrayList<TaxiDetails> history=new ArrayList<>();

    public static <taxi> String booking(char pickup, char drop, int timing) throws CloneNotSupportedException {
        if (taxi.size()<taxiLimit){
            taxi.add(new TaxiDetails());
        }
        int min=Integer.MAX_VALUE;
        TaxiDetails readyTaxi=null;
        for (TaxiDetails t:taxi){
            if (min>Math.abs(pickup-t.getCurrentLocation())&&t.getDropTiming()<=pickup){
                readyTaxi=t;
                min=Math.abs(pickup-t.getCurrentLocation());
            }
        }
        if (readyTaxi!=null){
            readyTaxi.setPassengerId(idGenerator++);
            readyTaxi.setDropLocation(drop);
            readyTaxi.setDropTiming(timing+Math.abs(drop-pickup));
            readyTaxi.setPickupLocation(pickup);
            readyTaxi.setPickupTiming(timing);
            readyTaxi.setCurrentLocation(drop);
            readyTaxi.setTaxiNo(taxi.indexOf(readyTaxi)+1001);
            readyTaxi.setEarning(readyTaxi.getEarning()+Math.abs(drop-pickup)*(100+(10*10)));
            history.add((TaxiDetails) readyTaxi.clone());
        }
        return readyTaxi!=null?"Taxi Number : "+readyTaxi.getTaxiNo()+" is booked.":"Taxi not available";
    }
    public static void history(){
        for (TaxiDetails t:taxi){
            System.out.println(t.toString());
            System.out.println("----------------------");
        }
    }
    //Done
}
