import java.util.*;
import RNG.*;

public class Simulation {
    public Inspector1 inspector1;
    public Inspector2 inspector2;
    public WorkStation1 workStation1;
    public WorkStation2 workStation2;
    public WorkStation3 workStation3;
    public PriorityQueue<Event> FEL;
    public List<Product> output;
    public double currentTime;

    public Simulation() {
        FEL = new PriorityQueue<Event>(new EventComparator());
    }

    public void StartSimulation(){

    }

    public static void main(String[] args) {
        /*
        WorkStation ws1 = new WorkStation1();
        Inspector isp1 = new Inspector1();
        for(int i =0; i<10; i++){
            System.out.println("WS1: " + ws1.getFinishTime());
            System.out.println("ISP1: " + isp1.getFinishTime());
        }

        CLCG test = new CLCG();
        System.out.println("X1(a,m,c): " + test.getX1().getA()+ ", "+test.getX1().getM()+ ", "+test.getX1().getC());
        System.out.println("X2(a,m,c): " + test.getX2().getA()+ ", "+test.getX2().getM()+ ", "+test.getX2().getC());
        System.out.println("X3(a,m,c): " + test.getX3().getA()+ ", "+test.getX3().getM()+ ", "+test.getX3().getC());
        for(int i =0; i<10; i++){
            System.out.println("R: " + test.getRN());
        }
         */

    }

    public boolean inspectionDone() {
        return true;
    }

    public boolean productComplete() {
        return true;
    }



    public Event getNextEvent(){
        return null;
    }

    class EventComparator implements Comparator<Event>{

        @Override
        public int compare(Event e1, Event e2) {
            if(e1.getCompleteTime() < e2.getCompleteTime()) return -1;
            else if (e1.getCompleteTime() > e2.getCompleteTime()) return 1;
            else return 0;
        }
    }

}
