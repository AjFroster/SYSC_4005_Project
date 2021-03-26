public class Inspector1 extends Inspector{

    private final double lambda = 0.09654;

    @Override
    public double getFinishTime() {
        double r = rng.getRN();
        double x = (-1/lambda)*Math.log(r);
        return x;
    }
}
