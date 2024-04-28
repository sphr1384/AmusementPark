package constants;

import java.awt.Dimension;
import java.awt.Toolkit;

public enum Size {
    COIN_SIZE(25),
    CARD_WIDTH(120),
    CARD_HEIGHT(150),
    GAME_ICON_WIDTH(60),
    GAME_ICON_HEIGHT(40),
    CARD_PANEL_VERTICAL_SIZE(35),
    AVATAR_SIZE(50),
    SLOT_MACHIN_SIZE(50),
    GAP_SIZE(2),
    SCREEN_WIDTH(getScreenSize().width),
    SCREEN_HEIGHT(getScreenSize().height);

    private final int value;

    private Size(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    private static Dimension getScreenSize() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        return toolkit.getScreenSize();
    }

}