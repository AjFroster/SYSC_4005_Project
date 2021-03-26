import java.util.*;
import RNG.CLCG;

public abstract class  WorkStation extends EventEntity {

    private Queue<Component> queue1;
    private enum states {WORKING, IDLE};
    private Enum state;
    private int priority;
    private double totalIdleTime;
    private int productType;


    public WorkStation(){

    }


}
