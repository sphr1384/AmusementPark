package Interface;

import Components.card.CardUI;

public interface ClickCardListener {
    // buy button
    void onTurnChange();
    void onWalletUpdate_card(CardUI card);
    int onWalletUpdate_coin(CardUI card);
    void onWalletUpdate_specialCoin(CardUI card);
    void onScore(CardUI card);

    // reserve button
    void onReservationUpdate(CardUI card);
}
