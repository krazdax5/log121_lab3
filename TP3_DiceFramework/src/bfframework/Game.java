package bfframework;

/**
 * Classe qui permet la communication entre les classes.
 *
 *        Historique des modifications
 ************************************************
 * @author Mathieu Lachance LACM14059305
 * 2013-11-01 : Creation de la classe
 * @author Charles Levesque LEVC27109107
 * 2013-11-07 : Ajout des méthode.
 * 2013-11-10 : Implémentation des méthodes
 */
public abstract class Game {

    protected GameStates gameState = GameStates.EARLY;
    protected PlayerManager playerManager;
    protected DiceManager diceManager;
    protected Rules rules;

    /**
     * Instancie les joueurs et les dés sans démarrer la partie.
     * @param numPlayers Le nombre de joueurs
     * @param numDices Le nombre de dés
     * @param numFacesPerDice Le nombre de faces par dé
     */
    public static Game createGame(int numPlayers, int numDices, int numFacesPerDice) {
        return null;
    }

    /**
     * Calcule le pointage de la ronde.
     * @return Le pointage de la ronde.
     */
    public abstract int calculateScoreRound(int roundNumber);

    /**
     * Joue la ronde pour tous les joueurs.
     */
    public abstract void playRound(int roundNumber);

    /**
     * Commence la partie. (M&eacute;thode Template)
     */
    public void startGame() {
        if(gameState != GameStates.CREATED) {
            gameState = GameStates.STARTED;
            playGame();
            findWinner();
            gameState = GameStates.FINISHED;
        }
    }

    /**
     * M&eacute;thode qui contient l'impl&eacute;mentation d'une partie d'un jeu de d&eacute;s
     */
    public abstract void playGame();

    /**
     * Trouve le gagnant de la partie.
     * @return Valeur nulle si non trouvé, le joueur si trouvé.
     */
    public abstract Player findWinner();

    /**
     * Instancie les d&eacute;s d'un jeu de d&eacutes;s
     * @param numDices      Le nombre de d&eacutes;s
     * @param numberOfFaces Le nombre de face par d&eacute;s
     */
    public abstract void createDices(int numDices, int numberOfFaces);

    /**
     * Instancie les joueurs d'un jeu de d&eacute;s
     * @param numPlayers    Le nombre de joueurs
     */
    public abstract void createPlayer(int numPlayers);

    public DiceManager getDiceManager() {
        return diceManager;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }
}
