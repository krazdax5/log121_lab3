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
    private ListIterator<Dice> diceIterator;

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
        diceIterator = dicesList.listIterator();
        return diceToAdd;
    }


    /**
     *Methode qui permet de supprimer un de dans la liste
     * @param diceToRemove quel de voulons-nous supprimer
     * @return le de qui a ete supprime
     */
    public Dice removeDice (Dice diceToRemove){
        dicesList.remove(diceToRemove);
        diceIterator = dicesList.listIterator();
        return diceToRemove;
    }


    /**
     *Methode qui permet de passer au prochain de dans la liste
     * @return le prochain de
     */
    public Dice nextDice(){

        if(diceIterator.hasNext())
            return diceIterator.next();
        else
            return null;

    }


    public Dice getDice(int position) {
        if(!dicesList.isEmpty())
            return dicesList.get(position);
        else return null;
    }


    public void rollAllDices() {
        for(int i = 0; i < dicesList.size(); i++) {
            dicesList.get(i).roll();
        }
    }


}
