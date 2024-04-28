// set background for the main board

package board.mainBoard;

import constants.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MainBackground extends JPanel {
    private Image backgroundImageMain;

    public MainBackground() {
        ImageIcon imageIconMain = new ImageIcon(Path.BACKGROUND_PATH.getPath() + "\\WoodenBackground1.JPG");
        backgroundImageMain = imageIconMain.getImage();
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw background Image Main
        if (backgroundImageMain != null) {
            g.drawImage(backgroundImageMain, 0, 0, getWidth(), getHeight(), this);
        }

       
    }
}


