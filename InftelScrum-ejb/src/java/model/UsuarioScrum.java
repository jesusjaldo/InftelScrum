/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author inftel20
 */
@Entity
@Table(name = "USUARIO_SCRUM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioScrum.findAll", query = "SELECT u FROM UsuarioScrum u"),
    @NamedQuery(name = "UsuarioScrum.findByIdUsuario", query = "SELECT u FROM UsuarioScrum u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "UsuarioScrum.findByToken", query = "SELECT u FROM UsuarioScrum u WHERE u.token = :token"),
    @NamedQuery(name = "UsuarioScrum.findByRefreshToken", query = "SELECT u FROM UsuarioScrum u WHERE u.refreshToken = :refreshToken"),
    @NamedQuery(name = "UsuarioScrum.findByNombre", query = "SELECT u FROM UsuarioScrum u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "UsuarioScrum.findByEmail", query = "SELECT u FROM UsuarioScrum u WHERE u.email = :email")})
public class UsuarioScrum implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "SeqIdUserScrum", sequenceName = "SECUENCIA_USUARIO_SCRUM", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqIdUserScrum")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USUARIO")
    private Long idUsuario;
    @Size(max = 256)
    @Column(name = "TOKEN")
    private String token;
    @Size(max = 256)
    @Column(name = "REFRESH_TOKEN")
    private String refreshToken;
    @Size(max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "EMAIL")
    private String email;
    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private Collection<TareaScrum> tareaScrumCollection;
    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.EAGER)
    private Collection<UsuyproScrum> usuyproScrumCollection;
    @OneToMany(mappedBy = "idAdmin", fetch = FetchType.EAGER)
    private Collection<ProyectoScrum> proyectoScrumCollection;

    public UsuarioScrum() {
    }

    public UsuarioScrum(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<TareaScrum> getTareaScrumCollection() {
        return tareaScrumCollection;
    }

    public void setTareaScrumCollection(Collection<TareaScrum> tareaScrumCollection) {
        this.tareaScrumCollection = tareaScrumCollection;
    }

    @XmlTransient
    public Collection<UsuyproScrum> getUsuyproScrumCollection() {
        return usuyproScrumCollection;
    }

    public void setUsuyproScrumCollection(Collection<UsuyproScrum> usuyproScrumCollection) {
        this.usuyproScrumCollection = usuyproScrumCollection;
    }

    @XmlTransient
    public Collection<ProyectoScrum> getProyectoScrumCollection() {
        return proyectoScrumCollection;
    }

    public void setProyectoScrumCollection(Collection<ProyectoScrum> proyectoScrumCollection) {
        this.proyectoScrumCollection = proyectoScrumCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioScrum)) {
            return false;
        }
        UsuarioScrum other = (UsuarioScrum) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.UsuarioScrum[ idUsuario=" + idUsuario + " ]";
    }
    
}
