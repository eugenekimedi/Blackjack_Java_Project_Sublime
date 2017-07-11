package blackjack;
import blackjack.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by eugenekim on 7/10/17.
 */

public class Runner {

private static Game game;
private static Runner runner;

  public static void main(String[] args) {
    game = new Game();
    runner = new Runner();
    runner.run();
  }


  public void run(){
    game.getDeck().shuffle();
    game.getDealer().dealInitialHands(game.getDeck(), game.getPlayer(), game.getDealer());
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    ArrayList<Card> phand = game.getPlayer().getHand();
    ArrayList<Card> dhand = game.getDealer().getHand();
    game.printHands("both");
    game.printScores("both");
    if (game.checkBlackjack(dhand) && game.checkBlackjack(phand)){
      System.out.println("-----------------------------------\n               Draw\n-----------------------------------");
      System.out.println("-----------------------------------");
      game.replay();
      return;
    }
    if (game.checkBlackjack(dhand)) {
      System.out.println("-----------------------------------\n   Dealer blackjack, player loses\n-----------------------------------");
      game.replay();
      return;
    }
    if (game.checkBlackjack(phand)) {
      System.out.println("-----------------------------------\n           BLACKJACK PLAYER WINS\n-----------------------------------");
      game.replay();
      return;
    }
    int i = 1;
    while(i == 1){
      i = game.playerTurn();
      game.printHands("player");
      game.printScores("both");
      if (game.getRules().countValues(phand) > 21){
        System.out.println("-----------------------------------\n         BUST, PLAYER LOSES\n-----------------------------------");
        game.replay();
        return;
      }
    }
    int dealerScore = game.dealerTurn();
    if (dealerScore > 21) {
      System.out.println("-----------------------------------\n     Dealer Busts, Player Wins!\n-----------------------------------");
      game.replay();
      return;
    }
    else {
      System.out.println("-----------------------------------");
      System.out.println(game.getRules().compareHands(game.getPlayer(), game.getDealer()));
      System.out.println("-----------------------------------");
      game.replay();
      return;
    } 
  }
}
