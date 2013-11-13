package tests;

import bfframework.Dice;
import bfframework.DiceManager;
import bfframework.Rules;
import buncoplus.BuncoPlusRules;
import org.junit.Test;

/**
 * Classe de tests unitaires pour calculateScore() et donneLaMain()
 *
 * @author Mathieu Lachance LACM14059305
 * 2013-11-12 : Creation et implementation des tests
 */
public class BuncoPlusRulesTest {

    @Test
    public void testCalculateScore() throws Exception {

        Rules theRules = new BuncoPlusRules();

        DiceManager diceManager = new DiceManager();
        diceManager.addDice(Dice.createDice(6));
        diceManager.addDice(Dice.createDice(6));
        diceManager.addDice(Dice.createDice(6));

        // Si Bunco+, le score est de 21.
        diceManager.getDice(0).setActiveFace(3);
        diceManager.getDice(1).setActiveFace(3);
        diceManager.getDice(2).setActiveFace(3);

        assert theRules.calculateScore(diceManager,3) == 21;

        // Si tous les des ont la meme face active,
        // mais ne correspondent pas avec le numero de ronde,
        // le score est de 5.
        diceManager.getDice(0).setActiveFace(3);
        diceManager.getDice(1).setActiveFace(3);
        diceManager.getDice(2).setActiveFace(3);

        assert theRules.calculateScore(diceManager,4) == 5;

        // Si aucun des des a la meme face et
        // qu'aucun d'entre eux correspond avec le numero de ronde,
        // le score est de 0.
        diceManager.getDice(0).setActiveFace(1);
        diceManager.getDice(1).setActiveFace(2);
        diceManager.getDice(2).setActiveFace(3);

        assert theRules.calculateScore(diceManager,4) == 0;

        // Si un seul de correspond avec le numero de ronde,
        // le score est equivalent au numero de ronde.
        diceManager.getDice(0).setActiveFace(1);
        diceManager.getDice(1).setActiveFace(2);
        diceManager.getDice(2).setActiveFace(3);

        assert theRules.calculateScore(diceManager,3) == 3;

        // Si deux des correspondent avec le numero de ronde,
        // le score est equivalent au nombre d'occurence
        // fois le numero de la ronde (dans notre cas, 2*3=6)
        diceManager.getDice(0).setActiveFace(1);
        diceManager.getDice(1).setActiveFace(3);
        diceManager.getDice(2).setActiveFace(3);

        assert theRules.calculateScore(diceManager,3) == 6;

    }

    @Test
    public void testDonneLaMain() throws Exception {

        BuncoPlusRules theRules = new BuncoPlusRules();

        DiceManager diceManager = new DiceManager();
        diceManager.addDice(Dice.createDice(6));
        diceManager.addDice(Dice.createDice(6));
        diceManager.addDice(Dice.createDice(6));

        // Si Bunco+, on donne la main
        diceManager.getDice(0).setActiveFace(3);
        diceManager.getDice(1).setActiveFace(3);
        diceManager.getDice(2).setActiveFace(3);

        theRules.calculateScore(diceManager, 3);

        assert theRules.donneLaMain() == true;

        // Si les trois des sont identiques,
        // mais ne correspondent pas avec le numero de la ronde,
        // on ne passe pas la main
        diceManager.getDice(0).setActiveFace(3);
        diceManager.getDice(1).setActiveFace(3);
        diceManager.getDice(2).setActiveFace(3);

        theRules.calculateScore(diceManager,4);

        assert theRules.donneLaMain() == false;

        // Si un des des correspond avec le numero de la ronde,
        // on ne passe pas la main.
        diceManager.getDice(0).setActiveFace(1);
        diceManager.getDice(1).setActiveFace(2);
        diceManager.getDice(2).setActiveFace(3);

        theRules.calculateScore(diceManager, 3);

        assert theRules.donneLaMain() == false;

        // Si deux des des correspondent avec le numero de la ronde,
        // on ne passe pas la main.
        diceManager.getDice(0).setActiveFace(1);
        diceManager.getDice(1).setActiveFace(3);
        diceManager.getDice(2).setActiveFace(3);

        theRules.calculateScore(diceManager, 3);

        assert theRules.donneLaMain() == false;

        // Si les trois des sont differents et
        // qu'aucun d'entre eux correspond avec le numero de la ronde,
        // on passe la main.
        diceManager.getDice(0).setActiveFace(1);
        diceManager.getDice(1).setActiveFace(2);
        diceManager.getDice(2).setActiveFace(3);

        theRules.calculateScore(diceManager, 4);

        assert theRules.donneLaMain() == true;

    }
}
