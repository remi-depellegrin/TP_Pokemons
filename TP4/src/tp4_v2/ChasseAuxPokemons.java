package tp4_v2;

import tp4_v2.Pokemons;
import java.lang.Math;

public class ChasseAuxPokemons {

	public static void main(String[] args) {
		
		final Pokemons Piplup = new Pokemons("Piplup", "EAU", 5, true);
		final Pokemons Totodile = new Pokemons("Totodile", "EAU", 8, true);
		final Pokemons Fantominus = new Pokemons("Totodile", "SPECTRE", 8, true);
		
		final Nourriture tartiflette = new Nourriture(35, "tartiflette", new String[]{"DRAGON", "FEU", "COMBAT", "NORMAL", "EAU", "ELECTRIQUE"}, 20);
		final Nourriture ratatouille = new Nourriture(10, "ratatouille", new String[]{"PLANTE","EAU","VOL","FEU","NORMAL","ELECTRIQUE","COMBAT"}, 50);
		final Gourmandise barreChocolatee = new Gourmandise(20, "barre chocolatee", new String[]{"DRAGON", "FEU", "COMBAT", "SPECTRE", "EAU"}, 10, 7);
		final PotionMagique mojito = new PotionMagique("mojito", 2);
		final Nourriture[] diversesNourritures = new Nourriture[]{tartiflette, ratatouille, barreChocolatee, mojito};
		
		/*for(int i =0; i< diversesNourritures.length; i++ ) {
			System.out.println(diversesNourritures[i]);
			System.out.println("Compatible avec Piplup : " + diversesNourritures[i].isCompatible(Piplup));
			System.out.println("Compatible avec Totodile : " + diversesNourritures[i].isCompatible(Totodile));
			System.out.println("Compatible avec Fantominus : " + diversesNourritures[i].isCompatible(Fantominus));
			System.out.println();
		}*/
		
		for (int i = 0; i < diversesNourritures.length; i++) {
			Piplup.manger(diversesNourritures[i]);
			System.out.println(Piplup);
			System.out.println(diversesNourritures[i].genererMemeNourriture(true));
			System.out.println();
		}
		System.out.println();
		
		final Joueur Jean = new Joueur("Dupont", "Jean", 19);
		
		System.out.println();
		
		Jean.capturerPokemon(Piplup);
		for (int i = 0; i < diversesNourritures.length; i++) {
			Piplup.manger(diversesNourritures[i]);
			System.out.println(Piplup);
			System.out.println(diversesNourritures[i].genererMemeNourriture(true));
			System.out.println();
		}
		System.out.println();
		
		// generer un nombre aléatoire
		/*
		double alea;
		int nombreDEssais = Integer.valueOf(args[0]);
		boolean generer;
		Nourriture[] nourritureGeneree = new Nourriture[diversesNourritures.length];
				
		for (int i = 0; i<nombreDEssais; i++) {
			alea = Math.random()*100;
			for (int j = 0; j<diversesNourritures.length; j++) {
				if (alea < diversesNourritures[j].getFrequence()) {
					generer = true;
				}
				else {
					generer = false;
				}
				nourritureGeneree[j] = diversesNourritures[j].genererMemeNourriture(generer);
				if(nourritureGeneree[j]!=null) {
					System.out.println(nourritureGeneree[j] + " "+ i + j);
					System.out.println();
				}
			}
		}
		*/
	}
}
