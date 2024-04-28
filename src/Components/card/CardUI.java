package Components.card;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Components.Coin;
import constants.*;

import java.awt.*;

public class CardUI extends JPanel{
    Card card;
    // icons
    private ImageIcon originalMainIcon;
    private ImageIcon originalScoreIcon;
    
    // panels
    private JPanel mainPanel;
    private JPanel northPanel;
    private JPanel southPanel;
    private JPanel centerPanel;
    private JPanel coinsPanel[];

    // labels
    private JLabel gameLabel;
    private JLabel scoreLabel;
    private JLabel countLabel;
    
    public CardUI(Game game){
        card = new Card(game);

        setGameIcon(game);
        setScoreIcon(card.getScore());

        makeCard(game);
        mainPanel.setPreferredSize(new Dimension(Size.CARD_WIDTH.getValue(), Size.CARD_HEIGHT.getValue()));
        add(mainPanel);
        setBorder(BorderFactory.createLineBorder(Color.RED, 4));
    }

    // upload the main icon (game icon)
    public void setGameIcon(Game game){
        String imagePath = Path.GAMES_PATH.getPath() + "\\";

        switch (game) {
            //stage 1
            case CAROUSEL:
                imagePath += "\\stage1\\carousel.PNG";
                break;
            case MARRY_GO_ROUND:
                imagePath += "\\stage1\\merry-go-round.PNG";
                break;
            case BALLOON_DOG:
                imagePath += "\\stage1\\balloon-dog.PNG";
                break;
            case SPRING_SWING_CAR:
                imagePath += "\\stage1\\spring-swing-car.PNG";
                break;

            // stage 2
            case BOUNCY_CASTLE:
                imagePath += "\\stage2\\bouncy-castle.PNG";
                break;
            case WATER_SLIDE:
                imagePath += "\\stage2\\water-slide.PNG";
                break;
            case BUMPER:
                imagePath += "\\stage2\\bumper.PNG";
                break;
            case BOXING_MACHINE:
                imagePath += "\\stage2\\boxing-machine.PNG";
                break;

            //stage 3
            case ROLLER_COASTER:
                imagePath += "\\stage3\\roller-coaster.PNG";
                break;
            case FERRIS_WHEEL:
                imagePath += "\\stage3\\ferris-wheels.PNG";
                break;
            case PIRATE_SHIP:
                imagePath += "\\stage3\\pirate-ship.PNG";
                break;
            case SPRING_SWING:
                imagePath += "\\stage3\\spinning-swing.PNG";
                break;
        }
        originalMainIcon = new ImageIcon(imagePath);
    }

    // upload score icon
    public void setScoreIcon(int score){
        String imagePath = Path.GAMES_PATH.getPath() + "\\score\\number-";

        switch (score) {
            case 0:
                imagePath += "0.PNG";
                break;
            case 1:
                imagePath += "1.PNG";
                break;
            case 2:
                imagePath += "2.PNG";
                break;
            case 3:
                imagePath += "3.PNG";
                break;
            case 4:
                imagePath += "4.PNG";
                break;
            case 5:
                imagePath += "5.PNG";
                break;
        }
        originalScoreIcon = new ImageIcon(imagePath);
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

    // add icon to a label and return the label
    public JLabel addIconToJLabel(ImageIcon icon, JLabel label){
        label = new JLabel();
        label.setIcon(icon);
        return label;
    }


    // make the north region of the card
    public void makeNorthRegion(){
        northPanel = new JPanel();
        JPanel specialCoinPanel = card.getSpecialCoin().createCoinPanel();
        // score
        northPanel.setLayout(new BorderLayout());
        northPanel.add(addIconToJLabel(setIconSize(Size.COIN_SIZE.getValue(), Size.COIN_SIZE.getValue(), originalScoreIcon), scoreLabel), BorderLayout.WEST);

        // special coin
        northPanel.add(specialCoinPanel, BorderLayout.EAST);
        northPanel.setPreferredSize(new Dimension(northPanel.getPreferredSize().width, Size.CARD_PANEL_VERTICAL_SIZE.getValue()));

    }

    // make the south region of the card
    public void makeSouthRegion(){
        southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        coinsPanel = new JPanel[card.getCountOfCoins()]; // Initialize the coinsPanel array

        for (int i = 0; i < card.getCountOfCoins(); i++){
            coinsPanel[i] = new JPanel();
            coinsPanel[i].add(card.getCoin(i).createCoinPanel());
            southPanel.add(coinsPanel[i]);
            southPanel.add(Box.createRigidArea(new Dimension(Size.GAP_SIZE.getValue(), 0)));
            southPanel.setPreferredSize(new Dimension(southPanel.getPreferredSize().width, Size.CARD_PANEL_VERTICAL_SIZE.getValue()));
        }
    }

    // make the center region of the card
    public void makeCenterRegion(){
        gameLabel = new JLabel(setIconSize(Size.GAME_ICON_WIDTH.getValue(), Size.GAME_ICON_HEIGHT.getValue(), originalMainIcon));
        centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        centerPanel.add(gameLabel);
    }
    

    public void makeCard(Game game){
        mainPanel = new JPanel(); 
        countLabel = makeLabelText(this);
        setLayout(new BorderLayout());
        
        makeNorthRegion();
        makeSouthRegion();
        makeCenterRegion();

        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(255, 236, 179));

        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        mainPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        mainPanel.setOpaque(true);
        mainPanel.revalidate();
        mainPanel.repaint();

        add(mainPanel, BorderLayout.CENTER);
        add(countLabel, BorderLayout.SOUTH);
    }

    private JLabel makeLabelText(CardUI card){
        int count = card.getCard().getCount();
        JLabel text = new JLabel();
        if (count > 0){
            text.setText(Integer.toString(count));
            setBackground(new Color(179, 157, 219));
        }
        else {
            text.setText("No Cards Left");
            setBackground(Color.RED);
        }

        text.setHorizontalAlignment(SwingConstants.CENTER);
        
        return text;
    }

    public void setCount(int count){
        if (count >= 0) {
            card.setCount(count);
        }
    }

    public void updateCard(int count){
        if (count != card.getCount()){
            setCount(count);
            remove(countLabel);
            countLabel = makeLabelText(this);
            add(countLabel, BorderLayout.SOUTH);
            revalidate();
            repaint();
        }
    }

    public JPanel getMainPanel(){
        return this.mainPanel;
    }
    
    public Card getCard() {
        return card;
    }

}

