package buncoplus;

import bfframework.*;

/**
 * Classe qui implemente l'interface Rules pour les regles du jeu Bunco+
 *

 *        Historique des modifications
 ************************************************
 * @author Pierre-Luc Landry
 * 2013-11-08 : Creation de la classe et implementation des methodes
 * @author Mathieu Lachance LACM14059305
 * 2013-11-11 : Correction du calcul du score
 */


public class BuncoPlusRules implements Rules {

    final int EQUALS = 0;

    private boolean donneLaMain;

    public int calculateScore(DiceManager diceList, int roundNumber) {

        Dice dice1 = diceList.getDice(0);
        Dice dice2 = diceList.getDice(1);
        Dice dice3 = diceList.getDice(2);

        int score = 0;
        donneLaMain = true;

        if(dice1.compareTo(dice2) == EQUALS && dice2.compareTo(dice3) == EQUALS && dice1.getActiveFace() == roundNumber)
            score = 21;

        else if(dice1.compareTo(dice2) == EQUALS && dice2.compareTo(dice3) == EQUALS && dice1.getActiveFace() != roundNumber){
            score = 5;
            donneLaMain = false;
        }
        else{
            if(dice1.getActiveFace() == roundNumber) {
                donneLaMain = false;
                score += roundNumber;
            }
            if(dice2.getActiveFace() == roundNumber) {
                donneLaMain = false;
                score += roundNumber;
            }
            if(dice3.getActiveFace() == roundNumber){
                donneLaMain = false;
                score += roundNumber;
            }
        }

//        else if(dice1.compareTo(dice2) == EQUALS) {
//            if(dice1.getActiveFace() == roundNumber)
//                score += roundNumber;
//            if(dice2.getActiveFace() == roundNumber)
//                score += roundNumber;
//        }
//        else if(dice1.compareTo(dice3) == EQUALS) {
//            if(dice1.getActiveFace() == roundNumber)
//                score += roundNumber;
//            if(dice3.getActiveFace() == roundNumber)
//                score += roundNumber;
//        }
//        else if(dice2.getActiveFace() == EQUALS) {
//            if(dice2.getActiveFace() == roundNumber)
//                score += roundNumber;
//            if(dice3.getActiveFace() == roundNumber)
//                score += roundNumber;
//        }


//        //Si les des 1 et 2 ont la meme face active
//        if(dice1.compareTo(dice2)==0){
//
//            //Si le premier de a le meme chiffre que le tour, le deuxieme aussi
//            if(dice1.getActiveFace()==roundNumber){
//
//                //Si les des 2 et 3 ont la meme face active, alors BUNCO
//                if(dice2.compareTo(dice3)==0)
//                    score=21;
//                // Sinon pour chaque de avec la meme face, on additionne le numero de la ronde.
//                else
//                    score=2*roundNumber;
//
//            }
//        }
//
//        //Si les des 1 et 2 sont differents
//        else {
//
//            //Si le de 1 a le meme chiffre que le tour
//            if(dice1.getActiveFace()==roundNumber)
//                score+=roundNumber;
//
//                //Si le de 2 a le meme chiffre que le tour
//            else if(dice2.getActiveFace()==roundNumber)
//                score+=roundNumber;
//
//        }
//
//        //Si les des 1 et 3 ont la meme face active
//        if(dice1.compareTo(dice3)==0){
//
//            //Si la face active du premier de a le meme chiffre que le tour
//            if(dice1.getActiveFace()==roundNumber)
//                score+=2*roundNumber;
//
//        }
//        //Si le premier de est different du troisieme de
//        else {
//
//            //Si la face active du de 1 est egale au chiffre du tour
//            if(dice1.getActiveFace()==roundNumber)
//                score+=roundNumber;
//
//                //Si la face active du de 3 est egale au chiffre du tour
//            else if(dice3.getActiveFace()==roundNumber)
//                score+=roundNumber;
//        }
//
//        //Si les des 2 et 3 ont la meme face active
//        if(dice2.compareTo(dice3)==0){
//
//            if(dice2.getActiveFace()==roundNumber)
//                score+=2*roundNumber;
//
//        }
//        //Si les de 2 et 3 ont une face active differente
//        else {
//
//            //Si la face active 2 est egale au chiffre du tour
//            if(dice2.getActiveFace()==roundNumber)
//                score+=roundNumber;
//
//                //Si la face active 3 est egale au chiffre du tour
//            else if(dice3.getActiveFace()==roundNumber)
//                score+=roundNumber;
//
//        }

        return score;
    }

    public Player findWinner(PlayerManager playerManager) {
        return playerManager.findWinner();
    }

    public boolean donneLaMain() {
        return donneLaMain;
    }

}
