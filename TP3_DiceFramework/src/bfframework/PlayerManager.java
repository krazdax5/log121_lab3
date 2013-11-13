package bfframework;
import java.util.*;

/**
 * Classe bfframework.PlayerManager
 *
 * Classe qui permet la gestion des joueurs

 *
 *        Historique des modifications
 ************************************************
 * @author Mathieu Lachance LACM14059305
 * 2013-11-01 : Creation de la classe
 * @author Pierre-Luc Landry
 * 2013-11-08 : Ajout des methodes
 * @author Mathieu Lachance LACM14059305
 * 2013-11-11 : Correction de certaines methodes et ajout de getPlayer et getFirstPlayer.
 *
 */
public class PlayerManager {

    private LinkedList<Player> playersList;
    private ListIterator<Player> playerIterator;

    public PlayerManager() {
        playersList = new LinkedList<Player>();
    }

    /**
     * Methode qui permet d'ajouter un joueur a la liste
     * @param playerToAdd le joueur que nous voulons ajouteur
     * @return le joueur qui a ete ajouter
     */
    public Player addPlayer (Player playerToAdd){
        playersList.add(playerToAdd);
        playerIterator = playersList.listIterator();
        return playerToAdd;
    }


    /**
     * Methode qui permet de supprimer un joueur de la liste
     * @param playerToRemove le joueur que nous voulons supprimer
     * @return le joueur qui a ete supprimer
     */
    public Player removePlayer (Player playerToRemove){
        playersList.remove(playerToRemove);
        playerIterator = playersList.listIterator();
        return playerToRemove;
    }


    /**
     * Methode qui permet de passer au prochain joueur
     * @return le prochain joueur
     */
    public Player nextPlayer(){

        if(playerIterator.hasNext())
            return playerIterator.next();
        else
            return null;
    }

    public Player getFirstPlayer() {
        playerIterator = playersList.listIterator();
        Player firstPlayer = playerIterator.next();
        playerIterator.previous();
        return firstPlayer;
    }

    public Player getPlayer(int position){
//        playersList.listIterator().next();
        if(!playersList.isEmpty())
            return playersList.get(position);
        else
            return null;
    }


    public Player findWinner() {
        Collections.sort(this.playersList, Collections.reverseOrder());
        return getFirstPlayer();
    }

}