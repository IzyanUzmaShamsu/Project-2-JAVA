package logingame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class TicTacToeGame extends JFrame { //TicTacToeGame(subclass) inherits JFrame(superclass). 
//The meaning of "extends" is to increase the functionality.*allowing one class to incorporate another class into its declaration.
    private Container frame;
    private String Player; //To keep track player's turn 
    private JButton[][] board; //2D array (the board)
    private boolean Winner; //To signal whether have a winner or not
    private JMenuBar menuBar; //To add a container for menus
    private JMenu menu;
    private JMenuItem quit; //Encapsulates an element(quit) in a menu
    private JMenuItem newGame; //Encapsulates an element(newGame) in a menu

    public TicTacToeGame() { //Constructor
        super(); //A subclass execute its superclass's contructor. *can reuse methods and fields of the parent class
        frame = getContentPane(); //The content pane(layer that is used to hold objects) is just a Container that covers the visible area of the JFrame. 
        frame.setLayout(new GridLayout(3, 3)); //Lays out components within a grid.
        setTitle("Tic Tac Toe"); //To give a title of the frame
        setSize(350, 350); //To give the frame an initial size
        setDefaultCloseOperation(EXIT_ON_CLOSE); //used to specify one of several options for the close button- DISPOSE_ON_CLOSE:Exit the application.
        setVisible(true); //Display the frame
        Player = "X"; //player X always go first
        board = new JButton[3][3]; //create 3 by 3 board (that board is the type of JButton)
        Winner = false; //Just been created a new game so there is no winner
        Board();
        MenuBar();
    }

    private void MenuBar() { //Initialize MenuBar
        menuBar = new JMenuBar();
        menu = new JMenu("File");

        newGame = new JMenuItem("New Game"); //To create the file menu item which is "New Game".
        newGame.addActionListener(new ActionListener() {
            /*An anonymous inner class is created that implements the ActionListener interface.
              Action Listener defines a method that receives a notification when an action(clicking a button) take place.
            */
            @Override
            public void actionPerformed(ActionEvent ae) { //Handle button events
                resetBoard();
            }
        });

        quit = new JMenuItem("Quit"); //To create the file menu item which is "Quit".
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        menu.add(newGame);
        menu.add(quit);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private void resetBoard() { //when the user click New Game the board will be reset (reseting the field)
        Player = "X";
        Winner = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j].setText("");
            }
        }
    }

    private void Board() { //Initialize Board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton btn = new JButton("");
                btn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 45));
                btn.setBackground(Color.PINK);
                btn.setForeground(Color.BLACK);
                board[i][j] = btn;
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (((JButton) e.getSource()).getText().equals("") && Winner == false) {
                            btn.setText(Player);
                            Winner();
                            nextPlayer();
                        }
                    }
                });
                frame.add(btn); //To add the button to the container pane
            }
        }
    }

    public boolean isFull() { //To determine if game board is full and no winner then it will be draw game and no one  get three in a row
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].getText() == "") {
                    return false;
                }
            }
        }

        return true;
    }

    private void nextPlayer() { //Change move method, when player X move, then player O will be the next turn.
        if (Player.equals("X")) {
            Player = "O";
        } else {
            Player = "X";
        }
    }

    private void Winner() { // To determine who is the winner in that game or game draw.
        if (board[0][0].getText().equals(Player) && board[1][0].getText().equals(Player) && board[2][0].getText().equals(Player)) {
            JOptionPane.showMessageDialog(null, "Player " + Player + " Won!");
            Winner = true;
        } else if (board[0][1].getText().equals(Player) && board[1][1].getText().equals(Player) && board[2][1].getText().equals(Player)) {
            JOptionPane.showMessageDialog(null, "Player " + Player + " Won!");
            Winner = true;
        } else if (board[0][2].getText().equals(Player) && board[1][2].getText().equals(Player) && board[2][2].getText().equals(Player)) {
            JOptionPane.showMessageDialog(null, "Player " + Player + " Won!");
            Winner = true;
        } else if (board[0][0].getText().equals(Player) && board[0][1].getText().equals(Player) && board[0][2].getText().equals(Player)) {
            JOptionPane.showMessageDialog(null, "Player " + Player + " Won!");
            Winner = true;
        } else if (board[1][0].getText().equals(Player) && board[1][1].getText().equals(Player) && board[1][2].getText().equals(Player)) {
            JOptionPane.showMessageDialog(null, "Player " + Player + " Won!");
            Winner = true;
        } else if (board[2][0].getText().equals(Player) && board[2][1].getText().equals(Player) && board[2][2].getText().equals(Player)) {
            JOptionPane.showMessageDialog(null, "Player " + Player + " Won!");
            Winner = true;
        } else if (board[0][0].getText().equals(Player) && board[1][1].getText().equals(Player) && board[2][2].getText().equals(Player)) {
            JOptionPane.showMessageDialog(null, "Player " + Player + " Won!");
            Winner = true;
        } else if (board[0][2].getText().equals(Player) && board[1][1].getText().equals(Player) && board[2][0].getText().equals(Player)) {
            JOptionPane.showMessageDialog(null, "Player " + Player + " Won!");
            Winner = true;
        } else if (isFull()) {
            JOptionPane.showMessageDialog(null, "Draw Game!");

        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TicTacToeGame();
            }
        });
    }
}

