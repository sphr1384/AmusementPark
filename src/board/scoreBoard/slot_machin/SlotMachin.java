package board.scoreBoard.slot_machin;

import java.awt.Graphics;
import constants.Path;
import constants.Size;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.CoinColor;

public class SlotMachin extends JPanel{
    private ImageIcon originalIcon;
    private CoinColor color;
    private JLabel slotMachinLabel;



    public SlotMachin(CoinColor color){
        this.color = color;
        creatSlotMAchinIcon(color);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(originalIcon.getImage(), 0, 0, Size.SLOT_MACHIN_SIZE.getValue(), Size.SLOT_MACHIN_SIZE.getValue(), null);
    }

    private void creatSlotMAchinIcon(CoinColor color){
        String imagePath = Path.SLOT_MACHIN_PATH.getPath() + "//";

        switch (color){
            case PINK:
                imagePath += "pink.PNG";
                break;

            case ORANGE:
                imagePath += "orange.PNG";
                break;

            case RED:
                imagePath += "red.PNG";
                break;

            case BLUE:
                imagePath += "blue.PNG";
                break;

            case GREEN:
                imagePath += "green.PNG";
                break;
        }

        originalIcon = new ImageIcon(imagePath);
    }

    

    // add icon to a label and return the label
    public JLabel addIconToJLabel(ImageIcon icon, JLabel label){
        label = new JLabel();
        label.setIcon(icon);
        return label;
    }
}


