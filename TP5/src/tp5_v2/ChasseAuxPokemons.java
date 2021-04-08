package tp5_v2;

import tp5_v2.Pokemons;
import java.lang.Math;
import java.util.Scanner;

public class ChasseAuxPokemons {

	public static void main(String[] args) {
		
		final Pokemons Piplup = new Pokemons("Piplup", "EAU", 5, true);
		final Pokemons Totodile = new Pokemons("Totodile", "EAU", 8, true);
		final Pokemons Fantominus = new Pokemons("Fantominus", "SPECTRE", 8, false);
		
		final Nourriture tartiflette = new Nourriture(35, "Tartiflette", new String[]{"DRAGON", "FEU", "COMBAT", "NORMAL", "EAU", "ELECTRIQUE"}, 20);
		final Nourriture ratatouille = new Nourriture(10, "Ratatouille", new String[]{"PLANTE","EAU","VOL","FEU","NORMAL","ELECTRIQUE","COMBAT"}, 50);
		final Gourmandise barreChocolatee = new Gourmandise(20, "Barre chocolatee", new String[]{"DRAGON", "FEU", "COMBAT", "SPECTRE", "EAU"}, 10, 7);
		final PotionMagique mojito = new PotionMagique("Mojito", 2);
		final Nourriture[] diversesNourritures = new Nourriture[]{tartiflette, ratatouille, barreChocolatee, mojito};
		
		final Joueur Remi = new Joueur("De Pellegrin", "Remi", 19, new Pokemons[]{Piplup,Totodile,Fantominus,null,null});

		/*
		Scanner sc = new Scanner (System.in);
		Scanner sc = new Scanner (File);
		*/
		
		// generer un nombre aléatoire
		double alea;
		boolean generer;
		Nourriture[] nourritureGeneree = new Nourriture[diversesNourritures.length];		
		Scanner scanner = new Scanner(System.in);
		boolean stop = false;
		
		while(stop == false) {
			
			alea = Math.random()*100;
			for (int j = 0; j<diversesNourritures.length; j++) {
				if (alea < diversesNourritures[j].getFrequence()) {
					generer = true;
				}
				else {
					generer = false;
				}
				nourritureGeneree[j] = diversesNourritures[j].genererMemeNourriture(generer);
				if (generer) {
					System.out.println("Vous avez trouvé un.e/du/de la " + diversesNourritures[j].getNom() + ". Voulez-vous la prendre ? Ecrivez oui si c'est le cas.");
					String reponse = scanner.next();
					if (reponse.equals("oui")) {
						Remi.ajouterProvision(nourritureGeneree[j]);
						System.out.println(nourritureGeneree[j].getNom() + " a bien été ajouté.");
					}
				}
			}
			
			System.out.println("\nQue voulez-vous faire ? : "
					+ "\n  1- Regarder vos pokemons ? "
					+ "\n  2- Caresser un de vos pokemons ? "
					+ "\n  3- Regarder vos provisions ? "
					+ "\n  4- Nourrir vos pokemons ? "
					+ "\n  stop- Arreter \n");

			String reponse = scanner.next();
			scanner.nextLine();
			
			if(reponse.equals("stop"))
				stop = true;
			
			if(reponse.equals("1")) {
				Remi.afficherEquipe();
				System.out.println();
			}
			
			if(reponse.equals("2")) {
				int reponseInt = 0;
				if(reponseInt >= 0 && reponseInt < Remi.getEquipe().length) {
					System.out.println("Quel pokemon voulez vous caresser ?(0,1,2,3,4)");
					Remi.afficherEquipe();
					reponseInt = scanner.nextInt();
					scanner.nextLine();
					Pokemons[] equipe = Remi.getEquipe();

					if( null != equipe[reponseInt])
						Remi.caresserPokemon(Remi.getEquipe()[reponseInt]);
				}
				else
					System.out.println("Aucun pokemon à cette position, vous perdez votre tour !");
			}
			
			if(reponse.contentEquals("3")) {
				Remi.afficherProvisions();
			}
			
			if(reponse.contentEquals("4")) {
				System.out.println("Quel pokemon voulez-vous nourrir ?(0,1,2,3,4)");
				Remi.afficherEquipe();
				int reponseInt = 0;
				reponseInt = scanner.nextInt();
				if(reponseInt >= 0 && reponseInt < Remi.getEquipe().length) {
					System.out.println("Quelle provision voulez-vous utiliser ? Donnez son index entre 0 et " + (Remi.getProvisions().length-1));
					Remi.afficherProvisions();
					int deuxiemeReponse = scanner.nextInt();
					if(deuxiemeReponse >= 0 && deuxiemeReponse < Remi.getProvisions().length) {
						Remi.nourrirPokemon(Remi.getEquipe()[reponseInt], Remi.getProvisions()[deuxiemeReponse]);
					}
					else {
						System.out.println("Mauvaise valeur. Vous perdez votre tour.");
					}
				}
				else {
					System.out.println("Mauvaise valeur. Vous perdez votre tour.");
				}
			}
			
		}
			
		scanner.close();
		System.out.println("fin de programme");
	}
}
