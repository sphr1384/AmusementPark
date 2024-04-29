// create clickable panels of cards in the store

package board.mainBoard.center;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import Components.card.CardUI;
import Interface.ClickCardListener;
import board.Board;
import constants.Game;
import constants.Path;
import player.Player;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ShowCard extends JPanel implements MouseListener {
    JDialog decisionDialog;
    JButton[] buttons = new JButton[3];
    JPanel buttonPanel;
    CardUI card;

    ImageIcon buy;
    ImageIcon reserve;
    ImageIcon exit;

    private Player player1;
    private Player player2;

    private ClickCardListener turnChangeListener;

    // Constructor
    public ShowCard(Game game, Board board, ClickCardListener turnChangeListener, Player player1, Player player2) {
        this.turnChangeListener = turnChangeListener;
        this.player1 = player1;
        this.player2 = player2;
        setIcones();
        card = new CardUI(game);

        card.updateCard(4);

        add(card);

        createDialog();
        setupButtons();

        this.addMouseListener(this);
    }

    private void setIcones(){
        buy = new ImageIcon(Path.MAIN_REPOSITORY.getPath() + "\\buy.PNG");
        reserve = new ImageIcon(Path.MAIN_REPOSITORY.getPath() + "\\reservation.PNG.PNG");
        exit = new ImageIcon(Path.MAIN_REPOSITORY.getPath() + "\\exit.PNG.PNG");
    }

    public void setTurnChangeListener(ClickCardListener turnChangeListener) {
        this.turnChangeListener = turnChangeListener;
    }
    

    // Create dialog and add buttons to it
    private void createDialog() {
        decisionDialog = new JDialog();
        decisionDialog.setTitle("Decide What to Do");
        decisionDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        decisionDialog.setLayout(new BorderLayout());

        buttonPanel = new JPanel(new GridLayout(1, 3, 10, 10)); // 10 pixels horizontal and vertical gap
        buttonPanel.setBackground(Color.WHITE); // Set background color for the button panel

        for (int i = 0; i < 3; i++) {
            buttons[i] = createButton(i);
            buttonPanel.add(buttons[i]);
        }

        decisionDialog.add(buttonPanel, BorderLayout.CENTER);
        decisionDialog.pack();
        decisionDialog.setLocationRelativeTo(null); // Center the dialog on the screen
    }

    // Create and return buttons
    private JButton createButton(int index) {
        JButton button = new JButton();
        button.setBackground(Color.PINK);
        switch (index) {
            case 0:
                button.setText("Buy");
                break;

            case 1:
                button.setText("Reserve");
                break;

            case 2:
                button.setText("Exit");
                break;
        }
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int condition;
                // buy button
                if (index == 0){
                    if (card.getCard().getCount() > 0){
                        card.updateCard(card.getCard().getCount() - 1);
                        condition = turnChangeListener.onWalletUpdate_coin(card);

                        if (condition != -1){
                            turnChangeListener.onWalletUpdate_specialCoin(card);
                            turnChangeListener.onWalletUpdate_card(card);
                            turnChangeListener.onScore(card);
                            turnChangeListener.onTurnChange();
                        
                            decisionDialog.dispose();
                        }
                    }   
                }

                    // reserve button
                    else if (index == 1){
                        if (card.getCard().getCount() > 0){
                            if (isDisposingValid()){
                                card.updateCard(card.getCard().getCount() - 1);
                                turnChangeListener.onReservationUpdate(card);
                                turnChangeListener.onTurnChange();
    
                                decisionDialog.dispose();
                            }
                            
                        }
                    }

                    // exit button
                    else if (index == 2) {
                        decisionDialog.dispose();
                    }
                    
                }
            
        });
        return button;
    }

    private boolean isDisposingValid(){
        if (Player.turn == 1){
            if (player1.playerReservedCard.totalReserved < 3){
                return true;
            }
            else return false;
        }
        else if (Player.turn == 2){
            if (player2.playerReservedCard.totalReserved < 3){
                return true;
            }
            else return false;
        }

        else return false;
    }

    // Setup button listeners
    private void setupButtons() {
    }

    // If mouse clicked on the panel, show the dialog
    @Override
    public void mouseClicked(MouseEvent e) {
        decisionDialog.setVisible(true);
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
}

