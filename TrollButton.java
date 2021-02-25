

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
 *  |                          TrollButton                        |
 *  |------------------------------------------------------------ |
 *  |      Responsibilities         |   Collaborating Classes     |
 *  |-------------------------------+-----------------------------|     
 *  |   to return the value of      |        TreasureGame         |
 *  |   a troll when clicked        |        TreasureGameView     |
 *  |                               |                             |
 *      
 *  |                               |                             |
 *  |                               |                             |
                                               
 *  |                               |                             |
 *  |-------------------------------+-----------------------------|
 *
 */





import javax.swing.*;

public class TrollButton extends EmptyButton
{
           
    public TrollButton(TreasureGame game, TreasureGameView gameView)
    {
        //call the super class of the game and gameView
        super(game, gameView);
        
        //get the TrollButtonListener and remove it
        removeActionListener(getActionListeners()[0]);
        
        //add the TrollButtonListener to the TrollButton to take away the treasures when clicked
        addActionListener(new TrollButtonListener(this, game, gameView));
    }
    /**
     * purpose: to to reveal the troll text of a button when clicked
     */
    public String revealButtonText()
    {
        //return a TrollFace when Clicked.
        return ">:P";
    }
   
}
