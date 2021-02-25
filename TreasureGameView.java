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



/**
 ** |------------------------------------------------------------ |
 *  |                          TresaureGameView                   |
 *  |------------------------------------------------------------ |
 *  |      Responsibilities         |   Collaborating Classes     |
 *  |-------------------------------+-----------------------------|
 *  |   Display the attributes      |                             |
 *  |     of the TreasureGame       |     EmptyButtonListener     |
 *  |    and implement its features |                             |
 *  |                               |       TreasureButton        |
 *  |                               |        TreasureGame         |
 *  |                               |         EmptyButton         |
 *  |                               |                             |
 *  |-------------------------------+-----------------------------|
 *
 *
 */

import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;

public class TreasureGameView extends JFrame
{
    //has-a TreasureGame
    private TreasureGame treasureGame;
    //has-a JTextField for the number of Treasures Left
    private JTextField treasuresLeftField;
    //has-a JTextField for the tries left
    private JTextField triesLeftField;
    //has-a JTextField for the treasures found by the player
    private JTextField treasuresFoundField;
    //has-a JTextField for the last move
    private JTextField lastMoveField;
    //has-a Treasure Button
    private TreasureButton treasureButton;
    //has-a button array
    private EmptyButton[] buttonGrid;
    //has-a treasuresFound panel
    private JPanel treasuresFoundPanel;
    //has-a poinstScored TextField
    private JTextField pointsScoredField;
    //has-a menu MenuBar
    private JMenuBar menuBar;
    
