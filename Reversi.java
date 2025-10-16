/*
 * jeu Reversi/Othello
 * @authors Guénolé Sixte
 */

class reversi{

    char[][] tab;

    void principal() {
        regleDuJeu();
        choixMode();
        
        exitGame();
        
        //afficheGrille(tab);
    }

    /**
     * affiche le nom du jeu
     */
    void debut() {
		System.out.println();
		System.out.println();
		System.out.println();
        System.out.println("   ███████████   ██████████  ░███    ░███ ██████████ ███████████   ░█████████  ░█████");
        System.out.println("   ░░███░░░░░███ ░░███░░░░░█ ░███    ░███ ░░███░░░░░█░░███░░░░░███ ░███░░░░░███ ░███ ");
        System.out.println("    ░███    ░███  ░███  █ ░  ░███    ░███  ░███  █ ░  ░███    ░███ ░███    ░░░  ░███ ");
        System.out.println("    ░██████████   ░██████    ░███    ░███  ░██████    ░██████████  ░░█████████  ░███ ");
        System.out.println("    ░███░░░░░███  ░███░░█    ░░███   ███   ░███░░█    ░███░░░░░███  ░░░░░░░░███ ░███ ");
        System.out.println("    ░███    ░███  ░███ ░   █  ░░░█████░    ░███ ░   █ ░███    ░███  ███    ░███ ░███ ");
        System.out.println("    █████   █████ ██████████    ░░███      ██████████ █████   █████░░█████████  █████");
        System.out.println("   ░░░░░   ░░░░░ ░░░░░░░░░░      ░░░      ░░░░░░░░░░ ░░░░░   ░░░░░  ░░░░░░░░░  ░░░░░ ");

    }

        /**
     * affiche message de réussite en mode 1 joueur
     */
    void finWinJ() {
        System.out.print("\u001B[2J\u001B[H");
        System.out.println("");
        System.out.println("");
        System.out.println("░██     ░██   ░██████   ░██     ░██       ░██       ░██ ░██████░███    ░██ ");
        System.out.println(" ░██   ░██   ░██   ░██  ░██     ░██       ░██       ░██   ░██  ░████   ░██ ");
        System.out.println("  ░██ ░██   ░██     ░██ ░██     ░██       ░██  ░██  ░██   ░██  ░██░██  ░██");
        System.out.println("   ░████    ░██     ░██ ░██     ░██       ░██ ░████ ░██   ░██  ░██ ░██ ░██ ");
        System.out.println("    ░██     ░██     ░██ ░██     ░██       ░██░██ ░██░██   ░██  ░██  ░██░██ ");
        System.out.println("    ░██      ░██   ░██   ░██   ░██        ░████   ░████   ░██  ░██   ░████ ");
        System.out.println("    ░██       ░██████     ░██████         ░███     ░███ ░██████░██    ░███ ");
        System.out.println("");
        System.out.println("");
        afficheGrille(tab);
    }

    /**
     * affiche message d'échec face au robot
     */
    void finWinR() {
        System.out.print("\u001B[2J\u001B[H");
        System.out.println("");
        System.out.println("");
        System.out.println("  ░██████     ░███    ░███     ░███ ░██████████      ░██████   ░██    ░██ ░██████████ ░█████████ ");
        System.out.println(" ░██   ░██   ░██░██   ░████   ░████ ░██             ░██   ░██  ░██    ░██ ░██         ░██     ░██");
        System.out.println("░██         ░██  ░██  ░██░██ ░██░██ ░██            ░██     ░██ ░██    ░██ ░██         ░██     ░██");
        System.out.println("░██  █████ ░█████████ ░██ ░████ ░██ ░█████████     ░██     ░██ ░██    ░██ ░█████████  ░█████████ ");
        System.out.println("░██     ██ ░██    ░██ ░██  ░██  ░██ ░██            ░██     ░██  ░██  ░██  ░██         ░██   ░██  ");
        System.out.println(" ░██  ░███ ░██    ░██ ░██       ░██ ░██             ░██   ░██    ░██░██   ░██         ░██    ░██ ");
        System.out.println("  ░█████░█ ░██    ░██ ░██       ░██ ░██████████      ░██████      ░███    ░██████████ ░██     ░██ ");
        System.out.println("");
        System.out.println("");
        afficheGrille(tab);
    }

