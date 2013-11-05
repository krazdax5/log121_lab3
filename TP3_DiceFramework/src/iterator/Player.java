package iterator;

/**
 * Classe joueur
 *
 * @author Jacob Marcil
 * 2013-11-01 : Creation de la classe
 * 2013-11-05 : Implémentation des méthodes et attributs de la classe
 */
public class Player {

    /**
     * Nom du joueur
     */
    private String name;
    /**
     * Numero du joueur
     */
    private int number;
    /**
     * Score du joueur
     */
    private int score;

    /**
     * Constructeur par default
     * Initialise les valeurs du nom, du numero et du score du joueur a null
     */
    public Player(){}

    /**
     * Getter pour le nom du joueur
     * @return Le nom du joueur
     */
    public String getName(){
        return name;
    }

    /**
     * Setter pour le nom du joueur
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Getter pour le numero du joueur
     * @return le numero du joueur
     */
    public int getNumber(){
        return number;
    }

    /**
     * Getter pour le score du joueur
     * @return le score du joueur
     */
    public int getScore(){
        return score;
    }

    /**
     * Setter pour le score du joueur
     * @param score
     */
    public void setScore(int score){
        this.score = score;
    }

}
