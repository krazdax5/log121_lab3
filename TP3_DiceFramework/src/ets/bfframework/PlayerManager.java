package ets.bfframework;
import java.util.*;

/**
 * Classe ets.bfframework.PlayerManager
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
 * 2013-11-11 : Correction de certaines methodes et ajout de getPlayer(int index) et getFirstPlayer().
 * 2013-11-12 : Ajout de finWinner().
 * 2013-11-14 : Changement d'implementation afin d'utiliser seulement l'iterateur de la liste afin de la parcourir.
 *
 */
public class PlayerManager {

    /**
     * La liste contenant tous les joueurs
     */
    private LinkedList<Player> playersList;
    /**
     * L'iterateur de la liste qui permet de naviguer au sein de celle-ci.
     */
    private ListIterator<Player> playerIterator;

    /**
     * Constructeur par defaut qui cree une liste de joueurs vide.
     * Initialise aussi son iterateur.
     */
    public PlayerManager() {
        playersList = new LinkedList<Player>();
        playerIterator = playersList.listIterator();
    }

    /**
     * M&eacute;thode qui permet d'ajouter un joueur a la liste
     * @param playerToAdd le joueur que nous voulons ajouteur
     * @return le joueur qui a ete ajouter
     */
    public Player addPlayer (Player playerToAdd){
        playersList.add(playerToAdd);
        playerIterator = playersList.listIterator();
        return playerToAdd;
    }


    /**
     * M&eacute;thode qui permet de supprimer un joueur de la liste
     * @param playerToRemove le joueur que nous voulons supprimer
     * @return le joueur qui a ete supprimer
     */
    public Player removePlayer (Player playerToRemove){
        playersList.remove(playerToRemove);
        playerIterator = playersList.listIterator();
        return playerToRemove;
    }


    /**
     * M&eacute;thode qui retourne l'element a la position courante de la liste et
     * pointe sur le joueur suivant de la liste
     * @return le joueur a la position actuelle et ensuite passe au suivant (s'il y en a un, sinon retourne null)
     */
    public Player nextPlayer(){

        if(playerIterator.hasNext())
            return playerIterator.next();
        else
            return null;
    }

    /**
     * M&eacute;;thode qui retourne l'element a la position courrante de la liste
     * et qui ensuite pointe sur l'element precedent de la liste.
     * @return  le joueur a la position actuelle et ensuite passe au precedent (s'il y en a un, sinon retourne null)
     */
    public Player previousPlayer() {
        if(playerIterator.hasPrevious())
            return playerIterator.previous();
        else
            return null;
    }

    /**
     * M&eacute;thoe qui pointe sur le premier element de la liste.
     * @return le premier element de la liste.
     */
    public Player getFirstPlayer() {
        playerIterator = playersList.listIterator();
        Player firstPlayer = playerIterator.next();
        playerIterator.previous();
        return firstPlayer;
    }

    /**
     * M&eacute;thode qui retourne le nombre de joueurs dans la liste.
     * @return  Le nombre de joueurs dans la liste.
     */
    public int getNumberOfPlayers() {
        int numberOfPlayers = 0;
        ListIterator<Player> listIterator = playersList.listIterator();
        while(listIterator.hasNext()) {
            listIterator.next();
            numberOfPlayers++;
        }
        return numberOfPlayers;
    }

    /**
     * Mutateur priv&eacute; qui est utilis&eacute; lors du clonage du PlayerManager.
     * @param playersList La nouvelle liste.
     */
    private void setPlayersList(LinkedList<Player> playersList) {
        this.playersList = playersList;
        this.playerIterator = playersList.listIterator();
    }

    /**
     * Retourne une copie de l'objet actuel.
     * @return La copie du PlayerManager actuel.
     */
    public PlayerManager clone() {
        PlayerManager clonePlayerManager = new PlayerManager();
        clonePlayerManager.setPlayersList(this.playersList);
        return clonePlayerManager;
    }

}