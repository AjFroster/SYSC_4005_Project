import RNG.CLCG;
import java.io.*;

public abstract class Inspector extends EventEntity {

    public int id;
    public enum states {BLOCKED, INSPECTING};
    private states state;
    private double totalTimeIdle;
    private double blockStart;
    protected Component component;
    private FileWriter writer1;
    private FileWriter writer2;

    public Inspector(){
        super();
        try{
            writer1 = new FileWriter("resources/insp1.csv");
            writer2 = new FileWriter("resources/insp2.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Takes sim clock finds next completion time
     * In getFinishTime, the specific inspector will create a new component to inspect
     * If was previously blocked will add to total idle time
     * @param clock
     * @return
     */
    public Event inspect(double clock){
        double duration = getFinishTime();
        double completeTime = clock+duration;
        System.out.println("Inspection" + component.getCType() + " Event Added: Duration " + duration + ", CompleteTime " + completeTime);
        if(state == states.BLOCKED){
            totalTimeIdle += clock - blockStart;
            try {
                if (component.getCType() == Component.componentType.ONE) {
                    writer1.write(clock + "," + totalTimeIdle + "\n");
                }
                else writer2.write(clock + "," + totalTimeIdle + "\n");
            }
            catch (IOException e){
                System.out.println(e);
            }
        }
        state = states.INSPECTING;
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

    public states getState(){
        return state;
    }
    public Component getComponent(){
        return this.component;
    }

    public double getTotalTimeIdle(){
        return totalTimeIdle;
    }

    abstract boolean selectWorkStation(WorkStation1 w1, WorkStation2 w2, WorkStation3 w3);


}
