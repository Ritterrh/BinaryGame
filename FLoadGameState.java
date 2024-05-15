import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FLoadGameState {

    //TODO: Id laden
   // private int id;
    private String name;
    private Date lastSave;
    private int level;
    private int points;

    /**
     * Constructor for objects of class LoadGameState
     */
    public FLoadGameState() {
        try (BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/save/GameSave.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
               // id = Integer.parseInt(parts[0]);
                name = parts[0];
             //     System.out.println(name);
                lastSave = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(parts[1]);
              //    System.out.println(lastSave);
                level = Integer.parseInt(parts[2]);
             //     System.out.println(level);
                points = Integer.parseInt(parts[3]);
            //      System.out.println(points);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    // public int getId() {
    //    return id;
   // }

    public String getName() {
        return this.name;
    }

    public Date getLastSave() {
        return this.lastSave;
    }

    public int getLevel() {
        return this.level;
    }

    public int getPoints() {
        return this.points;
    }
}
