import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoadGameConfig implements GameConfig {

    private int id;
    private String name;
    private Date version;


    /**
     * Constructor for objects of class LoadGameConfig
     */
    public LoadGameConfig() {
        try (BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") +"/config/GameConfig.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
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

        @SuppressWarnings("unused")
        public int getId() {
            return id;
        }
        @SuppressWarnings("unused")
        public String getName() {
            return name;
        }
        @SuppressWarnings("unused")
        public Date getversion() {
            return version;
        }
        @SuppressWarnings("unused")
        public Object getGameConfig() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getGameConfig'");
        }
    }
}
