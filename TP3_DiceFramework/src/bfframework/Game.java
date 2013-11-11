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
    private GameStates gameState = GameStates.EARLY;
    private PlayerManager playerManager;
    private DiceManager diceManager;
    private Rules rules;

    /**
     * Instancie les joueurs et les dés sans démarrer la partie.
     * @param numPlayers Le nombre de joueurs
     * @param numDices Le nombre de dés
     * @param numFacesPerDice Le nombre de faces par dé
     */
    public void createGame(int numPlayers, int numDices, int numFacesPerDice, Rules rules){
        playerManager = new PlayerManager();
        diceManager = new DiceManager();

        while (numPlayers > 0){
            playerManager.addPlayer(new Player());
            numPlayers--;
        }

        while (numDices > 0){
            diceManager.addDice(new Dice(numFacesPerDice));
            numDices--;
        }

        this.rules = rules;
        gameState = GameStates.CREATED;
    }

    /**
     * Calcule le pointage de la ronde.
     * @return Le pointage de la ronde.
     */
    public int calculateScoreRound(){
        return rules.calculateScore();
    }

    /**
     * Joue la ronde pour tous les joueurs.
     */
    public void playRound(){
        Player playingPlayer = playerManager.nextPlayer();
        rules.playRound();
    }

    /**
     * Commence la partie.
     */
    public void startGame(){
        gameState = GameStates.STARTED;
    }

    /**
     * Trouve le gagnant de la partie.
     * @return Valeur nulle si non trouvé, le joueur si trouvé.
     */
    public Player findWinner(){
        return rules.findWinner();
    }
}
