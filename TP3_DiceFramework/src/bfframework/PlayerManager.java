package bfframework;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Classe bfframework.PlayerManager
 *
 * Classe qui permet la gestion des joueurs
 *
 * @author Mathieu Lachance
 * 2013-11-01 : Creation de la classe
 * @author Pierre-Luc Landry
 * 2013-11-08 : Ajout des methodes
 */
public class PlayerManager {

    private LinkedList<Player> playersList;

    
    /**
     * Methode qui permet d'ajouter un joueur a la liste
     * @param playerToAdd le joueur que nous voulons ajouteur
     * @return le joueur qui a ete ajouter
     */
    public Player addPlayer (Player playerToAdd){
        playersList.add(playerToAdd);
        return playerToAdd;
    }


    /**
     * Methode qui permet de supprimer un joueur de la liste
     * @param playerToRemove le joueur que nous voulons supprimer
     * @return le joueur qui a ete supprimer
     */
    public Player removePlayer (Player playerToRemove){
        playersList.remove(playerToRemove);
        return playerToRemove;
    }


    /**
     * Methode qui permet de passer au prochain joueur
     * @return le prochain joueur
     */
    public Player nextPlayer(){

        ListIterator <Player> it = playersList.listIterator();
        if(it.hasNext()){
            return it.next();
        } else return playersList.peekLast();


    }

}