    /**
     * affiche le message de réussite du joueur 1
     */
    void finWinJ1() {
        System.out.print("\u001B[2J\u001B[H");
        System.out.println("");
        System.out.println("");
        System.out.println("    ░█████        ░██████      ░██    ░██    ░███    ░██████░███    ░██   ░██████   ░██     ░██ ░██████████ ░██     ░██ ░█████████  ");
        System.out.println("      ░██        ░██   ░██     ░██    ░██   ░██░██     ░██  ░████   ░██  ░██   ░██  ░██     ░██ ░██         ░██     ░██ ░██     ░██");
        System.out.println("      ░██       ░██     ░██    ░██    ░██  ░██  ░██    ░██  ░██░██  ░██ ░██     ░██ ░██     ░██ ░██         ░██     ░██ ░██     ░██");
        System.out.println("      ░██  ░███ ░██     ░██    ░██    ░██ ░█████████   ░██  ░██ ░██ ░██ ░██     ░██ ░██     ░██ ░█████████  ░██     ░██ ░█████████  ");
        System.out.println("░██   ░██       ░██     ░██     ░██  ░██  ░██    ░██   ░██  ░██  ░██░██ ░██     ░██ ░██     ░██ ░██         ░██     ░██ ░██   ░██   ");
        System.out.println("░██   ░██        ░██   ░██       ░██░██   ░██    ░██   ░██  ░██   ░████  ░██   ░██   ░██   ░██  ░██          ░██   ░██  ░██    ░██  ");
        System.out.println(" ░██████          ░██████         ░███    ░██    ░██ ░██████░██    ░███   ░██████     ░██████   ░██████████   ░██████   ░██     ░██ ");
        System.out.println("                                                                              ░██                                                  ");
        System.out.println("                                                                               ░██                                                 ");
        System.out.println("");
        System.out.println("");
        afficheGrille(tab);
    }

    /**
     * affiche le message de réussite du joueur 1
     */
    void finWinJ2() {
        System.out.print("\u001B[2J\u001B[H");
        System.out.println("");
        System.out.println("");
        System.out.println("    ░█████      ░██    ░██    ░██    ░██    ░███    ░██████░███    ░██   ░██████   ░██     ░██ ░██████████ ░██     ░██ ░█████████  ");
        System.out.println("      ░██        ░██  ░██     ░██    ░██   ░██░██     ░██  ░████   ░██  ░██   ░██  ░██     ░██ ░██         ░██     ░██ ░██     ░██");
        System.out.println("      ░██         ░██░██      ░██    ░██  ░██  ░██    ░██  ░██░██  ░██ ░██     ░██ ░██     ░██ ░██         ░██     ░██ ░██     ░██");
        System.out.println("      ░██  ░███    ░███       ░██    ░██ ░█████████   ░██  ░██ ░██ ░██ ░██     ░██ ░██     ░██ ░█████████  ░██     ░██ ░█████████  ");
        System.out.println("░██   ░██         ░██░██       ░██  ░██  ░██    ░██   ░██  ░██  ░██░██ ░██     ░██ ░██     ░██ ░██         ░██     ░██ ░██   ░██   ");
        System.out.println("░██   ░██        ░██  ░██       ░██░██   ░██    ░██   ░██  ░██   ░████  ░██   ░██   ░██   ░██  ░██          ░██   ░██  ░██    ░██  ");
        System.out.println(" ░██████        ░██    ░██       ░███    ░██    ░██ ░██████░██    ░███   ░██████     ░██████   ░██████████   ░██████   ░██     ░██ ");
        System.out.println("                                                                              ░██                                                  ");
        System.out.println("                                                                               ░██                                                 ");
        System.out.println("");
        System.out.println("");
        afficheGrille(tab);
    }

