package tp4_v2;

public class Gourmandise extends Nourriture {
	private int apportLoyaute;

	public Gourmandise(int apport, String nom, String[] compatibilites, int frequence, int apportLoyaute) {
		super(apport, nom, compatibilites, frequence);
		this.apportLoyaute = apportLoyaute;
	}
	
	@Override
	public Gourmandise genererMemeNourriture(boolean generer) {
		if(generer)
			return new Gourmandise(this.apport, this.nom, this.compatibilites, this.frequence, this.apportLoyaute);
		
		else
			return null;
	}
	
	@Override
	public void estMangee(Pokemons pokemon) {
		if(pokemon != null) {
			pokemon.baisserAppetit(this.apport);
			if(pokemon.getMonJoueur()!= null) {
				pokemon.monterLoyaute(this.apportLoyaute);
			}
		}
	}
	
	public String toString() {
		String compatibilites = "{";
		for(int i = 0; i<this.compatibilites.length-1; i++) {
			compatibilites += this.compatibilites[i] + ", ";
		}
		compatibilites += this.compatibilites[this.compatibilites.length-1];
		return ("Gourmandise : "+ this.apportLoyaute + ", " + this.nom + ", " + this.apport + ", " + this.frequence + "/100, " + compatibilites + "}" ) ;
	}
	
	/* Getters and setters */
	public int getApportLoyaute() {
		return apportLoyaute;
	}

	public void setApportLoyaute(int apportLoyaute) {
		this.apportLoyaute = apportLoyaute;
	}
}
