/**
 * jeu Reversi/Othello
 * @authors Guénolé Sixte
 */

class Reversi{
	
    int nbJoueurNPPJouer = 0;    //le nombre de joueur qui sautent leur tour d'affilée

    void principal() {
        char rejouer = 'o';

        testIndice();

        regleDuJeu();
        
        while (rejouer == 'o' || rejouer == 'O'){
			lancementPartie();

			sautLigne(2);
            rejouer = SimpleInput.getChar("Voulez-vous rejouer ? (o/n) : ");
            nbJoueurNPPJouer = 0;
		}
    }

    char[][] creerPlateau(int taille){
        char[][] plateau = new char[taille][taille]; //construction du tableau de départ

        for (int j = 0 ; j < plateau.length ; j++) {   //on remplit le tableau d'espaces
            for (int k = 0 ; k < plateau.length ; k++) {
                plateau[j][k] = ' ';
            }
        }

        plateau[(plateau.length/2)-1][(plateau.length/2)-1] = 'x';  //on place les pions de début de partie
        plateau[(plateau.length/2)][(plateau.length/2)-1] = 'o';
        plateau[(plateau.length/2)-1][(plateau.length/2)] = 'o';
        plateau[(plateau.length/2)][(plateau.length/2)] = 'x';

        return plateau;
    }

    /**
     * Fonction qui saute un nombre nb de ligne
     */
    void sautLigne(int nb) {
        for (int i = 0 ; i < nb ; i++) {
            System.out.println();
        }
    }

    /**
     * Change le joueur à qui c'est le tour
     * @param joueur le joueur qui a fini son tour
     * @return le joueur adverse ('o' si joueur est 'x', sinon 'x')
     */
    char echange(char joueur){
        char joueurAdv;
        if (joueur == 'o'){
			joueurAdv = 'x';
        } else {
			joueurAdv = 'o';
        }
        return joueurAdv;
    }

    /**
     * Affiche le nom du jeu
     */
    void titre() {
		sautLigne(3);
        System.out.println("   ███████████   ██████████  ░███    ░███ ██████████ ███████████   ░█████████  ░█████");
        System.out.println("   ░░███░░░░░███ ░░███░░░░░█ ░███    ░███ ░░███░░░░░█░░███░░░░░███ ░███░░░░░███ ░███ ");
        System.out.println("    ░███    ░███  ░███  █ ░  ░███    ░███  ░███  █ ░  ░███    ░███ ░███    ░░░  ░███ ");
        System.out.println("    ░██████████   ░██████    ░███    ░███  ░██████    ░██████████  ░░█████████  ░███ ");
        System.out.println("    ░███░░░░░███  ░███░░█    ░░███   ███   ░███░░█    ░███░░░░░███  ░░░░░░░░███ ░███ ");
        System.out.println("    ░███    ░███  ░███ ░   █  ░░░█████░    ░███ ░   █ ░███    ░███  ███    ░███ ░███ ");
        System.out.println("    █████   █████ ██████████    ░░███      ██████████ █████   █████░░█████████  █████");
        System.out.println("   ░░░░░   ░░░░░ ░░░░░░░░░░      ░░░      ░░░░░░░░░░ ░░░░░   ░░░░░  ░░░░░░░░░  ░░░░░ ");
        sautLigne(3);
    }

    /**
     * Affiche le nom du jeu en taille réduite
     */
    void petitTitre() {
        System.out.println();
        System.out.println("     ┳┓┏┓┓┏┏┓┳┓┏┓┳");
        System.out.println("     ┣┫┣ ┃┃┣ ┣┫┗┓┃");
        System.out.println("     ┛┗┗┛┗┛┗┛┛┗┗┛┻");
    }

    /**
     * Affiche un message de réussite face à l'ordinateur
     */
    void finWinJ() {
        sautLigne(27);
        System.out.println("░██     ░██   ░██████   ░██     ░██    ░██       ░██   ░██████   ░███    ░██");
        System.out.println(" ░██   ░██   ░██   ░██  ░██     ░██    ░██       ░██  ░██   ░██  ░████   ░██");
        System.out.println("  ░██ ░██   ░██     ░██ ░██     ░██    ░██  ░██  ░██ ░██     ░██ ░██░██  ░██");
        System.out.println("   ░████    ░██     ░██ ░██     ░██    ░██ ░████ ░██ ░██     ░██ ░██ ░██ ░██");
        System.out.println("    ░██     ░██     ░██ ░██     ░██    ░██░██ ░██░██ ░██     ░██ ░██  ░██░██");
        System.out.println("    ░██      ░██   ░██   ░██   ░██     ░████   ░████  ░██   ░██  ░██   ░████");
        System.out.println("    ░██       ░██████     ░██████      ░███     ░███   ░██████   ░██    ░███");
        sautLigne(2);
    }

