package board.scoreBoard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Components.Coin;
import Components.card.CardUI;
import board.Board;
import board.scoreBoard.slot_machin.EntranceLogo;
import constants.CoinColor;
import constants.Size;
import player.Player;
import Interface.ClickCardListener;
import Interface.SlotMachinChosenCoinListener;

public class ScoreBoard extends JPanel implements ClickCardListener, SlotMachinChosenCoinListener{
    private ScoreBoardBackground scoreBoardBackground;
    
    private PlayersPanel player1Panel;
    private PlayersPanel player2Panel;
    private Wallet player1Wallet;
    private Wallet player2Wallet;
    private Reserved reserved1;
    private Reserved reserved2;
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

    private void withdrawCash(Player player, CardUI card){
        String cardCode = card.getCard().getCardCode();
        int count;
        int price;

        for (int i = 0; i < 14; i++){
            if (i % 3 == 0){
                count = Character.getNumericValue(cardCode.charAt(i + 1));

                switch (cardCode.charAt(i)) {
                    case 'P':
                        price = ScoreBoard.calculatePrice(count - player.stuff.getInfo().specialPinkCoin);
                        player.stuff.getInfo().pinkCoin -= price;

                        if (player.stuff.getInfo().pinkCoin < 0){
                            player.stuff.getInfo().pinkCoin = 0;
                        }

                        player.getPlayerCoin().getCoins()[0].updateCoin(player.stuff.getInfo().pinkCoin);
                        break;

                    case 'O':
                        price = ScoreBoard.calculatePrice(count - player.stuff.getInfo().specialOrangeCoin);
                        player.stuff.getInfo().orangeCoin -= price;

                        if (player.stuff.getInfo().orangeCoin < 0){
                            player.stuff.getInfo().orangeCoin = 0;
                        }

                        player.getPlayerCoin().getCoins()[1].updateCoin(player.stuff.getInfo().orangeCoin);
                        break;

                    case 'R':
                        price = ScoreBoard.calculatePrice(count - player.stuff.getInfo().specialRedCoin);
                        player.stuff.getInfo().redCoin -= price;

                        if (player.stuff.getInfo().redCoin < 0){
                            player.stuff.getInfo().redCoin = 0;
                        }

                        player.getPlayerCoin().getCoins()[2].updateCoin(player.stuff.getInfo().redCoin);
                        break;

                    case 'B':
                        price = ScoreBoard.calculatePrice(count - player.stuff.getInfo().specialBlueCoin);
                        player.stuff.getInfo().blueCoin -= price;

                        if (player.stuff.getInfo().blueCoin < 0){
                            player.stuff.getInfo().blueCoin = 0;
                        }

                        player.getPlayerCoin().getCoins()[3].updateCoin(player.stuff.getInfo().blueCoin);
                        break;
                        
                    case 'G':
                        price = ScoreBoard.calculatePrice(count - player.stuff.getInfo().specialGreenCoin);
                        player.stuff.getInfo().greenCoin -= price;

                        if (player.stuff.getInfo().greenCoin < 0){
                            player.stuff.getInfo().greenCoin = 0;
                        }

                        player.getPlayerCoin().getCoins()[4].updateCoin(player.stuff.getInfo().greenCoin);
                        break;
                } 
            } 
        } 
    }

