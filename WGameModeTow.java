import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameModeTow here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class WGameModeTow extends World {
    private FMessage leveltext =  new FMessage();
    private FMessage pointstext=  new FMessage();
    private BSaveButton sbutton = new BSaveButton();
    private BPauseButton button = new BPauseButton();
    private BEndGameButton ebutton = new BEndGameButton();
    public FGameModManger gameModManger = new FGameModManger();
    private String level ;
    private String points;
    int setBlockValue = 0;
    private List<List<Integer>> nullOderEinsList = new ArrayList<>();
    private HashMap<Integer, IBinaryBlockResult> blockMap;

    /**
     * Konstruktor für Objekte der Klasse BinaryWorld
     * 
     */
    public WGameModeTow() {
        super(36, 27, 33);
        loadlevel();
        loadGameMode();
    }

    public void act() {
         level = String.valueOf(gameModManger.getLevel());
         points = String.valueOf(gameModManger.getPoints());

         leveltext.showText("Deine Level: " + level, this, 1010, 10, 24, null, Color.WHITE);
         pointstext.showText("Deine Punkte: " + points, this, 1010, 40, 24, null, Color.WHITE);

    }

    public void loadlevel() {
        addObject(button, 33, 23);
        addObject(ebutton, 33, 25);
        addObject(sbutton, 33, 21);
    }


    public void loadGameMode() {
        for (int row = 1; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                IBinaryBlock block;
                int sollwert = Greenfoot.getRandomNumber(2);
                int istwert = Greenfoot.getRandomNumber(2);
                block = new IBinaryBlock(setBlockValue, sollwert, istwert);
                addObject(block, col * 3 + 1, row * 3 + 1);
                IBinaryTextResult buton = new IBinaryTextResult();
                addObject(buton, 26, row * 3 + 1);

            }
        }

    }

    public IBinaryBlockResult getBlockById(int id) {
        return blockMap.get(id);
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
        int[] decimalArray = new int[nullOderEinsList.size()];
        int rowIndex = 0;
        for (List<Integer> row : nullOderEinsList) {
            int decimalForRow = calculateDecimalForRow(row);
            decimalArray[rowIndex] = decimalForRow;
            rowIndex++;
        }
        return decimalArray;
    }

    public boolean checkUserInput(int userInput, int rowIndex) {
        int[] decimalArray = calculateDecimalForAllRows();
        if (rowIndex >= 0 && rowIndex < decimalArray.length) {
            int correctDecimal = decimalArray[rowIndex];
            System.out.println("Correct Decimal" + correctDecimal);
            return userInput == correctDecimal;
        }

        return false;
    }

    public void removeAllObjectsInRow(int row, int col, Color color) {

        LargeElement largeElement = new LargeElement(color, 1964, 90);
        addObject(largeElement, col * 3 - 100, row * 3 + 1);
    }

}
