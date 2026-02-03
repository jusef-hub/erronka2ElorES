package modelo;


public class HorarioDTO {
    private Integer id;
    private String dia;      
    private int hora;       
    private String aula;
    private String modulo; 
    private String observaciones;
    
    // Constructor vacío (Obligatorio para Gson)
    public HorarioDTO() {
    }
    
    // --- GETTERS Y SETTERS CORREGIDOS ---

    public Integer getId() { 
        return id; 
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getDia() { 
        return dia; 
    }
    public void setDia(String dia) {
        this.dia = dia; 
    }
    
    // OJO: Devuelve int, no String
    public int getHora() {
        return hora; 
    }
    public void setHora(int hora) {
        this.hora = hora; 
    }
    
    public String getAula() {
        return aula;
    }
    public void setAula(String aula) {
        this.aula = aula;
    }

    // OJO: Devuelve String, no Modulo
    public String getModulo() {
        return modulo; 
    }
    public void setModulo(String modulo) {
        this.modulo = modulo; 
    }

    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}