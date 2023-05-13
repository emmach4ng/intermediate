package AllGames.Games;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import AllGames.NumberGuessGame.src.*;
import AllGames.Superstore.*;
import AllGames.BuzzfeedQuiz.*;


public class Games {
    static String[] gameChoices = { "NumberGuessGame", "SuperStore", "BuzzfeedQuiz" };
    static Scanner sc = new Scanner(System.in);

    /**
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException, IOException {

        HashMap<Game1, Integer> gameCounts = new HashMap<Game1, Integer>();
        // writes highscores
        File f = new File("Highscore.csv");
        while (true) {
            System.out.println("Which game would you like to play?");
            printGameChoices();
            Game1 g = getGameChoice();
            System.out.println("You're playing " + g.getGameName());
            g.play();
            g.writeHighScore(f);
            // add one to game counts or add it to the hashmap
            if (gameCounts.containsKey(g)) {
                gameCounts.put(g, gameCounts.get(g) + 1);
            } else {
                gameCounts.put(g, 1);
            }
        }
    }

    public static void printGameChoices() {
        int n = 1;
        for (String s : gameChoices) {
            System.out.println("[" + (n++) + "]: " + s);
        }
    }

    /*
     * Takes in user input for printing out all games in
     */
    public static Game1 getGameChoice() {
        int choice = ErrorCheck.getInt(sc);
        // for it to be numbered, we can't use hashmaps.
        while (choice < 1 || choice > gameChoices.length) {
            System.out.println("We don't have this number. Try again.");
            choice = ErrorCheck.getInt(sc);
        }

        // valid game choice
        String gameString = gameChoices[choice - 1];
        if (gameString.equals("NumberGuessGame")) {
            return new NumberGuessGameJar();
        } else if (gameString.equals("SuperStore")) {
            return new SuperStore();
        } else if (gameString.equals("BuzzfeedQuiz")) {
            return new BuzzfeedQuiz();
        } else {
            return null;
        }

    }
}

class ErrorCheck {

    public static int getInt(Scanner sc) {
        if (sc.hasNextInt()) {
            return sc.nextInt();
        } else {
            System.out.println("This is not a number. Discarding this input");
            sc.next();
            return getInt(sc);
        }
    }
}