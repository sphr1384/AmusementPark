package player.presonalInformation;

public class GameInfo {
    public int pinkCoin;
    public int orangeCoin;
    public int redCoin;
    public int blueCoin;
    public int greenCoin;
    public int goldenCoin;

    public int specialPinkCoin;
    public int specialOrangeCoin;
    public int specialRedCoin;
    public int specialBlueCoin;
    public int specialGreenCoin;

   
    public GameInfo(){
        setDefaultValue();
    }

    public void setDefaultValue() {
        pinkCoin = 4;
        orangeCoin = 4;
        redCoin = 4;
        blueCoin = 4;
        greenCoin = 4;
        goldenCoin = 4;
        
        specialPinkCoin = 0;
        specialOrangeCoin = 0;
        specialRedCoin = 0;
        specialBlueCoin = 0;
        specialGreenCoin = 0;
    }
}
