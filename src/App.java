public class App {
    /**
     * Starte den Kennzeichengenerator
     * @param args 
     */
    
    public static void main(String[] args) {
    	Menue m1 = new Menue();
    	m1.start();
    	if(Kennzeichen.p.equals("nv") && Kennzeichen.kenn2.isEmpty()) {
    		System.err.println("Es konnte/n kein/e Kennzeichen generiert werden!");
    	}
    	if(Kennzeichen.p.equals("nv") && !Kennzeichen.kenn2.isEmpty()) {
    		System.err.println("Es konnte/n nur die angezeigten Kennzeichen generiert werden! Versuchen Sie es mit einem anderem Wort erneut!");
    	}
    }
}
