package board.scoreBoard.slot_machin;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Interface.SlotMachinChosenCoinListener;
import board.scoreBoard.TurnPanel;
import constants.Path;

public class EntranceLogo extends JPanel implements MouseListener{
    private ImageIcon originaIcon;
    private ChooseCoin slotMachinDialog;
    TurnPanel turnPanel;

    private SlotMachinChosenCoinListener slotMachinChosenCoinListener;
    
    
    public EntranceLogo(SlotMachinChosenCoinListener slotMachinChosenCoinListener, TurnPanel turnPanel){
        this.turnPanel = turnPanel;
        this.slotMachinChosenCoinListener = slotMachinChosenCoinListener;
        creatLogo();
        addMouseListener(this);
    }

    // set size for an icon
    private ImageIcon setIconSize(int width, int height, ImageIcon originalIcon) {
        if (originalIcon != null) {
            Image originalImage = originalIcon.getImage();
            Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return resizedIcon;
        }
        else {
            return null;
        }
    }

    private void creatLogo(){
        originaIcon = new ImageIcon(Path.MAIN_REPOSITORY.getPath() + "\\goldHill.JFIF");
        JLabel logo = new JLabel(setIconSize(100, 100, originaIcon));
        add(logo);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        slotMachinDialog = new ChooseCoin(slotMachinChosenCoinListener, turnPanel);
        slotMachinDialog.setVisible(true);
    }

    // Other mouse listener methods
    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    public ChooseCoin getSlotMachinDialog() {
        return slotMachinDialog;
    }

}


