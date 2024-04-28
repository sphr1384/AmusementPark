package board.scoreBoard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Components.card.CardUI;
import board.Board;
import board.scoreBoard.slot_machin.EntranceLogo;
import constants.Size;
import player.Player;
import Interface.ClickCardListener;

public class ScoreBoard extends JPanel implements ClickCardListener{
    private ScoreBoardBackground scoreBoardBackground;
    
    private PlayersPanel player1Panel;
    private PlayersPanel player2Panel;
    private Wallet player1Wallet;
    private Wallet player2Wallet;
    private TurnPanel turn;
    private EntranceLogo logo;

    Player player1;
    Player player2;

    @Override
    public void onTurnChange() {
        turn.updateTurn();
    }

    @Override
    public void onWalletUpdate_card(CardUI card){
        if (Player.turn == 1){
            for (int i = 0; i < 12; i++){
                if (card.getCard().getGame() == player1.getPlayerCard().getCard()[i].getCard().getGame()){
                    player1.getPlayerCard().getCard()[i].updateCard(player1.getPlayerCard().getCard()[i].getCard().getCount() + 1);
                }
            }
        }else {
            for (int i = 0; i < 12; i++){
                if (card.getCard().getGame() == player2.getPlayerCard().getCard()[i].getCard().getGame()){
                    player2.getPlayerCard().getCard()[i].updateCard(player2.getPlayerCard().getCard()[i].getCard().getCount() + 1);
                }
            }
        }
    }

    @Override
    public void onWalletUpdate_coin(CardUI card){
        String cardCode = card.getCard().getCardCode();
        int count;
        int price;

        if (Player.turn == 1){
            for (int i = 0; i < 14; i++){
                if (i % 3 == 0){
                    count = Character.getNumericValue(cardCode.charAt(i + 1));

                    switch (cardCode.charAt(i)) {
                        case 'P':
                            price = ScoreBoard.calculatePrice(count - player1.stuff.getInfo().specialPinkCoin);
                            player1.stuff.getInfo().pinkCoin -= price;
                            player1.getPlayerCoin().getCoins()[0].updateCoin(player1.stuff.getInfo().pinkCoin);
                            break;

                        case 'O':
                            price = ScoreBoard.calculatePrice(count - player1.stuff.getInfo().specialOrangeCoin);
                            player1.stuff.getInfo().orangeCoin -= price;
                            player1.getPlayerCoin().getCoins()[1].updateCoin(player1.stuff.getInfo().orangeCoin);
                            break;

                        case 'R':
                            price = ScoreBoard.calculatePrice(count - player1.stuff.getInfo().specialRedCoin);
                            player1.stuff.getInfo().redCoin -= price;
                            player1.getPlayerCoin().getCoins()[2].updateCoin(player1.stuff.getInfo().redCoin);
                            break;

                        case 'B':
                            price = ScoreBoard.calculatePrice(count - player1.stuff.getInfo().specialBlueCoin);
                            player1.stuff.getInfo().blueCoin -= price;
                            player1.getPlayerCoin().getCoins()[3].updateCoin(player1.stuff.getInfo().blueCoin);
                            break;
                            
                        case 'G':
                            price = ScoreBoard.calculatePrice(count - player1.stuff.getInfo().specialGreenCoin);
                            player1.stuff.getInfo().greenCoin -= price;
                            player1.getPlayerCoin().getCoins()[4].updateCoin(player1.stuff.getInfo().greenCoin);
                            break;
                    }
                }
                
                
            }

        }
        else {

            for (int i = 0; i < 14; i++){
                if (i % 3 == 0){
                    count = Character.getNumericValue(cardCode.charAt(i + 1));

                    switch (cardCode.charAt(i)) {
                        case 'P':
                            price = ScoreBoard.calculatePrice(count - player2.stuff.getInfo().specialPinkCoin);
                            player2.stuff.getInfo().pinkCoin -= price;
                            player2.getPlayerCoin().getCoins()[0].updateCoin(player2.stuff.getInfo().pinkCoin);
                            break;
                        case 'O':
                            price = ScoreBoard.calculatePrice(count - player2.stuff.getInfo().specialOrangeCoin);
                            player2.stuff.getInfo().orangeCoin -= price;
                            player2.getPlayerCoin().getCoins()[1].updateCoin(player2.stuff.getInfo().orangeCoin);
                            break;
                        case 'R':
                            price = ScoreBoard.calculatePrice(count - player2.stuff.getInfo().specialRedCoin);
                            player2.stuff.getInfo().redCoin -= price;
                            player2.getPlayerCoin().getCoins()[2].updateCoin(player2.stuff.getInfo().redCoin);
                            break;
                        case 'B':
                            price = ScoreBoard.calculatePrice(count - player2.stuff.getInfo().specialBlueCoin);
                            player2.stuff.getInfo().blueCoin -= price;
                            player2.getPlayerCoin().getCoins()[3].updateCoin(player2.stuff.getInfo().blueCoin);
                            break;
                        case 'G':
                            price = ScoreBoard.calculatePrice(count - player2.stuff.getInfo().specialGreenCoin);
                            player2.stuff.getInfo().greenCoin -= price;
                            player2.getPlayerCoin().getCoins()[4].updateCoin(player2.stuff.getInfo().greenCoin);
                            break;
                    }
                }
                
                
            }

        }
    }

