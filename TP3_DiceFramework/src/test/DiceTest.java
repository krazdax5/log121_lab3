package test;

import iterator.Dice;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: lucie
 * Date: 2013-11-04
 * Time: 21:49
 * To change this template use File | Settings | File Templates.
 */
public class DiceTest {
    @Test
    public void testRoll() throws Exception {
        Dice testDice = new Dice(6);

        int resultat = testDice.roll();

        assert (resultat <=6 && resultat >=1);

    }
}
