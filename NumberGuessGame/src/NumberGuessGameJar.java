/*
 * This class expects to import a NumberGuessGame.jar file, 
 * and run the packaged source code as an executable.  
 */

//Emma Chang - Feb 8, 2023
//added difficulties

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class NumberGuessGameJar {

    public static void main(String[] args) throws Exception {
        ArrayList<Game> games = new ArrayList<Game>();
        Scanner sc = new Scanner(System.in);
        boolean keepPlaying = true;
        int difficulty = 1;

        while (keepPlaying) {
            games.add(new Game(difficulty));
            System.out.println("You won! Would you like to play again? If so, type [y]. The game will get harder!");
            keepPlaying = sc.nextLine().equals("y");
            difficulty++;
        }

        System.out.println("Thanks for playing!");
        String plural = games.size() == 1 ? "" : "s";
        System.out.println("You played a total of " + games.size() + " game" + plural + ".");
        System.out.println("You averaged " + getAverageTries(games) + " tries per game!");
        sc.close();

    }

    public static int getAverageTries(ArrayList<Game> games) {
        int sum = 0;
        for (Game game : games) {
            sum += game.guesses;
        }

        return (int) Math.round(sum * 1.0 / games.size());
    }

}

class Game {
    int difficulty;
    int topRange = 100;
    int bottomRange = 0;
    int guesses = 0;

    Game(int difficulty) {

        for (int i = 2; i <= difficulty; i++) {
            topRange += 10;
            bottomRange -= 10;
        }

        Random rand = new Random();

        int number = rand.nextInt(topRange - bottomRange + 1) + bottomRange; // generates random integer to guess
        ArrayList<Integer> numbersGuessed = new ArrayList<Integer>(); // stores previous guesses

        for (;;) { // loops until number is guessed

            System.out.println("Guess a number between " + bottomRange + " and " + topRange);
            Scanner input = new Scanner(System.in);

            if (input.hasNextInt()) { // checks if the input is an integer
                int x = input.nextInt();
                if (x > topRange || x < bottomRange) { // checks if input is outside range
                    System.out.println("Hey! This is not an integer in the range. Try again.");
                } else { // if input is inside range...
                    if (x < number) { // if input is less than the number

                        if (numbersGuessed.contains(x)) {
                            System.out.println("You've already guessed this number. Try again.");
                        } else {
                            System.out.println("The number is higher. Try again.");
                            numbersGuessed.add(x); // adds input to the array of previous guesses
                            guesses++; // adds one to total number of guesses
                        }

                    } else if (x > number) { // if input is greater than the number

                        if (numbersGuessed.contains(x)) {
                            System.out.println("You've already guessed this number. Try again.");
                        } else {
                            System.out.println("The number is lower. Try again.");
                            numbersGuessed.add(x); // adds input to the array of previous guesses
                            guesses++; // adds one to total number of guesses
                        }

                    } else if (x == number) {
                        guesses++; // adds one to total number of guesses
                        break; // breaks out of the for loop
                    }
                }
            } else {
                System.out.println("This is not an integer. Try again.");
                input.next(); // discarding the next input
            }

        }

    }

}
