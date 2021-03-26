import java.util.*;

public class WorkStation2 extends WorkStation{

    private final double lambda = 0.09015;
    private Queue<Component> queue1;
    private Queue<Component> queue2;

    public WorkStation2 (){
        super();
    }

    @Override
    Event produce(double clock) {
        if(queue1.size()>=1 && queue2.size()>=1 && state == states.IDLE){
            state = states.WORKING;
            double completeTime = clock + getFinishTime();
            return new Event(this, completeTime);
        }
        else{
            if(queue1.size()<2) state = states.IDLE;
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
