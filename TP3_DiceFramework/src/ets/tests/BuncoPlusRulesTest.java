package ets.tests;

import ets.bfframework.*;
import ets.buncoplus.BuncoPlus;
import ets.buncoplus.BuncoPlusRules;
import org.junit.Test;

/**
 * Classe de ets.tests unitaires pour calculateScore() et nextToPlay()
 *
 * @author Mathieu Lachance LACM14059305
 * 2013-11-12 : Creation et implementation des ets.tests
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
        diceManager.getFirstDice().setActiveFace(3);
        diceManager.nextDice();
        diceManager.nextDice().setActiveFace(3);
        diceManager.nextDice().setActiveFace(3);

        assert theRules.calculateScore(diceManager,3) == 21;

        // Si tous les des ont la meme face active,
        // mais ne correspondent pas avec le numero de ronde,
        // le score est de 5.
        diceManager.getFirstDice().setActiveFace(3);
        diceManager.nextDice();
        diceManager.nextDice().setActiveFace(3);
        diceManager.nextDice().setActiveFace(3);

        assert theRules.calculateScore(diceManager,4) == 5;

        // Si aucun des des a la meme face et
        // qu'aucun d'entre eux correspond avec le numero de ronde,
        // le score est de 0.
        diceManager.getFirstDice().setActiveFace(1);
        diceManager.nextDice();
        diceManager.nextDice().setActiveFace(2);
        diceManager.nextDice().setActiveFace(3);

        assert theRules.calculateScore(diceManager,4) == 0;

        // Si un seul de correspond avec le numero de ronde,
        // le score est equivalent au numero de ronde.
        diceManager.getFirstDice().setActiveFace(1);
        diceManager.nextDice();
        diceManager.nextDice().setActiveFace(2);
        diceManager.nextDice().setActiveFace(3);

        assert theRules.calculateScore(diceManager,3) == 1;

        // Si deux des correspondent avec le numero de ronde,
        // le score est equivalent au nombre d'occurence
        // fois le numero de la ronde (dans notre cas, 2*3=6)
        diceManager.getFirstDice().setActiveFace(1);
        diceManager.nextDice();
        diceManager.nextDice().setActiveFace(3);
        diceManager.nextDice().setActiveFace(3);

        assert theRules.calculateScore(diceManager,3) == 2;

    }

    @Test
    public void testFindWinner() throws Exception {
        BuncoPlus theGame = BuncoPlus.createGame(5, 3, 6);

        theGame.startGame();

        PlayerManager playerManager = theGame.getPlayerManager();

        // Si compareTo retourne 0, alors le premier correspond bien au gagnant de la partie
        assert theGame.findWinner().compareTo(playerManager.getFirstPlayer()) == 0;

        Player player1 = playerManager.nextPlayer();
        Player player2 = playerManager.nextPlayer();
        Player player3 = playerManager.nextPlayer();
        Player player4 = playerManager.nextPlayer();
        Player player5 = playerManager.nextPlayer();

        // S'assure que la liste est bien en ordre.
        // Les joueurs peuvent avoir le meme score s'ils sont chanceux ...
        assert player1.getScore() >= player2.getScore();
        assert player2.getScore() >= player3.getScore();
        assert player3.getScore() >= player4.getScore();
        assert player4.getScore() >= player5.getScore();

    }

    @Test
    public void testDonneLaMain() throws Exception {

        BuncoPlusRules theRules = new BuncoPlusRules();

        DiceManager diceManager = new DiceManager();
        diceManager.addDice(Dice.createDice(6));
        diceManager.addDice(Dice.createDice(6));
        diceManager.addDice(Dice.createDice(6));

        // Si Bunco+, on donne la main
        diceManager.getFirstDice().setActiveFace(3);
        diceManager.nextDice();
        diceManager.nextDice().setActiveFace(3);
        diceManager.nextDice().setActiveFace(3);

        theRules.calculateScore(diceManager, 3);

        assert theRules.nextToPlay() == true;

        // Si les trois des sont identiques,
        // mais ne correspondent pas avec le numero de la ronde,
        // on ne passe pas la main
        diceManager.getFirstDice().setActiveFace(3);
        diceManager.nextDice();
        diceManager.nextDice().setActiveFace(3);
        diceManager.nextDice().setActiveFace(3);
        theRules.calculateScore(diceManager,4);

        assert theRules.nextToPlay() == false;

        // Si un des des correspond avec le numero de la ronde,
        // on ne passe pas la main.
        diceManager.getFirstDice().setActiveFace(1);
        diceManager.nextDice();
        diceManager.nextDice().setActiveFace(2);
        diceManager.nextDice().setActiveFace(3);

        theRules.calculateScore(diceManager, 3);

        assert theRules.nextToPlay() == false;

        // Si deux des des correspondent avec le numero de la ronde,
        // on ne passe pas la main.
        diceManager.getFirstDice().setActiveFace(1);
        diceManager.nextDice();
        diceManager.nextDice().setActiveFace(3);
        diceManager.nextDice().setActiveFace(3);

        theRules.calculateScore(diceManager, 3);

        assert theRules.nextToPlay() == false;

        // Si les trois des sont differents et
        // qu'aucun d'entre eux correspond avec le numero de la ronde,
        // on passe la main.
        diceManager.getFirstDice().setActiveFace(1);
        diceManager.nextDice();
        diceManager.nextDice().setActiveFace(2);
        diceManager.nextDice().setActiveFace(3);

        theRules.calculateScore(diceManager, 4);

        assert theRules.nextToPlay() == true;

    }
}
