package bfframework;

/**
 * Interface des règles du jeu.
 *
 * @author Mathieu Lachance
 * 2013-11-01 : Creation de la classe
 */
public interface Rules {

    public int calculateScore(DiceManager diceList, int roundNumber);

    public Player findWinner(PlayerManager playerManager);

    public boolean donneLaMain();

}
