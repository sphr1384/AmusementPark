package welcomePage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.Size;
import player.Player;
import player.presonalInformation.Avatar;

public class NamePanel extends JPanel{
    private String name1;
    private String name2;

    private JButton avatarButton;
    
    private AvatarPanel avatarPanel;

    private JTextField player1TextField;
    private JTextField player2TextField;

    JPanel player1InfoPanel = new JPanel();
    JPanel player2InfoPanel = new JPanel();
    Player player1;
    Player player2;
    

    public NamePanel(WelcomePage page, int number){
        setLayout(new GridLayout(2, 2));

        if (number == 1){
            createUI(page, number,  player1);
            add(player1InfoPanel);
        }
        else if (number == 2){
            createUI(page, number,  player2);
            add(player2InfoPanel);
        } 
        
        setBorder(BorderFactory.createLineBorder(new Color( 0, 121, 107), 4));
    }

    private void createUI(WelcomePage page, int number, Player player){
        if (number == 1){
            player1TextField = new JTextField();
        }
        else if (number == 2){
            player2TextField = new JTextField();
        }    

        JPanel avatarPanel = createAvatarPanel(page, number);

        JLabel northLabel = new JLabel("Player " + Integer.toString(number) + ": ");
        JLabel nameLabel = new JLabel("Name: ");
        JLabel avatarLabel = new JLabel("Avatar: ");
        JPanel center = new JPanel();


        if (number == 1){
            player1InfoPanel.setLayout(new BorderLayout());
        }
        else if (number == 2){
            player2InfoPanel.setLayout(new BorderLayout());
        }        
        center.setLayout(new GridLayout(2, 2));

        // set up center panel
        center.add(nameLabel);

        if (number == 1){
            center.add(player1TextField);
        }
        else if (number == 2){
            center.add(player2TextField);
        }
        
        center.add(avatarLabel);
        center.add(avatarPanel);

        // set up player information panel
        if (number == 1){
            player1InfoPanel.add(northLabel, BorderLayout.NORTH);
            player1InfoPanel.add(center, BorderLayout.CENTER);
        }
        else if (number == 2){
            player2InfoPanel.add(northLabel, BorderLayout.NORTH);
            player2InfoPanel.add(center, BorderLayout.CENTER);
        }
        
    }

    private JPanel createAvatarPanel(WelcomePage page, int number){
        JPanel panel = new JPanel();
        panel.setSize(Size.AVATAR_SIZE.getValue(), Size.AVATAR_SIZE.getValue());
        avatarButton = new JButton("Choose your avatar");

        panel.add(avatarButton);

        avatarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JDialog dialog =  new JDialog();
                dialog.setSize(300, 300);
                avatarPanel = new AvatarPanel(dialog, panel); 
                dialog.add(avatarPanel);
                for (Avatar avatar : avatarPanel.avatar) { 
                    avatar.setButtonPanel(panel); 
                }
                dialog.setVisible(true);
            }
        });

        return panel;
    }

    public void creatTextField(int number, Player player, JTextField textField){
        textField.setColumns(10);
        textField.setBackground(Color.GRAY);

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (number == 1){
                    name1 = textField.getText();
                }
                else if (number == 2){
                    name2 = textField.getText();
                }
                
            }
        });
    }

    public String getName1() {
        return name1;
    }
    public String getName2() {
        return name2;
    }

    public AvatarPanel getAvatarPanel() {
        return avatarPanel;
    }

}
