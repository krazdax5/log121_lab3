package test;

import iterator.Player;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Jacob
 * Date: 13-11-05
 * Time: 13:26
 * To change this template use File | Settings | File Templates.
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

}
