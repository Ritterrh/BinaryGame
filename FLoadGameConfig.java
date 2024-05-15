import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FLoadGameConfig implements GameConfig {

    private int id;
    private String name;
    private Date version;

    /**
     * Constructor for objects of class LoadGameConfig
     */
    public FLoadGameConfig() {
        try (BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") +"/config/GameConfig.txt"))) {
            String line;
            if ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                id = Integer.parseInt(parts[0]);
                name = parts[1];
                version = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(parts[2]);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public Object getGameConfig() {
        return new GameConfigImpl(id, name, version);
    }

    private class GameConfigImpl implements GameConfig {
        private int id;
        private String name;
        private Date version;

        public GameConfigImpl(int id, String name, Date version) {
            this.id = id;
            this.name = name;
            this.version = version;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Date getVersion() {
            return version;
        }

        public Object getGameConfig() {
            return this;
        }
    }
}
