package board.scoreBoard;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import player.Player;

public class PlayersPanel extends JPanel{
    private JLabel name;
    private JPanel center = new JPanel();
    private JLabel scoreText = new JLabel("score:");
    private JLabel score = new JLabel();
    private Player player;
    private JPanel scorePanel = new JPanel();

    public PlayersPanel(Player player){
        this.player = player;
        // Set the preferred size of the panel
        setPreferredSize(new Dimension(150, 80));
        // Set the maximum size of the panel
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));


        name = new JLabel(player.stuff.getName());
        makeCenterPanel(player);

        setLayout(new BorderLayout());

        add(name, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
    }

    private void makeCenterPanel(Player player){
        center.setLayout(new GridLayout(1, 2));
        scorePanel.setLayout(new GridLayout(2, 1));

        scorePanel.add(scoreText);
        score.setText(Integer.toString(player.getScore()));
        scorePanel.add(score);

        center.add(player.stuff.getAvatar());
        center.add(scorePanel);
    }

    public void updateScore(int score){
        this.scorePanel.remove(this.score);
        this.score.setText(Integer.toString(player.getScore()));
        scorePanel.add(this.score);
        System.out.println("SSS");
            
        revalidate();
        repaint();
    }
}
