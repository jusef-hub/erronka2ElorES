package modelo;

import java.io.Serializable;

public class ReunionDTO implements Serializable {
	
    private Integer id;
    private String titulo;
    private String asunto;
    private String estado;   
    private String aula;
    
    private String fecha;

    private String nombreAlumno;
    private String nombreProfesor;

    public ReunionDTO() {
	}

    public Integer getId() { 
        return id; 
    }
    public void setId(Integer id) { 
        this.id = id; 
    }

    public String getTitulo() { 
        return titulo; 
    }
    public void setTitulo(String titulo) { 
        this.titulo = titulo; 
    }

    public String getAsunto() { 
        return asunto; 
    }
    public void setAsunto(String asunto) { 
        this.asunto = asunto; 
    }

    public String getEstado() { 
        return estado; 
    }
    public void setEstado(String estado) { 
        this.estado = estado; 
    }
    
    public String getAula() { 
        return aula; 
    }
    public void setAula(String aula) { 
        this.aula = aula; 
    }

    
    public String getFecha() { 
        return fecha; 
    }
    public void setFecha(String fecha) { 
        this.fecha = fecha; 
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }
    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }
    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }
}