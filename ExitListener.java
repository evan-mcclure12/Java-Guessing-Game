import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//is-a actionListener
public class ExitListener implements ActionListener
{
 /**
 ** |------------------------------------------------------------ |
 *  |                          ExitListener                       |
 *  |------------------------------------------------------------ |
 *  |      Responsibilities         |   Collaborating Classes     |
 *  |-------------------------------+-----------------------------|
 *  |    to end the game            |                             |
 *  |    when clicked on            |                             |
 *  |                               |    TreasureGameView         |
 *  |                               |                             |
 *  |                               |                             |
 *  |                               |                             |
 *  |                               |                             |
 *  |-------------------------------+-----------------------------|
 *
 *
 */
    /**
     * purpose: to finish the game, when clicked on
     */
    public void actionPerformed(ActionEvent e)
    {
        //use System.exit to end the game
        System.exit(0);
    }
}
