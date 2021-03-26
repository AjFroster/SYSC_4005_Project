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
        currentTime=0.0;
        output = new ArrayList<Product>();
        inspector1 = new Inspector1();
        inspector2 = new Inspector2();
        workStation1 = new WorkStation1();
        workStation2 = new WorkStation2();
        workStation3 = new WorkStation3();
        FEL = new PriorityQueue<Event>(new EventComparator());
        FEL.add(inspector1.inspect(currentTime));
        FEL.add(inspector2.inspect(currentTime));

        while(currentTime < 120.0){
            Event nextE = getNextEvent();
            if(nextE.getEType() == Event.eventType.InspectDone){
                inspectionDone((Inspector) nextE.getSource());
            }
            else if(getNextEvent().getEType() == Event.eventType.ProductDone){

            }

        }
    }

    public boolean inspectionDone(Inspector i) {
        if(i.selectWorkStation(workStation1, workStation2, workStation3)){
            //Run produce, if it can start produce will return a new event Otherwise return null
            Event e1 = workStation1.produce(currentTime);
            Event e2 = workStation2.produce(currentTime);
            Event e3 = workStation3.produce(currentTime);
            if(e1 != null) FEL.add(e1);
            if(e2 != null) FEL.add(e2);
            if(e3 != null) FEL.add(e3);
            FEL.add(i.inspect(currentTime));
        }
        else{
            i.idle(currentTime);
        }
        return true;
    }

    public boolean productComplete() {
        return true;
    }

    public Event getNextEvent(){
        return FEL.poll();
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


    class EventComparator implements Comparator<Event>{
        @Override
        public int compare(Event e1, Event e2) {
            if(e1.getCompleteTime() < e2.getCompleteTime()) return -1;
            else if (e1.getCompleteTime() > e2.getCompleteTime()) return 1;
            else return 0;
        }
    }

}
