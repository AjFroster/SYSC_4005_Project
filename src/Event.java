

public class Event {
    private double completeTime;
    private enum eventType {InspectDone, ProductDone};
    private EventEntity source;

    public Event(double ct){
        this.completeTime = ct;
    }

    public double getCompleteTime(){
        return completeTime;
    }
}
