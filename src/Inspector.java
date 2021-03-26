import RNG.CLCG;

public abstract class Inspector extends EventEntity {

    public int id;
    public Component currentComponent;
    public static enum states {BLOCKED, INSPECTING, WAITING};
    private double totalTimeIdle;


}
