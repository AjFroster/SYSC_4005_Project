import RNG.CLCG;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public abstract class EventEntity {
    public int id;
    protected CLCG rng;

    public EventEntity(){
        rng = new CLCG();
    }

    abstract public double getFinishTime();


}
