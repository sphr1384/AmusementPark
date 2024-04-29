package board.scoreBoard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Components.Coin;
import Components.card.CardUI;
import board.Board;
import constants.Path;
import constants.Size;
import player.Player;

public class Wallet extends JPanel implements MouseListener{
    private ImageIcon originalIcon = new ImageIcon(Path.MAIN_REPOSITORY.getPath() + "\\wallet.PNG");
    private JLabel label;
    private JPanel cardPanel = new JPanel();
    private JPanel coinPanel;
    private JPanel specialCoinPanel;
    private Player player;
    private Board board;
    private CardUI card[] = new CardUI[12];
    private Coin coin[] = new Coin[6];
    private Coin specialCoin[] = new Coin[5];
    private JPanel panelForCoin = new JPanel();

    private JDialog dialog;

    public Wallet(Player player, Board board){
        this.board = board;
        this.player = player;
        setCoin();
        setSpecialCoin();

        creatWallet();

        this.addMouseListener(this);
    }

    private void setCards(){
        for (int i = 0; i < 12; i++){
            if (player.getPlayerCard().getCard()[i] != null && i < player.getPlayerCard().getCard().length){
                card[i] = player.getPlayerCard().getCard()[i];
            }
        }
    }

    private void setCoin(){
        for (int i = 0; i < 6; i++){
            if (player.getPlayerCoin().getCoins()[i].getCount() >= 0){
                coin[i] = player.getPlayerCoin().getCoins()[i];
            }
        }
    }

    private void setPanelForCoin(){
        panelForCoin.setLayout(new GridLayout(4, 1));
        panelForCoin.add(coinPanel);
        panelForCoin.add(specialCoinPanel);
    }

    private void setSpecialCoin(){
        for (int i = 0; i < 5; i++){
            if (player.getPlayerCoin().getSpaecialCoins()[i].getCount() >= 0){
                specialCoin[i] = player.getPlayerCoin().getSpaecialCoins()[i];
            }
        }
    }

    private void creatWallet(){
        setCards();
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
    public void mouseClicked(MouseEvent e) {
        dialog = new JDialog(board);
        dialog.setTitle(player.stuff.getName() + " wallet:");
        dialog.setLayout(new BorderLayout());
        creatCards(player);
        cardPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));

        creatCoins(player, true);
        creatCoins(player, false);
        setPanelForCoin();
        panelForCoin.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));

        dialog.add(cardPanel, BorderLayout.CENTER);
        dialog.add(panelForCoin, BorderLayout.EAST);

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

    private void creatCards(Player player){
        cardPanel.setLayout(new GridLayout(3, 4, 10, 10));
        for (int i = 0; i < 12; i++){
            if (card[i] != null) {
                cardPanel.add(card[i]);
            }
        }  
    }

    private void creatCoins(Player player, boolean isSpecial){
        if (!isSpecial && coinPanel == null){
            coinPanel = new JPanel();
            coinPanel.setLayout(new GridLayout(3, 2));
            for (int i = 0; i < 6; i++){
                if (coin[i].createCoinPanel() != null){
                    coinPanel.add(coin[i].createCoinPanel());
                }
            }
            coinPanel.setBorder(BorderFactory.createLineBorder(new Color(149, 117, 205), 4));
        }

        else if(specialCoinPanel == null) {
            specialCoinPanel = new JPanel();
            specialCoinPanel.setLayout(new GridLayout(3, 2));
            for (int i = 0; i < 5; i++){
                if (specialCoin[i].createCoinPanel() != null){
                    specialCoinPanel.add(specialCoin[i].createCoinPanel());
                }
            }
            specialCoinPanel.setBorder(BorderFactory.createLineBorder(new Color(149, 117, 205), 4));
        }
    }

    public CardUI[] getCard() {
        return card;
    }
}
