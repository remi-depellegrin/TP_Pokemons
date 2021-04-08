package tp7_8_v2;

public abstract class Item {
	protected String nom;
	protected int frequence;
	protected int nbUti;
	protected int nbUtiRest;
	
	public Item(String nom, int frequence, int nbUti) {
		this.nom = nom;
		this.frequence = frequence;
		this.nbUti = nbUti;
		this.nbUtiRest = nbUti;
	}
	
	
	public String toString() {
		return(this.nom + " : " + this.frequence + ", " + this.nbUtiRest + "/" + this.nbUti);
	}
	
	public void monterUti(int difference) {
		if (this.nbUtiRest + difference <= this.nbUti) {
			this.nbUtiRest += difference;
		}
		else
			this.nbUtiRest = this.nbUti;
	}
	
	public void baisserUti(int difference) {
		if (this.nbUtiRest - difference >= 0) {
			this.nbUtiRest -= difference;
		}
		else
			this.nbUtiRest = 0;
	}
	
	public abstract Item genererMemeItem(boolean generer);

	public void resetUti() {
		this.nbUtiRest = this.nbUti;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getFrequence() {
		return frequence;
	}

	public void setFrequence(int frequence) {
		this.frequence = frequence;
	}

	public int getNbUti() {
		return nbUti;
	}

	public void setNbUti(int nbUti) {
		this.nbUti = nbUti;
	}

	public int getNbUtiRest() {
		return nbUtiRest;
	}

	public void setNbUtiRest(int nbUtiRest) {
		this.nbUtiRest = nbUtiRest;
	}	
}
