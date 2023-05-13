package AllGames.BuzzfeedQuiz;

import java.util.Scanner;
import java.io.IOException;
import java.lang.Math;
import java.io.File;

import AllGames.Games.Game1;

public class BuzzfeedQuiz implements Game1 {
    public static void main(String[] args) throws Exception {
    }

    @Override
    public void play() throws InterruptedException, IOException {
        // Create Categories
        Category notSus = new Category("NOT SUS", "Brown", "Not sus at all, you are a crewmate for sure for sure for sure.");
        Category slightlySus = new Category("SLIGHTLY SUS", "Dark Green",
        "You are very peculiar. Maybe you are a crewmate, but you sometimes act very sus for no reason. Why?");
        Category mediumSus = new Category("MEDIUM LEVEL SUS", "Pink", 
            "We hope that you are a crewmate and still like to trust you. You seem to do your tasks, or are you just acting?");
        Category Sus = new Category("SUS", "Yellow", "Scary. The definition of sus. People run away from you because you act sus. No matter how you prove you're a crewmate, you still act abnormally.");
        Category verySus = new Category("VERY VERY SUSSY", "Purple", "Nah bro I'm outta here you're going to betray me.");
        Category insanelySus = new Category("INSANELY SUSSY", "Black", "I'm running away ASAP.");
        Category extremelySus = new Category("EXTREMELY SUS 100% SUSSY", "Red", 
        "I don't know how its po1ssible to be this sus, anyways I'm out OH GOD AHHH YOU'RE RIGHT BEHIND ME YOU JUST VENTED OH NO OH NO OH NO I'M SO DOOMEDDDD!D!D");
        
        // Create Questions

        Question q1 = new Question("What's your favorite type of food...?");
        // Attach Answers to Questions
        q1.possibleAnswers[0] = new Answer("Red cotton candy", 10);
        q1.possibleAnswers[1] = new Answer("Slides", 6);
        q1.possibleAnswers[2] = new Answer("The Odyssey", 21);
        q1.possibleAnswers[3] = new Answer("Pizza", 1);

        Question q2 = new Question("How often do you eat food?!?");
        q2.possibleAnswers[0] = new Answer("Once every 2 weeks", 7);
        q2.possibleAnswers[1] = new Answer("Every other minute", 0);
        q2.possibleAnswers[2] = new Answer("Every minute", 20);
        q2.possibleAnswers[3] = new Answer("All of the above", 8);

        Question q3 = new Question("What is your favorite type of cheese......");
        q3.possibleAnswers[0] = new Answer("What is cheese", 10);
        q3.possibleAnswers[1] = new Answer("Earthworms", 0);
        q3.possibleAnswers[2] = new Answer("Blue cheese", 8);
        q3.possibleAnswers[3] = new Answer("Gray cheese", 20);

        Question q4 = new Question("What's your favorite color??");
        q4.possibleAnswers[0] = new Answer("Red", 50);
        q4.possibleAnswers[1] = new Answer("Pink", 1);
        q4.possibleAnswers[2] = new Answer("Yellow", 2);
        q4.possibleAnswers[3] = new Answer("Bleu is the color of the airspace of the heavens", 75);

        Question q5 = new Question("Why is that your favorite color?");
        q5.possibleAnswers[0] = new Answer("I don't know", 0);
        q5.possibleAnswers[1] = new Answer("Yes", 1);
        q5.possibleAnswers[2] = new Answer("Jazz", 10);
        q5.possibleAnswers[3] = new Answer("Floridaman", 15);

        Question q6 = new Question("Do you pull pranks on your friends? >:|");
        q6.possibleAnswers[0] = new Answer("Regularly", 5);
        q6.possibleAnswers[1] = new Answer("Astronomically", 10);
        q6.possibleAnswers[2] = new Answer("Neverly", -10);
        q6.possibleAnswers[3] = new Answer("Haha funny", 12);
        
        Question q7 = new Question("What are your opinions on milk.");
        q7.possibleAnswers[0] = new Answer("Delicious", 10);
        q7.possibleAnswers[1] = new Answer("Finger lickin good", 20);
        q7.possibleAnswers[2] = new Answer("Ew", 2);
        q7.possibleAnswers[3] = new Answer("Elon Musk", 25);

        Question q8 = new Question("What pet would you want to have?");
        q8.possibleAnswers[0] = new Answer("Donkey", 20);
        q8.possibleAnswers[1] = new Answer("Pigeon", 2);
        q8.possibleAnswers[2] = new Answer("Worm", 10);
        q8.possibleAnswers[3] = new Answer("I am vegan", 25);

        Question q9 = new Question("What superpower would you want to have?");
        q9.possibleAnswers[0] = new Answer("Invisibility", 30);
        q9.possibleAnswers[1] = new Answer("Metal detector arm", 3);
        q9.possibleAnswers[2] = new Answer("Transform into ant", 20);
        q9.possibleAnswers[3] = new Answer("Shapeshift", 25);

        Question q10 = new Question("What's your favorite class.......");
        q10.possibleAnswers[0] = new Answer("Intermediate programming", 1);
        q10.possibleAnswers[1] = new Answer("Spanish", 50);
        q10.possibleAnswers[2] = new Answer("HMO", 50);
        q10.possibleAnswers[3] = new Answer("P.E.", 10);

        // For each question, ask, read input, store answer.
        Scanner sc = new Scanner(System.in);
        gameIntro(sc);
        Question[] qList = {q1, q2, q3, q4, q5, q6, q7, q8, q9, q10};
        int totalPoints = 0;
        for (Question q : qList) {
            int c = q.ask(sc);
            totalPoints += c;
        }
        
        // Return Category
        double rPercent = (totalPoints/293.0); // get the sum of the answer points and find the percentage over the total points possible
        rPercent = Math.round(rPercent * 100.0); // round the percentage to an integer
        int percent = (int)rPercent;

        for (int x = 0; x <= 6; x++) { // loading animation
            System.out.println(".");
            Thread.sleep(200);
        }
        
        // loading animation
        String load = "|/-\\";
        for (int x = 0; x <= 100; x += 5) { 
            String data = "\r" + "Sus counter loading: " + load.charAt(x % load.length()) + " " + x + "%"; 
            System.out.write(data.getBytes());
            Thread.sleep(150);
        }
        System.out.println("");

        // print quiz results
        System.out.println("You are " + percent + "% sus.");
        if (percent <= 15) {
            System.out.println("You would be the " + notSus.color + " among us.");
            System.out.println(notSus.description);
        }
        else if (percent <= 30) {
            System.out.println("You would be the " + slightlySus.color + " among us.");
            System.out.println(slightlySus.description);
        }
        else if (percent <= 45) {
            System.out.println("You would be the " + mediumSus.color + " among us.");
            System.out.println(mediumSus.description);
        }
        else if (percent <= 60) {
            System.out.println("You would be the " + Sus.color + " among us.");
            System.out.println(Sus.description);
        }
        else if (percent <= 75) {
            System.out.println("You would be the " + verySus.color + " among us.");
            System.out.println(verySus.description);
        }
        else if (percent <= 90) {
            System.out.println("You would be the " + insanelySus.color + " among us.");
            System.out.println(insanelySus.description);
        }
        else {
            System.out.println("You would be the " + extremelySus.color + " among us.");
            System.out.println(extremelySus.description);
        }
    }

