package blackjack;

import java.util.HashMap;

/**
 * Created by eugenekim on 7/7/17.
 */

public class Game {
    private HashMap <Enum, Integer> rules;
    private Deck deck;
    private Player player;
    private Dealer dealer;


    public Game() {


        this.deck = new Deck();
        this.player = new Player();
        this.dealer = new Dealer();
    }

}
