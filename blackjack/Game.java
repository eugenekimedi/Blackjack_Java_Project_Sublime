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

  public String stringHand(ArrayList<Card> hand){
    String cardString = "";
    for (Card card : hand){
      cardString += card.getCardString() + "\n";
    }
    return cardString;
  }


  public void run() {
    deck.shuffle();
    dealer.dealInitialHands(deck, player, dealer);
    ArrayList<Card> phand = player.getHand();
    ArrayList<Card> dhand = dealer.getHand();
    printHands();
    printScores();
    if (checkBlackjack(dhand) && checkBlackjack(phand)){
      System.out.println("Draw");
      return;
    }
    if (checkBlackjack(dhand)) {
      System.out.println("Dealer blackjack, player loses");
      return;
    }
    if (checkBlackjack(phand)) {
      System.out.println("BLACKJACK PLAYER WINS");
      return;
    }

    int i = 1;
    while(i == 1){
      i = playerTurn();
      printHands();
      printScores();
    }
    if (rules.countValues(phand) > 21){
      System.out.println("Bust. Player Loses");
    }
    else{
      int dealerScore = dealerTurn();
      if (dealerScore > 21) {
        System.out.println("Dealer Busts, Player Wins!");
      }
      else {System.out.println(rules.compareHands(player, dealer));}
    }
  }

  public int playerTurn(){
    System.out.println("Enter 1 to Hit\nEnter 2 to stay");
    Scanner sc = new Scanner(System.in);
    int i = sc.nextInt();
    if (i == 1 && rules.countValues(player.getHand()) < 21){
      dealer.dealCard(deck, player);
      if (rules.countValues(player.getHand()) >= 21){
        return 3;
      }
      return i;
    } 
    return 2;
  }

  public int dealerTurn(){
    while (rules.countValues(dealer.getHand()) < 17){
      System.out.println("Please enter 1 to continue");
      Scanner sc = new Scanner(System.in);
      int i = sc.nextInt();
      if (i==1){
        dealer.dealCard(deck, dealer);
        printHands();
        printScores();
      }
    }
    return rules.countValues(dealer.getHand());
  }

  public boolean checkBlackjack(ArrayList<Card>hand) {
    return (rules.countValues(hand) == 21);
  }
  public void printHands(){
    System.out.println("Players Hand:\n" + this.stringHand(player.getHand()));
    System.out.println("Dealers Hand:\n" + this.stringHand(dealer.getHand()));
  }

  public void printScores(){
    System.out.println("Players Score:" + rules.countValues(player.getHand()));
    System.out.println("Dealers Score:" + rules.countValues(dealer.getHand()));
  }
}
