import java.util.*;

public class WorkStation2 extends WorkStation{

    private final double lambda = 0.09015;
    private Queue<Component> queue1;
    private Queue<Component> queue2;

    public WorkStation2 (){
        super();
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    @Override
    Event produce(double clock) {
        if(queue1.size()>=1 && queue2.size()>=1 && state == states.IDLE){
            totalIdleTime += clock - idleStart;
            state = states.WORKING;
            double duration = getFinishTime();
            double completeTime = clock + duration;
            queue1.poll();
            queue2.poll();
            System.out.println("Workstation2 Event Added: Duration " + duration + ", CompleteTime " + completeTime);
            return new Event(this, completeTime);
        }
        else{
            if(queue1.size()<1 && queue2.size()<1){
                state = states.IDLE;
                idleStart=clock;
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
    public Queue<Component> getQueue2() {
        return queue2;
    }
}
