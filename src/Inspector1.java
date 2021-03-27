public class Inspector1 extends Inspector{

    private final double lambda = 0.09654;

    /**
     * creates new component and returns its completion time
     * @return
     */
    @Override
    public double getFinishTime() {
        this.component = new Component(Component.componentType.ONE);
        double r = rng.getRN();
        double x = (-1/lambda)*Math.log(r);
        return x;
    }

    /**
     * Select which workstation queue to add component 1 too
     * @param w1
     * @param w2
     * @param w3
     * @return
     */
    public boolean selectWorkStation(WorkStation1 w1, WorkStation2 w2, WorkStation3 w3){
        int w1Queue = w1.getQueue1().size();
        int w2Queue = w2.getQueue1().size();
        int w3Queue = w3.getQueue1().size();
        if(w1Queue==2 && w2Queue==2 && w3Queue==2) return false;
        else if(w3Queue < w1Queue && w3Queue < w2Queue){
            w3.getQueue1().add(component);
            System.out.println("Add component 1 to W3");
            return true;
        }
        else if(w2Queue < w1Queue){
            w2.getQueue1().add(component);
            System.out.println("Add component 1 to W2");
            return true;
        }
        else{
            w1.getQueue1().add(component);
            System.out.println("Add component 1 to W1");
            return true;
        }
    }
}
