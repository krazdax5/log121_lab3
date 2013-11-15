package ets.bfframework;

import java.util.ArrayList;
import java.util.ListIterator;

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
 * 2013-11-11 : Correction de certaines methodes et ajout de getDice(int index) et getFirstPlayer().
 * 2013-11-14 : Changement d'implementation afin d'utiliser seulement l'iterateur de la liste afin de la parcourir.
 *
 */
public class DiceManager {

    /**
     * La liste contenant tous les d&eacute;s
     */
    private ArrayList<Dice> dicesList;
    /**
     * L'it&eacute;rateur de la liste qui permet de naviguer au sein de celle-ci
     */
    private ListIterator<Dice> diceIterator;

    /**
     * Constructeur par d&eacute;faut qui cr&eacute;e une liste vide et
     * qui initialise l'it&eacute;rateur de cette liste.
     */
    public DiceManager(){
        dicesList = new ArrayList<Dice>();
        diceIterator = dicesList.listIterator();
    }


    /**
     * M&eacute;thode qui permet d'ajouter un d&eacute; dans la liste
     * @param diceToAdd Le d&eacute; &agrave; ajouter
     * @return Le d&eacute; qui a &eacute;t&eacute; ajout&eacute;
     */
    public Dice addDice (Dice diceToAdd){
        dicesList.add(diceToAdd);
        diceIterator = dicesList.listIterator();
        return diceToAdd;
    }

    /**
     * M&eacute;thode qui permet de supprimer un d&eacute; dans la liste
     * @param diceToRemove Le d&eacute; &agrave; supprimer
     * @return Le d&eacute; qui &agrave; &eacute;t&eacute; supprim&eacute;
     */
    public Dice removeDice (Dice diceToRemove){
        dicesList.remove(diceToRemove);
        diceIterator = dicesList.listIterator();
        return diceToRemove;
    }

    /**
     * M&eacute;thode qui retourne le d&eacute; &agrave; la position actuelle et
     * qui permet ensuite de passer au d&eacute; suivant dans la liste
     * @return Le d&eacute; &agrave; la position actuelle et passe ensuite au prochain (s'il y en a un, sinon retourne null)
     */
    public Dice nextDice(){

        if(diceIterator.hasNext())
            return diceIterator.next();
        else
            return null;

    }

    /**
     * M&eacute;thode qui retourne le d&eacute; &agrave; la position actuelle et
     * qui permet ensuite de passer au d&eacute; pr&eacute;c&eacute;dent dans la liste
     * @return Le d&eacute; &agrave; la position actuelle et passe ensuite au prochain (s'il y en a un, sinon retourne null)
     */
    public Dice previousDice() {
        if(diceIterator.hasPrevious())
            return diceIterator.previous();
        else
            return null;
    }

    /**
     * M&eacute;thode qui permet de pointer sur le premier d&eacute; de la liste.
     * @return  Le premier d&eacute; de la liste.
     */
    public Dice getFirstDice() {
        diceIterator = dicesList.listIterator();
        Dice firstDice = diceIterator.next();
        diceIterator.previous();
        return firstDice;
    }


    /**
     * M&eacute;thode qui roule al&eacute;atoirement
     * les faces actives de tous les d&eacute;s de la liste
     */
    public void rollAllDices() {
        for(int i = 0; i < dicesList.size(); i++) {
            dicesList.get(i).roll();
        }
    }

    /**
     * Mutateur priv&eacute; qui est utilis&eacute; lors du clonage du DiceManager.
     * @param dicesList La nouvelle liste.
     */
    private void setDicesList(ArrayList<Dice> dicesList) {
        this.dicesList = dicesList;
        this.diceIterator = dicesList.listIterator();
    }

    /**
     * Retourne une copie de l'objet actuel.
     * @return La copie du DiceManager actuel.
     */
    public DiceManager clone() {
        DiceManager cloneDiceList = new DiceManager();
        cloneDiceList.setDicesList(this.dicesList);
        return cloneDiceList;
    }

}
