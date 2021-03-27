import RNG.CLCG;

public class Inspector2 extends Inspector{

    private final double lambda2 = 0.06436;
    private final double lambda3 = 0.04846;
    private CLCG componentGenerator;

    public Inspector2(){
        componentGenerator = new CLCG();
    }


    @Override
    public double getFinishTime() {
        nextComponent();
        if(component.getCType()== Component.componentType.TWO){
            double r = rng.getRN();
            double x = (-1/lambda2)*Math.log(r);
            return x;
        }
        else if(component.getCType()== Component.componentType.THREE){
            double r = rng.getRN();
            double x = (-1/lambda3)*Math.log(r);
            return x;
        }
        return 0;
    }

    private void nextComponent(){
        double r = componentGenerator.getRN();

        if(r>0.5) this.component = new Component(Component.componentType.TWO);
        else this.component  = new Component(Component.componentType.THREE);

    }

    /**
     * if component 2, try to add to workstation 2
     * if component 3, try to add to workstation 3
     * @param w1
     * @param w2
     * @param w3
     * @return
     */
    @Override
    public boolean selectWorkStation(WorkStation1 w1, WorkStation2 w2, WorkStation3 w3) {
        if(component.getCType()== Component.componentType.TWO){
            if(w2.getQueue2().size()==2) return false;
            else{
                w2.getQueue2().add(component);
                System.out.println("Add component 2 to W2");
                return true;
            }
        }
        else if(component.getCType()== Component.componentType.THREE){
            if(w3.getQueue3().size()==2)return false;
            else{
                w3.getQueue3().add(component);
                System.out.println("Add component 3 to W3");
                return true;
            }
        }
        return false;
    }
}
