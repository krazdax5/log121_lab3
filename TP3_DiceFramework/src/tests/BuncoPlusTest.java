package tests;

import bfframework.Player;
import bfframework.PlayerManager;
import buncoplus.BuncoPlus;
import org.junit.Test;

/**
 * Methode de classe unitaires de BuncoPlus.
 *
 * @author Mathieu Lachance LACM14059305
 * @author Charles Levesque LEVC27109107
 * 2013-11-12 : Creation et implementation d'une partie normale avec la methode roll()
 *
 */
public class BuncoPlusTest {


    @Test
    public void testCalculateScoreRound() throws Exception {
        BuncoPlus theGame = BuncoPlus.createGame(2,3,6);
    }

    @Test
    public void testPlayGame() throws Exception {

        BuncoPlus theGame = BuncoPlus.createGame(5, 3, 6);

        theGame.startGame();

        PlayerManager playerManager = theGame.getPlayerManager();

        // Si compareTo retourne 0, alors le premier correspond bien au gagnant de la partie
        assert theGame.findWinner().compareTo(playerManager.getFirstPlayer()) == 0;

        Player player1 = playerManager.nextPlayer();
        Player player2 = playerManager.nextPlayer();
        Player player3 = playerManager.nextPlayer();
        Player player4 = playerManager.nextPlayer();
        Player player5 = playerManager.nextPlayer();

        // S'assure que la liste est bien en ordre.
        // Les joueurs peuvent avoir le meme score s'ils sont chanceux ...
        assert player1.getScore() >= player2.getScore();
        assert player2.getScore() >= player3.getScore();
        assert player3.getScore() >= player4.getScore();
        assert player4.getScore() >= player5.getScore();


    }

}
