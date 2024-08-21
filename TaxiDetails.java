public class TaxiDetails implements Cloneable {
    private char currentLocation ='A';
    private int taxiNo;
    private int passengerId;
    private int pickupLocation;
    private int dropLocation;
    private int pickupTiming;
    private int dropTiming;
    private double earning;

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public double getEarning() {
        return earning;
    }

    public void setEarning(double earning) {
        this.earning = earning;
    }

    public char getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(char currentLocation) {
        this.currentLocation = currentLocation;
    }

    public int getTaxiNo() {
        return taxiNo;
    }

    public void setTaxiNo(int taxiNo) {
        this.taxiNo = taxiNo;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public int getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(int pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public int getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(int dropLocation) {
        this.dropLocation = dropLocation;
    }

    public int getPickupTiming() {
        return pickupTiming;
    }

    public void setPickupTiming(int pickupTiming) {
        this.pickupTiming = pickupTiming;
    }

    public int getDropTiming() {
        return dropTiming;
    }

    public void setDropTiming(int dropTiming) {
        this.dropTiming = dropTiming;
    }

    @Override
    public String toString() {
        return  "TaxiNo         :" + taxiNo +"\n"+
                "PassengerId    :" + passengerId +"\n"+
                "PickupLocation :" + pickupLocation +"\n"+
                "DropLocation   :" + dropLocation +"\n"+
                "PickupTiming   :" + pickupTiming +"\n"+
                "DropTiming     :" + dropTiming+"\n"+
                "Total Earning  :"+earning;

    }
}
