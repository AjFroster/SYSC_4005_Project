import java.util.*;

public class EventEntity {
    public int id;
    public String[] filenames;
    public ArrayList<ArrayList<Float>> fileData;



    public EventEntity(String[] filenames) {
        parseFiles();
    }

    public void parseFiles(){
        fileData = new ArrayList<ArrayList<Float>>();

        for(int i = 0; i < filenames.length; i++){
            List<Float> values = new ArrayList<>();
            String file = filenames[i];
        }
    }
}
