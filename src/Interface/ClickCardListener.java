package Interface;

import Components.card.CardUI;

public interface ClickCardListener {
    void onTurnChange();
    void onWalletUpdate_card(CardUI card);
    void onWalletUpdate_coin(CardUI card);
    void onWalletUpdate_specialCoin(CardUI card);
    void onScore(CardUI card);
}
