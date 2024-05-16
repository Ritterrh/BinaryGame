import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import greenfoot.*;

public class WGameModeTow extends World {
    private FMessage leveltext = new FMessage();
    private FMessage pointstext = new FMessage();
    private BSaveButton sbutton = new BSaveButton();
    private BPauseButton button = new BPauseButton();
    private BEndGameButton ebutton = new BEndGameButton();
    FGameModManger gameManager = FGameModManger.getInstance();

    private String level;
    private String points;
    private int decimalNumber;
    private List<List<Integer>> binaryRows = new ArrayList<>();

    public WGameModeTow() {
        super(36, 27, 33);
        loadLevel();
        loadGameMode();
    }

    public void act() {
        leveltext.showText("Deine Level: " + gameManager.getLevel(), this, 1010, 10, 24, null, Color.WHITE);
        pointstext.showText("Deine Punkte: " + gameManager.getPoints(), this, 1010, 40, 24, null, Color.WHITE);
        // Check for correct input and call right() method if a row is correct
        for (int rowIndex = 0; rowIndex < binaryRows.size(); rowIndex++) {
            List<Integer> row = binaryRows.get(rowIndex);
            int[] decimalArray = calculateDecimalForAllRows();
            if (checkUserInputGameModeTow(decimalArray[rowIndex], rowIndex)) {
                right(rowIndex);
            }
        }
    }

    private void loadLevel() {
        addObject(button, 33, 23);
        addObject(ebutton, 33, 25);
        addObject(sbutton, 33, 21);
    }

    private void loadGameMode() {
        Random rand = new Random();
    
        for (int row = 0; row < 8; row++) {
            List<Integer> binaryRow = new ArrayList<>();
            int decimalForRow = rand.nextInt(256); // Generate random decimal value between 0 and 255 for each row
            System.out.println("Decimal for row " + row + ": " + decimalForRow);
            String binaryString = Integer.toBinaryString(decimalForRow);
    
            // Pad binary string to ensure it has 8 digits
            while (binaryString.length() < 8) {
                binaryString = "0" + binaryString;
            }
    
            for (int col = 0; col < 8; col++) {
                // Set the state of the block randomly
                int binaryDigit = rand.nextInt(2); // 0 or 1
                binaryRow.add(binaryDigit);
                IBinaryBlockGameModeTow block = new IBinaryBlockGameModeTow();
                block.setWert(binaryDigit);
                addObject(block, col * 3 + 1, row * 3 + 1);
                System.out.println("Block in Reihe " + row + ", Spalte " + col + " hat den Zustand: " + binaryDigit);
                // Display the decimal value for the row
                IBinaryTextBoxResult textBox = new IBinaryTextBoxResult(row, col, 2);
                textBox.setDecimal(decimalForRow);
                addObject(textBox, 26, row * 3 + 1);
            }
            
            // Add binaryRow to binaryRows
            binaryRows.add(binaryRow);
        }
    }
    
    

    public int calculateDecimalForRow(List<Integer> row) {
        int decimal = 0;
        int power = row.size() - 1;
        for (int i = 0; i < row.size(); i++) {
            decimal += row.get(i) * Math.pow(2, power);
            power--;
        }
        return decimal;
    }

    public int[] calculateDecimalForAllRows() {
        int[] decimalArray = new int[binaryRows.size()];
        for (int rowIndex = 0; rowIndex < binaryRows.size(); rowIndex++) {
            List<Integer> row = binaryRows.get(rowIndex);
            int decimalForRow = calculateDecimalForRow(row);
            decimalArray[rowIndex] = decimalForRow;
        }
        return decimalArray;
    }

    public boolean checkUserInputGameModeTow(int userInput, int rowIndex) {
        int[] decimalArray = calculateDecimalForAllRows();
        if (rowIndex >= 0 && rowIndex < decimalArray.length) {
            int correctDecimal = decimalArray[rowIndex];
            boolean isCorrect = userInput == correctDecimal;
            return isCorrect;
        }
        return false;
    }

    public void removeAllObjectsInRow(int row, int col, Color color) {
        LargeElement largeElement = new LargeElement(color, 1964, 90);
        addObject(largeElement, col * 3 - 100, row * 3 + 1);
    }

    public void right(int rowIndex) {
        int col = 0; // Hier kannst du die Spaltenposition festlegen, je nachdem, wie du sie
                     // berechnen möchtest
        Color color = Color.GREEN; // Hier kannst du die Farbe festlegen, die du verwenden möchtest
        LargeElement largeElement = new LargeElement(color, 1964, 90); // Hier wird ein neues LargeElement erstellt
        addObject(largeElement, col * 3 - 100, rowIndex * 3 + 1); // Hier werden die Bildschirmdaten berechnet und das
                                                                  // LargeElement hinzugefügt
        System.out.println("Row " + rowIndex + " is correct!"); // Konsolenausgabe, dass die Reihe richtig ist

    }

}