    @Override
    public void onWalletUpdate_specialCoin(CardUI card){
        String cardCode = card.getCard().getCardCode();
        int count = Character.getNumericValue(cardCode.charAt(16));

        if (Player.turn == 1){
            switch (cardCode.charAt(15)) {
                case 'P':
                    player1.stuff.getInfo().specialPinkCoin += count;
                    player1.getPlayerCoin().getSpaecialCoins()[0].updateCoin(player1.stuff.getInfo().specialPinkCoin);
                    break;

                case 'O':
                    player1.stuff.getInfo().specialOrangeCoin += count;
                    player1.getPlayerCoin().getSpaecialCoins()[1].updateCoin(player1.stuff.getInfo().specialOrangeCoin);
                    break;

                case 'R':
                    player1.stuff.getInfo().specialRedCoin += count;
                    player1.getPlayerCoin().getSpaecialCoins()[2].updateCoin(player1.stuff.getInfo().specialRedCoin);
                    break;

                case 'B':
                    player1.stuff.getInfo().specialBlueCoin += count;
                    player1.getPlayerCoin().getSpaecialCoins()[3].updateCoin(player1.stuff.getInfo().specialGreenCoin);
                    break;

                case 'G':
                    player1.stuff.getInfo().specialGreenCoin += count; 
                    player1.getPlayerCoin().getSpaecialCoins()[4].updateCoin(player1.stuff.getInfo().specialBlueCoin);
                    break;
            }
        }

        else {
            switch (cardCode.charAt(15)) {
                case 'P':
                    player2.stuff.getInfo().specialPinkCoin += count;
                    player2.getPlayerCoin().getSpaecialCoins()[0].updateCoin(player2.stuff.getInfo().specialPinkCoin);
                    break;

                case 'O':
                    player2.stuff.getInfo().specialOrangeCoin += count;
                    player2.getPlayerCoin().getSpaecialCoins()[1].updateCoin(player2.stuff.getInfo().specialOrangeCoin);
                    break;

                case 'R':
                    player2.stuff.getInfo().specialRedCoin += count;
                    player2.getPlayerCoin().getSpaecialCoins()[2].updateCoin(player2.stuff.getInfo().specialRedCoin);
                    break;

                case 'B':
                    player2.stuff.getInfo().specialBlueCoin += count;
                    player2.getPlayerCoin().getSpaecialCoins()[3].updateCoin(player2.stuff.getInfo().specialGreenCoin);
                    break;

                case 'G':
                    player2.stuff.getInfo().specialGreenCoin += count; 
                    player2.getPlayerCoin().getSpaecialCoins()[4].updateCoin(player2.stuff.getInfo().specialBlueCoin);
                    break;
            }
        }
    }

    public TurnPanel getTurn() {
        return turn;
    }

    public static int calculatePrice(int x){
        if (x > 0){
            return x;
        }
        else {
            return 0;
        }
    }


    public ScoreBoard(Board board, Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;

        setLayout(new GridLayout(7, 1));
        setScoreBoard(board, player1, player2);

        setBackground();
    }

    private void setBackground(){
        int width = (int) (Size.SCREEN_WIDTH.getValue() * 0.2);
        int height = (int) (Size.SCREEN_HEIGHT.getValue());
        scoreBoardBackground = new ScoreBoardBackground();
        scoreBoardBackground.setPreferredSize(new Dimension(width, height));
        //add(scoreBoardBackground);
    }

    private void setScoreBoard(Board board, Player player1, Player player2){
        // player 1
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2, 1));
        player1Panel = new PlayersPanel(player1);
        panel1.add(player1Panel);

        player1Wallet = new Wallet(player1, board);
        panel1.add(player1Wallet);

        panel1.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 4));
        add(panel1);

        // player 2
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2, 1));
        player2Panel = new PlayersPanel(player2);
        panel2.add(player2Panel);

        player2Wallet = new Wallet(player2, board);
        panel2.add(player2Wallet);

        panel2.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 4));
        add(panel2);

        // turn panel
        turn = new TurnPanel(player1, player2);
        add(turn);

        // logo pnale for slot machin
        logo = new EntranceLogo();
        add(logo);
    }

}


