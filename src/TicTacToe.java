public class TicTacToe {
    public char[][] spielfeld;


    //Konstruktor -> Erstellt das 3x3 Spielfeld und sorgt dafür, dass der Inhalt erstmal leer ist
    public TicTacToe() {
        spielfeld = new char[3][3];

        for (int i = 0; i < 3; i++) { //i = Spalte, j = Zeile
            for (int j = 0; j < 3; j++) {
                spielfeld[i][j] = ' ';
            }
        }
    }


    public char[][] getSpielfeld() {
        return spielfeld;
    }


    //Exceptions werfen

    //Hier sind Exceptions nicht sinnvoll (glaube ich), daher lieber weglassen
	/*public void readInput0(int zeile, int spalte, char spieler) throws IllegalArgumentException { //InputMismatchException {

		//Falsche Zahl eingegeben?
		if (zeile < 0 || zeile > 2 || spalte < 0 || spalte > 2) {
			throw new IllegalArgumentException("Falsche Eingabe!");
		}

		if (spielfeld[zeile][spalte] != ' ') {
			throw new IllegalArgumentException("Feld ist belegt!");
		}
	}*/

    //Diese Exception ist sinnvoll (glaube ich)
	/*public int[] readInput(Scanner sc) throws InputMismatchException {

		if ()
	}*/


    //Gewinner finden
    public char checkWinner() {

        //Reihen + Spalten
        for (int j = 0; j < 3; j++) {
            //Reihen
            if (spielfeld[j][0] == spielfeld[j][1] && spielfeld[j][1] == spielfeld[j][2] && spielfeld[j][0] != ' ') {
                return spielfeld[j][0];
            }
            //Spalten
            if (spielfeld[0][j] == spielfeld[1][j] && spielfeld[1][j] == spielfeld[2][j] && spielfeld[0][j] != ' ') {
                return spielfeld[0][j];
            }
        }

        // Diagonalen
        if (spielfeld[0][0] == spielfeld[1][1] && spielfeld[1][1] == spielfeld[2][2] && spielfeld[0][0] != ' ') {
            return spielfeld[0][0];
        }
        if (spielfeld[0][2] == spielfeld[1][1] && spielfeld[1][1] == spielfeld[2][0] && spielfeld[0][2] != ' ') {
            return spielfeld[0][2];
        }

        // Kein Gewinner
        return ' ';
    }


    //Spielfeld ausgeben
    public void printSpielfeld() {
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + spielfeld[i][0] + " | " + spielfeld[i][1] + " | " + spielfeld[i][2]);

            if (i < 2) {
                System.out.println("---+---+---");
            }
        }
    }
}
