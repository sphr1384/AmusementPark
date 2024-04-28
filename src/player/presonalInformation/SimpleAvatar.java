package player.presonalInformation;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.AvatarsName;
import constants.Path;
import constants.Size;

public class SimpleAvatar extends JPanel{
    private ImageIcon originalIcon;
    private AvatarsName name;

    public SimpleAvatar(AvatarsName name){
        this.name = name;
        setAvatarIcon(name);
        makeAvatarPanel();
    }

    private void setAvatarIcon(AvatarsName name){
        String path = Path.AVATAR_PATH.getPath();
        switch (name) {
            case MAN_1:
                originalIcon = new ImageIcon(path + "\\man1.PNG");
                break;
            case MAN_2:
                originalIcon = new ImageIcon(path + "\\man2.PNG");
                break;
            case MAN_3:
                originalIcon = new ImageIcon(path + "\\man3.PNG");
                break;
            case WOMAN_1:
                originalIcon = new ImageIcon(path + "\\woman1.PNG");
                break;
            case WOMAN_2:
                originalIcon = new ImageIcon(path + "\\woman2.PNG");
                break;
            case WOMAN_3:
                originalIcon = new ImageIcon(path + "\\woman3.PNG");
                break;
            case PERSON_1:
                originalIcon = new ImageIcon(path + "\\person1.PNG");
                break;
            case PERSON_2:
                originalIcon = new ImageIcon(path + "\\person2.PNG");
                break;
            case PERSON_3:
                originalIcon = new ImageIcon(path + "\\person3.PNG");
                break;
            case PERSON_4:
                originalIcon = new ImageIcon(path + "\\person4.PNG");
                break;
            
        }
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

    private void makeAvatarPanel(){
        JLabel avatarLabel = new JLabel(setIconSize(Size.AVATAR_SIZE.getValue(), Size.AVATAR_SIZE.getValue(), originalIcon));
        add(avatarLabel);
    }

}
