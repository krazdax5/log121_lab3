package bfframework;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Classe bfframework.DiceManager
 *
 * Classe qui permet la gestion des des(dices)
 *
 * @author Mathieu Lachance
 * 2013-11-01 : Creation de la classe
 * @author Pierre-Luc Landry
 * 2013-11-08 : Ajout des methodes
 */
public class DiceManager {

    private ArrayList<Dice> dicesList;

    public DiceManager(){
        dicesList = new ArrayList<Dice>();
    }


    /**
     * Methode qui permet d'ajouter un de dans la liste
     * @param diceToAdd quel de voulons-nous ajouter
     * @return le de qui a ete ajoute
     */
    public Dice addDice (Dice diceToAdd){
        dicesList.add(diceToAdd);
        return diceToAdd;
    }


    /**
     *Methode qui permet de supprimer un de dans la liste
     * @param diceToRemove quel de voulons-nous supprimer
     * @return le de qui a ete supprime
     */
    public Dice removeDice (Dice diceToRemove){
        dicesList.remove(diceToRemove);
        return diceToRemove;
    }


    /**
     *Methode qui permet de passer au prochain de dans la liste
     * @return le prochain de
     */
    public Dice nextDice(){

        ListIterator <Dice> it = dicesList.listIterator();

        if(it.hasNext())
            return it.next();
        else
            return it.previous();

    }

}
