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
    public abstract void createGame(int numPlayers, int numDices, int numFacesPerDice /*, Rules rules */);
//    {
//        playerManager = new PlayerManager();
//        diceManager = new DiceManager();
//
//        while (numPlayers > 0){
//            playerManager.addPlayer(new Player());
//            numPlayers--;
//        }
//
//        while (numDices > 0){
//            diceManager.addDice(new Dice(numFacesPerDice));
//            numDices--;
//        }
//
//        this.rules = rules;
//        this.rules = new Rules();
//        gameState = GameStates.CREATED;
//    }

    /**
     * Calcule le pointage de la ronde.
     * @return Le pointage de la ronde.
     */
    public abstract int calculateScoreRound(Player activePlayer);
//    {
//        return rules.calculateScore();
//    }

    /**
     * Joue la ronde pour tous les joueurs.
     */
    public abstract void playRound();
//    {
//        Player playingPlayer = playerManager.nextPlayer();
//        rules.playRound();
//    }

    /**
     * Commence la partie.
     */
    public void startGame(int numPlayers, int numDices, int numFacesPerDice) {
        if(gameState == GameStates.EARLY)
            createGame(numPlayers, numDices, numFacesPerDice);

        gameState = GameStates.STARTED;
        playGame();
    }

    public abstract void playGame();

    /**
     * Trouve le gagnant de la partie.
     * @return Valeur nulle si non trouvé, le joueur si trouvé.
     */
    public abstract Player findWinner();
//    {
//        return rules.findWinner();
//    }
}
