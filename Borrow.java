import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Julien on 06/03/2017, 11:00.
 * Package name : Borrow.
 *
 * @author Julien
 */
public class Borrow implements Serializable {

    // -----------------------------------------------
    //Attributs
    // -----------------------------------------------
    private Reader reader;
    private Copy copy;
    private GregorianCalendar dateRelease;

    // -----------------------------------------------
    //Constructeur
    // -----------------------------------------------

    /**
     * Cree un emprunt
     *
     * @param reader Lecteur lie a cet emprunt
     * @param copy Exemplaire lie a cet emprunt
     * @param dateRelease date de l'emprunt
     */
    public Borrow(Reader reader, Copy copy, GregorianCalendar dateRelease) {
        this.reader = reader;
        this.copy = copy;
        this.dateRelease = dateRelease;
    }

// -----------------------------------------------
// Public
// -----------------------------------------------

    // -----------------------------------------------
    // Methodes
    // -----------------------------------------------

    /**
     * Supprime un emprunt.
     * Delie le lecteur de l'emprunt, l'exmplaire de l'emprunt et remet
     * a NULL le lien du lecteur de l'exemplaire. #carbage_collector
     *
     */
    public void removeBorrow(){
        this.getReader().removeBorrow(this);
        this.getCopy().setBorrow(null);
        this.setReader(null);
        this.setCopy(null);
    }

    /**
     * Retourne les informations non detaillees relative a l'emprunt
     * @return (String)
     */
    public String display() {
        return  reader.getfName()                   + "\t" +
                reader.getlName()                + "\t" +
                this.copy.getBook().getNumISBN()  + "\t" +
                this.copy.getBook().getTitle()    + "\t" +
                this.copy.getIdCopy()             + "\t" +
                EntreesSorties.ecrireDate(dateRelease) + "\t" +
                EntreesSorties.ecrireDate(getDateReturn());
    }

    /**
     * Affiche les informations detaillees de l'emprunt
     */
    public void displayAll(){
        EntreesSorties.afficherMessage("Lecteur             : " + reader.getAllName());
        EntreesSorties.afficherMessage("Num Lecteur         : " + reader.getNumReader());
        EntreesSorties.afficherMessage("Num ISBN            : " + copy.getBook().getNumISBN());
        EntreesSorties.afficherMessage("Titre               : " + copy.getBook().getTitle() );
        EntreesSorties.afficherMessage("Numero d'exemplaire : " + copy.getIdCopy() );
        System.out.print("\n");
        EntreesSorties.afficherMessage("Date d'emprunt      : " + EntreesSorties.ecrireDate(dateRelease) );
        EntreesSorties.afficherMessage("Date de retour      : " + EntreesSorties.ecrireDate(getDateReturn()));
        EntreesSorties.afficherMessage("\n\n");
    }

    // -----------------------------------------------
    //Getters
    // -----------------------------------------------

    /**
     * Retourne la date a laquelle l'emprunt devra etre rendu
     * @return Date (GregorianCalendar)
     */
    public GregorianCalendar getDateReturn(){
        GregorianCalendar dateReturn = (GregorianCalendar) dateRelease.clone();
        dateReturn.add(Calendar.DATE, 8);
        return dateReturn;
    }
    

// -----------------------------------------------
// Private
// -----------------------------------------------
    // -----------------------------------------------
    //Setters
    // -----------------------------------------------

    /**
     * Lie le lecteur a l'emprunt
     * @param reader lecteur
     */
    private void setReader(Reader reader) {
        this.reader = reader;
    }

    /**
     * Lie un exemplaire a un ouvrage
     * @param copy Exemplaire
     */
    private void setCopy(Copy copy) {
        this.copy = copy;
    }

    // -----------------------------------------------
    //Getters
    // -----------------------------------------------

    /**
     * Retourne le lecteur lie a cet emprunt
     * @return Lecteur (Reader)
     */
    private Reader getReader() {
        return reader;
    }

    /**
     * Retourne l'exemplaire lie a cet emprunt
     * @return Exemplaire (Copy)
     */
    private Copy getCopy() {
        return copy;
    }

}