package blackjack;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by eugenekim on 7/8/17.
 */

public class Rules {

    private HashMap<Enum, Integer> rules;

    public Rules() {
        rules = new HashMap<Enum, Integer>();
        rules.put(Rank.TWO, 2 );
        rules.put(Rank.THREE, 3 );
        rules.put(Rank.FOUR, 4 );
        rules.put(Rank.FIVE, 5 );
        rules.put(Rank.SIX, 6 );
        rules.put(Rank.SEVEN, 7 );
        rules.put(Rank.EIGHT, 8 );
        rules.put(Rank.NINE, 9 );
        rules.put(Rank.TEN, 10 );
        rules.put(Rank.JACK, 10 );
        rules.put(Rank.QUEEN, 10 );
        rules.put(Rank.KING, 10 );
        rules.put(Rank.ACE, 11 );
    }

    public int countValues(ArrayList<Card> hand) {
        int points = 0;
        int aceCounter = countAce(hand);
        for (Card card : hand) {
            points += rules.get(card.getRank());
        }
        while(checkChangeAce(points, aceCounter)){
            points -= 10;
            aceCounter -= 1;
        }
        return points;
    }

    public String compareHands(Player player, Player dealer){
        int dealerScore = countValues(dealer.getHand());
        int playerScore = countValues(player.getHand());

        if (playerScore == dealerScore){
            return "draw";
        }
        if (playerScore == 21 && player.cardCount()== 2){
            return "BLACKJACK!";
        }
        if  (playerScore > dealerScore){
            return "player wins";
        }

        return "dealer wins";
    }

    public boolean checkChangeAce(int points, int aceCounter){
        return points > 21 && aceCounter > 0;
    }


    public int countAce(ArrayList<Card> hand) {
        int aceCounter = 0;
        for (Card card : hand) {
            if (card.getRank().equals(Rank.ACE)){
                aceCounter +=1;
            }
        }
        return aceCounter;
    }

}