    // instructions
    public static void gameIntro(Scanner sc) {
        // requires ok to keep going
        System.out.println("Are you ready to find out how SUSSY are you?!");
        System.out.println("Can the crew really trust you??");
        System.out.println("Enter [OK] to play!");
        String play = sc.nextLine();
        play = play.toLowerCase();
        if (!play.equals("ok")) {
            System.out.println("Unidentifiable input. Please enter [OK] to play!");
            gameIntro(sc);
        }
    }

    @Override
    public String getGameName() {
        String name = "Buzzfeed Quiz";
        return name;
    }

    @Override
    public int getScore() { //this game does not have a score
        int score = 0;
        return score;
    }

    @Override
    public void writeHighScore(File f) {
    }

    @Override
    public boolean isHighScore(int score, String highscore) { 
        int num = Integer.parseInt(highscore);
        if (score > num) {
            return true;
        } else {
            return false;
        }
    }

}

class Category {

    String label;
    String color;
    String description; // after user is done and gets this category, will output description.
    int points = 0;

    Category(String c, String color, String description) {
        this.label = c;
        this.color = color; // color of the corresponding among us character
        this.description = description;
    }

}

class Question {
    // Fields
    String label;
    long skipIndex; // ejects a question when assigned a positive value
    Answer[] possibleAnswers = new Answer[4];

    Question(String label) {
        this.label = label;
        double r = Math.random() * 7.0; 
        this.skipIndex = Math.round(r) - 4; // assigns skipIndex a value
    }

    // ask a question, and return the points of the answer
    int ask(Scanner sc) {
        System.out.println(this.label);
        // prints out all the answer choices
        for (int i = 0; i < this.possibleAnswers.length; i++) {
            String choice = Integer.toString(i + 1);
            if(i != this.skipIndex) {
                System.out.println("[" + choice + "]: " + this.possibleAnswers[i].label);
            }
            else {
                System.out.println("[" + choice + "]: <<<Error. Choice voted out and ejected for being too sus!>>>");
            }
        }
        int ans = errorCheck(sc);
        return possibleAnswers[ans - 1].susPoints;
    }

    int errorCheck(Scanner sc) {
        if(sc.hasNextInt()) {
            int input = sc.nextInt();
            if (input > this.possibleAnswers.length || input < 1 || input == this.skipIndex + 1) { // checks if the input is a possible answer
                System.out.println("Not a valid number. Please input a valid number.");
                return errorCheck(sc);
            } 
            else {
                return input;
            }
        } 
        else {
            System.out.println("Not an integer. Please input a valid integer.");
            sc.next(); // discarding the next input
            return errorCheck(sc); 
        }
    }
}

class Answer {
    String label;
    int susPoints; // assigned point value 

    Answer(String label, int susPoints) { 
        this.label = label; 
        this.susPoints = susPoints;
    }
}