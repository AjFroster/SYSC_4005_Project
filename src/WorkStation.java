import java.util.*;



public class WorkStation extends EventEntity {

    private int id;
    private Queue<Component> queue1;
    private enum states {WORKING, IDLE};
    private Enum state;
    private int priority;
    private double totalIdleTime;
    private int productType;

    public WorkStation(int id, String[] inputFiles) {
        super(inputFiles);
        this.id = id;

        //produceProduct();
    }
    public void produceProduct(){

    }

}
