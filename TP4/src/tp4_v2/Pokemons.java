package tp4_v2;

public class Pokemons {
	private String nom;
	private String type;
	private int niveau;
	private boolean diurne;
	private String nomDonne;
	private Joueur monJoueur;
	private int appetit;
	private int loyaute;
	
	public Pokemons(String nom, String type, int niveau, boolean diurne, String nomDonne, Joueur monJoueur) {
		this.nom = nom;
		this.type = type;
		this.setNiveau(niveau);
		this.diurne = diurne;
		this.nomDonne = nomDonne;
		this.monJoueur = monJoueur;
		this.appetit = 50;
		this.loyaute = 0;
	}
	
	public Pokemons(String nom, String type, int niveau, boolean diurne) {
		this(nom, type, niveau, diurne, null, null);
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
	
	
	public String toString() {
		if(this.diurne == true) {
			if(this.monJoueur != null)
				return "Pokemon[" + this.nom+", " + this.type + ", " + this.niveau + ", diurne, " + this.nomDonne + ", " + this.monJoueur.getNom() + ", " + this.appetit + ", "+ this.loyaute + "]" ;
		
			else
				return "Pokemon[" + this.nom+", " + this.type + ", " + this.niveau + ", diurne, " + this.nomDonne + ", " + this.appetit + ", "+ this.loyaute + "]" ;
		}
		
		else {
			if(this.monJoueur != null)
				return "Pokemon[" + this.nom+", " + this.type + ", " + this.niveau + ", nocturne, " + this.nomDonne + ", " + this.monJoueur.getNom()+ ", " + this.appetit + ", "+ this.loyaute + "]" ;
			
			else
				return "Pokemon[" + this.nom+", " + this.type + ", " + this.niveau + ", nocturne, " + this.nomDonne + ", " + this.appetit + ", "+ this.loyaute + "]" ;
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
		
		if (this.loyaute + difference <= 100)
			this.setLoyaute(this.loyaute + difference);
		
		else
			this.setLoyaute(100);
	}
	
	
	public void manger(Nourriture nourriture) {
		nourriture.estMangee(this);
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

}
