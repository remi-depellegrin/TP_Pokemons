package tp7_8_v2;

public class Nourriture extends Item implements Utilisable {

	protected int apport;
	protected String[] compatibilites;
	public static String[] tousLesTypesDePokemon = {"ACIER","COMBAT","DRAGON","EAU","ELECTRIQUE","FEE","FEU","GLACE","INSECTE","NORMAL","PALNTE","POISON","PSY","ROCHE","SOL","SPECTRE","TENEBRES","VOL"};
	
	public Nourriture(String nom, int frequence, int apport, String[] compatibilites) {
		super(nom, frequence, 1);
		this.apport = apport;
		this.compatibilites = compatibilites;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void utiliser(Joueur joueur, int indexPokemon) {
		if (null != joueur && indexPokemon >= 0 && indexPokemon < joueur.getEquipe().length) {
			if (null != joueur.getEquipe()[indexPokemon] && this.nbUtiRest > 0) {
				joueur.getEquipe()[indexPokemon].baisserAppetit(this.apport);
				this.baisserUti(1);
			}
		}

	}

	@Override
	public Item genererMemeItem(boolean generer) {
		
		if(generer) {
			return new Nourriture(this.nom, this.frequence, this.apport, this.compatibilites);
		}
		return null;
	}

	@Override
	public String toString() {
		String listeCompatibilites = "{";
		for (int i = 0; i < this.compatibilites.length-1; i++) {
			listeCompatibilites += this.compatibilites[i] + ",";
		}
		listeCompatibilites += this.compatibilites[this.compatibilites.length-1] + "}";
		
		return (super.toString() + ", " + this.apport + ", " + listeCompatibilites);
	}
	
	public boolean isCompatible(Pokemons pokemon) {
		
		boolean trouve = false;
		int i = 0;
		
		while(null != pokemon && i<this.compatibilites.length && !trouve) {
			if (this.compatibilites[i].equals(pokemon.getType())) {
				trouve = true;
			}
			i++;
		}
		
		if (null != pokemon && !trouve) {
			System.out.println("Un pokemon de type " + pokemon.getType() + " n'est pas compatible avec une nourriture de type " + this.getNom() + ".");
		}
		return trouve;
	}
	
	
	
	public int getApport() {
		return apport;
	}

	public String[] getCompatibilites() {
		return compatibilites;
	}
}
