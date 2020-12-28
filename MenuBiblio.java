
public class MenuBiblio {
	private Bibliotheque _bibliotheque;
	
	public MenuBiblio (Bibliotheque bibliotheque) {
	_bibliotheque = bibliotheque;
	}
	
	/**
	 * menuPrincipal permet a l'utilisateur de selectionner un type de sous menu (Lecteur, Livre ou Exemplaire)
	 * il effectuera par la suite l'action desiree. Si l'utilisateur a fini d'utiliuser le programme, il choisit l'option Quitter.
	*/
public void menuPrincipal() {
	Integer menu;
	do {
		EntreesSorties.afficherMessage(" ========================================================");
		EntreesSorties.afficherMessage("|                   Menu Principal                       |");
        EntreesSorties.afficherMessage("|                                                        |");
		EntreesSorties.afficherMessage("| Menu Lecteur : 1                                       |");
		EntreesSorties.afficherMessage("| Menu Livre   : 2                                       |");
        EntreesSorties.afficherMessage("| Menu Emprunt : 3                                       |");
        EntreesSorties.afficherMessage("|                                                        |");
		EntreesSorties.afficherMessage("| Quitter : 0                                            |");
		EntreesSorties.afficherMessage(" ========================================================");
		menu = EntreesSorties.lireEntier();
			
			switch (menu){
				case 1 : {
					this.menuLecteur();
					break;
				}
				case 2:{
					this.menuBook();
					break;
				}
                case 3:{
                    this.menuEmprunt();
                    break;
                }
				default : {
					break;
				}
			}
	} while (menu != 0);	
}

	/** menuLect permet d'effectuer une serie d'action concernant les utilisateur (lecteurs) de la biblioth�que.
	 * Une fois une action effectuee, l'utilisateur sera rediriger vers ce meme menu afin de pouvoir selectionner
	 * une nouvelle fois une action concernant les lecteurs.
	 * "Retour Menu Principal" renvoi l'utilisateur au menu principal.
	*/
public void menuLecteur() {
	Integer menuLect;
	do {
		EntreesSorties.afficherMessage(" ========================================================");
        EntreesSorties.afficherMessage("|                     Menu Lecteur                       |");
        EntreesSorties.afficherMessage("|                                                        |");
		EntreesSorties.afficherMessage("| Nouveau Lecteur    	    : 1                          |");
		EntreesSorties.afficherMessage("| Consulter detail Lecteur  : 2                          |");
        EntreesSorties.afficherMessage("| Consulter tous lecteurs   : 3                          |");
        EntreesSorties.afficherMessage("|                                                        |");
		EntreesSorties.afficherMessage("| Retour Menu Principal     : 0                          |");
		EntreesSorties.afficherMessage(" ========================================================");
		menuLect = EntreesSorties.lireEntier();
			
			switch (menuLect){
				case 1 : {
					_bibliotheque.newReader();
					break;
				}
				case 2 : {
					_bibliotheque.consultReader();
					break;
				}
				case 3:{
                    _bibliotheque.consultListReader();
				}
				default : {
					break;
				}
			}
	} while (menuLect != 0);	
}

	/**
	 * menuEmprunt permet d'effectuer serie d'action concernant les emprunts (borrow) de la bibliotheque.
     * Une fois une action effectuee, l'utilisateur sera rediriger vers ce même menu afin de pouvoir selectionner
     * une nouvelle fois une action concernant les emprunts.
     * "Retour Menu Principal" renvoi l'utilisateur au menu principal.
	 */
    public void menuEmprunt() {
        Integer menuEmprunt;
        do {
            EntreesSorties.afficherMessage(" ========================================================");
            EntreesSorties.afficherMessage("|                      Menu Emprunt                      |");
            EntreesSorties.afficherMessage("|                                                        |");
            EntreesSorties.afficherMessage("| Emprunter un livre            : 1                      |");
            EntreesSorties.afficherMessage("| Rendre un livre    	        : 2                      |");
            EntreesSorties.afficherMessage("| Consulter emprunt Lecteur 	: 3                      |");
            EntreesSorties.afficherMessage("| Rappelle emprunt Lecteur   	: 4                      |");
            EntreesSorties.afficherMessage("| Consulter tout emprunt        : 5                      |");
            EntreesSorties.afficherMessage("| emprunt inferieur             : 6                      |");
            EntreesSorties.afficherMessage("|                                                        |");
            EntreesSorties.afficherMessage("| Retour Menu Principal         : 0                      |");
            EntreesSorties.afficherMessage(" ========================================================");
            menuEmprunt = EntreesSorties.lireEntier();

            switch (menuEmprunt){
                case 1 : {
                    _bibliotheque.borrCopy();
                    break;
                }
                case 2 : {
                    _bibliotheque.returnCopy();
                    break;
                }
                case 3:{
                    _bibliotheque.consultBorrReader();
                    break;
                }
                case 4:{
                    _bibliotheque.reviveReader();
                    break;
                }
                case 5:{
                    _bibliotheque.consultListBorrow();
                    break;
                }
                case 6:{
                    _bibliotheque.borrCopy2();
                    break;
                }
                default : {
                    break;
                }
            }
        } while (menuEmprunt != 0);
    }

    /**
     * menuBook permet d'effectuer serie d'action concernant les livres (book) de la bibliotheque.
     * Une fois une action effectuee, l'utilisateur sera rediriger vers ce meme menu afin de pouvoir selectionner
     * une nouvelle fois une action concernant les livres.
     * "Retour Menu Principal" renvoi l'utilisateur au menu principal.
     *
     */
    public void menuBook() {
		Integer menuBook;
		do {
			EntreesSorties.afficherMessage(" ========================================================");
            EntreesSorties.afficherMessage("|                        Menu Livre                      |");
            EntreesSorties.afficherMessage("|                                                        |");
			EntreesSorties.afficherMessage("| Ajout d'un livre               : 1                     |");
			EntreesSorties.afficherMessage("| Consulter detail d'un livre    : 2                     |");
			EntreesSorties.afficherMessage("| Ajout d'un  exemplaire         : 3                     |");
			EntreesSorties.afficherMessage("| Consulter un exemplaire        : 4                     |");
            EntreesSorties.afficherMessage("| Consulter tout les Livre       : 5                     |");
			EntreesSorties.afficherMessage("|                                                        |");
            EntreesSorties.afficherMessage("| Retour Menu Principal   : 0                            |");
			EntreesSorties.afficherMessage(" ========================================================");
			menuBook = EntreesSorties.lireEntier();

			switch (menuBook){
				case 1 : {
					_bibliotheque.newBook();
					break;
				}
				case 2 : {
					_bibliotheque.consultBook();
					break;
				}
				case 3 : {
					_bibliotheque.newCopy();
					break;
				}
				case 4 : {
					_bibliotheque.consultCopyBook();
					break;
				}
                case 5 : {
                    _bibliotheque.consultListBook();
                    break;
                }
				default : {
					break;
				}
			}
		} while (menuBook != 0);
	}
}

