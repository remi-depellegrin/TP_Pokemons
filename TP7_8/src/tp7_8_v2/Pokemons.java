package tp7_8_v2;

public class Pokemons {
	private String nom;
	private String type;
	private int niveau;
	private boolean diurne;
	private String nomDonne;
	private Joueur monJoueur;
	private int appetit;
	private int loyaute;
	private int attaque;
	private int defense;
	private int attaqueSpeciale;
	private int defenseSpeciale;
	private int hp;
	private Attaque[] attaques = new Attaque[4];
	
	public Pokemons(String nom, String type, int niveau, boolean diurne, String nomDonne, Joueur monJoueur, 
			int attaque, int defense, int attaqueSpeciale, int defenseSpeciale, Attaque[] attaques) {
		this.nom = nom;
		this.type = type;
		this.setNiveau(niveau);
		this.diurne = diurne;
		this.nomDonne = nomDonne;
		this.monJoueur = monJoueur;
		this.appetit = 50;
		this.loyaute = 0;
		this.attaque = attaque;
		this.defense = defense;
		this.attaqueSpeciale = attaqueSpeciale;
		this.defenseSpeciale = defenseSpeciale;
		this.hp = 30;
		
		for(int i=0; i < attaques.length; i++) /* temps que la liste d'attaques en entré n'est pas fini cela continura a ajouter des attaques mais lorsque le tableau d'attaque du pokemon sera plein cela n'ajoutera plus aucune attaque car plus de place vide*/
			this.ajouterAttaque(attaques[i]);
	}
	
	public Pokemons(String nom, String type, int niveau, boolean diurne, int attaque, int defense, int attaqueSpeciale, int defenseSpeciale, Attaque[] attaques) {
		this(nom, type, niveau, diurne, null, null, attaque,defense,attaqueSpeciale, defenseSpeciale, attaques);
	}
	
	public void direBonjour(String periodeDeLaJournee) {
		if((this != null) && (periodeDeLaJournee.equals("jour") || periodeDeLaJournee.equals("nuit"))) {
			if(periodeDeLaJournee.equals("jour")) {
				if(this.diurne == true)
					System.out.println(this.nom + " dit Bonjour !"); // jour + diurne
		
				else
					System.out.println(this.nom + " dort, zzzzzzz"); // jour + nocturne
			}
			else {
				if(periodeDeLaJournee.equals("nuit")) {
					if(this.diurne == true)
						System.out.println(this.nom + " dort, zzzzzzz"); // nuit + diurne
			
					else
						System.out.println(this.nom + " dit Bonsoir !"); // nuit + nocturne
				}
			}
		}
	}
	
	public void sePresenter(){
		System.out.println("Voici un pokemon " + this.nom + " de niveau " + this.getNiveau());
		
		if(this.monJoueur != null)
			System.out.println("Il appartient à " + this.monJoueur.getNom());
		
		if(this.nomDonne != null)
			System.out.println("Il s'appelle" + this.nomDonne);
	}
	
	private int trouverAttaque(Attaque attaque) {
		boolean attaqueTrouve = false;
		int compteur = 0;
		
		while (compteur<this.attaques.length && !attaqueTrouve) {
			if(this.attaques[compteur]==attaque) {
				return compteur;
			}
			compteur++;
		}
		return -1;
		
	}

	public void rechargerAttaques() {
		for (int i = 0; i<this.attaques.length; i++) {
			if(this.attaques[i] != null)
				this.attaques[i].resetPP();
		}
	}

	public void ajouterAttaque(Attaque attaque) {
		if(attaque != null) {
			int placeDispo = this.trouverAttaque(null);
			if(attaque.isCompatible(this) && placeDispo != -1) {
				this.attaques[placeDispo] = attaque;
				System.out.println(this.getNom() + " a bien apprit " +attaque.getNom());
			}
		}
	}
	
	public void blessure(int dommage) {
		if(this.hp - dommage >= 0)
			this.hp -= dommage;
		
		else
			this.hp = 0;
	}
	
	public boolean sEstEvanoui() {
		return (this.hp == 0);
	}
	
	public void utiliserAttaque(int index, Pokemons victime) {
		if(index >= 0 && index <= this.attaques.length-1 && victime != null) {
			this.attaques[index].utiliserAttaque(this, victime);
			System.out.println(this.nom + " utilise " + this.attaques[index].getNom());
		}
	}
	
	public void afficherEtatAttaques() {
		for(int i = 0; i < this.attaques.length -1; i++) {
			if(this.attaques[i] != null) {
				System.out.println(i + " : " + this.attaques[i].getNom() + ", " + this.attaques[i].getPpRestant() + "/" + this.attaques[i].getPp() );
			}
		}
	}

