package bfframework;

/**
 * Classe abstraite de bfframework.Game
 *
 * @author Mathieu Lachance
 * 2013-11-01 : Creation de la classe
 * @author Pierre-Luc Landry
 * 2013-11-08 : Ajout des methodes et changement pour classe abstraite
 */
public abstract class AbstractGame {

    private PlayerManager playerManager;
    private DiceManager diceManager;
    private Rules rules;

    public void createGame(int numDices, int numPlayers, int numFacesPerDice){

        diceManager = new DiceManager();
        for(int i=0; i<=numDices; i++){
            Dice dice = new Dice(numFacesPerDice);
            diceManager.addDice(dice);
            diceManager.nextDice();
        }

        playerManager = new PlayerManager();
        for(int i=0; i<= numPlayers; i++){
            Player player = new Player();
            playerManager.addPlayer(player);
            playerManager.nextPlayer();
        }

    }

    /*public int calculateScoreRound(){

    }*/

    public void playRound(){

    }

    public void startGame(){

    }

    public int getNumRound(){
        return 1;
    }

   /* public Player findWinner(){


    }*/



}
