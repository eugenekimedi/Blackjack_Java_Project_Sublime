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


  public void run() {
    deck.shuffle();
    dealer.dealInitialHands(deck, player, dealer);
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    ArrayList<Card> phand = player.getHand();
    ArrayList<Card> dhand = dealer.getHand();
    printHands("both");
    printScores("both");
    if (checkBlackjack(dhand) && checkBlackjack(phand)){
      System.out.println("-----------------------------------\n               Draw\n-----------------------------------");
      System.out.println("-----------------------------------");
      replay();
      return;
    }
    if (checkBlackjack(dhand)) {
      System.out.println("-----------------------------------\n   Dealer blackjack, player loses\n-----------------------------------");
      replay();
      return;
    }
    if (checkBlackjack(phand)) {
      System.out.println("-----------------------------------\n           BLACKJACK PLAYER WINS\n-----------------------------------");
      replay();
      return;
    }

    int i = 1;
    while(i == 1){
      i = playerTurn();
      printHands("player");
      printScores("both");
      if (rules.countValues(phand) > 21){
        System.out.println("-----------------------------------\n         BUST, PLAYER LOSES\n-----------------------------------");
        replay();
        return;
      }

    }
    
      int dealerScore = dealerTurn();
      if (dealerScore > 21) {
        System.out.println("-----------------------------------\n     Dealer Busts, Player Wins!\n-----------------------------------");
        replay();
        return;
      }
      else {
        System.out.println("-----------------------------------");
        System.out.println(rules.compareHands(player, dealer));
        System.out.println("-----------------------------------");
        replay();
        return;
      }
    
  }

  public int playerTurn(){
    System.out.println("-------------Players Turn-------------");
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
      System.out.println("-------------Dealers Turn--------------");
      System.out.println("Please enter 1 to continue Dealers turn");
      Scanner sc = new Scanner(System.in);
      int i = sc.nextInt();
      if (i==1){
        dealer.dealCard(deck, dealer);
        printHands("dealer");
        printScores("both");
      }
    }
    return rules.countValues(dealer.getHand());
  }

  public boolean checkBlackjack(ArrayList<Card>hand) {
    return (rules.countValues(hand) == 21);
  }
  public void printHands(String who){
    if (who == "both"){
      System.out.println("Players Hand:\n" + this.stringHand(player.getHand()));
      System.out.println("Dealers Hand:\n" + this.stringHand(dealer.getHand()));
    }
    if (who == "player"){
      System.out.println("Players Hand:\n" + this.stringHand(player.getHand()));
    } 
    if (who == "dealer"){
      System.out.println("Dealers Hand:\n" + this.stringHand(dealer.getHand()));
    }
  }

  public void printScores(String who){
    if (who == "both") {
    System.out.println("Players Score:" + rules.countValues(player.getHand()));
    System.out.println("Dealers Score:" + rules.countValues(dealer.getHand()));
    }
  }

  public void replay(){
    System.out.println("Enter 1 to Play again!!");
    Scanner sc = new Scanner(System.in);
    int i = sc.nextInt();
    if (i==1){
      player.eraseHand();
      dealer.eraseHand();
      run();
    }
  }
}
