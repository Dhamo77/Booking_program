import java.util.Objects;

public class TrainCancel extends TrainBooking {
    private static char preferencefTrack='\0';
    private static int seatNumberTrack=0;
    public static void cancelling(int id){
        for (TrainPassenger p:confirmedList){
            if (p.getId()==id){
                cancel(p);
                break;
            }
        }
        for (TrainPassenger p:racList){
            if (p.getId()==id){
                cancel(p);
                break;
            }
        }
        for (TrainPassenger p:waitingList){
            if (p.getId()==id){
                cancel(p);
                break;
            }
        }
    }

    private static void cancel(TrainPassenger p) {
        if (Objects.equals(p.getTicket_type(), "Berth")){
            preferencefTrack=p.getPreference();
            seatNumberTrack=p.getSeat_no();
            remove(p);
            if (!racList.isEmpty()){
                TrainPassenger np=racList.poll();
                np.setPreference(preferencefTrack);
                TrainBooking.booking(np);
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
    private static void remove(TrainPassenger p) {
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