    /**
     * Affiche un message d'échec face à l'ordinateur
     */
    void finWinR() {
        sautLigne(27);
        System.out.println("░██     ░██   ░██████   ░██     ░██    ░██           ░██████     ░██████   ░██████████");
        System.out.println(" ░██   ░██   ░██   ░██  ░██     ░██    ░██          ░██   ░██   ░██   ░██      ░██    ");
        System.out.println("  ░██ ░██   ░██     ░██ ░██     ░██    ░██         ░██     ░██ ░██             ░██    ");
        System.out.println("   ░████    ░██     ░██ ░██     ░██    ░██         ░██     ░██  ░████████      ░██    ");
        System.out.println("    ░██     ░██     ░██ ░██     ░██    ░██         ░██     ░██         ░██     ░██    ");
        System.out.println("    ░██      ░██   ░██   ░██   ░██     ░██          ░██   ░██   ░██   ░██      ░██    ");
        System.out.println("    ░██       ░██████     ░██████      ░██████████   ░██████     ░██████       ░██    ");
        sautLigne(2);
    }

    /**
     * Affiche le message de réussite du joueur 'o'
     */
    void finWinJ1() {
        sautLigne(27);
        System.out.println("  ░██████      ░██    ░██    ░███    ░██████░███    ░██   ░██████   ░██     ░██ ░██████████ ░██     ░██ ░█████████  ");
        System.out.println(" ░██   ░██     ░██    ░██   ░██░██     ░██  ░████   ░██  ░██   ░██  ░██     ░██ ░██         ░██     ░██ ░██     ░██");
        System.out.println("░██     ░██    ░██    ░██  ░██  ░██    ░██  ░██░██  ░██ ░██     ░██ ░██     ░██ ░██         ░██     ░██ ░██     ░██");
        System.out.println("░██     ░██    ░██    ░██ ░█████████   ░██  ░██ ░██ ░██ ░██     ░██ ░██     ░██ ░█████████  ░██     ░██ ░█████████  ");
        System.out.println("░██     ░██     ░██  ░██  ░██    ░██   ░██  ░██  ░██░██ ░██     ░██ ░██     ░██ ░██         ░██     ░██ ░██   ░██   ");
        System.out.println(" ░██   ░██       ░██░██   ░██    ░██   ░██  ░██   ░████  ░██   ░██   ░██   ░██  ░██          ░██   ░██  ░██    ░██  ");
        System.out.println("  ░██████         ░███    ░██    ░██ ░██████░██    ░███   ░██████     ░██████   ░██████████   ░██████   ░██     ░██ ");
        System.out.println("                                                               ░██                                                  ");
        System.out.println("                                                                ░██                                                 ");
        //sautLigne(2);
        System.out.println();
    }

    /**
     * Affiche le message de réussite du joueur 'x'
     */
    void finWinJ2() {
        sautLigne(27);
        System.out.println("░██    ░██    ░██    ░██    ░███    ░██████░███    ░██   ░██████   ░██     ░██ ░██████████ ░██     ░██ ░█████████  ");
        System.out.println(" ░██  ░██     ░██    ░██   ░██░██     ░██  ░████   ░██  ░██   ░██  ░██     ░██ ░██         ░██     ░██ ░██     ░██");
        System.out.println("  ░██░██      ░██    ░██  ░██  ░██    ░██  ░██░██  ░██ ░██     ░██ ░██     ░██ ░██         ░██     ░██ ░██     ░██");
        System.out.println("   ░███       ░██    ░██ ░█████████   ░██  ░██ ░██ ░██ ░██     ░██ ░██     ░██ ░█████████  ░██     ░██ ░█████████  ");
        System.out.println("  ░██░██       ░██  ░██  ░██    ░██   ░██  ░██  ░██░██ ░██     ░██ ░██     ░██ ░██         ░██     ░██ ░██   ░██   ");
        System.out.println(" ░██  ░██       ░██░██   ░██    ░██   ░██  ░██   ░████  ░██   ░██   ░██   ░██  ░██          ░██   ░██  ░██    ░██  ");
        System.out.println("░██    ░██       ░███    ░██    ░██ ░██████░██    ░███   ░██████     ░██████   ░██████████   ░██████   ░██     ░██ ");
        System.out.println("                                                              ░██                                                  ");
        System.out.println("                                                               ░██                                                 ");
        //sautLigne(2);
        System.out.println();
    }

