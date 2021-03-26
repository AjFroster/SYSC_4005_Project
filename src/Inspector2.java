import RNG.CLCG;

public class Inspector2 extends Inspector{

    private final double lambda2 = 0.06436;
    private final double lambda3 = 0.04846;
    private int currentComponent;
    private CLCG componentGenerator;

    public Inspector2(){
        componentGenerator = new CLCG();
    }


    @Override
    public double getFinishTime() {
        if(currentComponent==2){
            double r = rng.getRN();
            double x = (-1/lambda2)*Math.log(r);
            return x;
        }
        else if(currentComponent==3){
            double r = rng.getRN();
            double x = (-1/lambda3)*Math.log(r);
            return x;
        }
        return 0;
    }

    private void nextComponent(){
        double r = componentGenerator.getRN();

        if(r>0.5) currentComponent=2;
        else currentComponent=3;

    }
}
