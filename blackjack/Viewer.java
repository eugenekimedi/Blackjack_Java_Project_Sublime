package blackjack;
import blackjack.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Viewer {

private static Game game;

  public Viewer(Game game){
    this.game = game;
  }
  public void run(){

    if (game.getDeck().cardCount() < 10) {
      game.useNewDeck();
    }
    game.getDealer().dealInitialHands(game.getDeck(), game.getPlayer(), game.getDealer());
    System.out.println(squiglyLine);
    ArrayList<Card> phand = game.getPlayer().getHand();
    ArrayList<Card> dhand = game.getDealer().getHand();
    printHands("both");
    printScores("both");
    String bothBlackjack = game.announceBlackjackDraw(game.getPlayer(), game.getDealer());
    if (game.checkBlackjack(dhand) && game.checkBlackjack(phand)){
      System.out.println(line + "\n"+ bothBlackjack +"\n" + line);
      System.out.println(line);
      replay();
      return;
    }
    String dealerWins = game.announceBlackjack(game.getDealer());
    if (dealerWins != null) {
      System.out.println(line + "\n"+dealerWins + "\n" + line);
      replay();
      return;
    }

    String playerWins = game.announceBlackjack(game.getPlayer());
    if (playerWins != null) {
      System.out.println((line + "\n" + playerWins + "\n" + line));
      replay();
      return;
    }
    
    int choice = 1;
    while (choice == 1){
      System.out.println("-------------Players Turn-------------");
      System.out.println("Enter 1 to Hit\nEnter any other number to stay");
      Scanner sc = new Scanner(System.in);
      choice = sc.nextInt();
      choice = game.playerTurn(choice);
      printHands("player");
      printScores("both");
      if (game.getRules().countValues(phand) > 21){
        System.out.println(line + "\n        BUST, PLAYER LOSES"+ "\n" + line);
        replay();
        return;
      }
    }


    while(game.getDealerScore()< 17) {
      System.out.println("-------------Dealers Turn--------------");
      System.out.println("Please enter any number to continue");
      Scanner sc = new Scanner(System.in);
      int dealerChoice = sc.nextInt();
      game.dealerTurn(1);
      printHands("dealer");
      printScores("both");
    }

    int dealerScore = game.getDealerScore();

    //int dealerScore = game.dealerTurn(dealerChoice);
    if (dealerScore > 21) {
      System.out.println(line + "\n     Dealer Busts, Player Wins!"+ "\n" + line);
      replay();
      return;
    }
    else {
      System.out.println(line);
      System.out.println(game.getRules().compareHands(game.getPlayer(), game.getDealer()));
      System.out.println(line);
      replay();
      return;
    } 
  }

  public void replay(){
    System.out.println("Enter 1 to Play again!! \nEnter any other number to quit");
    Scanner sc = new Scanner(System.in);
    int i = sc.nextInt();
    if (i==1){
      game.getPlayer().eraseHand();
      game.getDealer().eraseHand();
      run();
    }
  }

  public void printHands(String who){
    if (who == "both"){
      System.out.println("Players Hand:\n" + game.stringHand(game.getPlayer().getHand()));
      System.out.println("Dealers Hand:\n" + game.stringHand(game.getDealer().getHand()));
    }
    if (who == "player"){
      System.out.println("Players Hand:\n" + game.stringHand(game.getPlayer().getHand()));
    } 
    if (who == "dealer"){
      System.out.println("Dealers Hand:\n" + game.stringHand(game.getDealer().getHand()));
    }
  }

  public void printScores(String who){
    if (who == "both") {
    System.out.println("Players Score:" + game.getRules().countValues(game.getPlayer().getHand()));
    System.out.println("Dealers Score:" + game.getRules().countValues(game.getDealer().getHand()));
    }
  }

  String squiglyLine = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
  String line = "-----------------------------------";
}
