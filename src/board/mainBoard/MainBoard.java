package board.mainBoard;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import Interface.ClickCardListener;
import board.Board;
import board.mainBoard.center.Center;
import constants.Size;
import player.Player;

public class MainBoard extends JPanel {
    private MainBackground mainBackground;
    private JPanel centerPanel;
    private ClickCardListener turnChangeListener;


    public MainBoard(Board board, ClickCardListener turnChangeListener, Player player1, Player player2) {
        // setLayout(new BorderLayout());
        this.turnChangeListener = turnChangeListener;
        setMainBoard(board, player1, player2);
        //setBackground();
    }

    // Set background for the main board
    private void setBackground() {
        int width = (int) (Size.SCREEN_WIDTH.getValue() * 0.8);
        int height = Math.round(Size.SCREEN_HEIGHT.getValue());
        mainBackground = new MainBackground();
        mainBackground.setPreferredSize(new Dimension(width, height));
        add(mainBackground, BorderLayout.CENTER); // Add MainBackground to the center
    }

    // Create the main board
    private void setMainBoard(Board board, Player player1, Player player2) {
        centerPanel = new Center(board, turnChangeListener, player1, player2);
        add(centerPanel, BorderLayout.CENTER); // Add centerPanel to the center
    }
}
