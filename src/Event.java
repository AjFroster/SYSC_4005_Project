

public class Event {
    private double completeTime;
    public enum eventType {InspectDone, ProductDone};
    private eventType eType;
    private EventEntity source;

    public Event(EventEntity ee, double ct){
        this.source = ee;
        this.completeTime = ct;
        if(ee instanceof WorkStation){
            this.eType = eventType.ProductDone;
        }
        else if(ee instanceof Inspector){
            this.eType = eventType.InspectDone;
        }
    }

    public double getCompleteTime(){
        return completeTime;
    }

    public eventType getEType(){
        return eType;
    }

    public EventEntity getSource(){
        return source;
    }
}
