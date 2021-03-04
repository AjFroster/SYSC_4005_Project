public class Component {
    private int componentType;
    private enum eventType {Inspected, WorkstationQueue, Product};

    public Component(int componentType) {
        this.componentType = componentType;
    }
    public int getComponentType() {
        return componentType;
    }

}
