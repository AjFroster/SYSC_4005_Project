import java.util.*;

public class WorkStation3 extends WorkStation{

    private final double lambda = 0.113693;
    private Queue<Component> queue1;
    private Queue<Component> queue3;

    public WorkStation3 (){
        super();
    }

    @Override
    Event produce(double clock) {
        return null;
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
    public Queue<Component> getQueue3() {
        return queue3;
    }
}
