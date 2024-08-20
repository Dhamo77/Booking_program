import java.util.Objects;

public class Cancel extends Booking {
    private static char preferencefTrack='\0';
    private static int seatNumberTrack=0;
    public static void cancelling(int id){
        for (Passenger p:confirmedList){
            if (p.getId()==id){
                cancel(p);
                break;
            }
        }
        for (Passenger p:racList){
            if (p.getId()==id){
                cancel(p);
                break;
            }
        }
        for (Passenger p:waitingList){
            if (p.getId()==id){
                cancel(p);
                break;
            }
        }
    }

    private static void cancel(Passenger p) {
        if (Objects.equals(p.getTicket_type(), "Berth")){
            preferencefTrack=p.getPreference();
            seatNumberTrack=p.getSeat_no();
            remove(p);
            if (!racList.isEmpty()){
                Passenger np=racList.poll();
                np.setPreference(preferencefTrack);
                Booking.booking(np);
                np.setSeat_no(seatNumberTrack);
            }
            if (!waitingList.isEmpty()){
               racList.add(waitingList.poll());
            }
        } else if (Objects.equals(p.getTicket_type(), "RAC")) {
            racList.remove(p);
            if (!waitingList.isEmpty()){
                racList.add(waitingList.poll());
            }
        }else {
            waitingList.remove(p);
        }
    }
    private static void remove(Passenger p) {
        if (p.getPreference()=='M'){
            middleList.remove(p);
        }else if (p.getPreference()=='L'){
            lowerList.remove(p);
        }
        else {
            upperList.remove(p);
        }
        confirmedList.remove(p);
    }
}
