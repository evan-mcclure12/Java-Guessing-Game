/**
 * Lead Author(s):Evan McClure:5550053396
 *                Imahni King
 * Other Contributors: CISC 190 class
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
 *  |                          EmptyButtonListener                |
 *  |------------------------------------------------------------ |
 *  |      Responsibilities         |   Collaborating Classes     |
 *  |-------------------------------+-----------------------------|    
 *  |  to implement the features    |                             |
 *  |     of an empty button        |                             |
 *  |    when pressed and return    |      TreasureGameView       |
 *       an "X"
 *  |                               |                             |
 *  |                               |        TreasureGame         |
                                             EmptyButton
 *  |                               |                             |
 *  |-------------------------------+-----------------------------|
 *
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//is- a actionListener
public class EmptyButtonListener implements ActionListener
{
    //has-a empty button
    private EmptyButton emptyButton;
    //has-a TreasureGame
    private TreasureGame treasureGame;
    //has-a TreasureGameView
    private TreasureGameView treasureGameView;
    
    
    public EmptyButtonListener(EmptyButton button, TreasureGame game, TreasureGameView gameView )
    {
       //an empty button is-a button
       emptyButton = button;
       //a treasure game is-a game
       treasureGame = game;
       //a treasuregameview is-a gameView
       treasureGameView = gameView;
               
    }
    
    /**
     * purpose: to conduct the functions of an actionListener for an empty button
     */
    public void actionPerformed(ActionEvent e)
    {   
        //use the found nothing method in the game view
        treasureGameView.foundNothing();
        //set the text of an emptybutton by using the reveal button text
        emptyButton.setText(emptyButton.revealButtonText());
        //reduce the number of tries every time the button is clicked
        treasureGame.reduceNumberOfTries();
        //update the treasure game view when an empty button is clicked
        treasureGameView.updateUI();
        //use the end game method when all the tries are used
        treasureGameView.endGame();
        //diable the empty buttons when clicked
        emptyButton.setEnabled(false);
    }

}
