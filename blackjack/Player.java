package blackjack;

import java.util.ArrayList;

/**
 * Created by eugenekim on 7/7/17.
 */

public class Player {

    private ArrayList<Card> hand;
    private int money;
    private int bet;

    public Player() {
        this.hand = new ArrayList<Card>();
        this.money = 100;
        this.bet = 0;
    }

    public int cardCount() {
        int numberOfCards = 0;

        for(Card card : this.hand) {
            if (card != null) {
                numberOfCards++;
            }
        }
        return numberOfCards;
    }

    public void receiveCard(Card newCard) {
        this.hand.add(newCard);
    }

    public ArrayList<Card> getHand(){
        return this.hand;
    }

    public void eraseHand(){
        this.hand = new ArrayList<Card>();
    }

    public int getMoney(){
        return this.money;
    }

    public void addMoney(int amount) {
        this.money += amount;
    }

    public void subtractMoney(int amount) {
        this.money -= amount;
    }

    public int getBet(){
        return this.bet;
    }

    public void bet(int amount){
        this.bet = amount;
        this.money -= amount;
    }
}
