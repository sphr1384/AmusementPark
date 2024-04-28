package welcomePage;

import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;

import constants.AvatarsName;
import player.presonalInformation.Avatar;

public class AvatarPanel extends JPanel{
    Avatar avatar[] = new Avatar[10];
    private Avatar selectedAvatar; 

    public AvatarPanel(JDialog dialog, JPanel buttonPanel){
        setLayout(new GridLayout(3, 4));

        
        createAvatar(AvatarsName.MAN_1, 0, dialog, this, buttonPanel);
        createAvatar(AvatarsName.MAN_2, 1, dialog, this, buttonPanel);
        createAvatar(AvatarsName.MAN_3, 2, dialog, this, buttonPanel);

        createAvatar(AvatarsName.WOMAN_1, 3, dialog, this, buttonPanel);
        createAvatar(AvatarsName.WOMAN_2, 4, dialog, this, buttonPanel);
        createAvatar(AvatarsName.WOMAN_3, 5, dialog, this, buttonPanel);

        createAvatar(AvatarsName.PERSON_1, 6, dialog, this, buttonPanel);
        createAvatar(AvatarsName.PERSON_2, 7, dialog, this, buttonPanel);
        createAvatar(AvatarsName.PERSON_3, 8, dialog, this, buttonPanel);
        createAvatar(AvatarsName.PERSON_4, 9, dialog, this, buttonPanel);
    }

    private void createAvatar(AvatarsName name, int i, JDialog dialog, AvatarPanel avatarPanel, JPanel buttonPanel){
        avatar[i] = new Avatar(name, avatarPanel, buttonPanel);
        add(avatar[i]);
        avatar[i].setParentDialog(dialog);
    }

    public Avatar getAvatars(int i){
        return avatar[i];
    }

    public Avatar getSelectedAvatar(){ 
        return selectedAvatar;
    }

    public void setSelectedAvatar(Avatar selectedAvatar){ 
        this.selectedAvatar = selectedAvatar;
    }
}
