package player;

import Components.card.CardUI;
import constants.Game;

public class PlayerCard {
    public CardUI card[] = new CardUI[12];

    public PlayerCard(){
        creatCards();
    }

    private void creatCards(){
        int i = 0;

        i = makeCard(Game.CAROUSEL, i);
        i = makeCard(Game.MARRY_GO_ROUND, i);
        i = makeCard(Game.BALLOON_DOG, i);
        i = makeCard(Game.SPRING_SWING_CAR, i);

        i = makeCard(Game.BOUNCY_CASTLE, i);
        i = makeCard(Game.WATER_SLIDE, i);
        i = makeCard(Game.BUMPER, i);
        i = makeCard(Game.BOXING_MACHINE, i);

        i = makeCard(Game.ROLLER_COASTER, i);
        i = makeCard(Game.FERRIS_WHEEL, i);
        i = makeCard(Game.PIRATE_SHIP, i);
        i = makeCard(Game.SPRING_SWING, i);
    } 

    private int makeCard(Game game, int i){
        if (i < 12){
            card[i] = new CardUI(game);
            card[i].updateCard(0);
            return i + 1;
        }
        else return i; 
    } 

    public int makeCard(Game game, int i, int count){
        if (i < 12){
            card[i] = new CardUI(game);
            card[i].updateCard(count);
            return i + 1;
        }
        else return i; 
    }

    public CardUI[] getCard() {
        return card;
    }

    
}
