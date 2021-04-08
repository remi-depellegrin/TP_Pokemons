package tp7_8_v2;

public class Outils extends Item implements ChangerItems {

	public Outils(String nom, int frequence, int nbUti) {
		super(nom, frequence, nbUti);
	}

	@Override
	public void changer(Modifiable item) {
		if(item != null && this.nbUtiRest >0) {
			item.modifier();
			this.baisserUti(1);
		}
	}

	@Override
	public Item genererMemeItem(boolean generer) {
		
		if(generer) {
			return new Outils(this.nom, this.frequence, this.nbUti);
		}
		return null;
	}

}
