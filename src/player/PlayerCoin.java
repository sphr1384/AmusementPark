package player;

import Components.Coin;
import constants.CoinColor;
import player.presonalInformation.StoredStuff;

public class PlayerCoin {
    private Coin coins[] = new Coin[6];
    private Coin spaecialCoins[] = new Coin[5];
    
    public PlayerCoin(StoredStuff stuff){
        int i = 0;
        i = creatCoin(stuff, CoinColor.PINK, i, false);
        i = creatCoin(stuff, CoinColor.ORANGE, i, false);
        i = creatCoin(stuff, CoinColor.RED, i, false);
        i = creatCoin(stuff, CoinColor.BLUE, i, false);
        i = creatCoin(stuff, CoinColor.GREEN, i, false);
        i = creatCoin(stuff, CoinColor.GOLDEN, i, false);

        i = 0;
        i = creatCoin(stuff, CoinColor.PINK, i, true);
        i = creatCoin(stuff, CoinColor.ORANGE, i, true);
        i = creatCoin(stuff, CoinColor.RED, i, true);
        i = creatCoin(stuff, CoinColor.BLUE, i, true);
        i = creatCoin(stuff, CoinColor.GREEN, i, true);
    }

    private int creatCoin(StoredStuff stuff, CoinColor color, int i, boolean isSpecial){
        if (!isSpecial){
            switch (color) {
                case PINK:
                    coins[i] = new Coin(stuff.getInfo().pinkCoin, CoinColor.PINK, false);
                    break;
                case ORANGE:
                    coins[i] = new Coin(stuff.getInfo().orangeCoin, CoinColor.ORANGE, false);
                    break;
                case RED:
                    coins[i] = new Coin(stuff.getInfo().redCoin, CoinColor.RED, false);
                    break;
                case BLUE:
                    coins[i] = new Coin(stuff.getInfo().blueCoin, CoinColor.BLUE, false);
                    break;
                case GREEN:
                    coins[i] = new Coin(stuff.getInfo().greenCoin, CoinColor.GREEN, false);
                    break;
                case GOLDEN:
                    coins[i] = new Coin(stuff.getInfo().goldenCoin, CoinColor.GOLDEN, false);
                    break;
            }
        }

        else {
            switch (color) {
                case PINK:
                    spaecialCoins[i] = new Coin(stuff.getInfo().specialPinkCoin, CoinColor.PINK, true);
                    break;
                case ORANGE:
                    spaecialCoins[i] = new Coin(stuff.getInfo().specialOrangeCoin, CoinColor.ORANGE, true);
                    break;
                case RED:
                    spaecialCoins[i] = new Coin(stuff.getInfo().specialRedCoin, CoinColor.RED, true);
                    break;
                case BLUE:
                    spaecialCoins[i] =new Coin(stuff.getInfo().specialBlueCoin, CoinColor.BLUE, true);
                    break;
                case GREEN:
                    spaecialCoins[i] =new Coin(stuff.getInfo().specialGreenCoin, CoinColor.GREEN, true);
                    break;
            }
        }

        i++;
        return i;
    }

    public Coin[] getCoins() {
        return coins;
    }

    public Coin[] getSpaecialCoins() {
        return spaecialCoins;
    }
}
