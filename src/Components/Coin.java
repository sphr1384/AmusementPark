package Components;

import constants.*;
import javax.swing.*;
import java.awt.*;

public class Coin {
    private int count;
    private boolean isSpecial;
    private CoinColor color;
    private ImageIcon originalCoinIcon;
    private ImageIcon originalStarIcon;
    private ImageIcon coinIcon;
    private ImageIcon starIcon;
    private JLabel coinLabel;
    private JLabel starLabel;
    private JPanel coinPanel; // JPanel to contain the coin JLabel

    

    public Coin(int count, CoinColor color, boolean isSpecial) {
        this.isSpecial = isSpecial;
        this.count = count;
        this.color = color;
        this.coinPanel = createCoinPanel();
    }

  
    // upload the icon for the coin
    private void setCoinIcon(CoinColor color) {
        String imagePath = Path.COINS_PATH.getPath() + "\\coin-";
        switch (color) {
            case RED:
                imagePath += "red.PNG";
                break;
            case ORANGE:
                imagePath += "orange.PNG";
                break;
            case GREEN:
                imagePath += "green.PNG";
                break;
            case PINK:
                imagePath += "pink.PNG";
                break;
            case BLUE:
                imagePath += "blue.PNG";
                break;
            case GOLDEN:
                imagePath += "golden.PNG";
        }
        originalCoinIcon = new ImageIcon(imagePath);
    }

    private void setSpecialCoinIcon(CoinColor color){
        String imagePath = Path.MAIN_REPOSITORY.getPath() + "\\specialCoins\\specialCoin-";
        switch (color) {
            case RED:
                imagePath += "red.PNG";
                break;
            case ORANGE:
                imagePath += "orange.PNG";
                break;
            case GREEN:
                imagePath += "green.PNG";
                break;
            case PINK:
                imagePath += "pink.PNG";
                break;
            case BLUE:
                imagePath += "blue.PNG";
                break;
        }
        originalCoinIcon = new ImageIcon(imagePath);
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

    // return coin icon
    public ImageIcon createCoinIcon() {
        if (isSpecial == true){
            setSpecialCoinIcon(color);
        }
        else {
            setCoinIcon(color);
        }
        return setIconSize(Size.COIN_SIZE.getValue(), Size.COIN_SIZE.getValue(), originalCoinIcon);        
    }

    // retuen star icon
    public ImageIcon createStarIcon(){
        if (isSpecial == true){
            originalStarIcon = new ImageIcon(Path.COINS_PATH.getPath() + "\\stars.PNG");
            return setIconSize(Size.COIN_SIZE.getValue(), Size.COIN_SIZE.getValue(), originalStarIcon);
        }
        else return null;
   }

    // put star icon in star label and return the label
    public JLabel createStarLabel(ImageIcon starIcon){
        starIcon = createStarIcon();
        starLabel = new JLabel(starIcon);

        return coinLabel;
    }

    // put coin icon in coin label and return the label
    private JLabel createCoinLabel(ImageIcon icon){
        coinIcon = icon;
        coinLabel = new JLabel(coinIcon);
        
        coinLabel.setText(String.valueOf(count));

        return coinLabel;
    }

    public void updateCoin(int count){
        if (count != this.count && count >= 0){
            coinPanel.remove(coinLabel);
            this.count = count;
            coinLabel = createCoinLabel(coinIcon);
            coinPanel.add(coinLabel);
        }
    }

    // put coin label in coin panel and return coin panel
    public JPanel createCoinPanel(){
        coinLabel = createCoinLabel(createCoinIcon());
        starLabel = createStarLabel(createStarIcon());

        coinPanel = new JPanel();
        if (starLabel != null){
            coinPanel.setLayout(new BoxLayout(coinPanel, BoxLayout.Y_AXIS));
            coinPanel.add(starLabel);
            coinPanel.add(coinLabel);
            return coinPanel;
        }
        else{
            coinPanel.add(coinLabel);
            return coinPanel;
        }
    }
    
    

    // Getters
    public int getCount() {
        return count;
    }

    public CoinColor getColor() {
        return color;
    }
    
}
