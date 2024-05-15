import greenfoot.*;

public class LargeElement extends Actor {
    public LargeElement(Color color, int with , int height) {
        // Setze die Größe und das Aussehen des LargeElements
        GreenfootImage image = new GreenfootImage(with, height); // Hier kannst du die Breite und Höhe entsprechend anpassen
        image.setColor(color); // Setze die Farbe des Elements (hier Blau als Beispiel)
        image.fill(); // Fülle das Bild mit der Farbe
        setImage(image); // Setze das Bild als Aussehen des LargeElements
    }
}
