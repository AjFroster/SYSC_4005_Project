import java.awt.Component;
import java.util.*;

public class WorkStation2 extends WorkStation{

    private final double lambda = 0.09015;

    public WorkStation2 (){
        super();
    }

    @Override
    public double getFinishTime() {
        double r = rng.getRN();
        double x = (-1/lambda)*Math.log(r);
        return x;
    }
}
