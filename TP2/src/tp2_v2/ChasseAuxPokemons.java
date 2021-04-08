package tp2_v2;

import tp2_v2.Pokemons;

public class ChasseAuxPokemons {

	public static void main(String[] args) {
		final Pokemons Piplup = new Pokemons("Piplup", "Eau", 5, true);
		final Pokemons Rowlet = new Pokemons("Rowlet", "Plante", 10, false);
		final Pokemons Totodile = new Pokemons("Totodile", "Eau", 8, true); // Cela compile car le contructeur reste bon, nomDonne et monJoueur seront mis à null.
		final Pokemons Totodile2 = new Pokemons("Totodile2", "Eau", 8, true);
		final Pokemons Totodile3 = new Pokemons("Totodile3", "Eau", 8, true);
		final Pokemons Totodile4 = new Pokemons("Totodile4", "Eau", 8, true);
		
		final Joueur Jean = new Joueur("Dupont", "Jean", 19);
		final Joueur Truc = new Joueur("Much", "Truc", 19);
		Truc.capturerPokemon(Rowlet);
		Truc.capturerPokemon(Totodile);
		Truc.capturerPokemon(Totodile2);
		Truc.capturerPokemon(Totodile3);
		Truc.capturerPokemon(Totodile4);
		Truc.donnerNom(Totodile4, "TotodileTest");
		
		Jean.capturerPokemon(Piplup);
		System.out.println();
		Jean.echangerPokemon(Piplup, Totodile4, Truc);
		Truc.donnerPokemon(Totodile, Jean);
		
		
		System.out.println();
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
