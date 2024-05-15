import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FLoadGameConfig implements GameConfig {

    private int id;
    private String name;
    private int version;

    /**
     * Constructor for objects of class LoadGameConfig
     */
    public FLoadGameConfig() {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(System.getProperty("user.dir") + "/config/GameConfig.txt"))) {
            String line;
            if ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                id = Integer.parseInt(parts[0]);
                name = parts[1];
                version = Integer.parseInt(parts[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object getGameConfig() {
        return new GameConfigImpl(id, name, version);
    }

    private class GameConfigImpl implements GameConfig {
        private int id;
        private String name;
        private int version;

        public GameConfigImpl(int id, String name, int version) {
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

        public int getVersion() {
            return version;
        }

        public Object getGameConfig() {
            return new GameConfigImpl(id, name, version);
        }
    }
}
