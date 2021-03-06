/**
 * @version April 10 2017
 * @author Group26
 */

 //package logic;
 //import gui.*; //import all the types contained in gui package
 //import logic.*; //import all the types contained in logic package
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 * The class HighScores is the class that opens a text file called "Scores.txt"
 * for reading the exciting score when user hits "R" for reloading the score
 * and keeps overwriting the score when user hits "S" to save the current score.
 * This class is being called in Player class. It shouldn't be used without running other classes.
 */
public class Scores {

  /**
   * Open the text file and write the score into it
   * @param playerScore the current player score of the game
   * @exception IOException catches the error if there is a problem
   * writing the score to the text file
   */
  public void writing(int playerScore) {
    //System.out.println("WRITING ---------------------------------------------------------------------------");
    try {
        File highScores = new File("Scores.txt");
        FileOutputStream is = new FileOutputStream(highScores);
        OutputStreamWriter osw = new OutputStreamWriter(is);
        Writer scores = new BufferedWriter(osw);
        scores.write("Score: " + playerScore);
        scores.close();
    } catch (IOException e) {
        System.err.println("Problem writing to the file Scores.txt");
    }
  }

  /**
   * Open the text file for reading the current score
   * and the return the current as an integer only
   * @exception FileNotFoundException catches the error if the text file does not exist
   * @exception NumberFormatException catches the error if the score cannot be splited
   * as an integer from the text file
   * @return return Integer.parseInt(word) if the score is splited as an integer from the textfile
   * @return return 0 if there is an error that the score cannot be splited as
   * an integer from the text file
   */
  public int reading(){
    String fileName = "Scores.txt";
    Scanner inputStream = null;
    String word = null;
    try {
      inputStream = new Scanner (new File(fileName));
    }
    catch (FileNotFoundException e) {
      System.out.println("Error opening the file " + fileName);
    }
		while(inputStream.hasNextLine()) {
      String line = inputStream.nextLine();
      String[] words = line.split(" ");
      for (int index = 1; index < words.length; index++) {
        word = words[index];
        //inputStream.print(word);
      }
		}
		inputStream.close();
    try {
      return Integer.parseInt(word);
    }
    catch(NumberFormatException n){
      return 0;
    }
  }
}
