import java.util.*;

public class Simulation {
    public EventEntity inspector1, inspector2;
    public EventEntity workStation1, workStation2, workStation3;
    public Queue<Event> FEL;
    public List<Product> output;
    public double currentTime;

    public Simulation(){
        this.inspector1 = new Inspector1();
        this.inspector2 = new Inspector2();

        this.workStation1 = new WorkStation1();
        this.workStation2 = new WorkStation2();
        this.workStation3 = new WorkStation3();

    }

    public static void main(String[] args){

    }
}
