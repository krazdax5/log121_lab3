package bfframework;

/**
 * Classe qui implemente l'interface Rules pour les regles Bunco+
 *
 * @author Pierre-Luc Landry
 * 2013-11-08 : Creation de la classe
 *
 */


public class MyRules implements Rules{

    private Dice dice1;
    private Dice dice2;
    private Dice dice3;
    private int score;
    private AbstractGame round;


    public int calculateScore() {
        return score;
    }


    public Player findWinner() {
        return null;
    }


    public void playRound() {
    }

    public void score(){

        //Si les des 1 et 2 ont la meme face active
        if(dice1.compareTo(dice2)==0){

            //Si le premier de a le meme chiffre que le tour
            if(dice1.getActiveFace()==round.getNumRound()){

                //Si les des 2 et 3 ont la meme face active
                if(dice2.compareTo(dice3)==0)
                    score=21;

                score=2;
            }
            //Si ils sont pareils mais pas le chiffre du tour
            else
                score=0;
        }


        //Si les des 1 et 2 sont differents
        else if(dice1.compareTo(dice2)!=0){

            //Si le de 1 a le meme chiffre que le tour
            if(dice1.getActiveFace()==round.getNumRound())
                score=1;

            //Si le de 2 a le meme chiffre que le tour
            else if(dice2.getActiveFace()==round.getNumRound())
                score=1;

            //Si aucun de (1 ou 2) a le meme chiffre que le tour
            else
                score=0;
        }

        //Si les des 1 et 3 ont la meme face active
        if(dice1.compareTo(dice3)==0){

            //Si la face active du premier de a le meme chiffre que le tour
            if(dice1.getActiveFace()==round.getNumRound())
               score=2;

            //Si la face active des de 1 et 3 est differente que le chiffre du tour
            else
                score=0;
        }
        //Si le premier de est different du troisieme de
        else if(dice1.compareTo(dice3)!=0){

            //Si la face active du de 1 est egale au chiffre du tour
            if(dice1.getActiveFace()==round.getNumRound())
                score=1;

            //Si la face active du de 3 est egale au chiffre du tour
            else if(dice3.getActiveFace()==round.getNumRound())
                score=1;

            //Si aucun des de (1 et 3) est egal au chiffre du tour
            else
                score=0;
        }

        //Si les des 2 et 3 ont la meme face active
        if(dice2.compareTo(dice3)==0){
            if(dice2.getActiveFace()==round.getNumRound())
                score=2;

            else
                score=0;
        }
        //Si les de 2 et 3 ont une face active differente
        else if(dice2.compareTo(dice3)!=0){

            //Si la face active 2 est egale au chiffre du tour
            if(dice2.getActiveFace()==round.getNumRound())
                score=1;

            //Si la face active 3 est egale au chiffre du tour
            else if(dice3.getActiveFace()==round.getNumRound())
                score=1;

            //Si aucunes des faces actives est egale au chiffre du tour
            else
                score=0;
        }

    }
}
