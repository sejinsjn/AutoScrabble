import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sedad, Jonas
 */

public class Kennzeichen {
    
        // Das generierte Kennzeichen als String
	private final String kennzeichen;
        // String der anzeigt ob ein Kennzeichen generiert werden kann
	public static String p = "";
        // Random fuer die zufaellige Zahl am Ende eines Kennzeichens
	private static Random r1;
        // Speichert die generierten Kennzeichen
	static ArrayList<Kennzeichen> kennzeichenListe = new ArrayList<>();
        // Alle Kennzeichen werden hier gespeichert
	static ArrayList<Kennzeichen> kenn = new ArrayList<>();
        // Zur Ueberpruefung ob ein Kennzeichen vorhanden ist
	static ArrayList<String> kenn2 = new ArrayList<>();
        // Speichert die Stadtkuerzel aus der Textdatei kz.txt
	static ArrayList<String> k = readLines("kz.txt");
        
        
	public Kennzeichen(String kennzeichen) {
		this.kennzeichen = kennzeichen;
	}

	public void ausgeben() {
		for (String k1 : k) {
			System.out.println(k1);
		}
	}

	public static ArrayList<String> readLines(String filename) {
		String line = null;
		ArrayList<String> lines = new ArrayList<>();
		FileReader fr;
		try {
			fr = new FileReader(filename);
			try (BufferedReader bf = new BufferedReader(fr)) {
				while ((line = bf.readLine()) != null) {
					lines.add(line);
				}
			}
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Kennzeichen.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Kennzeichen.class.getName()).log(Level.SEVERE, null, ex);
		}
		return lines;
	}

	public static ArrayList<Kennzeichen> gK2(String input) {
		r1 = new Random();
		int a = 1;
		if (input.length() == 2) {
			for (String k1 : k) {
				while (a < input.length()) {
					if (input.substring(0, a).equals(k1)) {
						kennzeichenListe.add(new Kennzeichen(
								"1: " + input.substring(0, a) + " - " + input.substring(a) + " " + r1.nextInt(1000)));

					}
					break;
				}
			}
		}

		return kennzeichenListe;
	}

	public static ArrayList<Kennzeichen> gK3(String input) {
		r1 = new Random();
		int a = r1.nextInt(2) + 1;
		if (input.length() == 3) {
			for (String k1 : k) {
				while (a < input.length()) {
					if (input.substring(0, a).equals(k1)) {
						kennzeichenListe.add(new Kennzeichen(a + ": " + input.substring(0, a) + " - "
								+ input.substring(a) + " " + r1.nextInt(1000)));
					}
					break;
				}
			}
		}

		return kennzeichenListe;
	}

	public static ArrayList<Kennzeichen> gK4(String input) {
		r1 = new Random();
		int a = 2;
		if (input.length() == 4) {
			for (String k1 : k) {
				while (a < input.length()) {
					if (input.substring(0, a).equals(k1)) {
						kennzeichenListe.add(new Kennzeichen("1: " + input.substring(0, a) + " - "
								+ input.substring(a, a + 2) + " " + r1.nextInt(1000)));
					}
					break;
				}
			}
		}

		return kennzeichenListe;
	}

	public static ArrayList<Kennzeichen> gK5(String input) {
		r1 = new Random();
		int a = 3;
		if (input.length() == 5) {
			for (String k1 : k) {
				while (a < input.length()) {
					if (input.substring(0, a).equals(k1)) {
						kennzeichenListe.add(new Kennzeichen("1: " + input.substring(0, a) + " - "
								+ input.substring(a, a + 2) + " " + r1.nextInt(1000)));
					}
					break;
				}
			}
		}

		return kennzeichenListe;
	}

	public static ArrayList<Kennzeichen> generateKennzeichen(String input, int q) {
		int a = q, c = 0, i = 1, b = 0;
		if(a < Eingabe.pM.size()) {
		String sum = Eingabe.pM.get(a);

		if (kennzeichenListe.isEmpty()) {
			while (i < sum.length() + 1 && b <= input.length()) {
				if (sum.substring(c, i).equals("2")) {
					gK2(input.substring(b, 2 + b));
					b = b + 2;
				}
				if (sum.substring(c, i).equals("3")) {
					gK3(input.substring(b, 3 + b));
					b = b + 3;
				}
				if (sum.substring(c, i).equals("4")) {
					gK4(input.substring(b, 4 + b));
					b = b + 4;
				}
				if (sum.substring(c, i).equals("5")) {
					gK5(input.substring(b, 5 + b));
					b = b + 5;
				}

				i++;
				c++;
				
				if (kennzeichenListe.size() < sum.length() && i == sum.length() + 1) {
					kennzeichenListe.clear();
					a++;
					generateKennzeichen(input, a);
					break;
				}
			}
		}
		}else {
			p = "nv";
		}
		return kennzeichenListe;
	}

	public static void showKennzeichen(String input) {
			int a = 0;
			Eingabe.sumMoeglichkeiten(input.length());
			while(a < Eingabe.sM.size()) {
				Eingabe.permutation(Eingabe.sM.get(a));
				a++;
				
				if(a == Eingabe.sM.size()) {
					break;
				}
			}
			ArrayList<Kennzeichen> kenn = generateKennzeichen(input, 0);
			kenn.stream().forEach((kz) -> {
				kenn2.add(kz.kennzeichen);
				System.out.println(kz.kennzeichen);
			});
			kenn.clear();
			Eingabe.sM.clear();
			Eingabe.pM.clear();
	}
}
