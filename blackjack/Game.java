package blackjack;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Created by eugenekim on 7/7/17.
 */

public class Game {
  private Deck deck;
  private Player player;
  private Dealer dealer;
  private Rules rules;


  public Game() {
    this.rules = new Rules();
    this.deck = new Deck();
    this.player = new Player();
    this.dealer = new Dealer();
    deck.setup();
  }

  public Rules getRules(){
    return this.rules;
  }

  public Deck getDeck(){
    return this.deck;
  }

  public Player getPlayer(){
    return this.player;
  }

  public Dealer getDealer(){
    return this.dealer;
  }

  public String stringHand(ArrayList<Card> hand){
    String cardString = "";
    for (Card card : hand){
      cardString += card.getCardString() + "\n";
    }
    return cardString;
  }


  public int playerTurn(int choice){
    if (choice == 1 && rules.countValues(player.getHand()) < 21){
      dealer.dealCard(deck, player);
      if (rules.countValues(player.getHand()) >= 21){
        return 3;
      }
      return choice;
    } 
    return 2;
  }

  public int dealerTurn(int dealerChoice){
    //while (rules.countValues(dealer.getHand()) < 17){
        dealer.dealCard(deck, dealer);
   // }
    return rules.countValues(dealer.getHand());
  }

  public int getDealerScore() {
    return rules.countValues(dealer.getHand());
  }

  public boolean checkBlackjack(ArrayList<Card>hand) {
    return (rules.countValues(hand) == 21);
  }



}
