/**
* @version April 10 2017
* @author Group26
*/

//package gui;
//import gui.*; //import all the types contained in gui package
//import logic.*; //import all the types contained in logicpackage
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
* The class World is one of the only two graphic user interface classes in the game
* The functionality of this class is setting the background color of the world,
* painting all the obstacles and the player.
* It also displays the instructions of the shortcut keys for the users on the screnn
* by drawing them.
* This class is only used for painting.
* We don't use this class manually.
* This class is called in GUI class automatically.
* These two classes always work together when painting is applied.
*/
public class World extends JPanel{
  private BufferedImage upwardsSpike;
  private BufferedImage player;

  /**
   * @exception IOEXception catches an exception if there is error displaying
   * the image of the objects in the game
   */
  public World() {
    try {
      upwardsSpike = ImageIO.read(new File("Spike.png"));
      player = ImageIO.read(new File("Player.png"));
    } catch (IOException ex) {
    }
  }

  public void paintComponent (Graphics paint) {
    Spike grab = new Spike();
    int tri1 = grab.getTri1();
    int tri2 = grab.getTri2();
    int tri3 = grab.getTri3();
    int tri4 = grab.getTri4();
    int tri5 = grab.getTri5();
    GUI fixLag = new GUI();
    Player get = new Player();
    int playerX = get.getplayerX();
    int playerY = get.getplayerY();
    int score = get.getPlayerScore();

    // Paint the instruction of the shortcut keys to the screen
    super.paintComponent(paint);
    paint.setColor(Color.WHITE);
    paint.drawString("SCORE: " + score, 750,100);

    paint.setColor(Color.WHITE);
    paint.drawString("Press 'B' to begin", 25,25);

    paint.setColor(Color.WHITE);
    paint.drawString("Press 'P' to pause", 25,50);

    paint.setColor(Color.WHITE);
    paint.drawString("Press 'R' to restart the level", 25,75);

    paint.setColor(Color.WHITE);
    paint.drawString("Press 'L' to reload a saved game", 25,100);

    paint.setColor(Color.WHITE);
    paint.drawString("Press 'S' to save your score", 25,125);

    paint.setColor(Color.WHITE);
    paint.drawString("Press 'Q' to exit the game", 25,150);


    // sets background color
    this.setBackground(Color.BLACK);

    paint.drawImage(upwardsSpike, tri1, 560, this);
    paint.drawImage(upwardsSpike, tri2, 560, this);
    paint.drawImage(upwardsSpike, tri3, 560, this);
    paint.drawImage(upwardsSpike, tri4, 560, this);
    paint.drawImage(upwardsSpike, tri5, 560, this);

    paint.drawImage(player, playerX, playerY, this);
    paint.setColor(Color.RED);
    paint.fillRect(0,600,1900,25);
  }
}