    //has-a JMenu
    private JMenu optionsMenu;
    //has-a about menu
    private JMenu aboutMenu;
    //has-a trollLegend label
    private JLabel trollLegend;
    
    
    public TreasureGameView(TreasureGame newTreasureGame)
    {
        
        //the button grid has a size of 100 buttons
        buttonGrid = new EmptyButton[100];
        //initialize a new treasureGame for the gameView
        treasureGame = newTreasureGame;
        //make the title of the game
        setTitle("Treasure hunt");
        //initialize the dimmensions of the window
        setSize(1000,800);
        
        setResizable(true);
        //set the layout to a borderlyout
        setLayout(new BorderLayout());
        
        //has-a gridPanel
        JPanel gridPanel = new JPanel();
        
        //has-a grid layout
        GridLayout statusLayout = new GridLayout(4,1);
        //has-a legend layout
        GridLayout legendLayout = new GridLayout(3,1);
        
        //has-a troll JLabel
        trollLegend = new JLabel(">:P = troll");
        //has-a treasure JLabel
        JLabel treasureLegend = new JLabel("$ = treasure");
        //has-a nothing label
        JLabel emptyLegend = new JLabel("X = nothing");
       
        
       
        //set the GridLayout 
        gridPanel.setLayout(new GridLayout(10, 10));
        //add the grid panel and set the border layout to the center
        add(gridPanel, BorderLayout.CENTER);
        
       
        //create a random generator for the buttons to be randomly placed 
        Random randomNumberGenerator = new Random();

        
        //create a counter for the random generator
        int counter = 0;       
        //use a while loop to constantly randomize the buttons
        while(counter < treasureGame.getNumberOfTrolls())
        {
            //create a variable for the random number and assign it to the random generator
            int randomNumber = randomNumberGenerator.nextInt(99);
            
            //if the button grid and random number are null, create a new treasure button on the board
            if(buttonGrid[randomNumber] == null)
            {
                //randomize the treasure buttons by adding the buttons to the button grid array
                buttonGrid[randomNumber] = new TrollButton(treasureGame, this);
                //counter wilt count up when randomizing the buttons
                counter++;
            }
            
            
            
            
        }
        
        //create a variable to hold the counter for the trolls
        int trollCounter = 0;
        while(trollCounter < treasureGame.getNumberStillHidden())
        {
            //create a variable for the random number and assign it to the random generator
            int randomNumber = randomNumberGenerator.nextInt(99);
            
            //if the button grid and random number are null, create a new treasure button on the board
            if(buttonGrid[randomNumber] == null)
            {
                //randomize the treasure buttons by adding the buttons to the button grid array
                buttonGrid[randomNumber] = new TreasureButton(treasureGame, this);
                //counter wilt count up when randomizing the buttons
                trollCounter++;
            }
            
            
            
            
        }
                           
        
      
        //use a for loop and get the entire input of the button grid
        for(int index = 0; index < 100; index++)
        {
             // verify if the button grid is true
              if(buttonGrid[index] == null)
              {
                  //add an empty button to the button grid and call from the treasureGame
                  buttonGrid[index] = new EmptyButton(treasureGame, this);
              }              
            
        }
        
                
        //use a for loop to get all of the button grids values
        for(int index = 0; index<100; index++)
        {
            //add the button grid to the grid panel
            gridPanel.add(buttonGrid[index]);        

        }
        
        
        
        
        //has-a JPanel 
        JPanel triesLeftPanel = new JPanel();
        //has-a JLabel   
        JLabel triesLeftLabel = new JLabel("Tries Left");  
        //add the label to the Panel
        triesLeftPanel.add(triesLeftLabel);
     
        
        //initialize the tries left field.
        triesLeftField = new JTextField("" + treasureGame.getNumberOfTriesLeft());
        //add the textField to the Panel
        triesLeftPanel.add(triesLeftField);
        //initialize the JLabel treasuresLeft
        JLabel treasuresLeftLabel = new JLabel("Treasures Left");
        //add the treasures Left label to the panel
        triesLeftPanel.add(treasuresLeftLabel);
        //initialize the treasuresLeft JTextField
        treasuresLeftField = new JTextField("" +treasureGame.getNumberStillHidden());
        //add the treasures left text field 
        triesLeftPanel.add(treasuresLeftField);
        //Initialiaze the treasures found Label
        JLabel treasuresFoundLabel = new JLabel("Found Treasures");
        //Initialize the treasures found text field
        treasuresFoundField = new JTextField("" + treasureGame.getFoundTreasures());
        
        //has-a panel for the treasures found
        JPanel treasuresFoundPanel = new JPanel();
        //add the treasures found label to the treasures found Panel
        treasuresFoundPanel.add(treasuresFoundLabel);
        
        //add the treasures found label to the tries Left panel
        triesLeftPanel.add(treasuresFoundLabel);
        //add the treasures left text field to the tries left panel
        triesLeftPanel.add(treasuresFoundField);
        
        
        //has-a gamePanel
        JPanel gamePanel = new JPanel();
        
        JLabel pointsScoredLabel = new JLabel("Points scored");
        pointsScoredField = new JTextField("" + treasureGame.getNumberOfPoints());
        
        
        
        
        //has-a textField for the last move
        lastMoveField = new JTextField();
        //add the last move field to the tries left panel
        
        //add  the last move text field to the game panel
        gamePanel.add(lastMoveField, BorderLayout.WEST);
        
        //add the points scored label to the tries left panel to the left
        triesLeftPanel.add(pointsScoredLabel);
        //add the points scored field to the tries left panel to the left
        triesLeftPanel.add(pointsScoredField);
        
        //has-a legendPanel
        JPanel legendPanel = new JPanel();
        //set the Legend Panel's grid layout to a 10*10
        legendPanel.setLayout(new GridLayout(10,10));
        //add the treasuresLabel to the legend panel
        legendPanel.add(treasureLegend);
        //add the emptyLabel to the legend panel
        legendPanel.add(emptyLegend);
        //add the troll legend the legend panel
        legendPanel.add(trollLegend);
        
       
        makeMenuBar();
        //add the treasures found panel to the game view
        add(treasuresFoundPanel, BorderLayout.WEST);

        add(gamePanel, BorderLayout.SOUTH);
        //add the tries left panel to the game view and set the layout to the left side            
        add(triesLeftPanel, BorderLayout.WEST);
        //add the treasures found panel to the game view 
        add(treasuresFoundPanel, BorderLayout.EAST);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //add the legend panel to the tries left section
        triesLeftPanel.add(legendPanel,BorderLayout.WEST);

        
       
        //make the game layout visible
        setVisible(true);
        
          
        
    }
    
    /**
     * to let the player know a treasure isn't present
     * 
     */
    public void foundNothing()
    {
        //set the last move textField to tell the play they didn't find a treasre
        lastMoveField.setText("Your last move: nothing");

    }
    
