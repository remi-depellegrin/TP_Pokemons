package tp1;

import tp1.Pokemons;
public class ChasseAuxPokemons {

	public static void main(String[] args) {
		final Pokemons Piplup = new Pokemons("Piplup", "Eau", 5, true);
		final Pokemons Rowlet = new Pokemons("Rowlet", "Plante", 10, false);
		final Pokemons Totodile = new Pokemons("Totodile", "Eau", 8, true);
		
		System.out.println(Piplup);
		System.out.println(Rowlet);
		System.out.println(Totodile);
		System.out.println();
		
		// final String periodedeJournee = "nuit";
		
		// Dire bonjour pendant la journée
		System.out.println("Dire bonjour pendant la journée : ");
		Piplup.direBonjour(args[0]);
		Rowlet.direBonjour(args[0]);
		Totodile.direBonjour(args[0]);
		
		System.out.println();
		
		// Dire bonjour pendant la nuit (args[1] == nuit)
		System.out.println("Dire bonjour pendant la nuit (args[1] == nuit) : ");
		Piplup.direBonjour(args[1]);
		Rowlet.direBonjour(args[1]);
		Totodile.direBonjour(args[1]);
	}

}
