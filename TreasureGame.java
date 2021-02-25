
/**
 * Lead Author(s):Evan McClure:5550053396
 *                Imahni King
 * Other Contributors: CISC 190 Class
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley.
 * Other sources:
 * None
 * 
/




/**
 ** |------------------------------------------------------------ |
 *  |                          TreasureGame                       |
 *  |------------------------------------------------------------ |
 *  |      Responsibilities         |   Collaborating Classes     |
 *  |-------------------------------+-----------------------------|     
 *  |   to hold the GameView's      |                             |
 *  |     features                  |                             |
 *  |                               |                             |
 *      
 *  |                               |                             |
 *  |                               |                             |
                                               
 *  |                               |                             |
 *  |-------------------------------+-----------------------------|
 *
 */
import javax.swing.*;
import java.util.Random;

public class TreasureGame
{
    //has-a number of Tries int
    private int numberOfTries = 50;
    //has-a numberStill hidden int
    private int numberStillHidden = 20;
    //has-a number of treasures found int
    private int numberOfFoundTreasures = 0;
    
    //has-a troll, there are 20 in total
    private int numberOfTrolls = 20;
    //has-a boolean for the game over
    private boolean gameOver = false;
    
    //has-a points scoring array
    private int[] pointScoring = {1, 2, 3};
    
    //has-a change in points scoring integer
    private int changeInPointScoring = 0;
    //has-a number of point
    private int numberOfPoints;
    
    /**
     * purpose: to reduce the number of tries for every attempt made by the user
     * 
     */
    public void reduceNumberOfTries()
    {
        //verify if the number of tries is greater than 0
        if(numberOfTries > 0)
        {
            //subtract the number of tries by 1
            numberOfTries -= 1;
        }
    }
    
    /**
     * purpose: to get the remaining number of tries 
     */
    public int getNumberOfTriesLeft()
    {
        //return the number of tries
        return numberOfTries ;
    }
    
    /**
     * purpose: to get the reduce the number of hidden treasures 
     */
    public void reduceNumberStillHidden()
    {
        //if the numberof treasures is more than 0
        if(numberStillHidden > 0)
        {
            //reduce the number of treasures by 1
            numberStillHidden -= 1;
            //count the number of found treasures
            numberOfFoundTreasures++;
       
        }
    }
    /**
     * purpose: to get the remaining number of treasures 
     */
    public int getNumberStillHidden()
    {
        return numberStillHidden;
    }
    
    /**
     * purpose: to get the number of found treasures 
     */
    public int getFoundTreasures()
    {
        //return the number of found treasures
        return numberOfFoundTreasures;
    }
    
   /**
     * purpose: to verify if the game is over
     */
    public boolean isGameOver()
    {
        //the game is over if the number of tries is 0 and the number of found treasures is 0
        return numberOfTries == 0 || numberStillHidden == 0;
        
           
    }
    
    /**
     * purpose: to reset the treasure score to 0
     */
    public void resetTreasureScore()
    {
        //veritfy if the found treasures 
        if(numberOfFoundTreasures > 0)
        {
            //the number of found treasures will be reset to 0
            numberOfFoundTreasures = 0;
        }
    }
    
    /**
     * purpoes: to reset the point scored when a troll is found
     */
    public void resetPoints()
    {
        //if the number of points is greater than 0. reset the points scored to 0
        if(numberOfPoints > 0)
        {
            numberOfPoints = 0;
        }
    }
   
    
    /**
     * purpose: to get the number of trolls
     */
    public int getNumberOfTrolls()
    {
        //return the number of trolls in the game
        return numberOfTrolls;
    }
    /**
     * putpose: to get the number of points
     */
    public int getNumberOfPoints()
    {
        //return the number of points
        return numberOfPoints;
    }
    /**
     * purpose: to get the change in points for every treasure found
     */
    public int getChangeInPointScoring()
    {
        //return the change in point scoring
        return changeInPointScoring;
    }
   
    /**
     * purpose: to score points for every treasure found
     */
    public void scorePoints()
    {
        //use and int for the current number of points to be equal to the number of points
        int currentNumberOfPoints = numberOfPoints;
        //create a random generator
        Random randomPointIndexGenerator = new Random(); 
        //the random generator will be between 1 and 3
        int pointIndex = randomPointIndexGenerator.nextInt(3);
        //the number of points will be scored based on the point index that is randomly generated
        numberOfPoints += pointScoring[pointIndex];
        //initialize the change in scoring
        changeInPointScoring = numberOfPoints - currentNumberOfPoints;
        //accumulate the number of points to count up
        numberOfPoints++;
    }
}
