package iterator;

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
public class Dice {

    /**
     * Le nombre de faces du de
     */
    private int numFaces;
    /**
     * La face active du de.
     */
    private int activeFace;
    /**
     * Constante qui agit comme etant la valeur minimum que peut
     * avoir une face d'un de.
     */
    private final int MIN = 1;

    /**
     * Constructeur par defaut.<br/>
     * Initialise la valeur de numFaces et de activeFace a null.
     */
    public Dice() {}

    /**
     * Constructeur par copie d'attibut.<br/>
     * On lui envoie en parametres le nombre de face desire et
     * on lui assigne 1 comme la face actuelle
     *
     * @param numFaces   le nombre de faces desirees pour le de.
     */
    public Dice(int numFaces) {
        this.numFaces = numFaces;
        this.activeFace = 1;
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
        // la valeur maximale du nombre de face du de.
        activeFace = (int) Math.floor(Math.random()* (numFaces) +
                MIN);

        return activeFace;
    }

}
