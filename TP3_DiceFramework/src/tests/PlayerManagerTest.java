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
        playerManager.getFirstPlayer();
        assert playerManager.nextPlayer() == john;

    }

    @Test
    public void testGetPlayer() throws Exception {
        PlayerManager playerManager = new PlayerManager();

        Player john = Player.createPlayer("John", 0, 0);
        Player joe = Player.createPlayer("Joe", 1, 0);
        Player jeff = Player.createPlayer("Jeff", 2, 0);

        playerManager.addPlayer(john);
        playerManager.addPlayer(joe);
        playerManager.addPlayer(jeff);

        assert playerManager.getPlayer(2) == jeff;
        assert playerManager.getPlayer(0) == john;
        assert playerManager.getPlayer(2) == jeff;
        assert playerManager.getPlayer(1) == joe;

    }

    @Test
    public void testFindWinner() throws Exception {
        
        PlayerManager playerManager = new PlayerManager();

        Player john = Player.createPlayer("John", 0, 20);
        Player joe = Player.createPlayer("Joe", 1, 50);
        Player jeff = Player.createPlayer("Jeff", 2, 100);

        playerManager.addPlayer(john);
        playerManager.addPlayer(joe);
        playerManager.addPlayer(jeff);

        assert jeff == playerManager.findWinner();


    }
}
