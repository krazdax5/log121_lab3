package ets.tests;

import org.junit.Test;
import ets.bfframework.DiceManager;
import ets.bfframework.Dice;

/**
 * Classe de ets.tests unitaires qui teste toutes les methodes de la classe DiceManager.
 *
 * @author Charles Levesque LEVC27109107
 * 2013-11-10 : Ajout des ets.tests
 * @author Mathieu Lachance
 * 2013-11-13 : Ajout des ets.tests : previousDice() et getFirstDice()
 */
public class DiceManagerTest {

    @Test
    public void testAddDice() throws Exception{
        DiceManager diceManager = new DiceManager();

        Dice oneFaceDice = Dice.createDice(1);
        Dice twoFacesDice = Dice.createDice(2);

        assert oneFaceDice == diceManager.addDice(oneFaceDice);
        assert twoFacesDice == diceManager.addDice(twoFacesDice);

        assert diceManager.nextDice() == oneFaceDice;
        assert diceManager.nextDice() == twoFacesDice;
    }

    @Test
    public void testRemoveDice() throws Exception{
        DiceManager diceManager = new DiceManager();

        Dice oneFaceDice = Dice.createDice(1);
        Dice twoFacesDice = Dice.createDice(2);

        diceManager.addDice(oneFaceDice);
        diceManager.addDice(twoFacesDice);

        assert diceManager.removeDice(twoFacesDice) == twoFacesDice;
        assert diceManager.nextDice() == oneFaceDice;
    }

    @Test
    public void testNextDice() throws Exception{
        DiceManager diceManager = new DiceManager();

        Dice oneFaceDice = Dice.createDice(1);
        Dice twoFacesDice = Dice.createDice(2);
        Dice threeFacesDice = Dice.createDice(3);

        diceManager.addDice(oneFaceDice);
        diceManager.addDice(twoFacesDice);
        diceManager.addDice(threeFacesDice);

        assert diceManager.nextDice() == oneFaceDice;
        assert diceManager.nextDice() == twoFacesDice;
        assert diceManager.nextDice() == threeFacesDice;
        assert diceManager.nextDice() == null;
    }

    @Test
    public void testPreviousDice() throws Exception {
        DiceManager diceManager = new DiceManager();

        Dice oneFaceDice = Dice.createDice(1);
        Dice twoFacesDice = Dice.createDice(2);
        Dice threeFacesDice = Dice.createDice(3);

        diceManager.addDice(oneFaceDice);
        diceManager.addDice(twoFacesDice);
        diceManager.addDice(threeFacesDice);

        // Verifie que lorsque l'iterateur est au premier de,
        // la methode retourne null
        assert diceManager.previousDice() == null;

        diceManager.nextDice(); // oneFaceDice
        diceManager.nextDice(); // twoFaceDice
        diceManager.nextDice(); // threeFaceDice
        diceManager.nextDice(); // null : cas limite
        diceManager.nextDice(); // null : cas limite

        assert diceManager.previousDice() == threeFacesDice;
        assert diceManager.previousDice() == twoFacesDice;
        assert diceManager.previousDice() == oneFaceDice;

        assert diceManager.previousDice() == null; // cas limite

    }

    @Test
    public void testGetFirstDice() throws Exception {

        DiceManager diceManager = new DiceManager();

        Dice oneFaceDice = Dice.createDice(1);
        Dice twoFacesDice = Dice.createDice(2);
        Dice threeFacesDice = Dice.createDice(3);
        Dice fourFacesDice = Dice.createDice(4);

        diceManager.addDice(oneFaceDice);
        diceManager.addDice(twoFacesDice);
        diceManager.addDice(threeFacesDice);

        // Bouge la position de l'iterateur et ajoute un de.
        diceManager.nextDice();
        diceManager.nextDice();
        diceManager.nextDice();
        diceManager.nextDice();
        diceManager.nextDice();
        diceManager.nextDice();
        diceManager.addDice(fourFacesDice);
        diceManager.nextDice();
        diceManager.nextDice();
        diceManager.previousDice();
        diceManager.nextDice();

        assert diceManager.getFirstDice() == oneFaceDice;
        diceManager.nextDice();
        assert diceManager.nextDice() == twoFacesDice;


    }

    @Test
    public void testClone() throws Exception {

        DiceManager diceManager = new DiceManager();

        Dice oneFaceDice = Dice.createDice(1);
        Dice twoFacesDice = Dice.createDice(2);
        Dice threeFacesDice = Dice.createDice(3);
        Dice fourFacesDice = Dice.createDice(4);

        diceManager.addDice(oneFaceDice);
        diceManager.addDice(twoFacesDice);
        diceManager.addDice(threeFacesDice);

        DiceManager diceManagerCloned = diceManager.clone();

        assert diceManager.getFirstDice() == diceManagerCloned.getFirstDice();
        assert diceManager.nextDice() == oneFaceDice;
        assert diceManagerCloned.nextDice() == oneFaceDice;
        assert diceManager.nextDice() == diceManagerCloned.nextDice();
        assert diceManager.nextDice() == diceManagerCloned.nextDice();


    }
}
