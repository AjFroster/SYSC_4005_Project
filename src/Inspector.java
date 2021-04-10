import RNG.CLCG;
import java.io.*;
import java.util.ArrayList;

public abstract class Inspector extends EventEntity {

    public int id;
    public enum states {BLOCKED, INSPECTING};
    private states state;
    private double totalTimeIdle;
    private double blockStart;
    protected Component component;
    public ArrayList<String> idle1Ouput;
    public ArrayList<String> idle2Ouput;
    public ArrayList<Double> idle2Average; //after 25000 minutes

    public Inspector(){
        super();
        idle1Ouput = new ArrayList<String>();
        idle2Ouput = new ArrayList<String>();
        idle2Average = new ArrayList<Double>();
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
            if (component.getCType() == Component.componentType.ONE) {
                idle1Ouput.add(clock+","+totalTimeIdle);
            }
            else{
                idle2Ouput.add(clock+","+totalTimeIdle);
                if(clock > 25000){
                    idle2Average.add(totalTimeIdle/clock);
                }
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
