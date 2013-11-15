package ets.buncoplus;

import ets.bfframework.*;

/**
 * Classe qui implemente le jeu Bunco+.
 * Hérite de la classe AbstractGame selon le patron Methode Template.
 *
 *        Historique des modifications
 ************************************************
 * @author Mathieu Lachance LACM14059305
 * 2013-11-11 : Creation de la classe
 * 2013-11-11 : Ajout des methodes et implementation de celle-ci
 * 2013-11-12 : Correction de certaines m&eacute;thodes,
 *              ainsi que l'ajout de la m&eacute;thode factory
 *
 */
public class BuncoPlus extends AbstractGame {

    /**
     * Le nombre de rondes selon le nombre de faces de d&eacute;s
     */
    private int numRounds;
    /**
     * Le nombre de joueurs d'une partie de BuncoPlus
     */
    private int numPlayers;

    /**
     * Constructeur priv&eacute; de l'instance de jeu BuncoPlus.
     *
     * @param numPlayers        Le nombre de joueurs de la partie
     * @param numDices          Le nombre de de d&eacute;; la partie
     * @param numFacesPerDice   Le nombre de face par d&eacute;s de la partie
     */
    private BuncoPlus(int numPlayers, int numDices, int numFacesPerDice) {
        this.playerManager = new PlayerManager();
        this.diceManager = new DiceManager();
        this.rules = new BuncoPlusRules();
        this.gameState = GameStates.CREATED;
        createDices(numDices, numFacesPerDice);
        createPlayer(numPlayers);
        this.numRounds = numFacesPerDice;
        this.numPlayers = numPlayers;
    }

    /**
     * Methode factory qui permet la creation d'une instance de jeu BuncoPlus.
     *
     * @param numPlayers        Le nombre de joueurs de la partie
     * @param numDices          Le nombre de d&eacute;s de la partie
     * @param numFacesPerDice   Le nombre de face par d&eacute;s de la partie
     * @return
     */
    public static BuncoPlus createGame(int numPlayers, int numDices, int numFacesPerDice) {
        return new BuncoPlus(numPlayers, numDices, numFacesPerDice);

    }

    /**
     * M&eacute;thode qui calcule le score d'une partie
     *
     * @param roundNumber   Le numéro de la ronde dans laquelle on veut calculer le score
     * @return              Le score a ajouter au pointage du joueur.
     */
    @Override
    public int calculateScoreRound(int roundNumber) {
        return rules.calculateScore(diceManager, roundNumber);
    }

    /**
     * Joue une ronde de BuncoPlus.
     */
    @Override
    public void playRound(int roundNumber) {

        for(int playerNumber=0; playerNumber < numPlayers; playerNumber++) {
            int newScore;
            do {
                newScore=0;
                diceManager.rollAllDices();
                newScore = calculateScoreRound(roundNumber);
                playerManager.nextPlayer().addScore(newScore);
            } while(rules.nextToPlay());
        }

    }

    /**
     * Joue une partie complete de BuncoPlus.
     */
    @Override
    public void playGame() {
        for(int roundNumber = 1; roundNumber <= numRounds; roundNumber++) {
            playRound(roundNumber);
        }
    }

    /**
     * Trouve le gagnant de BuncoPlus.
     * @return  Le joueur gagnant de BuncoPlus.
     */
    @Override
    public Player findWinner() {
        return rules.findWinner(playerManager);
    }

    /**
     * M&eacute;thode qui permet la cr&eacute;ation de d&eacute;s.
     *
     * @param numDices          Le nombre de d&eacutes;s
     * @param numFacesPerDice   Le nombre de faces par d&eacute;s
     */
    @Override
    protected void createDices(int numDices, int numFacesPerDice) {
        while (numDices > 0){
            diceManager.addDice(Dice.createDice(numFacesPerDice));
            numDices--;
        }
    }

    /**
     * M&eacute;thode qui permet la cr&eacute;ation des joueurs d'une partie
     *
     * @param numPlayers    Le nombre de joueurs
     */
    @Override
    protected void createPlayer(int numPlayers) {
        for(int playerNumber = 1; playerNumber <= numPlayers; playerNumber++){
            playerManager.addPlayer(Player.createPlayer("", playerNumber, 0));
        }
    }

}
