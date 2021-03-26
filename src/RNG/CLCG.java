package RNG;

public class CLCG {
    private LCM X1;
    private LCM X2;
    private LCM X3;

    public CLCG(){
        X1 = new LCM();
        X2 = new LCM();
        X3 = new LCM();
    }

    public double getRN(){
        double rn;
        long x = Math.abs((X1.getX()-X2.getX()+X3.getX()) % (X1.getM()-1));
        //System.out.println(x + " = " + X1.getX() + " - " + X2.getX() + " + " + X3.getX() + " mod " + (X1.getM()-1));
        if(x>0) {
             rn = (double) x/X1.getM();
        }
        else{
            rn = (double) (X1.getM()-1)/X1.getM();
        }
        X1.nextX();
        X2.nextX();
        X3.nextX();
        return rn;
    }
    public LCM getX1() {
        return X1;
    }

    public LCM getX2() {
        return X2;
    }

    public LCM getX3() {
        return X3;
    }
}
