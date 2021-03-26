import RNG.CLCG;
import java.lang.Math;

public class WorkStation1 extends WorkStation{

    private final double lambda = 0.217183;

    public WorkStation1 (){
        super();
    }

    @Override
    public double getFinishTime() {
        double r = rng.getRN();
        double x = (-1/lambda)*Math.log(r);
        return x;
    }
}
