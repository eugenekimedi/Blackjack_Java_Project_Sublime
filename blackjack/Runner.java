package blackjack;
import blackjack.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by eugenekim on 7/10/17.
 */

public class Runner {

private static Viewer viewer;
private static Game game;
private static Runner runner;

  public static void main(String[] args) {
    game = new Game();
    viewer = new Viewer();
    game.getDeck().shuffle();
    runner = new Runner();
    viewer.run();
  }


  // public void run(){
  //   if (game.getDeck().cardCount() < 10) {
  //     game.useNewDeck();
  //   }
  //   game.getDealer().dealInitialHands(game.getDeck(), game.getPlayer(), game.getDealer());
  //   System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  //   ArrayList<Card> phand = game.getPlayer().getHand();
  //   ArrayList<Card> dhand = game.getDealer().getHand();
  //   printHands("both");
  //   printScores("both");
  //   String bothBlackjack = game.announceBlackjackDraw(game.getPlayer(), game.getDealer());
  //   if (game.checkBlackjack(dhand) && game.checkBlackjack(phand)){
  //     System.out.println("-----------------------------------\n"+ bothBlackjack +"\n-----------------------------------");
  //     System.out.println("-----------------------------------");
  //     replay();
  //     return;
  //   }
  //   String dealerWins = game.announceBlackjack(game.getDealer());
  //   if (dealerWins != null) {
  //     System.out.println("-----------------------------------\n"+dealerWins + "\n-----------------------------------");
  //     replay();
  //     return;
  //   }

  //   String playerWins = game.announceBlackjack(game.getPlayer());
  //   if (playerWins != null) {
  //     System.out.println(("-----------------------------------\n" + playerWins + "\n-----------------------------------"));
  //     replay();
  //     return;
  //   }
    
  //   int choice = 1;
  //   while (choice == 1){
  //     System.out.println("-------------Players Turn-------------");
  //     System.out.println("Enter 1 to Hit\nEnter 2 to stay");
  //     Scanner sc = new Scanner(System.in);
  //     choice = sc.nextInt();
  //     choice = game.playerTurn(choice);
  //     printHands("player");
  //     printScores("both");
  //     if (game.getRules().countValues(phand) > 21){
  //       System.out.println("-----------------------------------\n         BUST, PLAYER LOSES\n-----------------------------------");
  //       replay();
  //       return;
  //     }
  //   }
  //   System.out.println("-------------Dealers Turn--------------");
  //   System.out.println("Please enter 1 to continue");
  //   Scanner sc = new Scanner(System.in);
  //   int dealerChoice = sc.nextInt();


  //   while(game.getDealerScore()< 17) {
  //     game.dealerTurn(1);
  //     printHands("dealer");
  //     printScores("both");
  //   }

  //   int dealerScore = game.getDealerScore();

  //   //int dealerScore = game.dealerTurn(dealerChoice);
  //   if (dealerScore > 21) {
  //     System.out.println("-----------------------------------\n     Dealer Busts, Player Wins!\n-----------------------------------");
  //     replay();
  //     return;
  //   }
  //   else {
  //     System.out.println("-----------------------------------");
  //     System.out.println(game.getRules().compareHands(game.getPlayer(), game.getDealer()));
  //     System.out.println("-----------------------------------");
  //     replay();
  //     return;
  //   } 
  // }

  // public void replay(){
  //   System.out.println("Enter 1 to Play again!!");
  //   Scanner sc = new Scanner(System.in);
  //   int i = sc.nextInt();
  //   if (i==1){
  //     game.getPlayer().eraseHand();
  //     game.getDealer().eraseHand();
  //     run();
  //   }
  // }

  // public void printHands(String who){
  //   if (who == "both"){
  //     System.out.println("Players Hand:\n" + game.stringHand(game.getPlayer().getHand()));
  //     System.out.println("Dealers Hand:\n" + game.stringHand(game.getDealer().getHand()));
  //   }
  //   if (who == "player"){
  //     System.out.println("Players Hand:\n" + game.stringHand(game.getPlayer().getHand()));
  //   } 
  //   if (who == "dealer"){
  //     System.out.println("Dealers Hand:\n" + game.stringHand(game.getDealer().getHand()));
  //   }
  // }

  // public void printScores(String who){
  //   if (who == "both") {
  //   System.out.println("Players Score:" + game.getRules().countValues(game.getPlayer().getHand()));
  //   System.out.println("Dealers Score:" + game.getRules().countValues(game.getDealer().getHand()));
  //   }
  // }
}
