public class Inspector extends EventEntity {

    public int id;
    public Component currentComponent;
    public static enum states {BLOCKED, INSPECTING, WAITING};
    private double totalTimeIdle;



    public Inspector(int id, String[] inputFiles) {
        super(inputFiles);
        this.id = id;

        //inspectComponent();
        //selectWorkStation();
    }
}
