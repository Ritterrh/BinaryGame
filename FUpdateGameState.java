import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import greenfoot.Greenfoot;

/**
 * Write a description of class UpdateGameState here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class FUpdateGameState {

    /**
     * Constructor for objects of class UpdateGameState
     */
    //TODO: Id auto increment int id,
    public FUpdateGameState(String name, LocalDate lastSave, int level, int points) {
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

            // Convert LocalDate to Date
            Date date = java.sql.Date.valueOf(lastSave);

            // Schreibe den neuen Spielstandseintrag
            String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
            String gameStateString = name + "," + formattedDate + "," + level + "," + points;
            writer.write(gameStateString);

            writer.close();
            Greenfoot.setWorld(new WStartWelt());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
