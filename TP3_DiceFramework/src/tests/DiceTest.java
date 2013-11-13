package tests;

import bfframework.Dice;
import org.junit.Test;

/**
 * Classe de tests unitaires qui teste toutes les methodes de la classe Dice.
 *
 * @author Mathieu Lachance LACM14059305
 * 2013-11-04 ajout de testRoll (fonctionnel)
 * 2013-11-05 ajout de testCompareTo (fonctionnel)
 */
public class DiceTest {

    @Test
    public void testRoll() throws Exception {
        Dice testDice = Dice.createDice(6);

        int resultat = testDice.roll();

        assert (resultat <= 6 && resultat >= 1);
    }

    @Test
    public void testCompareTo() throws Exception {

        // Par defaut la face active est a 1.
        Dice dice1 = Dice.createDice(6);
        Dice dice2 = Dice.createDice(6);
        Dice dice3 = Dice.createDice(6);

        // Verifie que la methode compareTo fonctionne dans les deux sens
        assert (dice1.compareTo(dice2) == dice2.compareTo(dice1));

        // Cas ou les des ont tous la meme faceActive
        assert (dice1.compareTo(dice2) == dice1.compareTo(dice3));

        dice1.setActiveFace(3);
        dice2.setActiveFace(4);
        dice3.setActiveFace(3);

        // Cas ou la face active du de est plus petite que celle du de envoye en parametre
        assert (dice1.compareTo(dice2) == -1);
        // Cas ou la face active du de est plus grande que celle de de envoye en parametre
        assert (dice2.compareTo(dice1) == 1);
        // Cas ou la face active du de est identique a celle du de envoye en parametre
        assert (dice3.compareTo(dice1) == 0);



    }

}
