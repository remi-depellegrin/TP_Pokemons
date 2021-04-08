package tp7_8_v2;

public class Gourmandise extends Nourriture {
	private int apportLoyaute;

	public Gourmandise(String nom, int frequence, int apport, String[] compatibilites, int apportLoyaute) {
		super(nom, frequence, apport, compatibilites);
		this.apportLoyaute = apportLoyaute;
	}
	
	@Override
	public Item genererMemeItem(boolean generer){
		if(generer)
			return new Gourmandise(this.nom, this.frequence, this.apport, this.compatibilites, this.apportLoyaute);
		
		else
			return null;
	}
	
	@Override
	public void utiliser(Joueur joueur, int IndexPokemon) 
	{
		if(joueur.equals(null) || (IndexPokemon > joueur.getEquipe().length) || (IndexPokemon < joueur.getEquipe().length)) 
		{
			if((joueur.getEquipe()[IndexPokemon] == null) || (this.isCompatible(joueur.getEquipe()[IndexPokemon]) == false) || (this.nbUtiRest == 0)) 
			{
				System.out.println("le pokemon entré est null, n'est pas compatible ou l'objet n'a plus d'utilisations");
			}
			else
				System.out.println("Joueur null, index trop grand ou index trop petit");
		}
		else 
		{
			this.baisserUti(1);
			joueur.getEquipe()[IndexPokemon].baisserAppetit(this.apport);
			joueur.getEquipe()[IndexPokemon].monterLoyaute(this.apportLoyaute);
		}
	}

	public String toString() {
		String compatibilites = "{";
		for(int i = 0; i<this.compatibilites.length-1; i++) {
			compatibilites += this.compatibilites[i] + ", ";
		}
		compatibilites += this.compatibilites[this.compatibilites.length-1];
		return(this.nom+ "; " + this.frequence + ", " + this.nbUtiRest + "/" + this.nbUti + this.apport  +compatibilites +"}");
	}
	
	public int getApportLoyaute() {
		return apportLoyaute;
	}
}
