package board;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import constants.*;
import player.Player;
import board.mainBoard.MainBoard;
import board.scoreBoard.ScoreBoard;

import java.awt.BorderLayout;
import java.awt.Color;


public class Board extends JFrame {
    private ImageIcon AmusementPark = new ImageIcon(Path.MAIN_REPOSITORY.getPath() + "AmusementPark.png");
    private MainBoard mainBoard;
    private ScoreBoard scoreBoard;
    JPanel voidPanelW = new JPanel();
    JPanel voidPanelN = new JPanel();
    JPanel voidPanelS = new JPanel();

    public Board(Player player1, Player player2){
        scoreBoard = new ScoreBoard(this, player1, player2);
        mainBoard = new MainBoard(this, scoreBoard, player1, player2); 
        
        setBoardFrameBasical();
        setBoard();

    }

   
    private void setBoardFrameBasical() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState((int) JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setIconImage(AmusementPark.getImage());
        setTitle("Amusement Park");
    }

    private void setBoard(){
        setLayout(new BorderLayout());
        mainBoard.setBackground(Color.BLACK);
        scoreBoard.setBackground(Color.BLACK);
        voidPanelN.setBackground(Color.BLACK);
        voidPanelS.setBackground(Color.BLACK);
        voidPanelW.setBackground(Color.BLACK);
        add(scoreBoard, BorderLayout.EAST);
        add(mainBoard, BorderLayout.CENTER);
        add(voidPanelW, BorderLayout.WEST);
        add(voidPanelN, BorderLayout.NORTH);
        add(voidPanelS, BorderLayout.SOUTH);

    }
}
