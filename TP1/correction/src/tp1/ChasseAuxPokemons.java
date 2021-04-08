package tp1;

public class ChasseAuxPokemons {

	public static void main(String[] args) {
		
		final Pokemon piplup = new Pokemon("Piplup", "EAU", 5, true);
		final Pokemon rowlet = new Pokemon("Rowlet", "PLANTE", 10, false);
		final Pokemon totodile = new Pokemon("Totodile", "EAU", 8, true);
		
		// Pour l'exercice 6
		final String periodeJournee = "nuit";
		
		System.out.println(piplup);
		System.out.println(rowlet);
		System.out.println(totodile);
		
		//Utiliser juste l'affichage pour simuler le salut des pokemons
		//System.out.println("Piplup dit bonjour !");
		//System.out.println("Rowlet dit bonjour !");
		//System.out.println("Totodile dit bonjour !");
		
		//Utiliser la methode direBonjour exercice 6
		// piplup.direBonjour(periodeJournee);
		// rowlet.direBonjour(periodeJournee);
		// totodile.direBonjour(periodeJournee);
		
		// Utiliser la methode direBonjour avec args
		piplup.direBonjour(args[0]);
		rowlet.direBonjour(args[0]);
		totodile.direBonjour(args[0]);
	}
}
