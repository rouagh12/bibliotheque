/**
 * Created by Julien on 15/02/2017, 13:29.
 * Package name : Publiclec.
 *
 * @author Julien
 */
public enum Publiclec {

    // -----------------------------------------------
    //Attributs
    // -----------------------------------------------
    ENFANT ("Enfant"),
    ADO ("ADO"),
    ADULTE ("ADULTE");

    private String name = "";

    // -----------------------------------------------
    //Constructeur
    // -----------------------------------------------

    /**
     *
     * @param name String
     */
    Publiclec(String name){
        this.name = name;
    }
// -----------------------------------------------
// Public
// -----------------------------------------------

    // -----------------------------------------------
    // Methodes
    // -----------------------------------------------
    /**
     * Retourne l'enum en String
     * @return String
     */
    public String toString(){
            return name;
    }
}
