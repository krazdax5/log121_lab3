package tests;

import org.junit.Test;
import bfframework.PlayerManager;
import bfframework.Player;

/**
 * Classe de tests unitaires qui teste toutes les methodes de la classe PlayerManager.
 *
 * @author Charles Levesque LEVC27109107
 * 2013-11-10 : Ajout des tests
 * @auhtor Mathieu Lachance LACM14059305
 * 2013-11-11 : Ajout de testGetFirstPlayer et testGetPlayer. Modification de testNextPlayer.
 * 2013-11-13 : Ajout de testPreviousPlayer. testGetPlayer est supprime.
 */
public class PlayerManagerTest {

    @Test
    public void testAddPlayer() throws Exception{
        PlayerManager playerManager = new PlayerManager();

        Player john = Player.createPlayer("John", 0, 0);
        Player playerAdded = playerManager.addPlayer(john);

        assert playerAdded == john;
        assert playerManager.nextPlayer() == john;
    }

    @Test
    public void testRemovePlayer() throws Exception{
        PlayerManager playerManager = new PlayerManager();

        Player john = Player.createPlayer("John", 0, 0);
        Player joe = Player.createPlayer("Joe", 0, 0);

        playerManager.addPlayer(john);
        playerManager.addPlayer(joe);

        playerManager.removePlayer(john);

        assert playerManager.nextPlayer() == joe;
    }

    @Test
    public void testNextPlayer() throws Exception{
        PlayerManager playerManager = new PlayerManager();

        Player john = Player.createPlayer("John", 0, 0);
        Player joe = Player.createPlayer("Joe", 1, 0);
        Player jeff = Player.createPlayer("Jeff", 2, 0);

        playerManager.addPlayer(john);
        playerManager.addPlayer(joe);
        playerManager.addPlayer(jeff);

        assert playerManager.nextPlayer() == john;
        assert playerManager.nextPlayer() == joe;
        assert playerManager.nextPlayer() == jeff;

    }

    @Test
    public void testPreviousPlayer() throws Exception {
        PlayerManager playerManager = new PlayerManager();

        Player john = Player.createPlayer("John", 0, 0);
        Player joe = Player.createPlayer("Joe", 1, 0);
        Player jeff = Player.createPlayer("Jeff", 2, 0);

        playerManager.addPlayer(john);
        playerManager.addPlayer(joe);
        playerManager.addPlayer(jeff);

        // cas limite : le premier n'a pas de previous donc retourne null
        assert playerManager.previousPlayer() == null;

        playerManager.nextPlayer(); // john
        playerManager.nextPlayer(); // joe
        playerManager.nextPlayer(); // jeff
        playerManager.nextPlayer(); // cas limite : null
        playerManager.nextPlayer(); // cas limite : null

        assert playerManager.previousPlayer() == jeff;
        assert playerManager.previousPlayer() == joe;
        assert playerManager.previousPlayer() == john;
        assert playerManager.previousPlayer() == null; // cas limite
        assert playerManager.previousPlayer() == null; // cas limite
    }

    @Test
    public void testGetFirstPlayer() throws Exception {
        PlayerManager playerManager = new PlayerManager();

        Player john = Player.createPlayer("John", 0, 0);
        Player joe = Player.createPlayer("Joe", 1, 0);
        Player jeff = Player.createPlayer("Jeff", 2, 0);

        playerManager.addPlayer(john);
        playerManager.addPlayer(joe);
        playerManager.addPlayer(jeff);

        assert john.getName() == playerManager.getFirstPlayer().getName();
        playerManager.nextPlayer();
        playerManager.nextPlayer();
        playerManager.nextPlayer();
        assert playerManager.getFirstPlayer() == john;
        assert playerManager.nextPlayer() == john;
        assert playerManager.nextPlayer() == joe;

    }

    @Test
    public void testClone() throws Exception {

        PlayerManager playerManager = new PlayerManager();

        Player john = Player.createPlayer("John", 0, 0);
        Player joe = Player.createPlayer("Joe", 1, 0);
        Player jeff = Player.createPlayer("Jeff", 2, 0);

        playerManager.addPlayer(john);
        playerManager.addPlayer(joe);
        playerManager.addPlayer(jeff);

        PlayerManager playerManagerCloned = playerManager.clone();

        assert playerManager.getFirstPlayer() == playerManagerCloned.getFirstPlayer();
        assert playerManager.nextPlayer()  == john;
        assert playerManagerCloned.nextPlayer() == john;
        assert playerManager.nextPlayer() == playerManagerCloned.nextPlayer();
        assert playerManager.nextPlayer() == playerManagerCloned.nextPlayer();


    }
}
