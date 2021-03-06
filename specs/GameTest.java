import blackjack.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by eugenekim on 7/8/17.
 */

public class GameTest {
  Game game;
  Player player;
  Dealer dealer;
  Deck deck;

  @Before
  public void before(){
    player = new Player("Player");
    dealer = new Dealer("Dealer");
    game = new Game();
    deck = new Deck();
    deck.setup();
  }

  @Test
  public void canGetRules(){
    assertNotNull(game.getRules());
  }

  @Test
  public void canGetDeck(){
    assertNotNull(game.getDeck());
  }

  @Test
  public void canGetPlayer(){
    assertNotNull(game.getPlayer());
  }

  @Test
  public void canGetDealer(){
    assertNotNull(game.getDealer());
  }

  @Test
  public void canGetStringHand(){
    dealer.dealCard(deck, player);
    dealer.dealCard(deck, dealer);
    dealer.dealCard(deck, player);
    dealer.dealCard(deck, dealer);
    assertEquals("TWO OF CLUBS\nFOUR OF CLUBS\n", game.stringHand(player.getHand()));
  }

}
