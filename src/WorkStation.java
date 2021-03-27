import java.util.*;
import RNG.CLCG;

public abstract class  WorkStation extends EventEntity {

    public enum states {WORKING, IDLE};


    protected states state;
    protected double totalIdleTime;
    protected Product product;
    protected double idleStart;


    public WorkStation(){

    }

    abstract Event produce(double clock);

    public states getState() {
        return state;
    }

     public double getTotalIdleTime(){
        return totalIdleTime;
     }



}
