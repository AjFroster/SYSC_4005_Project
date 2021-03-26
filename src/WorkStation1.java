import RNG.CLCG;
import java.lang.Math;
import java.util.Queue;

public class WorkStation1 extends WorkStation{

    private final double lambda = 0.217183;
    private Queue<Component> queue1;


    public WorkStation1 (){
        super();
    }

    @Override
    public Event produce(double clock) {
        if(queue1.size()==2 && state == states.IDLE){
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
}
