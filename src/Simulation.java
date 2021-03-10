import java.util.*;

public class Simulation {
    public Inspector1 inspector1;
    public Inspector2 inspector2;
    public WorkStation1 workStation1;
    public WorkStation2 workStation2;
    public WorkStation3 workStation3;
    public Queue<Event> FEL;
    public List<Product> output;
    public double currentTime;

    public Simulation() {
        this.inspector1 = new Inspector1(1, new String[]{"resources/DataFiles/servinsp1.dat"});
        this.inspector2 = new Inspector2(2, new String[]{"resources/DataFiles/servinsp22.dat", "resources/DataFiles/servinsp23.dat"});

        this.workStation1 = new WorkStation1(1, new String[]{"resources/DataFiles/ws1.dat"});
        this.workStation2 = new WorkStation2(2, new String[]{"resources/DataFiles/ws2.dat", "resources/DataFiles/ws3.dat"});
        this.workStation3 = new WorkStation3(3, new String[]{"resources/DataFiles/ws2.dat", "resources/DataFiles/ws3.dat"});

    }

    public void StartSimulation(){

    }

    public static void main(String[] args) {
        Simulation simulation = new Simulation();

    }

    public boolean inspectionDone() {
        return true;
    }

    public boolean productComplete() {
        return true;
    }



    public Event getNextEvent(){
        return  new Event();
    }

}
