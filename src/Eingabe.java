import java.util.ArrayList;

/**
 *
 * @author Sedad, Jonas
 */
public class Eingabe {
    
        // Speichert alle Moeglichkeiten fuer die Summes des Integers n
	public static ArrayList<String> sM = new ArrayList<String>();
        // Speichert alle Mischmoeglichkeiten fuer den String str 
	public static ArrayList<String> pM = new ArrayList<String>();

        
        /**
         * Die Methode ruft die Methode sumMoeglichkeiten(int n, int max, String prefix) auf
         * @param n Anfangswert 
         */
	public static void sumMoeglichkeiten(int n) {
		sumMoeglichkeiten(n, 5, "");
	}

        /**
         * Die Methode fügt alle Möglichkeiten von einer bestimmten Stringlaenge in die ArrayList sM ein
         * Fuer mehr Moeglichkeiten werden die Moeglichkeiten einmal von vorne nach hinten und umgekehrt in die ArrayList eingefügt
         * 
         * @param n Anfangswert
         * @param max Maximalwert
         * @param prefix Die Moeglichkeit als String 
         */
	public static void sumMoeglichkeiten(int n, int max, String prefix) {	
		if (n == 0) {
			sM.add(prefix);
			return;
		}

		for (int i = Math.min(max, n); i >= 2; i--) {
			sumMoeglichkeiten(n - i, i, prefix + i);
			sumMoeglichkeiten(i - n, i, i + prefix);
		}
	}

        /**
         * Die Methode ruft die Methode permutation(String prefix, String str) auf
         * 
         * @param str Der Startwert
         */
	public static void permutation(String str) {
		permutation("", str);
	}

        /**
         * 
         * Die Methode veraendert die Position der einzelnen Character innerhalb eines Strings
         * und fuegt alle Moeglichkeiten in die ArrayList pM ein.
         * 
         * @param prefix Die Moeglichkeit als String
         * @param str Der Startwert
         */
	private static void permutation(String prefix, String str) {
		int n = str.length();
		if (n == 0) {
			pM.add(prefix);
			return;
		}
		
		for (int i = 0; i < n; i++)
                    permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
		}
}