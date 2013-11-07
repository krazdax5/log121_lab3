package bfframework;

/**
 * Classe joueur
 *
 * @author Jacob Marcil
 * 2013-11-01 : Creation de la classe
 * 2013-11-05 : Implémentation des méthodes et attributs de la classe
 */
public class Player implements Comparable<Player>{

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
     * Constructeur de la classe Player
     * Celui-ci instancie les valeurs du nom, du numéro ainsi que
     * le score du joueurs avec celles envoyées en paramètres.
     * @param name      Le pseudonyme du joueur
     * @param number    Le numero du joueur
     * @param score     Le score initial du joueur
     */
    public Player(String name, int number, int score){
        this.name = name;
        this.number = number;
        this.score = score;
    }

    /**
     * Getter pour le nom du joueur
     * @return Le nom du joueur
     */
    public String getName(){
        return name;
    }

    /**
     * Setter pour le nom du joueur
     * @param name Le pseudonyme du joueur
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
     * @param score Le score du joueur
     */
    public void setScore(int score){
        this.score = score;
    }

    /**
     * Methode CompareTo qui permet de comparer le score du joeur avec
     * celui du joueur que l'on envoie en parametre.<br/>
     * Si le score du joueur actuel est plus grand, on retourne 1.<br/>
     * Si le score du joueur actuel est plus petit, on retourne -1.<br/>
     * Si le score des joueurs est identique, on retourne 0.<br/>
     *
     * @param playerToCompare Le joueur que l'on veut comparer
     * @return  -1, 0, 1 dependament du score du joueur envoye en parametre
     */
    public int compareTo(Player playerToCompare) {

        if(this.score > playerToCompare.getScore())
            return 1;
        else if(this.score < playerToCompare.getScore())
            return (-1);
        else
            return 0;

    }

}