package RNG;

import java.util.Random;
import java.lang.Math;


public class LCM {
    private long a;
    private long m;
    private long c;
    private long X;

    public long getA() {
        return a;
    }
    public long getM() {
        return m;
    }
    public long getC() {
        return c;
    }

    public long getX(){
        return X;
    }

    private Random rnd;

    public LCM(){
        rnd = new Random();
        m = (long)Math.pow(2, rnd.nextInt(12)+20);
        c=m-1;
        a = 1+(4*rnd.nextInt(5000)+1000);
        try {
            X = rnd.nextInt((int) m - 2) + 1;
        }
        catch(Exception e){
            System.out.println("Failure!!!" + m);
        }
    }

    public long nextX(){
        X=((a*X)+c) % m;
        return X;
    }

}
