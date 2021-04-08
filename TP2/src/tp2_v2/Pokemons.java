package tp2_v2;

public class Pokemons {
	private String nom;
	private String type;
	private int niveau;
	private boolean diurne;
	private String nomDonne;
	private Joueur monJoueur;
	
	public Pokemons(String nom, String type, int niveau, boolean diurne, String nomDonne, Joueur monJoueur) {
		this.nom = nom;
		this.type = type;
		this.niveau = niveau;
		this.diurne = diurne;
		this.nomDonne = nomDonne;
		this.monJoueur = monJoueur;
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
		System.out.println("Voici un pokemon " + this.nom + " de niveau " + this.niveau);
		
		if(this.monJoueur != null)
			System.out.println("Il appartient à " + this.monJoueur.getNom());
		
		if(this.nomDonne != null)
			System.out.println("Il s'appelle" + this.nomDonne);
	}
	
	
	public String toString() {
		if(this.diurne == true)
			return "Pokemon[" + this.nom+", " + this.type + ", " + this.niveau + ", diurne, " + this.nomDonne + ", " + this.monJoueur.getNom() + "]" ;
		
		else
			return "Pokemon[" + this.nom+", " + this.type + ", " + this.niveau + ", nocturne, " + this.nomDonne + ", " + this.monJoueur.getNom() + "]" ;
	}
	
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
}
