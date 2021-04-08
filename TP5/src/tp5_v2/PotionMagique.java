package tp5_v2;

public class PotionMagique extends Nourriture {
	public PotionMagique(String nom, int frequence) {
		super(0, nom, tousLesTypesDePokemon, frequence);
	}
	
	@Override
	public PotionMagique genererMemeNourriture(boolean generer) {
		if(generer)
			return new PotionMagique(this.nom, this.frequence);
		
		else
			return null;
	}
	
	@Override
	public void estMangee(Pokemons pokemon) {
		if(pokemon != null) {
			pokemon.setNiveau(pokemon.getNiveau() +1);
		}
	}
	
	public String toString() {
		String compatibilites = "{";
		for(int i = 0; i<this.compatibilites.length-1; i++) {
			compatibilites += this.compatibilites[i] + ", ";
		}
		compatibilites += this.compatibilites[this.compatibilites.length-1];
		return ("Potion Magique : " + this.nom + ", 0, " + this.frequence + "/100, " + compatibilites + "}" ) ;
	}
}
