/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author inftel20
 */
@Entity
@Table(name = "USUYPRO_SCRUM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuyproScrum.findAll", query = "SELECT u FROM UsuyproScrum u"),
    @NamedQuery(name = "UsuyproScrum.findByIdUsuypro", query = "SELECT u FROM UsuyproScrum u WHERE u.idUsuypro = :idUsuypro"),
    @NamedQuery(name = "UsuyproScrum.findByIdUsuyIdPro", query = "SELECT u FROM UsuyproScrum u WHERE u.idProyecto = :idProyecto and u.idUsuario = :idUsuario")}    )
public class UsuyproScrum implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "SeqIdUsuyproScrum", sequenceName = "SECUENCIA_USUYPRO_SCRUM", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqIdUsuyproScrum")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USUYPRO")
    private Long idUsuypro;
    @JoinColumn(name = "ID_PROYECTO", referencedColumnName = "ID_PROYECTO")
    @ManyToOne
    private ProyectoScrum idProyecto;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private UsuarioScrum idUsuario;

    public UsuyproScrum() {
    }

    public UsuyproScrum(Long idUsuypro) {
        this.idUsuypro = idUsuypro;
    }

    public Long getIdUsuypro() {
        return idUsuypro;
    }

    public void setIdUsuypro(Long idUsuypro) {
        this.idUsuypro = idUsuypro;
    }

    public ProyectoScrum getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(ProyectoScrum idProyecto) {
        this.idProyecto = idProyecto;
    }

    public UsuarioScrum getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UsuarioScrum idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuypro != null ? idUsuypro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuyproScrum)) {
            return false;
        }
        UsuyproScrum other = (UsuyproScrum) object;
        if ((this.idUsuypro == null && other.idUsuypro != null) || (this.idUsuypro != null && !this.idUsuypro.equals(other.idUsuypro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.UsuyproScrum[ idUsuypro=" + idUsuypro + " ]";
    }
    
}
