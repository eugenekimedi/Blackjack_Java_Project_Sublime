package blackjack;
import java.util.ArrayList;

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

  public String stringHand(ArrayList<Card> hand){
    String cardString = "";
    for (Card card : hand){
      cardString += card.getCardString() + "\n";
    }
    return cardString;
  }

  public void run() {
    dealer.dealInitialHands(deck, player, dealer);
    ArrayList<Card> phand = player.getHand();
    ArrayList<Card> dhand = dealer.getHand();
    System.out.println(this.stringHand(phand));
    System.out.println(this.stringHand(dhand));
  }
}
