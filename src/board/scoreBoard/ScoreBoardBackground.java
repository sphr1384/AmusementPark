package board.scoreBoard;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import constants.Path;

public class ScoreBoardBackground extends JPanel{
    private Image backgroundImageSecondary;

    public ScoreBoardBackground(){
        ImageIcon imageIconSecondary = new ImageIcon(Path.BACKGROUND_PATH.getPath() + "\\WoodenBackgroundCropped1.JPG");
        backgroundImageSecondary = imageIconSecondary.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (backgroundImageSecondary != null) {
            g.drawImage(backgroundImageSecondary, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
