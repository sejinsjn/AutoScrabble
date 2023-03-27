import java.util.Scanner;

/**
 *
 * @author Sedad, Jonas
 */

public class Menue {

    // Scanner fuer die Eingabe des Strings aus dem ein oder mehrere Kennzeichen generiert werden sollen.
	Scanner scan = new Scanner(System.in);
        
        // Deutsche Umlaute in der Unicode-Codierung
        final private static char Ae = '\u00c4';
        final private static char Oe = '\u00d6';
        final private static char Ue = '\u00dc';
        final private static char ss = '\u00df';

        /**
         * Die Methode steuert den Ablauf fuer das Generieren von ein oder mehreren Kennzeichen, da fuer
         * unterschiedliche Eingaben unterschiedliche Methoden aufgefuehrt werden
         */
	public void start() {
		String input = scan.nextLine();
		input = replaceUmlaut(input);
		input = input.toUpperCase();
                input = replaceSonderLeerzeichen(input);

		if (input.length() < 2) {
			System.err.println("Die Eingabe muss länger als 1 sein und muss mindestens zwei Buschstaben enthalten!");
		} else {
			if (input.length() > 11) {
				int a = 0, b = runden(input.length()) / 10, c = input.length() - runden(input.length()), d = 0;

				while (true) {
					Kennzeichen.showKennzeichen(input.substring(a, a + 10));
					a = a + 10;
					d++;

					if(c == 1 && d == b) {
						Kennzeichen.showKennzeichen(input.substring(a-10));
						break;
					}
					
					if (d == b && c > 1 && a <= input.length()) {
						Kennzeichen.showKennzeichen(input.substring(a));
						break;
					}

					if (d == b && c == 0) {
						break;
					}
				}
			} else {
				Kennzeichen.showKennzeichen(input);
			}

		}

	}

        /**
         * Die Methode rundet eine Zahl auf
         * @param zahl Die aufzurundene Zahl
         * @return Die aufgerundete Zahl
         */
	public static int runden(int zahl) {
		int sum = zahl;
		int a = (((sum + 9) / 10) * 10) - 10;
		return a;
	}

        /**
         * Die Methode ersetzt Sonder- / Leerzeichen innerhalb eines Strings
         * @param input Der Strings beim dem die Sonder- / Leerzeichen ersetzt werden sollen.
         * @return String, wo Sonder- / Leerzeichen ersetzt worden sind
         */
	private static String replaceSonderLeerzeichen(String input) {
		String output = input.replaceAll("[^a-zA-Z]", "");

		return output;
	}

        /**
         * Die Methode ersetzt Umlaute innerhalb eines Strings
         * @param input Der Strings beim dem die Umlaute ersetzt werden sollen.
         * @return String, der keine Umlaute mehr besitzt
         */
	private static String replaceUmlaut(String input) {

		String output = input.replaceAll(Ue+"", "UE").replaceAll(Oe+"", "OE").replaceAll(Ae+"", "AE").replaceAll(ss+"", "SS");

		return output;
	}
}