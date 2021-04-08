package tp7_8_v2;

public class PotionMagique extends Nourriture{
	public PotionMagique(String nom, int frequence) 
	{
		super(nom, frequence, 0, tousLesTypesDePokemon);
	}

	@Override
	public Item genererMemeItem(boolean generer) {
        if (generer ) {
            return new PotionMagique(this.nom, this.frequence);
        }
        return null;
    }
	
	@Override
	public void utiliser(Joueur joueur, int IndexPokemon) 
	{
		if(joueur.equals(null) || (IndexPokemon > joueur.getEquipe().length) || (IndexPokemon < joueur.getEquipe().length)) 
		{
			if((joueur.getEquipe()[IndexPokemon] == null) || (this.isCompatible(joueur.getEquipe()[IndexPokemon]) == false) || (this.nbUtiRest == 0)) 
			{
				System.out.println("Problème de paramètres");
			}
		}
		else 
		{
			
			joueur.getEquipe()[IndexPokemon].mettreANiveau();
		}
	}
}
