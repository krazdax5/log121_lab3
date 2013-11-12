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


public class MyRules implements Rules {


    private int score;


    public int calculateScore(Player activePlayer, DiceManager diceList, int numberOfRound) {

        final byte ISEQUAL = 0;
        final byte SCORE_BUNCO = 21;
        final byte SCORE_ONE_DICE = 1;
        final byte SCORE_NULL = 0;


        Dice dice1 = diceList.getDice(0);
        Dice dice2 = diceList.getDice(1);
        Dice dice3 = diceList.getDice(2);

        score = activePlayer.getScore();

        //Calcul le score si les des 1 et 2 ont la meme face active
        if( dice1.compareTo(dice2) == ISEQUAL ){

            if( dice1.getActiveFace() == numberOfRound ){

                if( dice2.compareTo(dice3) == ISEQUAL )
                    score+= SCORE_BUNCO;

                score+= 2 * SCORE_ONE_DICE ;
            }

            else
                score+= SCORE_NULL;
        }


        //Calcul du score si les des 1 et 2 non pas la meme face active
        else if( dice1.compareTo(dice2) != ISEQUAL ){

            if( dice1.getActiveFace() == numberOfRound )
                score+= SCORE_ONE_DICE;

            else if( dice2.getActiveFace() == numberOfRound )
                score+= SCORE_ONE_DICE;

            else
                score+= SCORE_NULL;
        }


        //Calcul du score si les des 1 et 3 ont la meme face active
        if( dice1.compareTo(dice3) == ISEQUAL ){

            if( dice1.getActiveFace() == numberOfRound )
                score+= 2 * SCORE_ONE_DICE;

            else
                score+= SCORE_NULL;
        }


        //Calcul du score si les des 1 et 3 non pas la meme face active
        else if( dice1.compareTo(dice3)!= ISEQUAL ){

            if( dice1.getActiveFace( )== numberOfRound )
                score+= SCORE_ONE_DICE;

            else if( dice3.getActiveFace() == numberOfRound )
                score+=SCORE_ONE_DICE;

            else
                score+= SCORE_NULL;
        }


        //Calcul du score si les des 2 et 3 ont la meme face active
        if( dice2.compareTo (dice3) == ISEQUAL ){

            if( dice2.getActiveFace() == numberOfRound )
                score+= 2 * SCORE_ONE_DICE;

            else
                score+= SCORE_NULL;
        }


        //Calcul du score si els des 2 et 3 non pas la meme face active
        else if( dice2.compareTo(dice3)!= ISEQUAL ){

            if( dice2.getActiveFace() == numberOfRound )
                score+= SCORE_ONE_DICE;

            else if( dice3.getActiveFace() == numberOfRound )
                score+= SCORE_ONE_DICE;

            else
                score+= SCORE_NULL;
        }


        return score;
    }


    public Player findWinner() {
        return null;
    }


    public void playRound() {
    }

}
