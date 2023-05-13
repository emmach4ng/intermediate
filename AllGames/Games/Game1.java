package AllGames.Games;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public interface Game1 {
    String getGameName();

    void play() throws InterruptedException, IOException; // must be able to play a game

    int getScore(); // get a score - if there is no "score" then we

    public boolean isHighScore(int score, String highscore);

    public default void writeHighScore(File f) {
        // get the current score of this game, compare it with the current highScore
        // (getBestScore) using isHighScore
        // and if it is a high score, replace that line of the file with the new high
        // score.
        int score = getScore();
        String highScore = getBestScore(f);
        if (isHighScore(score, highScore)) {
            System.out.println("You got a new high score, which beats the previous high score of " + highScore);
            try {

                Scanner myReader = new Scanner(f);
                String newFile = "";
                while (myReader.hasNextLine()) {
                    // rewrite all lines except the line with the game name
                    String line = myReader.nextLine();
                    String[] data = line.split(",");
                    if (!data[0].equals(getGameName())) {
                        newFile += line + "\n";
                    }
                }
                // replace the Game's line with the new high score
                // puts it at the end of the file
                newFile += getGameName() + "," + score + "\n";
                // write the new file
                FileWriter myWriter = new FileWriter(f);
                myWriter.write(newFile);
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // get the best score for a specific game, from a file
    public default String getBestScore(File highscoreFile) {
        String highScore = null;
        try {
            Scanner myReader = new Scanner(highscoreFile);
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(",");
                if (data.length != 2 || !data[0].equals(getGameName())) {
                    // bad line or not this game, skip
                    continue;
                }
                highScore = data[1];
                break;
            }
        } catch (FileNotFoundException e) {
            try {
                highscoreFile.createNewFile();
            } catch (IOException ioException) {
                System.err
                        .println("Could not create file " + highscoreFile.getName() + " in " + highscoreFile.getPath());
            }
        }
        return highScore;
    }

}
