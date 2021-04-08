package tp6_v2;

public abstract class Attaque {
	protected String nom;
	protected String[] compatibilites;
	protected int puissance;
	protected int precision;
	protected int pp; /* = nombre de répétitions */
	protected int ppRestant;
	public static String[] tousLesTypesDePokemon = {"ACIER","COMBAT","DRAGON","EAU","ELECTRIQUE","FEE","FEU","GLACE","INSECTE","NORMAL","PALNTE","POISON","PSY","ROCHE","SOL","SPECTRE","TENEBRES","VOL"};

	public Attaque(String nom, String[] compatibilites, int puissance, int precision, int pp) {
		this.nom =nom;
		this.compatibilites = compatibilites;
		this.puissance = puissance;
		this.precision = precision;
		this.pp = pp;
		this.ppRestant = pp;
	}
	
	public Attaque(String nom, int puissance, int precision, int pp) {
		this(nom, tousLesTypesDePokemon, puissance, precision, pp);
	}
	
	public void resetPP() {
		this.ppRestant = this.pp;
	}
	
	public void baisserPP() {
		if(this.ppRestant - 1 >= 0)
			this.ppRestant -= 1;
		
		else
			this.ppRestant = 0;
	}
	
	public abstract void utiliserAttaque(Pokemons attaquant, Pokemons victime);
	
	public abstract boolean isCompatible(Pokemons pokemon);
	
	public String toString() {
		String compatibilites = "{";
		for(int i = 0; i<this.compatibilites.length-1; i++) {
			compatibilites += this.compatibilites[i] + ", ";
		}
		compatibilites += this.compatibilites[this.compatibilites.length-1] + "}";
		
		return (this.nom + " : " + this.puissance + ", " + this.precision + ", " + this.ppRestant + "/" + this.pp + ", " + compatibilites);
	}
	
	/* Getter et setter */
	
	public String getNom() {
		return nom;
	}

	public String[] getCompatibilites() {
		return compatibilites;
	}

	public int getPuissance() {
		return puissance;
	}

	public int getPrecision() {
		return precision;
	}

	public int getPp() {
		return pp;
	}

	public int getPpRestant() {
		return ppRestant;
	}

	public static String[] getTousLesTypesDePokemon() {
		return tousLesTypesDePokemon;
	}
}
