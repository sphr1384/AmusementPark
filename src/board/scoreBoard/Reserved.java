package board.scoreBoard;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

 import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Components.card.CardUI;
import board.Board;
import constants.Path;
import constants.Size;
import player.Player;

public class Reserved extends JPanel implements MouseListener{
    private ImageIcon originalIcon = new ImageIcon(Path.MAIN_REPOSITORY.getPath() + "\\reserved.PNG");
    private JLabel label = new JLabel();
    private JLabel emptyLabel;
    private Player player;
    private Board board;
    private CardUI[] reservedCards = new CardUI[3];

    private JDialog dialog;

    public Reserved(Player player, Board board){
        this.board = board;
        this.player = player;
        creatReservedPanel();

        this.addMouseListener(this);
    }

    private void creatReservedPanel(){
        label = new JLabel(setIconSize(Size.GAME_ICON_WIDTH.getValue(), Size.GAME_ICON_WIDTH.getValue(), originalIcon));
        add(label);
        
    }

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

     @Override
    public void mouseClicked(MouseEvent e){
        dialog = new JDialog(board);
        dialog.setTitle("Reserved Cards");
        dialog.setLayout(new GridLayout(2, 2));

        creatCards();
        
        dialog.pack();
        dialog.setVisible(true);
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

    private void creatCards(){
        if (player.playerReservedCard.totalReserved <= 0){
            emptyLabel = new JLabel();
            emptyLabel.setText("You have no reserved card!");
            emptyLabel.setOpaque(true);
            emptyLabel.setBackground(Color.red);
            dialog.add(emptyLabel);
        }

        else {
            for (int i = 0; i < player.playerReservedCard.totalReserved; i++){
                reservedCards[i] = player.playerReservedCard.cardList.get(i);
                dialog.add(reservedCards[i]);
            }
        }   
    }

}
