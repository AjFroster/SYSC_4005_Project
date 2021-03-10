import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class EventEntity {
    public int id;
    public String[] inputFiles;
    public ArrayList<ArrayList<Float>> fileData;



    public EventEntity(String[] inputFiles) {
        this.inputFiles = inputFiles;
        parseFiles();
    }

    public void parseFiles(){

        fileData = new ArrayList<ArrayList<Float>>();

        for(int i = 0; i < inputFiles.length; i++){
            ArrayList<Float> values = new ArrayList<>();
            String file = inputFiles[i];
            BufferedReader reader;

            try{
                reader = new BufferedReader(new FileReader(file));
                String line = reader.readLine();
                while (line != null ){
                    //System.out.println(line +":");
                    if(line.equals("")){
                        break;
                    }
                    values.add(Float.parseFloat(line));
                    line = reader.readLine();
                }
                fileData.add(values);
            }
            catch (IOException e){
                e.printStackTrace();
                System.out.println("Can't Read Input File: " + file);
            }
            System.out.println("File Data Added: "+ file);
        }

    }
}
