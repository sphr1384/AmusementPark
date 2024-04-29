package player;

import java.util.ArrayList;

import Components.card.CardUI;
import constants.Game;

public class PlayerReservedCard{
    public int totalReserved = 0;
    public static final int MAX_RESERVATION = 3;
    public ArrayList<CardUI> cardList = new ArrayList<>();

    public void addToReserved(CardUI card){
        if (totalReserved < MAX_RESERVATION){
            creatCards(card);
            totalReserved++;
            System.out.println(totalReserved);
        }
    }

    public void removeFromeReserved(int index){
        cardList.remove(index);
        totalReserved--;
    }

    private void creatCards(CardUI card){
        switch (card.getCard().getGame()) {
            case CAROUSEL:
                cardList.add(new CardUI(Game.CAROUSEL));
                cardList.get(totalReserved).updateCard(1);
                break;
            case MARRY_GO_ROUND:
                cardList.add(new CardUI(Game.MARRY_GO_ROUND));
                cardList.get(totalReserved).updateCard(1);
                break;
            case BALLOON_DOG:
                cardList.add(new CardUI(Game.BALLOON_DOG));
                cardList.get(totalReserved).updateCard(1);
                break;
            case SPRING_SWING_CAR:
                cardList.add(new CardUI(Game.SPRING_SWING_CAR));
                cardList.get(totalReserved).updateCard(1);
                break;

            // stage 2
            case BOUNCY_CASTLE:
                cardList.add(new CardUI(Game.BOUNCY_CASTLE));
                cardList.get(totalReserved).updateCard(1);
                break;
            case WATER_SLIDE:
                cardList.add(new CardUI(Game.WATER_SLIDE));
                cardList.get(totalReserved).updateCard(1);
                break;
            case BUMPER:
                cardList.add(new CardUI(Game.BUMPER));
                cardList.get(totalReserved).updateCard(1);
                break;
            case BOXING_MACHINE:
                cardList.add(new CardUI(Game.BOXING_MACHINE));
                cardList.get(totalReserved).updateCard(1);
                break;

            //stage 3
            case ROLLER_COASTER:
                cardList.add(new CardUI(Game.ROLLER_COASTER));
                cardList.get(totalReserved).updateCard(1);
                break;
            case FERRIS_WHEEL:
                cardList.add(new CardUI(Game.FERRIS_WHEEL));
                cardList.get(totalReserved).updateCard(1);
                break;
            case PIRATE_SHIP:
                cardList.add(new CardUI(Game.PIRATE_SHIP));
                cardList.get(totalReserved).updateCard(1);
                break;
            case SPRING_SWING:
                cardList.add(new CardUI(Game.SPRING_SWING));
                cardList.get(totalReserved).updateCard(1);
                break;
        
        }
    }

}

