import java.io.*;
import java.lang.reflect.Array;
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

    public void StartSimulation() throws IOException {
        //System.out.println("-------Simulation Start--------");
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
        //run this code to start their idle time
        workStation1.produce(currentTime);
        workStation2.produce(currentTime);
        workStation3.produce(currentTime);

        while(currentTime < 100000.0){
            Event nextE = getNextEvent();
            if(nextE.getEType() == Event.eventType.InspectDone){
                inspectionDone((Inspector) nextE.getSource());
            }
            else if(nextE.getEType() == Event.eventType.ProductDone){
                productComplete((WorkStation) nextE.getSource());
            }

        }

        try(FileWriter avgWriter = new FileWriter("resources/avgOutput.csv", true)){
            double productCount=0.0;
            for(Product p: output){
                //GetTotal
                if(p.getCompletionTime() > 25000){
                    productCount++;
                }
            }
            avgWriter.append(productCount/75000.0+"\n");
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }

        try(FileWriter avgIdle2 = new FileWriter("resources/avgInsp2.csv", true)){
            double sum=0.0;
            for(double d: inspector2.idle2Average){
                sum+=d;
            }
            avgIdle2.append(sum/inspector2.idle2Average.size()+"\n");
        }

        /*
        System.out.println("--------SIMULATION COMPLETE-------");
        System.out.println("Inspector 1 idle time: " + inspector1.getTotalTimeIdle());
        System.out.println("Inspector 2 idle time: " + inspector2.getTotalTimeIdle());
        System.out.println("Workstation 1 idle time: " + workStation1.getTotalIdleTime());
        System.out.println("Workstation 2 idle time: " + workStation2.getTotalIdleTime());
        System.out.println("Workstation 3 idle time: " + workStation3.getTotalIdleTime());
        System.out.println("Product made:" + output.size());
        */
    }



    public boolean inspectionDone(Inspector i) {
        //System.out.println("Event InspectionComplete! Type " + i.getComponent().getCType() + " at " + currentTime);
        if(i.selectWorkStation(workStation1, workStation2, workStation3)){
            //Run produce, if it can start produce will return a new event Otherwise return null
            Event e1 = workStation1.produce(currentTime);
            Event e2 = workStation2.produce(currentTime);
            Event e3 = workStation3.produce(currentTime);
            if(e1 != null) FEL.add(e1);
            if(e2 != null) FEL.add(e2);
            if(e3 != null) FEL.add(e3);
            FEL.add(i.inspect(currentTime));
            return true;
        }
        else{
            i.idle(currentTime);
            return false;
        }
    }

    public boolean productComplete(WorkStation ws) {
        ws.state = WorkStation.states.IDLE;
        if(ws.equals(workStation1)){
            //System.out.println("Event Product! Type 1 at " + currentTime);
            output.add(new Product(Product.productType.ONE, currentTime));
            Event e1 = workStation1.produce(currentTime);
            if(e1!=null) FEL.add(e1);
            if(inspector1.getState() == Inspector.states.BLOCKED){
                workStation1.getQueue1().add(inspector1.getComponent());
                FEL.add(inspector1.inspect(currentTime));
            }
            return true;
        }
        else if(ws.equals(workStation2)){
            //System.out.println("Event Product! Type 2 at " + currentTime);
            output.add(new Product(Product.productType.TWO, currentTime));
            Event e2 = workStation2.produce(currentTime);
            if(e2 != null) FEL.add(e2);
            if(inspector1.getState() == Inspector.states.BLOCKED){
                workStation2.getQueue1().add(inspector1.getComponent());
                FEL.add(inspector1.inspect(currentTime));
            }
            if(inspector2.getState() == Inspector.states.BLOCKED
                    && inspector2.getComponent().getCType() == Component.componentType.TWO){
                workStation2.getQueue2().add(inspector2.getComponent());
                FEL.add(inspector2.inspect(currentTime));
            }
            return true;
        }
        else if(ws.equals(workStation3)){
            //System.out.println("Event Product! Type 3 at " + currentTime);
            output.add(new Product(Product.productType.THREE, currentTime));
            Event e3 = workStation3.produce(currentTime);
            if(e3 != null) FEL.add(e3);
            if(inspector1.getState() == Inspector.states.BLOCKED){
                workStation3.getQueue1().add(inspector1.getComponent());
                FEL.add(inspector1.inspect(currentTime));
            }
            if(inspector2.getState() == Inspector.states.BLOCKED
                    && inspector2.getComponent().getCType() == Component.componentType.THREE){
                workStation3.getQueue3().add(inspector2.getComponent());
                FEL.add(inspector2.inspect(currentTime));
            }
            return true;
        }
        return false;
    }

    public Event getNextEvent(){
        Event next = FEL.poll();
        currentTime = next.getCompleteTime();
        return next;
    }
    public static void main(String[] args) throws IOException {
        for(int i=0; i<1000; i++) {
            Simulation sim = new Simulation();
            sim.StartSimulation();
        }
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
