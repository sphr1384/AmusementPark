package welcomePage;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import board.Board;
import constants.AvatarsName;
import player.Player;
import player.presonalInformation.SimpleAvatar;

public class WelcomePage extends JDialog{
    private OnAcceptClickListener listener;

    private boolean isAccepted = false;
    private NamePanel namePanel1;
    private NamePanel namePanel2;
    private Board board;

    private Player player1;
    private Player player2;
    private JLabel welcomeText = new JLabel("Welcome to the Amusement Park!");
    private JButton accept = new JButton("accept");
    private JPanel center = new JPanel();

    public WelcomePage(OnAcceptClickListener listener){
        setLayout(new BorderLayout());

        this.listener = listener;

        center.setLayout(new FlowLayout(FlowLayout.LEFT));
        namePanel1 = new NamePanel(this, 1);
        namePanel2 = new NamePanel(this, 2);
        center.add(namePanel1);
        center.add(namePanel2);

        createAcceptButton();
        add(welcomeText, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(accept, BorderLayout.SOUTH);
        pack();
        setVisible(true);

    }

    private void createAcceptButton(){
        accept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (namePanel1.getName1() != null && namePanel2.getName2() != null && namePanel1.getAvatarPanel().getSelectedAvatar() != null && namePanel2.getAvatarPanel().getSelectedAvatar() != null){
                    player1 = new Player(namePanel1.getName1(), namePanel1.getAvatarPanel().getSelectedAvatar());
                    player2 = new Player(namePanel2.getName2(), namePanel2.getAvatarPanel().getSelectedAvatar());
                    listener.onAcceptClick();
                    dispose();
                }

                else {
                    SimpleAvatar ava1 = new SimpleAvatar(AvatarsName.MAN_1);
                    SimpleAvatar ava2 = new SimpleAvatar(AvatarsName.WOMAN_1);

                    player1 = new Player("Player 1", ava1);
                    player2 = new Player("Player 2", ava2);
                    listener.onAcceptClick();
                    dispose();
                }
            }
        });
    }

    public boolean isAccepted() {
        return isAccepted;
    }


    public Player getPlayer1() {
        return player1;
    }
    public Player getPlayer2() {
        return player2;
    }
    public Board getBoard() {
        return board;
    }

    public Player getPlayer(int number){
        if (number == 1){
            return player1;
        }
        else if(number == 2) {
            return player2;
        }
        else {
            System.out.println("Invalid playerNumber");
            return null;
        }
    }

}
