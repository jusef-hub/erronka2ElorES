package modelo;

public class Modulo {
    private Integer id;
    private String nombre;
    private Ciclo ciclo; //relacion con ciclo

    public Integer getId() { 
    	return id; 
    }
    public void setId(Integer id) {
    	this.id = id;
    }
    public String getNombre() { 
    	return nombre; 
    }
    public void setNombre(String nombre) {
    	this.nombre = nombre; 
    }
    public Ciclo getCiclo() {
    	return ciclo;
    }
    public void setCiclo(Ciclo ciclo) {
    	this.ciclo = ciclo; 
    }
}