    /**
     * purpose: to let the play know they found a treasure
     * 
     */
    public void foundTreasure()
    {
        
        //set the last move textField to tell the player they found a treasure
        lastMoveField.setText("Your last move: Treasure");
              
    }
    /**
     * purpose: to update the User Interface of the game 
     */
    public void updateUI()
    {
        //set the text of the tries left text field to get the number of tries left
        triesLeftField.setText("" + treasureGame.getNumberOfTriesLeft());
        //set the text of the treasures text left field to get the number of treasures still hidden
        treasuresLeftField.setText("" + treasureGame.getNumberStillHidden());
        //set the text of the treasures found field to get the number of found treasures 
        treasuresFoundField.setText("" + treasureGame.getFoundTreasures());
        
        pointsScoredField.setText("" + treasureGame.getNumberOfPoints());
        
   
              
        
    }
    
   /**
    * purpose: to alert the player that a troll was found
    */    
    public void foundTroll()
    {
        //call the resetTreasureScore() method from the TreasureGame Class to reset the treasures found to  0
        treasureGame.resetTreasureScore();
        //display a message for the stolen treasures
        lastMoveField.setText("ill take that! >:P");
        //call the resetPoints method from the treasure game to erase the score to 0
        treasureGame.resetPoints();
    }
    
    /**
     * purpose: to end the game after it is played
     */
    public void endGame()     
    {
       //verify if the game is over
       if(treasureGame.isGameOver())
       {
           
           //verify if the player hasn't found all the treasures
           if(treasureGame.getNumberStillHidden() > 0)
           {
               //send a message to the player stating they lost for not findin all the treasures
               lastMoveField.setText("You lose");
               
           }
           
           //verify if the user found all the treasures
           if(treasureGame.getNumberStillHidden() == 20)
           {
               //send a message to the player indicating they have won for finding all the treasures
               lastMoveField.setText("You Win!");
           }
           
           //use a for loop to disable all of the buttons at the end of the game
           for(int index = 0; index<100; index++)
           {
                              
               //the empty button is part of the button grid array
               EmptyButton button = buttonGrid[index];
               //reveal the text underneath the button by using the reavealButtonText() method
               button.setText(button.revealButtonText());                                           
               //diable all the buttons when the game end
               button.setEnabled(false);
               
               
           }
       }
       
                     
    }
   
    
    private void makeAboutMenu()
    {
        //create an array to hold the developer names 
        String[] developerNames = {"Evan McClure", "Imahni king"};
        //create an array for the developers contact email
        String[] developerContacts = {"evanmccluregame@gmail.com" , "imahnikinggame@gmail.com"};
        //Create a new JMenu for the about section
        aboutMenu = new JMenu("about");
        //set the aboutMenu
        aboutMenu.setMnemonic(KeyEvent.VK_A);
        // loop to create menu items for every creator and add them to about menu
        for(int index = 0; index < developerNames.length; index++)
        {
            //create a string to hold the developer names in the index
            String itemName = developerNames[index];
            //create a string to holf the developer contacts in the index
            String itemContact = developerContacts[index];
            //has-a JMenuItem
            JMenuItem creatorItem = new JMenuItem(itemName + ":" + itemContact);
            //add the creator item to the about menu
            aboutMenu.add(creatorItem);
            
        }
    }
    
    private void makeOptionsMenu()
    {
        //has-a menuItem
        JMenuItem exitItem = new JMenuItem("Exit Game");
        //make a new JMenuBar for the optionsMenu
        optionsMenu = new JMenu("options");
        //add the exitlistener to the exitItem
        exitItem.addActionListener(new ExitListener());
        //add the exitItem to the Options Menu
        optionsMenu.add(exitItem);
    }
    
    private void makeMenuBar()
    {
        //make a new new menuBar
        menuBar = new JMenuBar();
        //call the makeOptionsMenu function
        makeOptionsMenu();
        //call the makeAboutMenu Function
        makeAboutMenu();
        //add the about menu to the menu bar
        menuBar.add(aboutMenu);
        //add the optionsMenu to the menu bar
        menuBar.add(optionsMenu);
        //set the menu bar
        setJMenuBar(menuBar);
    }
   
    
    /**
     * purpose: to use the main method to start the treasure hunt game
     */
    public static void main(String [] args)
    {
        //start a new Treasure game in the main method
        TreasureGame treasureGame = new TreasureGame();
        //start a new game view in the main method
        TreasureGameView treasureGameView = new TreasureGameView(treasureGame);
        
    }
    
    
}
