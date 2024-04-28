package player;

import player.presonalInformation.SimpleAvatar;
import player.presonalInformation.StoredStuff;

public class Player {
    public static int turn = 1;
    public StoredStuff stuff;
    public int score;
    private PlayerCard playerCard;
    private PlayerCoin playerCoin;

    public static void changeTurn(){
        if (turn == 1){
            turn = 2;
        }
        else {
            turn = 1;
        }
    }

    public Player(String playerName, SimpleAvatar avatar){
        stuff = new StoredStuff(playerName, avatar);
        playerCard = new PlayerCard();
        playerCoin = new PlayerCoin(stuff);
    }

    public PlayerCoin getPlayerCoin() {
        return playerCoin;
    }

    public int getScore() {
        return score;
    }

    public PlayerCard getPlayerCard() {
        return playerCard;
    }

    public void setPlayerCard(PlayerCard playerCard) {
        this.playerCard = playerCard;
    }



}
