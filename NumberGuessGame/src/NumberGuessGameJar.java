/*
 * This class expects to import a NumberGuessGame.jar file, 
 * and run the packaged source code as an executable.  
 */

 //Emma Chang - Jan 19, 2023

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class NumberGuessGameJar {
    public static void main(String args[]) throws Exception {
        
        System.out.println("Welcome to Number Guess Game. What range do you want the number to be in (must be integers)?");
        Scanner sc = new Scanner(System.in);
        for (;;) {
            System.out.println("Enter the lowest integer of the range.");
            if (sc.hasNextInt()) { //checks if the input is an integer
                bottomRange = sc.nextInt();
                break;
            } else {
                System.out.println("This is not an integer. Try again.");
                sc.next(); // discarding the next input
            }
        }
        for (;;) {
            System.out.println("Enter the highest integer of the range.");
            if (sc.hasNextInt()) { //checks if the input is an integer
                topRange = sc.nextInt();
                break;
            } else {
                System.out.println("This is not an integer. Try again.");
                sc.next(); // discarding the next input
            }
        }
        
        Random rand = new Random();

        int number = rand.nextInt(topRange - bottomRange + 1) + bottomRange; //generates random integer to guess
        int guesses = 0; //counts number of guesses
        ArrayList<Integer> numbersGuessed = new ArrayList<Integer>(); //stores previous guesses

        for (;;) { //loops until number is guessed

            System.out.println("Guess a number between " + bottomRange + " and " + topRange);
            Scanner input = new Scanner(System.in);

            if (input.hasNextInt()) { //checks if the input is an integer
                int x = input.nextInt();
                if (x > topRange || x < bottomRange) { //checks if input is outside range
                    System.out.println("Hey! This is not an integer in the range. Try again.");
                } else { //if input is inside range...
                    if (x < number) { //if input is less than the number

                        if (numbersGuessed.contains(x)) {
                            System.out.println("You've already guessed this number. Try again.");
                        } else {
                            System.out.println("The number is higher. Try again.");
                            numbersGuessed.add(x); //adds input to the array of previous guesses
                            guesses++; //adds one to total number of guesses
                        }

                    } else if (x > number) { //if input is greater than the number

                        if (numbersGuessed.contains(x)) {
                            System.out.println("You've already guessed this number. Try again.");
                        } else {
                            System.out.println("The number is lower. Try again.");
                            numbersGuessed.add(x); //adds input to the array of previous guesses
                            guesses++; //adds one to total number of guesses
                        }

                    } else if (x == number) {
                        guesses++; //adds one to total number of guesses
                        break; //breaks out of the for loop
                    }
                }
            } else {
                System.out.println("This is not an integer. Try again.");
                input.next(); // discarding the next input
            }

        }

        //gives user their results
        System.out.println("You guessed the number!");
        System.out.println("In total, it took you " + guesses + " guesses!");

    }

}
