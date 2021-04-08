package tp7_8_v2;

public class Jouet extends Item implements Utilisable, Modifiable {
	
	private int apportAppetit;
	private int apportLoyaute;
	
	public Jouet(String nom, int frequence, int nombreUtilisations, int apportAppetit, int apportLoyaute) {
		super(nom, frequence, nombreUtilisations);
		this.apportAppetit = apportAppetit;
		this.apportLoyaute = apportLoyaute;
	}

	@Override
	public void modifier() {
		this.setNom(this.nom + " magique");
		this.apportAppetit += 10;
		this.apportLoyaute += 5;
		this.resetUti();
		System.out.println("Transformation reussite");
	}

	@Override
	public void utiliser(Joueur joueur, int indexPokemon) {
		if (null != joueur && indexPokemon >= 0 && indexPokemon < joueur.getEquipe().length) {
			if (null != joueur.getEquipe()[indexPokemon] && this.nbUtiRest > 0) {
				joueur.getEquipe()[indexPokemon].monterAppetit(this.apportAppetit);
				joueur.getEquipe()[indexPokemon].monterLoyaute(this.apportLoyaute);
				this.baisserUti(1);
				System.out.println("Wow, j'adore ce jouet ! On joue encore une fois ?");
			}
		}
	}

	@Override
	public Item genererMemeItem(boolean generer) {
		if(generer) {
			return new Jouet(this.nom, this.frequence, this.nbUti, this.apportAppetit, this.apportLoyaute);
		}
		return null;
	}
	
	public String toString() {
		return (super.toString() + ", " + this.apportAppetit + ", " + this.apportLoyaute);
	}

	public int getApportAppetit() {
		return apportAppetit;
	}

	public int getApportLoyaute() {
		return apportLoyaute;
	}

}