    @Override
    public int onWalletUpdate_coin(CardUI card){
        // player 1
        if (Player.turn == 1){ 
            // can buy without golden coin
            if (card.getCard().canBuy(player1) == 0){
                withdrawCash(player1, card);
                return 0;
            }

            // can buy with golden coin
            else if (card.getCard().canBuy(player1) > 0){
                player1.stuff.getInfo().goldenCoin -= card.getCard().canBuy(player1);
                player1.getPlayerCoin().getCoins()[5].updateCoin(player1.stuff.getInfo().goldenCoin);
                withdrawCash(player1, card);
                return 1;
            }

            else return -1;
        }

        // player 2
        else {
            // can buy without golden coin
            if (card.getCard().canBuy(player2) == 0){
                withdrawCash(player2, card);
                return 0;
            }

            // can buy with golden coin
            else if (card.getCard().canBuy(player2) > 0){
                player2.stuff.getInfo().goldenCoin -= card.getCard().canBuy(player2);
                player2.getPlayerCoin().getCoins()[5].updateCoin(player2.stuff.getInfo().goldenCoin);
                withdrawCash(player2, card);
                return 1;
            }
            else return -1;
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

    @Override
    public void onScore(CardUI card){
        if (Player.turn == 1){
            player1.score += card.getCard().score;
            player1Panel.updateScore(player1.score);
        }
        else {
            player2.score += card.getCard().score;
            player2Panel.updateScore(player2.score);
        }
    }

    @Override
    public void onReservationUpdate(CardUI card){
        if (Player.turn == 1){
            if (player1.playerReservedCard.totalReserved < 3){
                player1.playerReservedCard.addToReserved(card);
            }
        }
        else {
            if (player1.playerReservedCard.totalReserved < 3){
                player2.playerReservedCard.addToReserved(card);
            } 
        }
    }

    private void addCoinsToPlayer(Player player, String[] selectedColorsArr, int count){
        int number;

        if (count == 1){
            number = 3;
        }
        else {
            number = 1;
        }

        for (int i = 0; i < count; i++){
            switch (selectedColorsArr[i]) {
                case "P":
                    player.stuff.getInfo().pinkCoin += number;  
                    player.getPlayerCoin().getCoins()[0].updateCoin(player.stuff.getInfo().pinkCoin);
                    break;

                case "O":
                    player.stuff.getInfo().orangeCoin += number;
                    player.getPlayerCoin().getCoins()[1].updateCoin(player.stuff.getInfo().orangeCoin); 
                    break;

                case "R":
                    player.stuff.getInfo().redCoin += number;     
                    player.getPlayerCoin().getCoins()[2].updateCoin(player.stuff.getInfo().redCoin);
                    break;

                case "B":
                    player.stuff.getInfo().blueCoin += number; 
                    player.getPlayerCoin().getCoins()[3].updateCoin(player.stuff.getInfo().blueCoin); 
                    break;

                case "G":
                    player.stuff.getInfo().greenCoin += number; 
                    player.getPlayerCoin().getCoins()[4].updateCoin(player.stuff.getInfo().greenCoin); 
                    break;
            }
        }

        
        System.out.println("P" + player.stuff.getInfo().pinkCoin);
        System.out.println("O" + player.stuff.getInfo().orangeCoin);
        System.out.println("R" + player.stuff.getInfo().redCoin);
        System.out.println("B" + player.stuff.getInfo().blueCoin);
        System.out.println("G" + player.stuff.getInfo().greenCoin); 
    }

    @Override
    public void onSelectedCoins(){
        int size = logo.getSlotMachinDialog().getSelectedColors().size();
        String[] selectedColorsArr = new String[size];

        for (int i = 0; i < size; i++){
            selectedColorsArr[i] = logo.getSlotMachinDialog().getSelectedColors().get(i);
        }


        
        if (Player.turn == 1){
            addCoinsToPlayer(player1, selectedColorsArr, size);
            
        }
        else {
            addCoinsToPlayer(player2, selectedColorsArr, size);
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

        setLayout(new GridLayout(6, 1));
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
        JPanel W_R1 = new JPanel();
        panel1.setLayout(new GridLayout(2, 1));
        W_R1.setLayout(new GridLayout(1, 2));

        player1Panel = new PlayersPanel(player1);
        panel1.add(player1Panel);

        player1Wallet = new Wallet(player1, board);
        W_R1.add(player1Wallet);
        reserved1 = new Reserved(player1, board);
        W_R1.add(reserved1);


        panel1.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 4));
        panel1.add(W_R1);
        add(panel1);

        // player 2
        JPanel panel2 = new JPanel();
        JPanel W_R2 = new JPanel();
        panel2.setLayout(new GridLayout(2, 1));
        W_R2.setLayout(new GridLayout(1, 2));

        player2Panel = new PlayersPanel(player2);
        panel2.add(player2Panel);

        player2Wallet = new Wallet(player2, board);
        W_R2.add(player2Wallet);
        reserved2 = new Reserved(player2, board);
        W_R2.add(reserved2);

        panel2.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 4));
        panel2.add(W_R2);
        add(panel2);

        // turn panel
        turn = new TurnPanel(player1, player2);
        add(turn);

        // logo pnale for slot machin
        logo = new EntranceLogo(this, turn);
        add(logo);
    }

}


