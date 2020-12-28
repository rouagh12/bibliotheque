import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Vector;

/**
 * Created by Julien on 15/02/2017, 13:20.
 * Package name : Book.
 *
 * @author Julien
 */
public class Book implements Serializable {


    // -----------------------------------------------
    //Attributs
    // -----------------------------------------------
    private String author;
    private GregorianCalendar dateRelease;
    private String editor;
    private int numISBN;
    private String title;
    private Publiclec publicc;
    private int lastIdCopy;
    private Vector<Copy> copy;

    // -----------------------------------------------
    //Constructeur
    // -----------------------------------------------

    /**
     * Cree un Livre.
     *
     * @param author auteur (String)
     * @param dateRelease date d'ajout (GregorianCalendar)
     * @param editor editeur (String)
     * @param numISBN ISBN (int)
     * @param title Titre livre (String)
     * @param publicc Type de public (Enum : Enfant, Ado, Adulte)
     */
    public Book(String author, GregorianCalendar dateRelease, String editor, int numISBN, String title, Publiclec publicc) {
        this.author = author;
        this.dateRelease = dateRelease;
        this.editor = editor;
        this.numISBN = numISBN;
        this.title = title;
        this.publicc = publicc;

        lastIdCopy = 0;

        copy = new Vector<>();
    }

// -----------------------------------------------
// Public
// -----------------------------------------------

    // -----------------------------------------------
    // Methodes
    // -----------------------------------------------

    /**
     * Affiche les donnees d'un exemplaire a partir de son identifiant
     *
     * @param idCopy identifiant de l'exmplaire (int)
     */
    public void PrintCopy(int idCopy){
        Copy c = getCopy(idCopy);
        if (c != null){
            System.out.println(c.toString());
        }else{
            System.out.println("L'exemplaire n'exite pas");
        }

    }

    /**
     * Retourne le nombre d'exmplaire empruntable
     *
     * @return nombre exemplaires (int)
     */
    public int nbBorrCopy(){
        int count = 0;
        for (Copy aCopy : copy) {
            if (aCopy.isBorrCopy() && aCopy.getBorrow() == null) {
                count++;
            }
        }
        return count;
    }

    /**
     * Ajoute un exemplaire de ce livre
     *
     * @param borrCopy Exemplaire empruntable ou non (true or false)
     * @param dateRecep Date de reception de l'exemplaire (GregorianCalendar)
     */
    public void addCopy(boolean borrCopy, GregorianCalendar dateRecep){
        lastIdCopy++;
        setCopy(borrCopy,dateRecep,lastIdCopy);
    }

    /**
     * Affiche les details du livre
     *
     */
    public void display() {
        System.out.println( "Detail livre : "            + "\n" +
                "Auteur        : " + author   + "\n" +
                "Date livre    : " + EntreesSorties.ecrireDate(dateRelease)+ "\n" +
                "Editeur       : " + editor   + "\n" +
                "ISBN          : " + numISBN  + "\n" +
                "Titre         : " + title    + "\n" +
                "Publique      : " + publicc  + "\n" +
                "Nb exemplaire : " + copy.size() );
    }

    // -----------------------------------------------
    //Getters
    // -----------------------------------------------

    /**
     * Retourne l'exemplaire lie a un identifiant
     * @param idCopy identifiant de l'exemplaire (int)
     * @return Exemplaire (Copy)
     */
    public Copy getCopy(int idCopy){
        for (int i = 0; i <= copy.size() ;i++){
            if(copy.get(i).getIdCopy() == idCopy){
                return copy.get(i);
            }
        }
        return null;
    }


    /**
     * Retourne "true" si il y a des exemplaires de ce livre en stock
     *
     * @return true ou false
     */
    public boolean getCopy(){
        return copy.isEmpty();
    }

    /**
     * Retourne l'identifiant du premier exemplaire empruntable
     * 
     * @return identifiant d'un exemplaire (int)
     */
    public int getfirstBorrCoppy() {
        for (int i = 0; i <= copy.size(); i++) {
            if (copy.get(i).isBorrCopy() && copy.get(i).getBorrow() == null) {
                return copy.get(i).getIdCopy();
            }
        }
        return 0;
    }

    /**
     * Retourne le type de public lie a ce livre
     *
     * @return le public (Enum)
     */
    public Publiclec getPublicc() {
        return publicc;
    }

    /**
     * Retourne le numero ISBN de ce livre
     *
     * @return ISBN (int)
     */
    public int getNumISBN() {
        return numISBN;
    }

    /**
     * Retourne le titre de ce livre
     *
     * @return Titre (String)
     */
    public String getTitle() {
        return title;
    }
// -----------------------------------------------
// Private
// -----------------------------------------------
    // -----------------------------------------------
    //Setters
    // -----------------------------------------------


    /**
     * Permet d'ajoute un exemplaire. Elle lie l'exemplaire au livre
     *
     * @param borrCopy Exemplaire empruntable ou non (true or false)
     * @param dateRecep Date de reception de l'exemplaire (GregorianCalendar)
     * @param idCopy identifiant de l'exemplaire (int)
     */
    private void setCopy(boolean borrCopy, GregorianCalendar dateRecep, int idCopy){
        this.copy.add(new Copy(borrCopy,dateRecep,idCopy, this));
    }

}