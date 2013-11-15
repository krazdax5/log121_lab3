package buncoplus;

import bfframework.*;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Classe qui implemente l'interface Rules pour les regles du jeu Bunco+
 *

 *        Historique des modifications
 ************************************************
 * @author Pierre-Luc Landry
 * 2013-11-08 : Creation de la classe et implementation des methodes
 * @author Mathieu Lachance LACM14059305
 * 2013-11-11 : Correction du calcul du score.
 * 2013-11-14 : Ajout de la methode findWinner().
 */


public class BuncoPlusRules implements Rules {

    /**
     * Constante utilis&eacute;e afin d'aider la comparaison lors du calcul du score
     */
    final int EQUALS = 0;

    /**
     * Variable bool&eacute;ene qui permet de donner la main au joueur suivant ou non.
     * True : le joueur passe la main au suivant
     * False : le joueur continu de jouer
     */
    private boolean nextToPlay;

    /**
     * M&eacute;thode qui permet de calculer le score selon la ronde et la face active des &eacute;s.
     * @param diceManager   Le DiceManager qui contient tous les d&eacute;s.
     * @param roundNumber   Le num&eacute;ro de la ronde
     * @return  Le pointage de la ronde.
     */
    public int calculateScore(DiceManager diceManager, int roundNumber) {

        Dice dice1 = diceManager.getFirstDice();
        diceManager.nextDice();
        Dice dice2 = diceManager.nextDice();
        Dice dice3 = diceManager.nextDice();

        int score = 0;
        nextToPlay = true;

        if(dice1.compareTo(dice2) == EQUALS && dice2.compareTo(dice3) == EQUALS && dice1.getActiveFace() == roundNumber)
            score = 21;

        else if(dice1.compareTo(dice2) == EQUALS && dice2.compareTo(dice3) == EQUALS && dice1.getActiveFace() != roundNumber){
            score = 5;
            nextToPlay = false;
        }
        else{
            if(dice1.getActiveFace() == roundNumber) {
                nextToPlay = false;
                score += roundNumber;
            }
            if(dice2.getActiveFace() == roundNumber) {
                nextToPlay = false;
                score += roundNumber;
            }
            if(dice3.getActiveFace() == roundNumber){
                nextToPlay = false;
                score += roundNumber;
            }
        }

        return score;
    }

    /**
     * M&eacute;thode qui permet de classer la liste de joueurs en ordre d&eacute;croissant de score
     * @return  Le premier joueur de la liste, c'est-&agrave;-dire celui avec le plus grand score.
     */
    public Player findWinner(PlayerManager playerManager) {
        LinkedList<Player> playersList = new LinkedList<Player>();
        for(int numberOfPlayer = 0; numberOfPlayer < playerManager.getNumberOfPlayers(); numberOfPlayer++) {
            playersList.add(playerManager.nextPlayer());
        }
        Collections.sort(playersList, Collections.reverseOrder());
        return playersList.peek();
    }

    /**
     * M&eacute;thode qui permet de savoir si le joueur doit donner la main au suivant.
     * @return true s'il doit donner la main, false s'il continu de jouer.
     */
    public boolean nextToPlay() {
        return nextToPlay;
    }

}
