package player.presonalInformation;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import constants.AvatarsName;
import welcomePage.AvatarPanel;

public class Avatar extends SimpleAvatar implements MouseListener{
    private AvatarPanel avatarPanel;
    private JPanel buttonPanel;

    private JDialog parentDialog; // dialog which is created in NamePanel
    public String ChosenAvatarName; // to store the name of hte choosen one
    private boolean isChosen = false;

    public Avatar(AvatarsName name, AvatarPanel avatarPanel, JPanel buttonPanel){
        super(name); // Call the constructor of SimpleAvatar
        this.avatarPanel = avatarPanel;
        this.buttonPanel = buttonPanel;
        this.addMouseListener(this);
    }

    public void setParentDialog(JDialog parentDialog) {
        this.parentDialog = parentDialog;
    }

    public boolean getIsChosen(){
        return isChosen;
    }

     // If mouse clicked on the panel, isChosen becomes true
     @Override
     public void mouseClicked(MouseEvent e) {
        JButton accept = new JButton("accept");
        JButton deny = new JButton("deny");

        JDialog di = new JDialog();
        di.setSize(100, 100);
        di.setLayout(new FlowLayout());
        di.add(accept);
        di.add(deny);
        di.setVisible(true);

        accept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                isChosen = true;
                
                avatarPanel.setSelectedAvatar(Avatar.this);
                buttonPanel.removeAll(); 
                buttonPanel.add(Avatar.this); 
                buttonPanel.revalidate();
                buttonPanel.repaint();

                di.dispose();
                parentDialog.dispose();
            }
        });

        deny.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                di.dispose();
            }
        });
        
    }

    public void setButtonPanel(JPanel buttonPanel) {
        this.buttonPanel = buttonPanel;
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
