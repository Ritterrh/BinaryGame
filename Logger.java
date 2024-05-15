/**
 * Write a description of class logger here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Logger {
    private static Logger instance;

    private String log;
    private String klass;
    private String method;
    /**
     * @param log   ist der Text der geloggt werden soll
     * @param color ist die Farbe in der der Text geloggt werden soll
     *              mögliche farben
     * @serialField ANSI_BLACK_BACKGROUND
     * @serialField ANSI_RED_BACKGROUND
     * @serialField ANSI_GREEN_BACKGROUND
     * @serialField ANSI_YELLOW_BACKGROUND
     * @serialField ANSI_BLUE_BACKGROUND
     * @serialField ANSI_PURPLE_BACKGROUND
     * @serialField ANSI_CYAN_BACKGROUND
     * @serialField ANSI_CYAN_BACKGROUND
     * @serialField ANSI_WHITE_BACKGROUND
     * @serialField ANSI_RESET
     * @serialField ANSI_BLACK
     * @serialField ANSI_RED
     * @serialField ANSI_GREEN
     * @serialField ANSI_YELLOW
     * @serialField ANSI_BLUE
     * @serialField ANSI_PURPLE
     * @serialField ANSI_CYAN
     * @serialField ANSI_WHITE
     */
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    /**
     * Constructor for objects of class logger
     */
    public Logger() {

    }
    
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    /**
     * Fuction zum Tracken von Calls
     * 
     * @param klass  ist der Name der Klasse die die Methode aufruft
     * @param method ist die Methode die aufgerufen wird
     */
    public void call(String klass, String method) {
        System.out.println(ANSI_YELLOW + klass + " " + method + ANSI_RESET);
    }

    public void log(String log, String color) {
        switch (color) {
            case "black":
                System.out.println(ANSI_RED + " " + log + ANSI_RESET);
                break;
            case "red":
                System.out.println(ANSI_GREEN + " " + log + ANSI_RESET);
                break;
            case "green":
                System.out.println(ANSI_YELLOW + " " + log + ANSI_RESET);
                break;
            case "yellow":
                System.out.println(ANSI_BLUE + " " + log + ANSI_RESET);
                break;
            case "blue":
                System.out.println(ANSI_PURPLE + " " + log + ANSI_RESET);
                break;
            case "purple":
                System.out.println(ANSI_CYAN + " " + log + ANSI_RESET);
                break;
            case "cyan":
                System.out.println(ANSI_WHITE + " " + log + ANSI_RESET);
                break;
            case "white":
                System.out.println(ANSI_WHITE + " " + log + ANSI_RESET);
                break;
            case "black_background":
                System.out.println(ANSI_RED_BACKGROUND + " " + log + ANSI_RESET);
                break;
            case "red_background":
                System.out.println(ANSI_GREEN_BACKGROUND + " " + log + ANSI_RESET);
                break;
            case "green_background":
                System.out.println(ANSI_YELLOW_BACKGROUND + " " + log + ANSI_RESET);
                break;
            case "yellow_background":
                System.out.println(ANSI_BLUE_BACKGROUND + " " + log + ANSI_RESET);
                break;
            case "blue_background":
                System.out.println(ANSI_PURPLE_BACKGROUND + " " + log + ANSI_RESET);
                break;
            case "purple_background":
                System.out.println(ANSI_CYAN_BACKGROUND + " " + log + ANSI_RESET);
                break;
            case "cyan_background":
                System.out.println(ANSI_WHITE_BACKGROUND + " " + log + ANSI_RESET);
                break;
            case "white_background":
                System.out.println(ANSI_WHITE_BACKGROUND + " " + log + ANSI_RESET);
                break;
            default:
                System.out.println(ANSI_BLACK + " " + log + ANSI_RESET);
                break;
        }
    }
}
