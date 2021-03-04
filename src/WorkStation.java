import java.util.*;

public class WorkStation extends EventEntity{
    private Queue<Component> queue1;
    private enum state {Working, Idle};
    private int priority;
    private double totalIdleTime;
    private int productType;

    public WorkStation() {
    }
}
