package tests;

import org.junit.Test;
import bfframework.DiceManager;
import bfframework.Dice;

/**
 * Classe de tests unitaires qui teste toutes les methodes de la classe DiceManager.
 *
 * @author Charles Levesque LEVC27109107
 * 2013-11-10 : Ajout des tests
 */
public class DiceManagerTest {

    @Test
    public void testAddDice() throws Exception{
        DiceManager diceManager = new DiceManager();

        Dice oneFaceDice = new Dice(1);
        Dice twoFacesDice = new Dice(2);

        assert oneFaceDice == diceManager.addDice(oneFaceDice);
        assert twoFacesDice == diceManager.addDice(twoFacesDice);

        assert diceManager.nextDice() == oneFaceDice;
        assert diceManager.nextDice() == twoFacesDice;
    }

    @Test
    public void testRemoveDice() throws Exception{
        DiceManager diceManager = new DiceManager();

        Dice oneFaceDice = new Dice(1);
        Dice twoFacesDice = new Dice(2);

        diceManager.addDice(oneFaceDice);
        diceManager.addDice(twoFacesDice);

        assert diceManager.removeDice(twoFacesDice) == twoFacesDice;
        assert diceManager.nextDice() == oneFaceDice;
    }

    @Test
    public void testNextDice() throws Exception{
        DiceManager diceManager = new DiceManager();

        Dice oneFaceDice = new Dice(1);
        Dice twoFacesDice = new Dice(2);
        Dice threeFacesDice = new Dice(3);

        diceManager.addDice(oneFaceDice);
        diceManager.addDice(twoFacesDice);
        diceManager.addDice(threeFacesDice);

        assert diceManager.nextDice() == oneFaceDice;
        assert diceManager.nextDice() == twoFacesDice;
        assert diceManager.nextDice() == threeFacesDice;
        assert diceManager.nextDice() == oneFaceDice;
    }
}
