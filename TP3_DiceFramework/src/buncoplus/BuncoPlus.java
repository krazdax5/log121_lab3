package buncoplus;

import bfframework.*;

/**
 * Classe qui implemente le jeu Bunco+.
 * Hérite de la classe Game selon le patron Methode Template.
 *
 *        Historique des modifications
 ************************************************
 * @author Mathieu Lachance LACM14059305
 * 2013-11-11 : Creation de la classe
 * 2013-11-11 : Ajout des methodes et implementation de celle-ci
 */
public class BuncoPlus extends Game{

    private int numRounds;
    private int numPlayers;

    @Override
    public void createGame(int numPlayers, int numDices, int numFacesPerDice) {

        playerManager = new PlayerManager();
        diceManager = new DiceManager();

        this.numPlayers = numPlayers;

        // Le nombre de rondes est egal au nombre de faces qu'ont les des.
        this.numRounds = numFacesPerDice;

        createDices(numDices, numFacesPerDice);
        createPlayer(numPlayers);

        this.rules = new MyRules();


        gameState = GameStates.CREATED;

    }

    @Override
    public int calculateScoreRound(Player activePlayer) {
        return rules.calculateScore(activePlayer,diceManager,numRounds);
    }

    @Override
    public void playRound() {
        diceManager.rollAllDices();;
    }

    @Override
    public void playGame() {
        for(int i = 0; i < numRounds; i++) {
            for(int j=0; i < numPlayers; j++) {
                int newScore;
                do {
                    playRound();
                    newScore = calculateScoreRound(playerManager.getPlayer(j));
                    playerManager.getPlayer(j).addScore(newScore);
                } while(newScore !=0 || newScore != 21);
            }
        }
    }

    @Override
    public Player findWinner() {

        boolean changement = true;
        while(changement)
            changement = false;
            for(int i =0; i < numPlayers-1; i++) {
                if(playerManager.getPlayer(i).getScore() <  playerManager.getPlayer(i+1).getScore()){
                    Player temporaryPlayer = playerManager.getPlayer(i);
//                    playerManager.setPlayer(i) = playerManager.getPlayer(i+1);
//                    playerManager.setPlayer(i+1) = temporaryPlayer;
                    changement = true;
                }
            }

        return null;
    }

    @Override
    public void createDices(int numDices, int numFacesPerDice) {
        while (numDices > 0){
            diceManager.addDice(new Dice(numFacesPerDice));
            numDices--;
        }
    }

    @Override
    public void createPlayer(int numPlayers) {
        while (numPlayers > 0){
            playerManager.addPlayer(new Player());
            numPlayers--;
        }
    }

}
