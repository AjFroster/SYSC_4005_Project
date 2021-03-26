public class Component {
    public enum componentType{ONE, TWO, THREE}
    private componentType cType;
    private enum eventType {Inspected, WorkstationQueue, Product};

    public Component(componentType cType) {
        this.cType = cType;
    }

    public componentType getCType() {
        return cType;
    }

}
