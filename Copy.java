import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * Created by Julien on 15/02/2017, 13:39.
 * Package name : PACKAGE_NAME.
 */
public class Copy implements Serializable {


    // -----------------------------------------------
    //Attributs
    // -----------------------------------------------

    private boolean borrCopy;
    private GregorianCalendar dateRecep;
    private int idCopy;
    private Book book;
    private Borrow borrow;

    // -----------------------------------------------
    //Constructeur
    // -----------------------------------------------

    /**
     * Cree un exemplaire
     *
     * @param borrCopy Exemplaire empruntable ou non (true ou false)
     * @param dateRecep Date de reception de l'exemplaire (GregorianCalendar)
     * @param idCopy Identifiant de l'exemplaire (int)
     * @param book Livre auquel l'exemplaire fait reference (book)
     */
    public Copy(boolean borrCopy, GregorianCalendar dateRecep, int idCopy, Book book) {
        this.borrCopy = borrCopy;
        this.dateRecep = dateRecep;
        this.idCopy = idCopy;
        this.book = book;

        this.borrow = null;
    }
// -----------------------------------------------
// Public
// -----------------------------------------------


    // -----------------------------------------------
    //Setters
    // -----------------------------------------------

    /**
     * Lie l'exemplaire a un emprunt
     *
     * @param borrow Emprunt (borrow)
     */
    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }

    // -----------------------------------------------
    //Getters
    // -----------------------------------------------
    /**
     * Retourne l'identifiant de l'exemplaire
     *
     * @return Identifiant de l'exemplaire (int)
     */
    public int getIdCopy() {
        return idCopy;
    }

    /**
     * Retourne l'emprunt fait sur cet exemplaire
     *
     * @return Emprunt (borrow)
     */
    public Borrow getBorrow() {
        return borrow;
    }


    /**
     * Retourne le livre lie a cet exemplaire
     *
     * @return Livre (Book)
     */
    public Book getBook() {
        return book;
    }

    // -----------------------------------------------
    // Methodes
    // -----------------------------------------------



    /**
     * Retourne l'etat de l'emprunt de l'exemplaire
     *
     * @return boolean (true ou false si emprunte)
     */
    public boolean isBorrCopy() {
        return borrCopy;
    }

    /**
     * Retourne les details de l'exemplaire
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Detail exemplaire    : " +"\n" +
                "empruntable  : " + BooltoString() + "\n" +
                "dateRecep    : " + EntreesSorties.ecrireDate(dateRecep) +"\n" +
                "idExemplaire : " + idCopy ;
    }


// -----------------------------------------------
// Private
// -----------------------------------------------
    // -----------------------------------------------
    // Methodes
    // -----------------------------------------------

    /**
     * Methode pour l'affiche
     * Retourne "Oui" si borrCopy = true ou "Non" si borrCopy = false
     * @return retourne le string correspondent au booleen
     */
    private String BooltoString(){
        if(borrCopy){
            return "Oui";
        }
        else{
            return "Non";
        }
    }
}