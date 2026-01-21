package modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * TiposDTO
 */
public class TiposDTO implements Serializable {
    
    private static final long serialVersionUID = 6357334177154530544L; // Fijo y único
    
    private int id;
    private String name;
    private String nameEus;
    private Set<UsersDTO> userses = new HashSet<>(0);

    public TiposDTO() {
    }

    public TiposDTO(int id) {
        this.id = id;
    }

    public TiposDTO(int id, String name, String nameEus, Set<UsersDTO> userses) {
        this.id = id;
        this.name = name;
        this.nameEus = nameEus;
        this.userses = userses;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEus() {
        return this.nameEus;
    }

    public void setNameEus(String nameEus) {
        this.nameEus = nameEus;
    }

    public Set<UsersDTO> getUserses() {
        return this.userses;
    }

    public void setUserses(Set<UsersDTO> userses) {
        this.userses = userses;
    }

    @Override
    public String toString() {
        return "TiposDTO [id=" + id + ", name=" + name + ", nameEus=" + nameEus + ", userses=" + userses + "]";
    }
}