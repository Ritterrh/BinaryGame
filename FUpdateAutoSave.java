import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;



import greenfoot.Greenfoot;

/**
 * Write a description of class UpdateGameState here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class FUpdateAutoSave {

    /**
     * Constructor for objects of class UpdateGameState
     */
    //TODO: Id auto increment int id,
    public FUpdateAutoSave(String name,  int level, int points) {
        try (BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") +"/save/GameSave.txt"))) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(System.getProperty("user.dir") +"/save/GameSave.txt", true));
            String line;
            boolean isEmpty = true;

            // Überprüfe, ob die Datei leer ist oder nicht
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    isEmpty = false;
                    break;
                }
            }

            // Füge eine neue Zeile ein, falls die Datei nicht leer ist
            if (!isEmpty) {
                writer.newLine();
            }

            Instant date = Instant.now();

            String gameStateString = name + "," + date + "," + level + "," + points;
            writer.write(gameStateString);

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
