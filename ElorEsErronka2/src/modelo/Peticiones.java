package modelo;

public class Peticiones {
	
    public enum KontzultaMota { Login, IrakasleakLortu, IkasleLortu, IrakasleakLortuByName, OrdutegiaLortu, BilerakLortu, UpdateBilera, UpdateUser };

    private static final long serialVersionUID = 1L; // Control de versión
    
    private KontzultaMota km;
    private String[] credentials;
    private String izena;
    
    
    public Peticiones(KontzultaMota km) {
        this.km = km;
    }
    
    public Peticiones(KontzultaMota km, String[] credentials) {
        this.km = km;
        this.credentials = credentials;
    }
    
    public Peticiones(KontzultaMota km, String izena) {
		this.km = km;
		this.izena = izena;
	}
    
    public KontzultaMota getKm() {
        return km;
    }

}
