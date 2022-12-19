/**
 * Lead Author(s):Evan McClure:5550053396
 *                Imahni King
 * Other Contributors: 
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley.
 * Other sources: CISC 190 class
 * None
 * 
/

//this is an edit


/**
 ** |------------------------------------------------------------ |
 *  |                          EmptyButton                        |
 *  |------------------------------------------------------------ |
 *  |      Responsibilities         |   Collaborating Classes     |
 *  |-------------------------------+-----------------------------|     
 *  |   to return the value         |                             |
 *  |     of an empty button        |                             |
 *  |    when pressed               |      TreasureGameView       |
 *      
 *  |                               |                             |
 *  |                               |        TreasureGame         |
                                             EmptyButton
 *  |                               |                             |
 *  |-------------------------------+-----------------------------|
 *
 */



import javax.swing.*;
public class EmptyButton extends JButton
{
    //has-a TreasureGame
    private TreasureGame treasureGame;
    
    //has-a TreasureGameView
    private TreasureGameView treasureGameView;
    public EmptyButton(TreasureGame game, TreasureGameView gameView)
    {
         //call the super class from the emptybutton listener
         super();
         //initialize the treasure game to  a new game
         treasureGame = game;
         //initialize the treasure game view to a new game view
         treasureGameView = gameView;
         //add an empty button listener to conduct the functions of the empty button
         addActionListener(new EmptyButtonListener(this, game, gameView));
    }
    
    /**
     *purpose: to reveal the button text under an empty 
     */
    public String revealButtonText()
    {
        //return an "X" to signify an empty button
        return "X";
    }
    
    
    
}
