package tp1;

public class Pokemon {
	private String nom;
	private String type;
	private int niveau;
	private boolean diurne;
	
	public Pokemon(String nom, String type, int niveau, boolean diurne) {
		this.nom = nom;
		this.type = type;
		this.niveau = niveau;
		this.diurne = diurne;
	}
	
	public String toString() {
		return ("Pokemon[" + this.nom + ", " + this.type + ", " + this.niveau + "," + this.diurne + "]");
	}
	
	public void direBonjour(String periodeDeLaJournee) {
		if (periodeDeLaJournee.equals("jour")) {
			if (this.diurne) {
				System.out.println(this.nom +" dit bonjour !");
			}
			else {
				System.out.println(this.nom + " dit zzzzzzzzzzzzz !");
			}
		}
		else {
			if (this.diurne) {
				System.out.println(this.nom + " dit zzzzzzzzzzzzz !");
			}
			else {
				System.out.println(this.nom + " dit bonsoir !");
			}
		}
		
	}
}
