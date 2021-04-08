package tp7_8_v2;

public class Joueur {
	private String nom;
	private String prenom;
	private int age;
	private Pokemons[] equipe = new Pokemons[5];
	private Nourriture[] provisions = new Nourriture[10];
	private Item[] sac;
	
	public Joueur(String nom, String prenom, int age, Pokemons[] equipe) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.equipe = equipe;
		this.provisions = new Nourriture[10];
		this.sac = new Item[15];
		
		for (int i = 0; i < equipe.length; i++) {
			if (null!=this.equipe[i]) {
				this.equipe[i].setMonJoueur(this);
			}
		}
	}

	public Joueur(String nom, String prenom, int age) {
		this(nom,prenom,age, new Pokemons[] {null,null,null,null,null});
	}
	
	public int trouverPokemon(Pokemons pokemon) {
			
			boolean pokemonTrouve = false;
			int compteur = 0;
			
			while (compteur<this.equipe.length && !pokemonTrouve) {
				if(this.equipe[compteur]==pokemon) {
					return compteur;
				}
				compteur++;
			}
			return -1;
		}
		
	public void capturerPokemon(Pokemons pokemon) {
		if (pokemon.getMonJoueur()!=null ) {
			System.out.println("Vous ne pouvez pas capturer le pokemon d'un autre joueur.");
		}
		else {
			int premierePlaceDisponible = this.trouverPokemon(null);
			if (premierePlaceDisponible != -1) {
				this.equipe[premierePlaceDisponible] = pokemon;
				System.out.println(pokemon.getNom() +" devient la propriete du joueur " + this.nom);
				pokemon.setMonJoueur(this);
				pokemon.setLoyaute(0);
				pokemon.setAppetit(10);
			}
			else {
				System.out.println("Vous n'avez pas la place pour accueillir ce pokemon ! Vous devrez renoncer a un autre pokemon pour capturer celui-ci.");
			}
		}
		
	}
	
	public void libererPokemon(Pokemons pokemon) {
		int positionPokemon = this.trouverPokemon(pokemon);
		if(positionPokemon != -1) {
			this.equipe[positionPokemon] = null;
			System.out.println("Ce pokemon n'est plus la propriete du joueur " + this.nom);
			pokemon.setMonJoueur(null);
			pokemon.setNomDonne(null);
			pokemon.setLoyaute(0);
			pokemon.setAppetit(10);
		}
		else {
			System.out.println("Vous n'etes pas le maitre de ce pokemon.");
		}
	}
	
	public void donnerNom(Pokemons pokemon, String nomDonne) {
		if (pokemon != null) {
			int positionPokemon = this.trouverPokemon(pokemon);
			if (positionPokemon != -1) {
				if(pokemon.getNomDonne() == null) {
					pokemon.setNomDonne(nomDonne);
					System.out.println("Le pokemon " + pokemon.getNom() + " a été renomé " + pokemon.getNomDonne());
					pokemon.monterLoyaute(10);
				}
				else {
					pokemon.setNomDonne(nomDonne);
					System.out.println("Le pokemon " + pokemon.getNom() + " a été renomé " + pokemon.getNomDonne());
					pokemon.baisserLoyaute(10);
				}
			}
			else {
				System.out.println("Vous ne pouvez pas nommer ce pokemon car vous n'etes pas son maitre !");
			}
		}
	}
	
	public void donnerPokemon(Pokemons pokemon, Joueur joueur) {
		if((pokemon != null) && (joueur != null )) {
			int premierePlaceDisponible = this.trouverPokemon(null);
			if (premierePlaceDisponible != -1) {
				joueur.equipe[premierePlaceDisponible] = pokemon;
				pokemon.setMonJoueur(joueur);
				System.out.println("don effectue, " + pokemon.getNom() + " appartient maintenant à " + joueur.getNom());
			}
			else {
				System.out.println("Plus de place");
			}
		}
	}
	
	public void echangerPokemon(Pokemons pokemonThis, Pokemons pokemonJoueur, Joueur joueur) {
		if((pokemonThis != null) && (joueur != null ) && (pokemonJoueur != null)) {
			int placePokemon1 = this.trouverPokemon(pokemonThis);
			int placePokemon2 = joueur.trouverPokemon(pokemonJoueur);
			if((placePokemon1 != -1) && (placePokemon2 != -1)) {
				pokemonThis.setMonJoueur(joueur);
				pokemonJoueur.setMonJoueur(this);
				System.out.println(this.getNom() + " a bien échangé son " + pokemonThis.getNom() + " contre un " + pokemonJoueur.getNom() + " à " + joueur.getNom());
			}
			else {
				System.out.println("Vous n'etes pas le propriétaire de ce pokemon/ La personne avec qui vous voulais faire l'échange n'est pas la propriétaire de ce pokemon");
			}
		}
		System.out.println("Les donnees en entree ne sont pas complète");
	}
	
	public void caresserPokemon(Pokemons pokemon) {
		if(pokemon.getMonJoueur() == this) {
			pokemon.monterLoyaute(1);
		}
		else {
			System.out.println("Vous ne pouvez pas carreser un pokemon qui ne vous appartient pas");
		}
	}
	
	private int trouverProvision(Nourriture nourriture) {
		int iterateur = 0;
		while (iterateur<this.provisions.length) {
			if(this.provisions[iterateur] == nourriture) {
				return iterateur;
			}
			iterateur++;
		}
		return -1;
	}
	
	public void ajouterProvision(Nourriture nourriture) {
		int positionLibre = this.trouverProvision(null);
		if (positionLibre != -1) {
			this.provisions[positionLibre] = nourriture;
		}
		else {
			System.out.println("Vous n'avez plus de place pour cette nourriture.");
		}
	}
	
	public void afficherProvisions() {
		for (int i = 0; i < this.provisions.length; i++) {
			if (null != this.provisions[i]) {
				System.out.println(i + " : " + this.provisions[i]);
			}
		}
	}
	
	public void afficherEquipe(){
		for (int i = 0; i < this.getEquipe().length; i++) {
			if(this.getEquipe()[i] != null) {
				System.out.println(i + " : " + this.getEquipe()[i]);
			}
		}
	}
	
	public void nourrirPokemon(Pokemons pokemon, Nourriture nourriture) {
		if (pokemon == null || nourriture == null || this.trouverPokemon(pokemon) == -1 || this.trouverProvision(nourriture) == -1) {
			System.out.println("Parametres non valides.");
		}
		else {
			pokemon.utiliser(nourriture);
			this.provisions[this.trouverProvision(nourriture)] = null;
		}
	}
	
	public void donnerItem(int indexP, int indexI) {
		if(indexP <= this.equipe.length && indexP>=0) {
			if(indexI <= this.sac.length && indexI>=0 ) {
				if( null != this.equipe[indexP] && null != this.sac[indexI]) {
					Utilisable item = (Utilisable) this.sac[indexI];
					item.utiliser(this, indexP);
					if (this.sac[indexI].getNbUtiRest() == 0) {
						this.sac[indexI] = null;
					}
				}
				else
					System.out.println("Aucun pokemon ou item à/aux index selectionne");
			}
			else
				System.out.println("L'index de l'item selectionne n'est pas valide (hors limite du sac)");
		}
		else
			System.out.println("L'index du pokemon selectionne n'est pas valide (index trop grand ou négatif)");
	}
	
	public void modifierItem(int indexC, int indexAMod) {
		if(indexC >= 0 && indexC < this.sac.length && indexAMod >= 0 && indexAMod < this.sac.length) {
			if (null != this.sac[indexC] && null != this.sac[indexAMod]) {
				if (this.sac[indexC] instanceof ChangerItems && this.sac[indexAMod] instanceof Modifiable) {
					ChangerItems itemChangeur = (ChangerItems) this.sac[indexC];
					Modifiable itemAModifier = (Modifiable) this.sac[indexAMod];
					itemChangeur.changer(itemAModifier);
					if (this.sac[indexC].getNbUtiRest() == 0) {
						this.sac[indexC] = null;
					}
				}
			}
		}
	}
	
	public int trouverItem(Item item)
	{
		int compteur = 0;
		while (compteur<this.sac.length) 
		{
			if(this.sac[compteur] == item) 
			{
				return compteur;
			}
			compteur++;
		}
		return -1;
	}

	public void ajouterItem(Item item) 
	{
		int positionLibre = this.trouverItem(null);
		if (positionLibre != -1) 
		{
			this.sac[positionLibre] = item;
		}
		else {
			System.out.println("Plus de place disponible dans votre sac");
		}
	}
	
	public void lacherItem(Item item) 
	{
		int positionItem = this.trouverItem(item);
		if(positionItem != -1) {
			this.sac[positionItem] = null;
			System.out.println("L'item a bien ete supprime");
		}
		else {
			System.out.println("vous ne possedez pas cet item");
		}
	}
	
	public void afficherSac() 
	{
		int compteur = 0;
		while(compteur < this.sac.length) 
		{
			if(this.sac[compteur] != null) 
			{
				System.out.println( compteur + " : " + this.sac[compteur]); 
			}
			compteur++ ;
		}
	}
	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Pokemons[] getEquipe() {
		return equipe;
	}

	public void setEquipe(Pokemons[] equipe) {
		this.equipe = equipe;
	}
	
	public Nourriture[] getProvisions() {
		return this.provisions;
	}
	
	public Item[] getSac() {
		return sac;
	}
}
