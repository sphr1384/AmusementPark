package board.scoreBoard;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import player.Player;

public class PlayersPanel extends JPanel{
    JLabel name;
    JPanel center = new JPanel();
    JLabel scoreText = new JLabel("score:");
    JLabel score = new JLabel();

    public PlayersPanel(Player player){
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
        JPanel scorPanel = new JPanel();

        center.setLayout(new GridLayout(1, 2));
        scorPanel.setLayout(new GridLayout(2, 1));

        scorPanel.add(scoreText);
        score.setText(Integer.toString(player.getScore()));
        scorPanel.add(score);

        center.add(player.stuff.getAvatar());
        center.add(scorPanel);
    }
}
