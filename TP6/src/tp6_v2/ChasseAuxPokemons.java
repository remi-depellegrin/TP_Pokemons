package tp6_v2;

import tp6_v2.Pokemons;
import java.lang.Math;
import java.util.Scanner;

public class ChasseAuxPokemons {

	public static void main(String[] args) {
		
		final Pokemons piplup = new Pokemons("Piplup", "EAU", 5, true,51, 53, 61, 56, new Attaque[] {new AttaqueTackle(), new AttaqueMorsure(), new AttaquePistoleEau(), new AttaqueEnfer()});
		final Pokemons rowlet = new Pokemons("Rowlet", "PLANTE", 10, false, 55, 55, 50, 55, new Attaque[] {new AttaqueMorsure(), new AttaqueFeinte(), new AttaqueTornadeFeuilles()});
		final Pokemons totodile = new Pokemons("Totodile", "EAU", 8, true,65, 64, 44, 48, new Attaque[] {new AttaqueBulle(), new AttaqueCoupDeTete()});
		
		
		final Joueur moi = new Joueur("Onete", "Cristina", 20, new Pokemons[] {piplup, rowlet, totodile, null, null});
		
		final Nourriture tartiflette = new Nourriture(35, "tartiflette", new String[]{"DRAGON", "FEU", "COMBAT", "NORMAL", "EAU", "ELECTRIQUE"}, 20);
		final Nourriture ratatouille = new Nourriture(10, "ratatouille", new String[]{"PLANTE","EAU","VOL","FEU","NORMAL","ELECTRIQUE","COMBAT"}, 50);
						
		final Gourmandise barreChocolatee = new Gourmandise(20, "Barre Chocolatee", new String[] {"DRAGON", "FEU", "COMBAT", "EAU", "ELECTRIQUE"}, 10, 7);
		final PotionMagique mojito = new PotionMagique("mojito", 2);

		final Nourriture[] tableauNourriture = new Nourriture[] {tartiflette, ratatouille, barreChocolatee, mojito};


		Scanner lecteur = new Scanner(System.in);
		System.out.println();
		
		final Pokemons p1 = piplup;
		final Pokemons p2 = rowlet;
		
		boolean batailleFinie = false;
	
		while (!batailleFinie) {
			if (p1.sEstEvanoui() || p2.sEstEvanoui()) {
				batailleFinie = true;
			}
			if(!batailleFinie) {
				p1.afficherEtatAttaques();
				System.out.println("Pour pokemon " +p1.getNom() + ", quel attaque utiliser contre " + p2.getNom());
				int reponseIndex = lecteur.nextInt();
				while (reponseIndex < 0 || reponseIndex > p1.getAttaques().length) {
					System.out.println("Refaites votre choix.");
					reponseIndex = lecteur.nextInt();
				}
				p1.utiliserAttaque(reponseIndex, p2);
				if (p2.sEstEvanoui()) {
					batailleFinie = true;
				}
			}
			
			if(!batailleFinie && !p2.sEstEvanoui()) {
				p2.afficherEtatAttaques();
				System.out.println("Pour pokemon" +p2.getNom() + ", quel attaque utiliser contre " + p1.getNom());
				int reponseIndex = lecteur.nextInt();
				while (reponseIndex < 0 || reponseIndex > p2.getAttaques().length) {
					System.out.println("Refaites votre choix.");
					reponseIndex = lecteur.nextInt();
				}
				p2.utiliserAttaque(reponseIndex, p1);
				if (p1.sEstEvanoui()) {
					batailleFinie = true;
				}
			}
		}

		if (p1.sEstEvanoui()) {
			System.out.println("Le vainqueur est " + p2.getNom());
		}
		else {
			System.out.println("Le vainqueur est " + p1.getNom());
		}
		
		p1.rechargerAttaques();
		p2.rechargerAttaques();
		
		lecteur.close();

		/*
		Scanner sc = new Scanner (System.in);
		Scanner sc = new Scanner (File);
		*/
		
		// generer un nombre aléatoire
		/*
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
	*/
	}
}
