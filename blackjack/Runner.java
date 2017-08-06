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

  public static void main(String[] args) {
    game = new Game();
    game.getDeck().shuffle();
    viewer = new Viewer(game);
    viewer.run();
  }
}
