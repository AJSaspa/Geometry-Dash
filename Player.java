/**
* @version April 10 2017
* @author Group26
*/


//package logic;
//import gui.*; //import all the types contained in gui package
//import logic.*; //import all the types contained in logic package

/**
* The class Player is the main class of the logic part of this game.
* It connects Scores, Ostacle and Spike classes by calling them.
* It is being used to calculte the player's location when any action event is performed
* and get the score of the player.
* This class is being called in GUI class. GUI class repaints the map and the player
* based on the locations passed by Player.
*/
public class Player{
  private static int playerX = 0;
  private static int playerY = 550;
  private static int playerScore = 0;
  Scores write = new Scores();

  /**
  *getter method for playerScore
  *@return playerScore the current player score
  */
  public int getPlayerScore(){
    return playerScore;
  }

  /**
  *getter method for playerY
  *@return playerY the height of the player relative to the main platform
  */
  public int getplayerY(){
    return playerY;
  }

  /**
  *getter method for playerX
  *@return playerX the height of the player relative to the main platform
  */
  public int getplayerX(){
    return playerX;
  }

  /**
  *setter method for playerX
  *sets playerX to xValue
  */
  public void setplayerX(int xValue){
    this.playerX = xValue;
  }

  /**
  *setter method for playerY
  *sets playerY to yValue
  */
  public void setplayerY(int yValue){
    this.playerY = yValue;
  }

  public void playerJump(){
    if(playerY == 550){
      playerY -= 50;
      playerX += 80;
    }
  }

  public void playerReset(){
    playerX = 0;
    playerScore = 0;
  }

  public void playerSave() {
    System.out.println(playerScore);
    write.writing(playerScore);

  }
  public void playerLoad() {
    int score = write.reading();
    playerScore = score;
  }

  public void playerDown(){
    if(playerY < 550){
      playerY += 20;
      playerX +=20;
    }
    if(playerY > 550){
      playerY -= 10;
    }
  }

  public void playerStraight(){
    Spike getHit = new Spike();
    if(getHit.hitDetection()){
      playerX = 0;
      playerScore = 0;
    }
    if (playerX >= 1500) {
      Spike make = new Spike();
      make.drawspike();
      playerX = 0;
    }
    else {
      playerX += 5;
      playerScore ++;
    }
  }

}
