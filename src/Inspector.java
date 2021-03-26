import RNG.CLCG;

public abstract class Inspector extends EventEntity {

    public int id;
    public enum states {BLOCKED, INSPECTING};
    private states state;
    private double totalTimeIdle;
    private double blockStart;
    protected Component component;


    /**
     * Takes sim clock finds next completion time
     * In getFinishTime, the specific inspector will create a new component to inspect
     * If was previously blocked will add to total idle time
     * @param clock
     * @return
     */
    public Event inspect(double clock){
        if(state == states.BLOCKED){
            totalTimeIdle += clock - blockStart;
        }
        state = states.INSPECTING;
        double completeTime = clock+getFinishTime();
        return new Event(this, completeTime);
    }

    /**
     * sets block start to sim clock
     * sets state to blocked
     * @param clock
     */
    public void idle(double clock){
        blockStart = clock;
        state = states.BLOCKED;
    }

    abstract boolean selectWorkStation(WorkStation1 w1, WorkStation2 w2, WorkStation3 w3);


}
