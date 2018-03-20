package com.rodrigo.TFG_server.Negocio.Modulo_Departamento.Entidad;

import com.rodrigo.TFG_server.Negocio.Modulo_Empleado.Entidad.Empleado;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@Entity
@NamedQueries({
        @NamedQuery(name = "Departamento.listar", query = "FROM Departamento"),
        @NamedQuery(name = "Departamento.buscarPorSiglas", query = "from Departamento e where e.siglas = :siglas")

})
@XmlRootElement(name = "Departamento")
public class Departamento implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO) //IDENTITY
    @Column/*(name = "id_depart")*/
    @Id protected Long id;

    @NotBlank
    @Column(nullable = false)
    private String nombre;


    @NotBlank
    @Column(nullable = false, unique = true)
    private String siglas;
    
    @OneToMany/*(mappedBy = "empleado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)*/
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Empleado> empleados;

    @Version protected long version;


    /****************************
     ******* CONSTRUCTORES ******
     ****************************/


    public Departamento(String nombre, String password) {
        this.nombre = nombre;
        this.siglas = nombre.toLowerCase().concat("@gmail.com");
    }


    public Departamento(Long id, String nombre, String password, String siglas, long version) {
        this.id = id;
        this.nombre = nombre;
        this.siglas = siglas;
        this.version = version;
    }

    public Departamento(String nombre, String password, String siglas) {
        this.nombre = nombre;
        this.siglas = siglas;

    }

    public Departamento() {
    }

    /****************************
     **** GETTERS AND SETTERS ***
     ****************************/

    @XmlElement(name = "id", required = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(name = "nombre", required = true)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @XmlElement(name = "version", required = true)
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @XmlElement(name = "siglas", required = true)
    public String getSiglas() { return siglas;}

    public void setSiglas(String siglas) {this.siglas = siglas;}



    /****************************
     ****** OTHER METHODS *******
     ****************************/

    @Override
    public String toString() {
        return "Departamento{" +
                "  id=" + id +
                ", nombre='" + nombre + '\'' +
                ", mail='" + siglas + '\'' +
                ", version=" + version +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Departamento)) return false;
        Departamento depto = (Departamento) o;
        return getVersion() == depto.getVersion() &&
                Objects.equals(getId(), depto.getId()) &&
                Objects.equals(getNombre(), depto.getNombre()) &&
                Objects.equals(getSiglas(), depto.getSiglas());
    }

    public boolean equalsWithOutVersion(Object o) {
        if (this == o) return true;
        if (!(o instanceof Departamento)) return false;
        Departamento dpto = (Departamento) o;
        return  Objects.equals(getId(), dpto.getId()) &&
                Objects.equals(getNombre(), dpto.getNombre()) &&
                Objects.equals(getSiglas(), dpto.getSiglas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre(), getVersion());
    }
}
