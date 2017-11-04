import controller.ConsoleController;
import model.GameLogic;
import model.IGameLogic;
import model.card.deck.IDeckStrategy;
import model.card.deck.UNODeckStrategy;
import model.player.IPlayerListBuilder;
import model.player.PlayerListBuilder;
import model.player.type.IPlayer;
import model.player.type.RealPlayer;
import model.player.type.VirtualPlayer;
import view.ConsoleView;

/**
 * Main class of UNO Game
 * 
 * It instantiates model, view and controller and makes the turn loop
 * while the game hasn't ended.
 * @author eriveros
 *
 */
public class Main {

  public static void main(String[] args) {
    IPlayerListBuilder playerBuilder = new PlayerListBuilder();
    IPlayer r1 = new RealPlayer("Ilana");
    IPlayer v1 = new VirtualPlayer("Daniela");
    IPlayer v2 = new VirtualPlayer("Claudia");
    IPlayer v3 = new VirtualPlayer("Joaquin");
    
    playerBuilder.addPlayer(r1);
    playerBuilder.addPlayer(v1);
    playerBuilder.addPlayer(v2);
    playerBuilder.addPlayer(v3);
    
    IDeckStrategy strategy = new UNODeckStrategy();
    
    IGameLogic game = new GameLogic(playerBuilder, strategy);
    ConsoleView view = new ConsoleView(game);
    ConsoleController ctrl = new ConsoleController(game, view);
    while (!game.hasEnded()) {
      ctrl.playTurn();
    }
    game.announceWinner(ctrl);
  }
}