    /**
     * Affiche le message d'égalité à la fin de la partie
     */
    void finDraw() {
        sautLigne(27);
        System.out.println("░██████████   ░██████     ░███    ░██         ░██████░██████████░██████████    ░██ ");
        System.out.println("░██          ░██   ░██   ░██░██   ░██           ░██      ░██    ░██            ░██ ");
        System.out.println("░██         ░██         ░██  ░██  ░██           ░██      ░██    ░██            ░██ ");
        System.out.println("░█████████  ░██  █████ ░█████████ ░██           ░██      ░██    ░█████████     ░██ ");
        System.out.println("░██         ░██     ██ ░██    ░██ ░██           ░██      ░██    ░██            ░██ ");
        System.out.println("░██          ░██  ░███ ░██    ░██ ░██           ░██      ░██    ░██                ");
        System.out.println("░██████████   ░█████░█ ░██    ░██ ░██████████ ░██████    ░██    ░██████████    ░██ ");
        //sautLigne(2);
        System.out.println();
    }

    /**
     * Affiche les règles du jeu
     */
    void regleDuJeu() {
        titre();
        System.out.println("                     ╔════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("                     ║                                                                                    ║");
        System.out.println("                     ║                                    REGLES DU JEU                                   ║");
        System.out.println("                     ║                                                                                    ║");
        System.out.println("                     ╠════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("                     ║                                                                                    ║");
        System.out.println("                     ║                                     But du jeu :                                   ║");
        System.out.println("                     ║                Avoir plus de pions à sa couleur à la fin de la partie.             ║");
        System.out.println("                     ║                                                                                    ║");
        System.out.println("                     ╠════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("                     ║                                                                                    ║");
        System.out.println("                     ║                                      Déroulé :                                     ║");
        System.out.println("                     ║         Les joueurs jouent chacun leur tour. Un pion posé doit encadrer au         ║");
        System.out.println("                     ║   moins un pion adverse (horizontal, vertical ou diagonalement) pour le retourner. ║");
        System.out.println("                     ║                  Si aucun coup n'est possible, on passe notre tour.                ║");
        System.out.println("                     ║   La partie s’arrête quand aucun joueur ne peut jouer ou que le plateau est plein. ║");
        System.out.println("                     ║                                                                                    ║");
        System.out.println("                     ╚════════════════════════════════════════════════════════════════════════════════════╝");
        System.out.println();
        String start = SimpleInput.getString("Appuyez sur une touche puis sur entrée pour commencez !   ");
        sautLigne(2);
    }

    /**
     * demande la taille de la grille à l'utilisateur
     */
    void lancementPartie() {
        int taille;

        sautLigne(25);
        titre();
        System.out.println("               ╔═════════════════════════════════════════════════════════╗");
        System.out.println("               ║                                                         ║");
        System.out.println("               ║        Choissisez la taille de la grille de jeu         ║");
        System.out.println("               ║                                                         ║");
        System.out.println("               ╚═════════════════════════════════════════════════════════╝");
        taille = SimpleInput.getInt("                                       Choix : ");

        //cas d'erreur
        int i = 1;
        while (taille < 4 || taille > 16 || taille%2!=0) {
            System.out.println("                                       valeur entre 4 et 16 compris et pair");
            System.out.println();
            taille = SimpleInput.getInt("                                       Choix : ");
            if (i == 3) {
                taille = 8;
                raslebol();
            }
            i++;
        }
        choixMode(taille);
    }
    
    /**
     * Lance la partie de Reversi
     * @param taille la taille du plateau de Reversi
     */
    void choixMode(int taille) {
        char[][] plateau = creerPlateau(taille);

        sautLigne(25);
        titre();
        System.out.println("                     ╔═════════════════════════════════════════════╗");
        System.out.println("                     ║                                             ║");
        System.out.println("                     ║        Choissisez votre mode de jeu :       ║");
        System.out.println("                     ║             1 joueur  : Tapez (1)           ║");
        System.out.println("                     ║             2 joueurs : Tapez (2)           ║");
        System.out.println("                     ║                                             ║");
        System.out.println("                     ╚═════════════════════════════════════════════╝");
        int choix = SimpleInput.getInt("                                        Choix : ");

        //cas d'erreur
        int i = 1;
        while (choix != 1 && choix != 2) {
            System.out.println("                                        tapez 1 ou 2");
            System.out.println();
            choix = SimpleInput.getInt("                                       Choix : ");
            if (i == 3) {
                choix = 1;
                raslebol2();
            }
            i++;
        }

        if (choix == 1) {
            mode1joueur(plateau);
        } else {
            mode2joueurs(plateau);
        }
    }

    /**
     * Lance le mode à 1 joueur
     * @param plateau le tableau à deux dimensions représentant le plateau de Reversi
     */
    void mode1joueur(char[][] plateau){
        sautLigne(25);
        titre();
        System.out.println("               ╔═════════════════════════════════════════════════════════╗");
        System.out.println("               ║                                                         ║");
        System.out.println("               ║               Choisissez votre pion (o/x)               ║");
        System.out.println("               ║                                                         ║");
        System.out.println("               ╚═════════════════════════════════════════════════════════╝");
        char joueur = SimpleInput.getChar("                                       Choix : ");

        while (joueur != 'o' && joueur != 'x'){
            System.out.println("                                       valeur incorrecte.");
            System.out.println();
            joueur = SimpleInput.getChar("                                       Choix : ");
        }

        transition(plateau);
        afficheGrille(plateau);

        if (joueur == 'o'){   //si le joueur a choisi le pion o, il joue en premier
            jouer(plateau, joueur);
        }
        while (!tabPlein(plateau) && nbJoueurNPPJouer < 2){  //tant que le tableau n'est pas plein et qu'un des deux joueurs peut jouer, on continue
            jouerOrdi(plateau, echange(joueur));      //l'ordinateur joue en premier s'il a les pions o
            if (!tabPlein(plateau) && nbJoueurNPPJouer < 2){
                jouer(plateau, joueur);    //puis le joueur joue à son tour
            }
        }    //la partie se finit quand la boucle while s'arrête

        int pionsJoueur = compteCase(plateau, joueur);    //on compte le nombre de pions du joueur à la fin de la partie
        int pionsOrdi = compteCase(plateau, echange(joueur));   //on compte le nombre de pions de l'ordinateur à la fin de la partie
        if (pionsOrdi > pionsJoueur){
            finWinR();          //si le joueur a plus de pions que l'ordinateur, alors un message s'affiche
        } else if (pionsOrdi < pionsJoueur){
            finWinJ();          //sinon, s'il a moins de pions que l'ordinateur, un autre message s'affiche
        } else {
            finDraw();          //sinon, un message d'égalité s'affiche
        }
        if (joueur == 'o'){
            score(plateau, pionsOrdi, pionsJoueur);    //on affiche le score du joueur et de l'ordinateur, selon le pion appartenant au joueur
        } else {
            score(plateau, pionsJoueur, pionsOrdi);
        }
    }

    /**
     * Lance le mode à 2 joueurs
     * @param plateau le tableau à deux dimensions représentant le plateau de Reversi
     */
    void mode2joueurs(char[][] plateau){
        char joueur = 'o';

        transition(plateau);
        afficheGrille(plateau);

        while (!tabPlein(plateau) && nbJoueurNPPJouer < 2 ){   //le jeu continue tant qu'un des deux joueurs peut jouer et que le tableau n'est pas plein
            jouer(plateau, joueur);

            joueur = echange(joueur);

            transition(plateau);
            afficheGrille(plateau);  //on affiche le plateau à chaque tour
        }        //la partie se finit quand on sort de la boucle while

        int pionsX = compteCase(plateau, 'x');    //on compte le nombre de pions de chacun des joueurs à la fin de la partie
        int pionsO = compteCase(plateau, 'o');
        if(pionsX > pionsO){
            finWinJ2();          //s'il y a plus de pions 'x' que de 'o' alors un message s'affiche
        } else if (pionsX < pionsO){
            finWinJ1();          //sinon, s'il y a plus de pions 'o' que de 'x' un autre message s'affiche
        } else {
            finDraw();           //sinon, un message d'égalité s'affiche
        }
        score(plateau, pionsX, pionsO);  //on affiche le score des deux joueurs
    }

    /**
     * Détermine si le plateau est plein
     * @param plateau le tableau à deux dimensions représentant le plateau de Reversi
     * @return false si un seul élément du tableau tab est un espace, true sinon
     */
    boolean tabPlein(char[][] plateau){
        return compteCase(plateau, ' ') == 0;
    }

    /**
     * Compte le nombre de case contenant le caractère c dans le plateau de Reversi
     * @param plateau le tableau à deux dimensions représentant le plateau de Reversi
     * @param c le caractère à comparer avec chaque case du plateau
     * @return le nombre de cases dans le tableau contenant le caractère c
     */
    int compteCase(char[][] plateau, char c){
        int cpt = 0;
        for (int i = 0 ; i < plateau.length; i++) {
            for (int j = 0 ; j < plateau.length; j++) {
                if (plateau[i][j] == c){
                    cpt++;
                }
            }
        }
        return cpt;
    }

    /**
     * Affiche le tableau final et le score de chaque joueur
     * @param plateau le tableau à deux dimensions représentant le plateau de Reversi
     * @param pionsX le nombre de pions appartenant au joueur x à la fin de la partie
     * @param pionsO le nombre de pions appartenant au joueur o à la fin de la partie
     */
    void score(char[][] plateau, int pionsX, int pionsO){
        afficheGrille(plateau);

        System.out.print(pionsX + " pion");
        if (pionsX > 1){
            System.out.print("s");
        }
        System.out.print(" au joueur x contre " + pionsO + " pion");
        if (pionsO > 1){
            System.out.print("s");
        }
        System.out.println(" au joueur o.");
    }

        /**
     * lance le tour d'un joueur
     * @param plateau le tableau à deux dimensions représentant le plateau de Reversi
     * @param joueur le joueur qui joue
     */
    void jouer(char[][] plateau, char joueur){
        boolean peutJouer = false;
        String[] lettres = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p"};
        String[] nombres = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};

        System.out.println("C'est au joueur " + joueur + " de jouer");
        System.out.print("Voici les cases jouables : ");

        for (int i = 0; i < plateau.length; i++){
            for (int j = 0; j < plateau[i].length; j++){
                if (caseJouable(plateau, i, j, joueur)[0] == 1){
                    System.out.print(lettres[i] + nombres[j] + " ");
                    peutJouer = true;
                }
            }
        }
        System.out.println();

        if (peutJouer){
            nbJoueurNPPJouer = 0;

            String ligneStr = SimpleInput.getString("Entrez la ligne de la case à jouer (lettre) : ");
            int ligne = indice(ligneStr, lettres);
        
            while (ligne == -1 || ligne >= plateau.length){
                System.out.println("Ligne incorrecte.");
                ligneStr = SimpleInput.getString("Entrez la ligne de la case à jouer (lettre) : ");
                ligne = indice(ligneStr, lettres);
            }
        
            String colonneStr = SimpleInput.getString("Entrez la colonne de la case à jouer (nombre) : ");
            int colonne = indice(colonneStr, nombres);
        
            while (colonne == -1 || colonne >= plateau.length){
                System.out.println("Colonne incorrecte.");
                colonneStr = SimpleInput.getString("Entrez la colonne de la case à jouer (nombre) : ");
                colonne = indice(colonneStr, nombres);
            }
        
            while (caseJouable(plateau, ligne, colonne, joueur)[0] == 0){
                System.out.println("Coordonnées incorrectes.");
            
                ligneStr = SimpleInput.getString("Entrez la ligne de la case à jouer (lettre) : ");
                ligne = indice(ligneStr, lettres);

                while (ligne == -1 || ligne >= plateau.length){
                    System.out.println("Ligne incorrecte.");
                    ligneStr = SimpleInput.getString("Entrez la ligne de la case à jouer (lettre) : ");
                    ligne = indice(ligneStr, lettres);
                }

                colonneStr = SimpleInput.getString("Entrez la colonne de la case à jouer (nombre) : ");
                colonne = indice(colonneStr, nombres);

                while (colonne == -1 || colonne >= plateau.length){
                    System.out.println("Colonne incorrecte.");
                    colonneStr = SimpleInput.getString("Entrez la colonne de la case à jouer (nombre) : ");
                    colonne = indice(colonneStr, nombres);
                }
            }
            ajoutPion(plateau, ligne, colonne, joueur);
        } else {
            nbJoueurNPPJouer++;
            
            transition(plateau);
            afficheGrille(plateau);
            System.out.println("Vous ne pouvez pas jouer.");
            System.out.println("On saute votre tour.");
            String a = SimpleInput.getString("Appuyez sur une touche puis sur entrée pour continuer : ");
        }
    }

    /**
     * Lance le tour de l'ordinateur en mode 1 joueur
     * @param plateau le tableau à deux dimensions représentant le plateau de Reversi
     * @param joueur le joueur joué par l'ordinateur
     */
    void jouerOrdi(char[][] plateau, char joueur){
        String[] lettres = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p"};
        String[] nombres = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};
        int ligneCaseMax = 0;
        int colonneCaseMax = 0;
        int nbAlignements;
        int nbAlignMax = 0;

        for (int i = 0; i < plateau.length; i++){
            for (int j = 0; j < plateau.length; j++){    //on parcourt chaque case du plateau

                int[] alignCase = caseJouable(plateau, i, j, joueur);    
                nbAlignements = 0;

                if (alignCase[0] == 1){
                    //on additionne tous les pions adverses que l'on peut récupérer si l'on pose un pion sur la case
                    //à la ligne i et la colonne j.
                    for (int k = 1; k < alignCase.length; k++){
                        nbAlignements += alignCase[k];
                    }
                    //si le nombre de pions récupérables à cette case est supérieure à toutes celles déjà parcourues,
                    //on enregistre le nombre de pions récupérables, la ligne et la colonne de la case.
                    if (nbAlignements > nbAlignMax){
                        nbAlignMax = nbAlignements;
                        ligneCaseMax = i;
                        colonneCaseMax = j;
                    }
                }
            }
        }

        if (nbAlignMax > 0){
            nbJoueurNPPJouer = 0;

            ajoutPion(plateau, ligneCaseMax, colonneCaseMax, joueur);
            transition(plateau);
            afficheGrille(plateau);
            System.out.println("L'ordinateur a ajouté un pion à la case " + lettres[ligneCaseMax] + nombres[colonneCaseMax]);
        } else {
            nbJoueurNPPJouer++;

            transition(plateau);
            afficheGrille(plateau);
            System.out.println("L'ordinateur n'a pas pu jouer, c'est à votre tour.");
        }
        System.out.println();
        String continuer = SimpleInput.getString("Appuyer sur une touche, puis sur entrée pour continuer : ");
        System.out.println();
    }

    /**
     * Affiche un nouvel écran pour le tour suivant
     * @param plateau le tableau à deux dimensions représentant le plateau de Reversi
     */
    void transition(char[][] plateau){
        sautLigne(25);
        if (plateau.length < 10) {
            titre();
        } else {
            petitTitre();
        }
        System.out.println();
    }

    /**
     * affiche du reversi avec les valeurs du tableau
     * @param plateau le tableau à deux dimensions représentant le plateau de Reversi
     */
    void afficheGrille(char[][] plateau) {
        String abc = "abcdefghijklmnop";
        System.out.print("    ");
        for (int i = 1 ; i < plateau.length +1 ; i++) { //affichage de l'abcissse
            System.out.printf("%2d ", i);
            System.out.print(" ");
        }
        System.out.println();
        

        //Affichage de la premiere ligne du tableau
        System.out.print("   ╔");
        for (int i = 0; i < plateau.length-1; i++) {
            System.out.print("═══╦");
        }
        System.out.println("═══╗");
        
        for (int i = 0 ; i < plateau.length-1; i++) { //affichage de l'ordonnée et des valeurs

            //affichage des valeurs
            System.out.print(" "+abc.charAt(i));
            for (int j = 0 ; j < plateau.length ; j++) { 
                System.out.print(" ║ "+plateau[i][j]);
            }
            System.out.println(" ║");


            //affichage de l'interligne
            System.out.print("   ");
            System.out.print("╠");
            for (int k = 0 ; k < plateau.length-1 ; k++) { 
                System.out.print("═══╬");
            }
            System.out.print("═══╣");
            System.out.println();
        }

        //Affichage de la derniere ligne du tableau
        System.out.print(" "+abc.charAt(plateau.length-1));
        for (int i = 0 ; i < plateau.length ; i++) {
            System.out.print(" ║ "+plateau[plateau.length-1][i]);
        }
        System.out.println(" ║");
        System.out.print("   ╚");
        for (int i = 0; i < plateau.length-1; i++) {
            System.out.print("═══╩");
        }
        System.out.println("═══╝");
        System.out.println();
    }

    /**
     * lance le jeu si l'entrée de la taille de la grille est incorrect
     */
    void raslebol() {
        System.out.println("        ▜     ▗     ▐▘          ");
        System.out.println("▛▌▀▌▛▌  ▐ ▀▌  ▜▘▌▌  ▜▘▛▌▛▘▛▘█▌▛▘");
        System.out.println("▌▌█▌▌▌  ▐▖█▌  ▐▖▙▌  ▐ ▙▌▌ ▙▖▙▖▄▌");
        System.out.println();
        System.out.println("▗     ▗     ▘     ▘         ▗     ▄▄▖");
        System.out.println("▜▘▀▌▛▌▜▘  ▛▌▌▛▘   ▌█▌  ▛▛▌█▌▜▘▛▘  ▙▄▌");
        System.out.println("▐▖█▌▌▌▐▖  ▙▌▌▄▌   ▌▙▖  ▌▌▌▙▖▐▖▄▌  ▙▄▌");
        System.out.println("          ▌      ▙▌                 ");
        sautLigne(3);
        String str = SimpleInput.getString("Appuyez sur une touche puis sur entrée : ");
    }

    /**
     * lance le jeu tout seul
     */
    void raslebol2() {

        System.out.println("▌   ▌    ▘        ▗     ▗         ▜ ");
        System.out.println("▛▌▀▌▛▌   ▌▛▌▌▌█▌  ▜▘▛▌▌▌▜▘  ▛▘█▌▌▌▐ ");
        System.out.println("▙▌█▌▌▌   ▌▙▌▙▌▙▖  ▐▖▙▌▙▌▐▖  ▄▌▙▖▙▌▐▖");
        System.out.println("        ▙▌                          ");
        sautLigne(3);
        String str = SimpleInput.getString("Appuyez sur une touche puis sur entrée : ");
    }

    /**
	 * Recherche l'indice de la première occurence d'une chaîne de caractères dans un tableau
	 * @param str une chaîne de caractères
	 * @param tab un tableau de chaîne de caractères
	 * @return l'indice de la première occurence de str dans tab, -1 s'il n'est pas présent
	 */
	int indice(String str, String[] tab){
		int ind = -1;
		boolean strEgal;
		int i = 0;
		int j;
		while (i < tab.length && ind == -1){
			if (tab[i].length() == str.length()){
				strEgal = true;
				j = 0;
				while (j < str.length() && strEgal){
					if (tab[i].charAt(j) != str.charAt(j)){
						strEgal = false;
					}
					j++;
				}
				if (strEgal){
					ind = i;
				}
			}
			i++;
		}
		return ind;
	}

    /**
     * Ajoute un pion sur une case jouable du tableau tab
     * @param plateau le tableau à deux dimensions représentant le plateau de Reversi
     * @param ligne la ligne de la case du pion joué
     * @param colonne la colonne de la case du pion joué
     * @param joueur le joueur qui joue à ce tour ('x' ou 'o')
     */
    void ajoutPion(char[][] plateau, int ligne, int colonne, char joueur){
        int[] tabCase = caseJouable(plateau, ligne, colonne, joueur);
        int i;
        if (tabCase[0] == 1){
            plateau[ligne][colonne] = joueur;
            for (i = 1; i <= tabCase[1]; i++){
                plateau[ligne + i][colonne] = joueur;
            }
            for (i = 1; i <= tabCase[2]; i++){
                plateau[ligne - i][colonne] = joueur;
            }
            for (i = 1; i <= tabCase[3]; i++){
                plateau[ligne][colonne + i] = joueur;
            }
            for (i = 1; i <= tabCase[4]; i++){
                plateau[ligne][colonne - i] = joueur;
            }
            for (i = 1; i <= tabCase[5]; i++){
                plateau[ligne + i][colonne + i] = joueur;
            }
            for (i = 1; i <= tabCase[6]; i++){
                plateau[ligne - i][colonne - i] = joueur;
            }
            for (i = 1; i <= tabCase[7]; i++){
                plateau[ligne + i][colonne - i] = joueur;
            }
            for (i = 1; i <= tabCase[8]; i++){
                plateau[ligne - i][colonne + i] = joueur;
            }
        }
    }

    /**
     * Teste si une case est jouable par le joueur
     * @param plateau le tableau à deux dimensions représentant le plateau de Reversi
     * @param ligne la ligne de la case testée, 0 <= ligne <= taille du plateau - 1
     * @param colonne la colonne de la case testée, 0 <= colonne <= taille du plateau - 1
     * @param joueur le joueur qui joue à ce tour ('x' ou 'o')
     * @return un tableau d'entiers dont la première valeur indique si la case est jouable (0 pour faux et 1 pour vrai)
     * et dont les autres valeurs indiquent dans quel sens l'encadrement est possible et sur combien de pions adverses
     * (cJouable[1] vers le bas, cJouable[2] vers le haut, cJouable[3] vers la droite...)
     */
    int[] caseJouable(char[][] plateau, int ligne, int colonne, char joueur){
        char pionCase = plateau[ligne][colonne];
        char joueurAdv = echange(joueur);
        int comptDepl;
        int i;
        int j;

        int[] cJouable = new int[9];
        if (pionCase == ' '){
            pionCase = joueur;
			i = ligne + 1;         //teste si on peut encadrer des pions adverses vers le haut
			comptDepl = 0;
			while (i < plateau.length - 1 && plateau[i][colonne] == joueurAdv){    //parcourt un alignement de pions tant que ceux-ci sont au joueur adverse
				i++;
				comptDepl++;        //note le nombre de cases concernées dans l'alignement
			}
			if (i <= plateau.length - 1 && plateau[i][colonne] == joueur && comptDepl > 0){    //teste si le dernier pion rencontré est un pion au joueur qui joue
				cJouable[0] = 1;
				cJouable[1] = comptDepl;                              //l'encadrement est validé, on enregistre le nombre de pions adverses encadrés
			}

			i = ligne - 1;         //on teste si on peut encadrer des pions adverses vers le bas
			comptDepl = 0;
			while (i > 0 && plateau[i][colonne] == joueurAdv){
				i--;
				comptDepl++;
			}
			if (i >= 0 && plateau[i][colonne] == joueur && comptDepl > 0){
				cJouable[0] = 1;
				cJouable[2] = comptDepl;
			}

			i = colonne + 1;       //on teste si on peut encadrer des pions adverses vers la droite
			comptDepl = 0;
			while (i < plateau.length - 1 && plateau[ligne][i] == joueurAdv){
				i++;
				comptDepl++;
			}
			if (i <= plateau.length - 1 && plateau[ligne][i] == joueur && comptDepl > 0){
				cJouable[0] = 1;
				cJouable[3] = comptDepl;
			}

			i = colonne - 1;       //on teste si on peut encadrer des pions adverses vers la gauche
			comptDepl = 0;
			while (i > 0 && plateau[ligne][i] == joueurAdv){
				i--;
				comptDepl++;
			}
			if (i >= 0 && plateau[ligne][i] == joueur && comptDepl > 0){
				cJouable[0] = 1;
				cJouable[4] = comptDepl;
			}

			i = ligne + 1;         //on teste si on peut encadrer en diagonale vers le bas et la droite
			j = colonne + 1;
			comptDepl = 0;
			while (i < plateau.length - 1 && j < plateau.length - 1 && plateau[i][j] == joueurAdv){
				j++;
				i++;
				comptDepl++;
			}
			if (i <= plateau.length - 1 && j <= plateau.length - 1 && plateau[i][j] == joueur && comptDepl > 0){
				cJouable[0] = 1;
				cJouable[5] = comptDepl;
			}

			i = ligne - 1;         //on teste si on peut encadrer en diagonale vers le haut et la gauche
			j = colonne - 1;
			comptDepl = 0;
			while (i > 0 && j > 0 && plateau[i][j] == joueurAdv){
				i--;
				j--;
				comptDepl++;
			}
			if (i >= 0 && j >= 0 && plateau[i][j] == joueur && comptDepl > 0){
				cJouable[0] = 1;
				cJouable[6] = comptDepl;
			}

			i = ligne + 1;         //on teste si on peut encadrer en diagonale vers le bas et la gauche
			j = colonne - 1;
			comptDepl = 0;
			while (i < plateau.length - 1 && j > 0 && plateau[i][j] == joueurAdv){
				i++;
				j--;
				comptDepl++;
			}
			if (i <= plateau.length - 1 && j >= 0 && plateau[i][j] == joueur && comptDepl > 0){
				cJouable[0] = 1;
				cJouable[7] = comptDepl;
			}

			i = ligne - 1;         //on teste si on peut encadrer en diagonale vers le haut et la droite
			j = colonne + 1;
			comptDepl = 0;
			while (i > 0 && j < plateau.length - 1 && plateau[i][j] == joueurAdv){
				i--;
				j++;
				comptDepl++;
			}
			if (i >= 0 && j <= plateau.length - 1 && plateau[i][j] == joueur && comptDepl > 0){
				cJouable[0] = 1;
				cJouable[8] = comptDepl;
			}
        }
        return cJouable;
    }

    /**
     * Teste un appel de indice()
     * @param str une chaîne de caractères
     * @param tab un tableau de chaîne de caractères
     * @param result le résultat attendu
     */
    void testCasIndice(String str, String[] tab, int result){
        // Affichage
		System.out.print("indice(\"" + str + "\", ");
        afficheTab(tab);
        System.out.print(") \t = " + result + "\t : ");
		
		// Appel
		int resExec = indice(str, tab);
		
		// Verification
		if (resExec == result){
			System.out.println("OK");
		} else {
			System.err.println("ERREUR");
		}
    }

    /**
     * Teste la méthode indice()
     */
    void testIndice(){
		System.out.println("*** testIndice()");
		
		testCasIndice("1", new String[] {"1", "2", "3", "4", "5"}, 0);
        testCasIndice("6", new String[] {"1", "2", "3", "4", "5"}, -1);
        testCasIndice("", new String[] {"1", "2", "3", "4", "5"}, -1);
        testCasIndice("abc", new String[] {"ab", "abc", "abcd", "abc"}, 1);
        testCasIndice("abc", new String[] {}, -1);
    }

    /**
     * Affiche un tableau de chaînes de caractères
     * @param tab un tableau de chaînes de caractères
     */
    void afficheTab(String[] tab){
        System.out.print("{");
        for (int i = 0; i < tab.length - 1; i++){
            System.out.print("\"" + tab[i] + "\", ");
        }
        if (tab.length > 0){
            System.out.print("\"" + tab[tab.length - 1] + "\"");
        }
        System.out.print("}");
    }
}
