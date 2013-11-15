package bfframework;

/**
 * Interface des règles du jeu.
 *
 * @author Mathieu Lachance
 * 2013-11-01 : Creation de l'interface
 */
public interface Rules {

    public int calculateScore(DiceManager diceManager, int roundNumber);

    public Player findWinner(PlayerManager playerManager);

    public boolean nextToPlay();

}
