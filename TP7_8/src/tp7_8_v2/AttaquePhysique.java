package tp7_8_v2;
import java.util.Random;

public class AttaquePhysique extends Attaque {

	public AttaquePhysique(String nom, int puissance, int precision, int pp) {
		super(nom, puissance, precision, pp);
	}

	@Override
	public void utiliserAttaque(Pokemons attaquant, Pokemons victime) {
		if(attaquant != null && victime != null && this.ppRestant >0) {
			if(this.getPpRestant()>0) {
				Random random = new Random();
				int aleaAttaquant = random.nextInt(attaquant.getNiveau());
				int aleaDefenseur = random.nextInt(victime.getNiveau());
				int aleaPrecision = random.nextInt(100);
				
				if((attaquant.getAttaque() + aleaAttaquant > victime.getDefense() + aleaDefenseur) && aleaPrecision <= this.getPrecision() ){
					int aleaDommage = random.nextInt(this.puissance);
					victime.blessure(aleaDommage);
					this.baisserPP();
					System.out.println("Succes, " + victime.getNom() + " a perdu " + aleaDommage + " hp");
				}
			}
		}

	}
	
	@Override
	public boolean isCompatible(Pokemons pokemon) {
		if(pokemon == null )
			return false;
		
		else
			return true;
	}

}
