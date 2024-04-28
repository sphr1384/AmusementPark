package board.mainBoard.center;

import javax.swing.JPanel;

import Interface.ClickCardListener;

import java.awt.GridLayout;

import board.Board;
import constants.Game;
import player.Player;

public class Center extends JPanel{
    private ShowCard card[] = new ShowCard[12];
    private ClickCardListener turnChangeListener;

    public Center(Board board, ClickCardListener turnChangeListener, Player player1, Player player2){
        this.turnChangeListener = turnChangeListener;
        setLayout(new GridLayout(3, 4));
        makeCardStartUp(board, player1, player2);
    }
    
    // put all cards in their position [every row is for one stage]
    private void makeCardStartUp(Board board, Player player1, Player player2){
        int i = 0;
        
        // stage 1
        i = createCards(Game.CAROUSEL, board, i, player1, player2);
        i = createCards(Game.MARRY_GO_ROUND, board, i, player1, player2);
        i = createCards(Game.BALLOON_DOG, board, i, player1, player2);
        i = createCards(Game.SPRING_SWING_CAR, board, i, player1, player2);
        
        // stage 2
        i = createCards(Game.BOUNCY_CASTLE, board, i, player1, player2);
        i = createCards(Game.WATER_SLIDE, board, i, player1, player2);
        i = createCards(Game.BUMPER, board, i, player1, player2);
        i = createCards(Game.BOXING_MACHINE, board, i, player1, player2);
            
        // stage 3
        i = createCards(Game.ROLLER_COASTER, board, i, player1, player2);
        i = createCards(Game.FERRIS_WHEEL, board, i, player1, player2);
        i = createCards(Game.PIRATE_SHIP, board, i, player1, player2);
        i = createCards(Game.SPRING_SWING, board, i, player1, player2);
    }

    // create cards (using ShowCard class)
    private int createCards(Game game, Board board, int i, Player player1, Player player2) {
        if (i < 12) {
            card[i] = new ShowCard(game, board, turnChangeListener, player1, player2);
            add(card[i]);
            return i + 1;
        }
        return i;
    }
}
