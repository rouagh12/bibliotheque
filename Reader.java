import java.io.Serializable;
import java.util.*;

// Classe de gestion de Reader

/**
 * Classe de Gestion des lecteurs
 * @author Julien
 */
public class Reader implements Serializable
{
	
	private static final long serialVersionUID = 422L;
	
	// -----------------------------------------------
		//Attributs
	// -----------------------------------------------
	
		private String fName;
		private String lName;
		private Integer numReader;
		private GregorianCalendar _dateNaiss;
		private String adress;
		private String tel;
		private Vector<Borrow> borrow;
	
	
	
	// -----------------------------------------------
		//Constructeur
	// -----------------------------------------------

	/**
	 * Cree un Lecteur
	 *
	 * @param fName Prenom du lecteur
	 * @param lName	Nom du lecteur
	 * @param numReader Numero du lecteur
	 * @param dateNaiss	Date de naissance du lecteur
	 * @param adress adresse postal du lecteur
	 * @param tel Numero du lecteur
	 */
		public Reader(String fName, String lName, Integer numReader, GregorianCalendar dateNaiss, String adress, String tel)
		{
			this.fName = fName;
			this.lName = lName;
			this.numReader = numReader;
			this._dateNaiss = dateNaiss;
			this.adress = adress;
			this.tel = tel;
			borrow = new Vector<>();
		}

// -----------------------------------------------
	// Public
// -----------------------------------------------


    // -----------------------------------------------
    //Setters
    // -----------------------------------------------

    /**
     * Permet d'ajouter un emprunt a la liste d'emprunt de ce lecteur
     * @param copy Emprunt
     */
    public void setBorrow(Copy copy){
        borrow.add(new Borrow(this,copy, new GregorianCalendar()));
        copy.setBorrow(this.borrow.lastElement());
    }
    /**
     * Permet d'ajouter un emprunt a la liste d'emprunt de ce lecteur
     * @param copy Emprunt
     */
    public void setBorrow(Copy copy, GregorianCalendar g){
        borrow.add(new Borrow(this,copy, g));
        copy.setBorrow(this.borrow.lastElement());
    }


    // -----------------------------------------------
        //Getters
    // -----------------------------------------------


		/**
		 * Retourne le nombre d'emprunt effectue par le lecteur
		 *
		 * @return Nombre d'emprunt (int)
		 */
		public int getNbBorrow(){
		    return borrow.size();
        }

		/**
		 * Retourne le prenom du lecteur
		 *
		 * @return Prenom (String)
		 */
		public String getfName() {
				return fName;
			}

		/**
		 * Retourne le nom du lecteur
         *
		 * @return Nom (String)
		 */
		public String getlName() {
			return lName;
		}

		/**
		 * Retourne le numero du Lecteur
         *
		 * @return Numero Lecteur (int)
		 */
		public int getNumReader() { return numReader; }

		/**
		 * Retourne le tableau contenant tout les emprunts effectues par le lecteur
         *
		 * @return Tableau emprunt lecteur (Vector)
		 */
		public Vector<Borrow> getBorrow() {
        return borrow;
    	}

		/**
		 * Retourne le nom complet du lecteur
         *
		 * @return Nom complet avec le nom en majuscule (String)
		 */
		public String getAllName(){
		    return lName + " " + fName.toUpperCase();
        }


    // -----------------------------------------------
    // Methodes
    // -----------------------------------------------


		/**
		 * la methode calculAge permet de determiner l'age des lecteurs grace a leur date de naissance
		 * et la date actuelle. De cette facon, il n'y a pas de mise a jour a faire sur l'age des lecteurs.
		 * @return Age (Integer)
		 */
		public Integer calculAge() {
			Integer age;
			GregorianCalendar dateNaissComp;
			GregorianCalendar dateActuelle = new GregorianCalendar();
			dateNaissComp = new GregorianCalendar(dateActuelle.get(GregorianCalendar.YEAR), _dateNaiss.get(GregorianCalendar.MONTH), _dateNaiss.get(GregorianCalendar.DATE));
			if(dateNaissComp.before(dateActuelle)){
				age=dateActuelle.get(GregorianCalendar.YEAR)-_dateNaiss.get(GregorianCalendar.YEAR);
			}
			else{
				age=dateActuelle.get(GregorianCalendar.YEAR)-_dateNaiss.get(GregorianCalendar.YEAR)-1;
			}
			return age;
		}

		/**
		 * La methode suprime un emprunt de la liste.
		 * Elle est executee lorsque toutes les conditions pour rendre un exemplaire sont remplies
		 * @param borrow Exemplaire
		 */
		public void removeBorrow(Borrow borrow){
				this.borrow.remove(borrow);
        }

    /**
     * Affiche les details du lecteur
     */
    public void display() {
        String r = "";
        if(!borrow.isEmpty()) {
            for (Borrow aBorrow : borrow) {
                r = r + aBorrow.display();
            }
        }else{
            r =  "Aucun emprunt";
        }
        System.out.println( "Lecteur : " + "\n" +
                "Prenom    : " + fName + "\n" +
                "Nom       : " + lName + "\n" +
                "Numero    : " + numReader + "\n" +
                "DateNaiss : " + EntreesSorties.ecrireDate(_dateNaiss) + "\n" +
                "Adress    : " + adress + "\n" +
                "Numtel    : " + tel +  "\n" +
                "Emprunt   : " + r + "\n" );

    }

}