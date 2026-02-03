package modelo;

public class MatriculacionDTO {
    private Integer id;
    private UserDTO alumno; 
    private Ciclo ciclo;    

    public Integer getId() {
    	return id; 
    }
    public void setId(Integer id) {
    	this.id = id; 
    }
    
    public UserDTO getAlumno() { 
    	return alumno;
    }
    public void setAlumno(UserDTO alumno) { 
    	this.alumno = alumno;
    }
    
    public Ciclo getCiclo() {
    	return ciclo; 
    }
    public void setCiclo(Ciclo ciclo) { 
    	this.ciclo = ciclo; 
    }
}