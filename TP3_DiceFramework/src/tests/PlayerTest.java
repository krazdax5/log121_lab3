package tests;

import bfframework.Player;
import org.junit.Test;

/**
 * Classe de tests unitaires qui teste toutes les methodes de la classe Player.
 *
 * @author Jacob Marcil MARJ02029304
 * 2013-11-05 : Creation de la classe de Test et ajout de testGetName, testGetScore (fonctionnel)
 * @author Mathieu Lachance LACM14059305
 * 2013-11-05 : Ajout de testCompareTo
 */
public class PlayerTest {
    @Test
    public void testGetName() throws Exception {
        Player testPlayer = new Player();
        testPlayer.setName("Jacob");
        assert testPlayer.getName() == "Jacob";
    }

    @Test
    public void testGetScore() throws Exception {
        Player testPlayer = new Player();
        testPlayer.setScore(200);
        assert testPlayer.getScore() == 200;
    }

    @Test
    public void testCompareTo() throws Exception {

        Player player1 = new Player("Player 1", 1, 5); // score = 5
        Player player2 = new Player("Player 2", 2, 10); // score = 10
        Player player3 = new Player("Player 3", 3, 5); // score = 5

        // Cas ou le player envoye en parametre a un plus grand score que le player actuel.
        assert (player1.compareTo(player2) == -1);
        // Cas ou le player envoye en parametre a le meme score que le player actuel.
        assert (player1.compareTo(player3) == 0);
        // Cas ou le player envoye en parametre a un plus petit score que le player actuel.
        assert (player2.compareTo(player1) == 1);

        player2.setScore(5);

        // Verifie que compareTo fonctionne dans tous les sens.
        assert (player1.compareTo(player2) == player2.compareTo(player1));

        // Cas ou tous les players ont le meme score.
        assert (player1.compareTo(player1) == player1.compareTo(player3));


    }

}
