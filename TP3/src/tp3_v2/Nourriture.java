package tp3_v2;

public class Nourriture {
	private int apport;
	private String nom;
	private String[] compatibilites; // la taille de tableau compatibilites dépendra du nombre d'éléments différents (glace, feu, plante, ...)
	private int frequence;

	public Nourriture(int apport, String nom, String[] compatibilites, int frequence) {
		super();
		this.apport = apport;
		this.nom = nom;
		this.compatibilites = compatibilites;
		this.frequence = frequence;
	}
	
	public boolean isCompatible(Pokemons pokemon) {
		int i = 0;
		boolean compatible = false;
		while (i <this.compatibilites.length && !compatible) {
			if(this.compatibilites[i].equals(pokemon.getType())) {
				compatible = true;
			}
			i++;
		}
		if(!compatible) {
			System.out.println("Un pokemon de type " + pokemon.getType() + " ne peut pas manger de " + this.nom);
		}
		return compatible;
	}
	
	public Nourriture genererMemeNourriture(boolean generer) {
		if(generer)
			return new Nourriture(this.apport, this.nom, this.compatibilites, this.frequence);
		
		else
			return null;
	}
	
	
	
	public String toString() {
		String compatibilites = "{";
		for(int i = 0; i<this.compatibilites.length-1; i++) {
			compatibilites += this.compatibilites[i] + ", ";
		}
		compatibilites += this.compatibilites[this.compatibilites.length-1];
		return("[" + this.nom + "; " + this.apport + "; " + this.frequence + "/100; " +compatibilites +"}]");
	}
	
	// getter and setter
	public int getApport() {
		return apport;
	}
	public void setApport(int apport) {
		this.apport = apport;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String[] getCompatibilites() {
		return compatibilites;
	}
	public void setCompatibilites(String[] compatibilites) {
		this.compatibilites = compatibilites;
	}
	
	public int getFrequence() {
		return frequence;
	}
	public void setFrequence(int frequence) {
		this.frequence = frequence;
	}
	
}