	public String toString() {
		String attaques = "{";
		for( int i = 0; i <this.attaques.length-1; i++) {
			if(this.attaques[i] != null && i == 1)
				attaques += this.attaques[i].getNom();
			
			if(this.attaques[i] != null)
				attaques += ", " + this.attaques[i].getNom();
		}
		attaques += "}";
		
		if(this.diurne == true) {
			if(this.monJoueur != null)
				if(this.nomDonne != null)
					return "Pokemon[" + this.nom+", " + this.type + ", " + this.niveau + ", diurne, " + this.nomDonne + ", " + this.monJoueur.getNom() + ", " + this.appetit + ", "+ this.loyaute + ", " + this.hp + ", " + this.attaque + ", " + this.defense + ", " + this.attaqueSpeciale + ", " + this.defenseSpeciale + ", attaques : " + attaques + "]" ;
				else
					return "Pokemon[" + this.nom+", " + this.type + ", " + this.niveau + ", diurne, " + this.monJoueur.getNom() + ", " + this.appetit + ", "+ this.loyaute + ", " + this.hp + ", " + this.attaque + ", " + this.defense + ", " + this.attaqueSpeciale + ", " + this.defenseSpeciale + ", attaques : " + attaques + "]" ;
			else
				return "Pokemon[" + this.nom+", " + this.type + ", " + this.niveau + ", diurne, " + this.appetit + ", "+ this.loyaute + ", " + this.hp + ", " + this.attaque + ", " + this.defense + ", " + this.attaqueSpeciale + ", " + this.defenseSpeciale + ", attaques : " + attaques + "]" ;
		}
		
		else {
			if(this.monJoueur != null)
				if(this.nomDonne != null)
					return "Pokemon[" + this.nom+", " + this.type + ", " + this.niveau + ", nosturne, " + this.nomDonne + ", " + this.monJoueur.getNom() + ", " + this.appetit + ", "+ this.loyaute + ", " + this.hp + ", " + this.attaque + ", " + this.defense + ", " + this.attaqueSpeciale + ", " + this.defenseSpeciale + ", attaques : " + attaques + "]" ;
				else
					return "Pokemon[" + this.nom+", " + this.type + ", " + this.niveau + ", nocturne, " + this.monJoueur.getNom() + ", " + this.appetit + ", "+ this.loyaute + ", " + this.hp + ", " + this.attaque + ", " + this.defense + ", " + this.attaqueSpeciale + ", " + this.defenseSpeciale + ", attaques : " + attaques + "]" ;
			else
				return "Pokemon[" + this.nom+", " + this.type + ", " + this.niveau + ", nocturne, " + this.appetit + ", "+ this.loyaute + ", " + this.hp + ", " + this.attaque + ", " + this.defense + ", " + this.attaqueSpeciale + ", " + this.defenseSpeciale + ", attaques : " + attaques + "]" ;
		}
	}
	
	//modification appetit
	
	public void baisserAppetit(int difference) {
		
		if (this.appetit - difference>= 0)
			this.setAppetit(this.appetit - difference);
		
		else
			this.setAppetit(0);
	}
	
	public void monterAppetit(int difference) {
		
		if (this.appetit + difference <= 100)
			this.setAppetit(this.appetit + difference);
		
		else
			this.setAppetit(100);
	}
	
	// Modification loyauté 
	
	public void baisserLoyaute(int difference) {
		
		if (this.loyaute - difference>= 0)
			this.setLoyaute(this.loyaute - difference);
		
		else
			this.setLoyaute(0);
	}
	
	public void monterLoyaute(int difference) {
		
		if (this.loyaute + difference < 100) {
			this.setLoyaute(this.loyaute + difference);
			System.out.println("Mmmmmmmmmm, c'est bon !!!!");
		}
		else {
			this.setLoyaute(100);
			System.out.println("oui, moi aussi je t'aime !");
		}
	}
	
	
	public void utiliser(Utilisable item) {
		if(item != null) {
			if(this.monJoueur != null) {
				int index;
				index = this.monJoueur.trouverPokemon(this);
				if(index != -1 ) {
					item.utiliser(this.monJoueur, index);
					System.out.println("L'objet " + item + " a bien été utilisé sur " + this.getNom());
				}
			}
			else
				System.out.println("Cet un pokemon sauvage et ne peut donc pas recevoir d'items utilisables");
		}		
		else
			System.out.println("Rien en entrée");
	}
	
	public void mettreANiveau() {
		this.setNiveau(this.getNiveau() + 1); 
	}
	
	// getter and setter
	
	public String getNomDonne() {
		return nomDonne;
	}

	public void setNomDonne(String nomDonne) {
		this.nomDonne = nomDonne;
	}

	public Joueur getMonJoueur() {
		return monJoueur;
	}
	public void setMonJoueur(Joueur monJoueur) {
		this.monJoueur = monJoueur;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getAppetit() {
		return appetit;
	}
	public void setAppetit(int appetit) {
		this.appetit = appetit;
	}

	public int getLoyaute() {
		return loyaute;
	}
	public void setLoyaute(int loyaute) {
		this.loyaute = loyaute;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	
	public int getAttaque() {
		return attaque;
	}

	public int getDefense() {
		return defense;
	}

	public int getAttaqueSpeciale() {
		return attaqueSpeciale;
	}

	public int getDefenseSpeciale() {
		return defenseSpeciale;
	}

	public int getHp() {
		return hp;
	}

	public Attaque[] getAttaques() {
		return attaques;
	}


}
