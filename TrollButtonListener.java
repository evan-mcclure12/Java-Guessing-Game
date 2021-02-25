

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
 *  |                          TrollButtonListener                |
 *  |------------------------------------------------------------ |
 *  |      Responsibilities         |   Collaborating Classes     |
 *  |-------------------------------+-----------------------------|     
 *  |   to take away a players      |                             |
 *  |   treasures when clicked      |  TrollButton                |
 *  |                               |                             |
 *      
 *  |                               |  TreasureGame               |
 *  |                               |  TreasureGameView           |
                                               
 *  |                               |                             |
 *  |-------------------------------+-----------------------------|
 *
 */






import java.awt.*;
import java.awt.event.*;

public class TrollButtonListener implements ActionListener
{
    //has-a TrollButton
    private TrollButton trollButton;
    //has-a TreasureGameView
    private TreasureGameView treasureGameView;
    //has-a TreasureGame
    private TreasureGame treasureGame;
  
    /**
     * purpose: constructor to hold the
     */
    public TrollButtonListener(TrollButton button, TreasureGame game, TreasureGameView gameView)
    {
        //initialize the troll button to button
        trollButton = button;
        //initialize the treasureGameView to gameView
        treasureGameView = gameView;
        //initialize the treasureGame to game
        treasureGame = game;   
        

    }
    /**
     * purpose: to execute the trolls of the treasure game
     */
    public void actionPerformed(ActionEvent e)
    {
        //call the treasureGameView class and call the foundTroll() method, 
        treasureGameView.foundTroll();
        //set the troll button text by calling the revealTrollText in the TrollButton
        trollButton.setText(trollButton.revealButtonText());
        //the troll will reset the found treasures to 0 by using the resetTreasureScore() method in the TreasureGame class
        treasureGame.resetTreasureScore();        
        //reveal the trolls when the game ends
        treasureGameView.endGame();        
        //make the buttons unclickable after a troll is activated
        trollButton.setEnabled(false);
        //update the userinterface when a troll is clicked
        treasureGameView.updateUI();
    }
}
