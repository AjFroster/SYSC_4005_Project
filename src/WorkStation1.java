import RNG.CLCG;
import java.lang.Math;
import java.util.LinkedList;
import java.util.Queue;

public class WorkStation1 extends WorkStation{

    private final double lambda = 0.217183;
    private Queue<Component> queue1;


    public WorkStation1 (){
        super();
        queue1 = new LinkedList<Component>();
    }

    @Override
    public Event produce(double clock) {
        if(queue1.size()==2 && state == states.IDLE){
            totalIdleTime += clock - idleStart;
            state = states.WORKING;
            double duration = getFinishTime();
            double completeTime = clock + duration;
            queue1.poll();
            queue1.poll();
            System.out.println("Workstation1 Event Added: Duration " + duration + ", CompleteTime " + completeTime);
            return new Event(this, completeTime);
        }
        else{
            if(queue1.size()<2) {
                state = states.IDLE;
                idleStart = clock;
            }
            return null;
        }
    }

    @Override
    public double getFinishTime() {
        double r = rng.getRN();
        double x = (-1/lambda)*Math.log(r);
        return x;
    }

    public Queue<Component> getQueue1() {
        return queue1;
    }
}