    /**
     * affiche le message d'égalité à la fin de la partie
     */
    void finDraw() {
        System.out.print("\u001B[2J\u001B[H");
        System.out.println("");
        System.out.println("");
        System.out.println("░██████████   ░██████     ░███    ░██         ░██████░██████████░██████████    ░██ ");
        System.out.println("░██          ░██   ░██   ░██░██   ░██           ░██      ░██    ░██            ░██ ");
        System.out.println("░██         ░██         ░██  ░██  ░██           ░██      ░██    ░██            ░██ ");
        System.out.println("░█████████  ░██  █████ ░█████████ ░██           ░██      ░██    ░█████████     ░██ ");
        System.out.println("░██         ░██     ██ ░██    ░██ ░██           ░██      ░██    ░██            ░██ ");
        System.out.println("░██          ░██  ░███ ░██    ░██ ░██           ░██      ░██    ░██                ");
        System.out.println("░██████████   ░█████░█ ░██    ░██ ░██████████ ░██████    ░██    ░██████████    ░██ ");
        System.out.println("");
        System.out.println("");
        afficheGrille(tab);
    }

    /**
     * affiche les règles du jeu
     */
    void regleDuJeu() {
        System.out.print("\u001B[2J\u001B[H");
        debut();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("                     ╔════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("                     ║                                                                                    ║");
        System.out.println("                     ║                                    REGLES DU JEU                                   ║");
        System.out.println("                     ║                                                                                    ║");
        System.out.println("                     ╠════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("                     ║                                                                                    ║");
        System.out.println("                     ║   Une partie s'effectue sur un plateau de jeu de n^^2 cases(n pair et 4<=n<=16).   ║");
        System.out.println("                     ║     Les 2 joueurs jouent l'un contre l'autre. Ils disposent chacun d'un même       ║");
        System.out.println("                     ║                nombre de pions réversibles et jouent chacun leur tour.             ║");
        System.out.println("                     ║                                 Les 'o' commencent.                                ║");
        System.out.println("                     ║                                                                                    ║");
        System.out.println("                     ╠════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("                     ║                                                                                    ║");
        System.out.println("                     ║                                     But du jeu :                                   ║");
        System.out.println("                     ║               Lorsque sur le plateau une ligne, colonne ou diagonale d'un          ║");
        System.out.println("                     ║         même pion se retrouve encadrée par deux pions adverses, tous ceux-ci       ║");
        System.out.println("                     ║           sont alors retournés du côté de l'adversaire. L'objectif est donc        ║");
        System.out.println("                     ║             à la fin de la partie d'avoir le plus de ses pions retournés           ║");
        System.out.println("                     ║                                    sur le plateau.                                 ║");
        System.out.println("                     ║                                                                                    ║");
        System.out.println("                     ╠════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("                     ║                                                                                    ║");
        System.out.println("                     ║                               Déroulement d'un tour :                              ║");
        System.out.println("                     ║        Le joueur entre les coordonnées de la case dans laquelle il souhaite        ║");
        System.out.println("                     ║        jouer et pose ainsi son pion. Il peut uniquement poser un pion sur          ║");
        System.out.println("                     ║             une case permettant de retourner une ligne par la suite.               ║");
        System.out.println("                     ║              Si l'on ne peut pas jouer de pion, on saute son tour.                 ║");
        System.out.println("                     ║                                                                                    ║");
        System.out.println("                     ╠════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("                     ║                                                                                    ║");
        System.out.println("                     ║     Si aucun des deux joueurs ne peut jouer, ou si le plateau ne comporte plus     ║");
        System.out.println("                     ║                          de case vide, la partie s’arrête.                         ║");
        System.out.println("                     ║        Si le pion nouvellement placé vient fermer plusieurs alignements, il        ║");
        System.out.println("                     ║             capture tous les pions adverses des lignes ainsi fermées.              ║");
        System.out.println("                     ║                                                                                    ║");
        System.out.println("                     ╚════════════════════════════════════════════════════════════════════════════════════╝");
        char start = SimpleInput.getChar("Appuyez sur une touche pour commencez !   ");
        System.out.println();
        System.out.println();
    }
    
    /**
     * affichage du choix du mode de jeu
     */
    void choixMode() {
        System.out.print("\u001B[2J\u001B[H");
        debut();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("                     ╔═════════════════════════════════════════════╗");
        System.out.println("                     ║                                             ║");
        System.out.println("                     ║        Choissisez votre mode de jeu :       ║");
        System.out.println("                     ║             1 joueur  : Tapez (1)           ║");
        System.out.println("                     ║             2 joueurs : Tapez (2)           ║");
        System.out.println("                     ║                                             ║");
        System.out.println("                     ║                                             ║");
        System.out.println("                     ╚═════════════════════════════════════════════╝");
        System.out.print("\u001B[3A");
        int choix = SimpleInput.getInt("                     ║                  Choix : ");

        //cas d'erreur
        String warning = "\u26A0";
        int i = 1;
        while (choix != 1 && choix != 2) {
            System.out.print("\u001B[3B");
            System.out.print("                                   "+warning+"  tapez 1 ou 2\r");
            System.out.print("\u001B[4A");
            System.out.print("                                                       \r");
            choix = SimpleInput.getInt("                     ║                 Choix : ");
            warning = warning + " " + "\u26A0";
            if (i == 3) {
                choix = 1;
                raslebol2();
            }
            i++;
        }
        
        if (choix == 1) {
            //mode1joueur();
            //choixTaille(); 
            

        } else {
            //mode2joueurs
            choixTaille(); 
            mode2joueurs('o');
        }
    }

    /**
     * lance le mode 2 joueur
     * @param player un caractere correespondant au pion du joueur
     */
    void mode2joueurs(char player) {
        /*while casesjouables  diff de 0*/ {
            if (tabPlein(tab)) {
                if(comptePion(tab, 'x') > comptePion(tab, 'o')) {
                    finWinJ1();
                } else if (comptePion(tab, 'x') < comptePion(tab, 'o')){
                    finWinJ2();
                } else {
                    finDraw();
                }
            } else {
                jouer(tab, player);
                if (player == 'x') {
                    mode2joueurs('o');
                } else {
                    mode2joueurs('x');
                }
            }
        }
    }

    /**
     * fonction qui determine si le plateau est plein
     * @param tab un tableau 2d de caracteres
     * @return false si un seul elt du tableau est un espace, true sinon
     */
    boolean tabPlein(char[][] tab) {
        boolean bool = true;
        for (int i = 0 ; i < tab.length ; i++) {
            for (int j = 0 ; j < tab.length ; j++) {
                if (tab[i][j] == ' ') {
                    bool = false;
                }
            }
        }
        return bool;
    }

    /**
     * fonction qui compte le nombre de pion x ou o sur le plateau
     * @param tab
     * @param pion
     * @return
     */
    int comptePion(char[][] tab, char pion) {
        int cpt = 0;
        for (int i = 0 ; i < tab.length ; i++) {
            for (int j = 0 ; j < tab.length ; j++) {
                if (tab[i][j] == pion) {
                    cpt++;
                }
            }
        }
        return cpt;
    }
    
    /**
     * demande la taille de la grille au joueur
     */
    void choixTaille() {
        System.out.print("\u001B[2J\u001B[H");
        debut();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("               ╔═════════════════════════════════════════════════════════╗");
        System.out.println("               ║                                                         ║");
        System.out.println("               ║        Choissisez la taille de la grille de jeu         ║");
        System.out.println("               ║                                                         ║");
        System.out.println("               ║                                                         ║");
        System.out.println("               ╚═════════════════════════════════════════════════════════╝");
        System.out.print("\u001B[3A");
        int choix = SimpleInput.getInt("               ║                       Choix : ");
        //cas d'erreur
        String warning = "\u26A0";
        int i = 1;
        while (choix < 4 || choix > 16 || choix%2!=0) {
            System.out.print("\u001B[3B");
            System.out.print("                       "+warning+"  valeur entre 4 et 16 compris et pair\r");
            System.out.print("\u001B[4A");
            System.out.print("                                                       \r");
            choix = SimpleInput.getInt("               ║                       Choix : ");
            warning = warning + " " + "\u26A0";
            if (i == 3) {
                choix = 8;
                raslebol();
            }
            i++;
        }

        tab = new char[choix][choix]; //construction du tableau de départ
        for (int j = 0 ; j < tab.length ; j++) {
            for (int k = 0 ; k < tab.length ; k++) {
                tab[j][k] = ' ';
            }
        }

        tab[(tab.length/2)-1][(tab.length/2)-1] = 'x';
        tab[(tab.length/2)][(tab.length/2)-1] = 'o';
        tab[(tab.length/2)-1][(tab.length/2)] = 'o';
        tab[(tab.length/2)][(tab.length/2)] = 'x';

        afficheGrille(tab);
    }

    /**
     * affiche du reversi avec les valeurs du tableau
     * @param tab un tableau à 2 dimensions de 0 et de 1
     */
    void afficheGrille(char[][] tab) {
        System.out.print("\u001B[2J\u001B[H");
        debut();
        System.out.println();
        System.out.println();
        System.out.println();
        String abc = "abcdefghijklmnop";
        System.out.print("    ");
        for (int i = 1 ; i < tab.length +1 ; i++) { //affichage de l'abcissse
            System.out.printf("%2d ", i);
            System.out.print(" ");
        }
        System.out.println();
        

        //Affichage de la premiere ligne du tableau
        System.out.print("   ╔");
        for (int i = 0; i < tab.length-1; i++) {
            System.out.print("═══╦");
        }
        System.out.println("═══╗");
        
        for (int i = 0 ; i < tab.length-1; i++) { //affichage de l'ordonnée et des valeurs

            //affichage des valeurs
            System.out.print(" "+abc.charAt(i));
            for (int j = 0 ; j < tab.length ; j++) { 
                System.out.print(" ║ "+tab[i][j]);
            }
            System.out.println(" ║");


            //affichage de l'interligne
            System.out.print("   ");
            System.out.print("╠");
            for (int k = 0 ; k < tab.length-1 ; k++) { 
                System.out.print("═══╬");
            }
            System.out.print("═══╣");
            System.out.println();
        }

        //Affichage de la derniere ligne du tableau
        System.out.print(" "+abc.charAt(tab.length-1));
        for (int i = 0 ; i < tab.length ; i++) {
            System.out.print(" ║ "+tab[tab.length-1][i]);
        }
        System.out.println(" ║");
        System.out.print("   ╚");
        for (int i = 0; i < tab.length-1; i++) {
            System.out.print("═══╩");
        }
        System.out.println("═══╝");
    }

    /**
     * lance le jeu si l'entrée de la taille de la grille est incorrect
     */
    void raslebol() {
        System.out.print("\u001B[2J\u001B[H");
        System.out.println("        ▜     ▗     ▐▘          ");
        System.out.println("▛▌▀▌▛▌  ▐ ▀▌  ▜▘▌▌  ▜▘▛▌▛▘▛▘█▌▛▘");
        System.out.println("▌▌█▌▌▌  ▐▖█▌  ▐▖▙▌  ▐ ▙▌▌ ▙▖▙▖▄▌");
        System.out.println();
        System.out.println("▗     ▗     ▘     ▘         ▗     ▄▖");
        System.out.println("▜▘▀▌▛▌▜▘  ▛▌▌▛▘   ▌█▌  ▛▛▌█▌▜▘▛▘  ▙▌");
        System.out.println("▐▖█▌▌▌▐▖  ▙▌▌▄▌   ▌▙▖  ▌▌▌▙▖▐▖▄▌  ▙▌");
        System.out.println("          ▌      ▙▌                 ");
        try {
            Thread.sleep(3000); // pause de 3 secondes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * lance le jeu tout seul
     */
    void raslebol2() {

        System.out.print("\u001B[2J\u001B[H");
        System.out.println("▌   ▌    ▘        ▗     ▗         ▜ ");
        System.out.println("▛▌▀▌▛▌   ▌▛▌▌▌█▌  ▜▘▛▌▌▌▜▘  ▛▘█▌▌▌▐ ");
        System.out.println("▙▌█▌▌▌   ▌▙▌▙▌▙▖  ▐▖▙▌▙▌▐▖  ▄▌▙▖▙▌▐▖");
        System.out.println("        ▙▌                          ");
        try {
            Thread.sleep(3000); // pause de 3 secondes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * lance le tour d'un joueur
     * @param tab le tableau représentant le reversi
     * @param joueur le joueur qui joue
     */
    void jouer(char[][] tab, char joueur){
        String[] lettres = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p"};
		String[] nombres = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};
        System.out.println("C'est au joueur " + joueur + " de jouer");
        System.out.print("Voici les cases jouables : ");
        for (int i = 0; i < tab.length; i++){
            for (int j = 0; j < tab[i].length; j++){
                if (caseJouable(tab, i, j, joueur)[0] == 1){
                    System.out.print(lettres[i] + (j + 1) + " ");
                }
            }
        }
        System.out.println();
        String coord = SimpleInput.getString("Entrez les coordonnées du pion à jouer (lettre puis nombre) : ");
        int ligne = ((int) (coord.charAt(0))) - 97;
        int colonne = Integer.parseInt(coord.substring(1)) - 1;
        while (caseJouable(tab, ligne, colonne, joueur)[0] == 0){
            System.out.println("Coordonnées incorrectes.");
            coord = SimpleInput.getString("Entrez les coordonnées du pion à jouer (lettre puis nombre) : ");
            ligne = ((int) (coord.charAt(0))) - 97;
            colonne = Integer.parseInt(coord.substring(1)) - 1;
        }
        ajoutPion(tab, ligne, colonne, joueur);
        afficheGrille(tab);
    }

    /**
     * ajoute un pion sur une case jouable
     * @param tab le tableau représentant le reversi
     * @param ligne la ligne de la case du pion joué
     * @param colonne la colonne de la case du pion joué
     * @param joueur le joueur qui joue à ce tour ('x' ou 'o')
     */
    void ajoutPion(char[][] tab, int ligne, int colonne, char joueur){
        int[] tabCase = caseJouable(tab, ligne, colonne, joueur);
        int i;
        if (tabCase[0] == 1){
            tab[ligne][colonne] = joueur;
            for (i = 1; i <= tabCase[1]; i++){
                tab[ligne + i][colonne] = joueur;
            }
            for (i = 1; i <= tabCase[2]; i++){
                tab[ligne - i][colonne] = joueur;
            }
            for (i = 1; i <= tabCase[3]; i++){
                tab[ligne][colonne + i] = joueur;
            }
            for (i = 1; i <= tabCase[4]; i++){
                tab[ligne][colonne - i] = joueur;
            }
            for (i = 1; i <= tabCase[5]; i++){
                tab[ligne + i][colonne + i] = joueur;
            }
            for (i = 1; i <= tabCase[6]; i++){
                tab[ligne - i][colonne - i] = joueur;
            }
            for (i = 1; i <= tabCase[7]; i++){
                tab[ligne + i][colonne - i] = joueur;
            }
            for (i = 1; i <= tabCase[8]; i++){
                tab[ligne - i][colonne + i] = joueur;
            }
            afficheGrille(tab);
        }
    }

    /**
     * teste si une case est jouable par le joueur
     * @param tab le tableau représentant le reversi
     * @param ligne la ligne de la case testée, 0 <= ligne <= taille - 1
     * @param colonne la colonne de la case testée, 0 <= colonne <= taille - 1
     * @param joueur le joueur qui joue à ce tour ('x' ou 'o')
     * @return un tableau dont la première valeur indique si la case est jouable (0 pour faux et 1 pour vrai)
     * et dont les autres valeurs indiquent dans quel sens l'encadrement est possible et sur combien de pions adverses
     * (tab[1] vers le haut, tab[2] vers le bas, tab[3] vers la droite...)
     */
    int[] caseJouable(char[][] tab, int ligne, int colonne, char joueur){
        char pionCase = tab[ligne][colonne];
        char joueurAdv;
        int comptDepl;
        int i;
        int j;
        if (joueur == 'o'){
            joueurAdv = 'x';
        } else {
            joueurAdv = 'o';
        }
        int[] cJouable = new int[9];
        if (pionCase != '0'){
            pionCase = joueur;
			i = ligne + 1;         //on teste si on peut encadrer des pions adverses vers le haut
			comptDepl = 0;
			while (i < tab.length - 1 && tab[i][colonne] == joueurAdv){    //on parcourt un alignement de pions tant que ceux-ci sont au joueur adverse
				i++;
				comptDepl++;
			}
			if (i <= tab.length - 1 && tab[i][colonne] == joueur && comptDepl > 0){    //on teste si le dernier pion rencontré est un pion au joueur qui joue
				cJouable[0] = 1;
				cJouable[1] = comptDepl;                              //l'encadrement est validé, on enregistre le nombre de pions adverses encadrés
			}
			i = ligne - 1;         //on teste si on peut encadrer des pions adverses vers le bas
			comptDepl = 0;
			while (i > 0 && tab[i][colonne] == joueurAdv){
				i--;
				comptDepl++;
			}
			if (i >= 0 && tab[i][colonne] == joueur && comptDepl > 0){
				cJouable[0] = 1;
				cJouable[2] = comptDepl;
			}
			i = colonne + 1;       //on teste si on peut encadrer des pions adverses vers la droite
			comptDepl = 0;
			while (i < tab.length - 1 && tab[ligne][i] == joueurAdv){
				i++;
				comptDepl++;
			}
			if (i <= tab.length - 1 && tab[ligne][i] == joueur && comptDepl > 0){
				cJouable[0] = 1;
				cJouable[3] = comptDepl;
			}
			i = colonne - 1;       //on teste si on peut encadrer des pions adverses vers la gauche
			comptDepl = 0;
			while (i > 0 && tab[ligne][i] == joueurAdv){
				i--;
				comptDepl++;
			}
			if (i >= 0 && tab[ligne][i] == joueur && comptDepl > 0){
				cJouable[0] = 1;
				cJouable[4] = comptDepl;
			}
			i = ligne + 1;         //on teste si on peut encadrer en diagonale vers le bas et la droite
			j = colonne + 1;
			comptDepl = 0;
			while (i < tab.length - 1 && j < tab.length - 1 && tab[i][j] == joueurAdv){
				j++;
				i++;
				comptDepl++;
			}
			if (i <= tab.length - 1 && j <= tab.length - 1 && tab[i][j] == joueur && comptDepl > 0){
				cJouable[0] = 1;
				cJouable[5] = comptDepl;
			}
			i = ligne - 1;         //on teste si on peut encadrer en diagonale vers le haut et la gauche
			j = colonne - 1;
			comptDepl = 0;
			while (i > 0 && j > 0 && tab[i][j] == joueurAdv){
				i--;
				j--;
				comptDepl++;
			}
			if (i >= 0 && j >= 0 && tab[i][j] == joueur && comptDepl > 0){
				cJouable[0] = 1;
				cJouable[6] = comptDepl;
			}
			i = ligne + 1;         //on teste si on peut encadrer en diagonale vers le bas et la gauche
			j = colonne - 1;
			comptDepl = 0;
			while (i < tab.length - 1 && j > 0 && tab[i][j] == joueurAdv){
				i++;
				j--;
				comptDepl++;
			}
			if (i <= tab.length - 1 && j >= 0 && tab[i][j] == joueur && comptDepl > 0){
				cJouable[0] = 1;
				cJouable[7] = comptDepl;
			}
			i = ligne - 1;         //on teste si on peut encadrer en diagonale vers le haut et la droite
			j = colonne + 1;
			comptDepl = 0;
			while (i > 0 && j < tab.length - 1 && tab[i][j] == joueurAdv){
				i--;
				j++;
				comptDepl++;
			}
			if (i >= 0 && j <= tab.length - 1 && tab[i][j] == joueur && comptDepl > 0){
				cJouable[0] = 1;
				cJouable[8] = comptDepl;
			}
        }
        return cJouable;
    }

    /**
     * permet de quitter le jeu
     */
    void exitGame() {
        System.exit(0);
    }

    /**
     * teste l'existence d'un caractere dans un tableau
     * @param c un caractere
     * @param tab un tableau de carctere
     * @return vrai ou faux
     */
    boolean in(char c, char[] tab) {
        boolean bool = false;
        for (int i = 0 ; i < tab.length ; i++) {
            if (c == tab[i]) {
                bool = true;
            } 
        }
        return bool;
    }

    /**
     * teste l'existence d'un entier dans un tableau
     * @param c un entier
     * @param tab un tableau d'entier
     * @return vrai ou faux
     */
    boolean in(int c, int[] tab) {
        boolean bool = false;
        for (int i = 0 ; i < tab.length ; i++) {
            if (c == tab[i]) {
                bool = true;
            } 
        }
		return bool;
    }

	/**
	 * Recherche l'indice de la première occurence d'une chaîne de caractères dans un tableau
	 * @param tab un tableau de chaîne de caractères
	 * @param str une chaîne de caractères
	 * @return l'indice de la première occurence de str dans tab, -1 s'il n'est pas présent
	 */
	int indice(String[] tab, String str){
		int ind = -1;
		boolean indTrouve = false;
		int i = 0;
		while (i < tab.length && !indTrouve){
			
		}
	}
    
}
