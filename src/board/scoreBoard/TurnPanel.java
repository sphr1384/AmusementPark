package board.scoreBoard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import player.Player;

public class TurnPanel extends JPanel {
    Player player1;
    Player player2;
    JLabel turnText = new JLabel("turn: ");
    JLabel playerName;
    JPanel turnBox = new JPanel();
    JPanel colorfulPanels[] = new JPanel[4];

    public TurnPanel(Player player1, Player player2){
        setLayout(new BorderLayout());
        turnBox.setLayout(new GridLayout(1, 2));

        this.player1 = player1;
        this.player2 = player2;
        turnBox.add(turnText);
        setNameLabel();

        createColorfulLabel();
        colorfulPanels[0].setPreferredSize(new Dimension(100, 40));
        add(colorfulPanels[0], BorderLayout.NORTH);
        colorfulPanels[1].setPreferredSize(new Dimension(100, 40));
        add(colorfulPanels[1], BorderLayout.SOUTH);
        add(colorfulPanels[2], BorderLayout.WEST);
        add(colorfulPanels[3], BorderLayout.EAST);

        add(turnBox, BorderLayout.CENTER);
    }

    private void setNameLabel(){
        if (Player.turn == 1){
            playerName = new JLabel(player1.stuff.getName());
            playerName.setBackground(new Color(233, 30, 99));
        }
        else {
            playerName = new JLabel(player2.stuff.getName());
            playerName.setBackground(new Color(255, 152, 0));
        }

        playerName.setOpaque(true);
        turnBox.add(playerName);
    }

    public void updateTurn(){
        Player.changeTurn();

        turnBox.remove(playerName);
        setNameLabel();

        revalidate();
        repaint();
        
    }

    private void createColorfulLabel(){
        for (int i = 0; i < 4; i++){
            colorfulPanels[i] = new JPanel();
            colorfulPanels[i].setBackground(new Color(121, 85, 72));
        }
    }

    public JPanel getTurnBox() {
        return turnBox;
    }
}
