package tp1;

public class Pokemons {
	private String nom;
	private String type;
	private int niveau;
	private boolean diurne;
	
	public Pokemons(String nom, String type, int niveau, boolean diurne){
		this.nom = nom;
		this.type = type;
		this.niveau = niveau;
		this.diurne = diurne;
	}
	
	public void direBonjour(String periodeDeLaJournee) {
		if((this != null) && (periodeDeLaJournee.equals("jour") || periodeDeLaJournee.equals("nuit"))) {
			if(periodeDeLaJournee.equals("jour")) {
				if(this.diurne)
					System.out.println(this.nom + " dit Bonjour !"); // jour + diurne
		
				else
					System.out.println(this.nom + " dort, zzzzzzz"); // jour + nocturne
			}
			else {
				if(periodeDeLaJournee.equals("nuit")) {
					if(this.diurne)
						System.out.println(this.nom + " dort, zzzzzzz"); // nuit + diurne
			
					else
						System.out.println(this.nom + " dit Bonsoir !"); // nuit + nocturne
				}
			}
		}
	}
	
	public String toString() {
		if(this.diurne == true)
			return "Pokemon[" + this.nom+", " + this.type + ", " + this.niveau + ", diurne]";
		
		else
			return "Pokemon[" + this.nom+", " + this.type + ", " + this.niveau + ", nocturne]";
	}
}
