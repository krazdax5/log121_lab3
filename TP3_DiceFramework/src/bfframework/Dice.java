package bfframework;

/**
 * Classe qui permet la creation d'un de.
 * On lui assigne un nombre de faces et une face actuelle.
 * La seule maniere de changer la face actuelle est d'utiliser la methode roll().
 *
 *        Historique des modifications
 ************************************************
 * @author Mathieu Lachance LACM14059305
 * 2013-11-01 : Creation de la classe
 * @author Mathieu Lachance LACM14059305
 * 2013-11-04 : Ajout des constructeurs et de la classe roll()
 *
 *
 */
public class Dice implements Comparable<Dice>{

    /**
     * Le nombre de faces du dé
     */
    private int numFaces;
    /**
     * La face active du dé.
     */
    private int activeFace;
    /**
     * Constante qui agit comme etant la valeur minimum que peut
     * avoir une face d'un dé.
     */
    private final int MIN = 1;

    /**
     * Constructeur par defaut.<br/>
     * Initialise la valeur de numFaces et de activeFace a null.
     */
    private Dice() {}

    /**
     * Constructeur priv&eacute; par copie d'attribut.<br/>
     * On lui envoie en parametres le nombre de face desire et
     * on lui assigne 1 comme la face actuelle
     *
     * @param numFaces   le nombre de faces desirees pour le dé.
     */
    private Dice(int numFaces) {
        this.numFaces = numFaces;
        this.activeFace = 1;
    }

    /**
     * M&eacute;thode factory qui permet la creation d'un nouveau d&eacute;,
     * puisque le constructeur est priv&eacute; selon le patron de conception
     * @param numFaces  Le nombre de faces du d&eacute;
     * @return          Le nouveau d&eacute; qui a &eacute;t&eacute; cr&eacute;&eacute;
     */
    public static Dice createDice(int numFaces) {
        return new Dice(numFaces);
    }

    /**
     * Methode qui "roule" un de en prenant un chiffre aleatoire entre
     * 1 et la valeur maximum de face de ce de.
     *
     * @return  la nouvelle face active du de.
     */
    public int roll() {
        // La fonction Math.floor retourne un chiffre aleatoire entre 0 et 1 qui
        // est multiplie par 6 et ensuite additionne a MIN (qui est egale a 1).
        // En arrondissant, ceci permet donc de generer une valeur aleatoire entre 1 et
        // la valeur maximale du nombre de face du dé.
        activeFace = (int) Math.floor(Math.random()* (numFaces) +
                MIN);

        return activeFace;
    }

    /**
     * Accesseur de la face active du d&eacute;
     * @return  le num&eacute;ro de la face active du d&eacute;
     */
    public int getActiveFace() {
        return activeFace;
    }


    /**
     * Methode qui sera utilise que lors des tests unitaires a supprimer apres
     */
    public void setActiveFace(int activeFace) {
        this.activeFace = activeFace;
    }

    /**
     * Methode CompareTo qui permet de comparer la face active du d&eacute; avec
     * cellle du d&eacute; que l'on envoie en parametre.<br/>
     * Si la face active du d&eacute; est plus grand, on retourne 1.<br/>
     * Si la face active du d&eacute; est plus petit, on retourne -1.<br/>
     * Si la face active des d&eacute;s est identique, on retourne 0.<br/>
     *
     * @param diceToCompare Le d&eacute; que l'on veut comparer
     * @return  -1, 0, 1 dependament de la face active du d&eacute; envoye en parametre
     */
    public int compareTo(Dice diceToCompare) {
        if(this.activeFace > diceToCompare.getActiveFace())
            return 1;
        else if(this.activeFace < diceToCompare.getActiveFace())
            return (-1);
        else
            return 0;
    }

}
