package tests;

import bfframework.Game;
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
        // S'assure que la liste est bien en ordre.
        // Les joueurs peuvent avoir le meme score s'ils sont chanceux ...
//        assert theGame.getPlayer(0).compareTo(theGame.getPlayer(1)) == 1 ||
//                theGame.getPlayer(0).compareTo(theGame.getPlayer(1)) == 0;
//        assert theGame.getPlayer(1).compareTo(theGame.getPlayer(2)) == 1 ||
//                theGame.getPlayer(1).compareTo(theGame.getPlayer(2)) == 0;
//        assert theGame.getPlayer(2).compareTo(theGame.getPlayer(3)) == 1 ||
//                theGame.getPlayer(2).compareTo(theGame.getPlayer(3)) == 0;
//        assert theGame.getPlayer(3).compareTo(theGame.getPlayer(4)) == 1 ||
//                theGame.getPlayer(3).compareTo(theGame.getPlayer(4)) == 0;

    }

}
