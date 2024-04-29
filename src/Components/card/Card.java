package Components.card;

import Components.Coin;
import constants.CoinColor;
import constants.Game;

public class Card {
    // non graphical attributes
    public int score;
    private int countOfCoins;
    private String cardCode = "P0-O0-R0-B0-G0/--";
    private Coin coins[];
    private Coin specialCoin;
    private Game game;
    private int count;

    public Card(Game game){
        this.game = game;
        setCardCode(game);
        setCountOfCoins();
        setCoins();
        setSpecialCoin();
    }

    // set card code
    public void setCardCode(Game game){
        switch (game) {
            //stage 1
            case CAROUSEL:
                this.cardCode = "P0-O0-R0-B0-G1/G0";
                this.score = 0;
                break;
            case MARRY_GO_ROUND:
                this.cardCode = "P0-O0-R1-B0-G0/R0";
                this.score = 0;
                break;
            case BALLOON_DOG:
                this.cardCode = "P0-O1-R0-B0-G0/O1";
                this.score = 1;
                break;
            case SPRING_SWING_CAR:
                this.cardCode = "P0-O0-R0-B1-G0/B1";
                this.score = 1;
                break;

            // stage 2
            case BOUNCY_CASTLE:
                this.cardCode = "P0-O2-R0-B0-G0/R1";
                this.score = 2;
                break;
            case WATER_SLIDE:
                this.cardCode = "P0-O2-R1-B0-G0/O1";
                this.score = 2;
                break;
            case BUMPER:
                this.cardCode = "P1-O0-R0-B1-G0/G1";
                this.score = 3;
                break;
            case BOXING_MACHINE:
                this.cardCode = "P0-O1-R0-B2-G0/B1";
                this.score = 3;
                break;

            //stage 3
            case ROLLER_COASTER:
                this.cardCode = "P2-O0-R0-B2-G0/P1";
                this.score = 5;
                break;
            case FERRIS_WHEEL:
                this.cardCode = "P2-O0-R2-B0-G0/R1";
                this.score = 4;
                break;
            case PIRATE_SHIP:
                this.cardCode = "P1-O0-R0-B0-G3/G1";
                this.score = 5;
                break;
            case SPRING_SWING:
                this.cardCode = "P3-O3-R0-B0-G0/O2";
                this.score = 4;
                break;
        }
    }

    // upload coins icon
    public void setCoins(){
        int j = 0;
        int count = 0;
        coins = new Coin[countOfCoins];
        for (int i = 0; i < 14; i++){
            if (i % 3 == 0){
                count = Character.getNumericValue(this.getCardCode().charAt(i + 1));

                if (count > 0){                    
                    switch (this.getCardCode().charAt(i)) {
                        case 'P':
                            this.coins[j] = new Coin(count, CoinColor.PINK, false);
                            break;
                        case 'O':
                            this.coins[j] =new Coin(count, CoinColor.ORANGE, false);
                            break;
                        case 'R':
                            this.coins[j] =new Coin(count, CoinColor.RED, false);
                            break;
                        case 'B':
                            this.coins[j] =new Coin(count, CoinColor.BLUE, false);
                            break;
                        case 'G':
                            this.coins[j] =new Coin(count, CoinColor.GREEN, false);
                            break;
                    }
                    j++;
                }
            }
        }
        
    }

    public void setSpecialCoin(){
        int count  = Character.getNumericValue(this.cardCode.charAt(16));
        switch (this.cardCode.charAt(15)) {
            case 'P':
                this.specialCoin = new Coin(count, CoinColor.PINK, true);
                break;
            case 'O':
                this.specialCoin = new Coin(count, CoinColor.ORANGE, true);
                break;
            case 'R':
                this.specialCoin = new Coin(count, CoinColor.RED, true);
                break;
            case 'B':
                this.specialCoin =new Coin(count, CoinColor.BLUE, true);
                break;
            case 'G':
                this.specialCoin =new Coin(count, CoinColor.GREEN, true);
                break;
        }
    }

    private void setCountOfCoins(){
        int j = 0;
        int count = 0;
        for (int i = 0; i < 14; i++){
            if (i % 3 == 0){
                count = Character.getNumericValue(cardCode.charAt(i + 1));
                if (count > 0){
                    j++;
                }
            }
        }
        countOfCoins = j;
    }



    public int getScore() {
        return score;
    }
    
    public int getCountOfCoins() {
        return countOfCoins;
    }
    
    public String getCardCode() {
        return cardCode;
    }
    
    public Coin[] getCoin() {
        return coins;
    }

    public Coin getCoin(int index){
        return this.coins[index];
    }
    
    public Coin getSpecialCoin() {
        return specialCoin;
    }

    public void setCoins(Coin coin, int index){
        this.coins[index] = coin;
    }

    public void setSpecialCoin(Coin coin){
        this.specialCoin = coin;
    }

    public Game getGame() {
        return game;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
    
}


