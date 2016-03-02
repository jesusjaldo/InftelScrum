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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "FICHEROS_SCRUM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FicherosScrum.findAll", query = "SELECT f FROM FicherosScrum f"),
    @NamedQuery(name = "FicherosScrum.findByIdFichero", query = "SELECT f FROM FicherosScrum f WHERE f.idFichero = :idFichero"),
    @NamedQuery(name = "FicherosScrum.findByExt", query = "SELECT f FROM FicherosScrum f WHERE f.ext = :ext")})
public class FicherosScrum implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_FICHERO")
    private Long idFichero;
    @Lob
    @Column(name = "FICHERO")
    private Serializable fichero;
    @Size(max = 100)
    @Column(name = "EXT")
    private String ext;
    @OneToMany(mappedBy = "idFichero")
    private Collection<TareaScrum> tareaScrumCollection;
    @JoinColumn(name = "ID_TAREA", referencedColumnName = "ID_TAREA")
    @ManyToOne(optional = false)
    private TareaScrum idTarea;

    public FicherosScrum() {
    }

    public FicherosScrum(Long idFichero) {
        this.idFichero = idFichero;
    }

    public Long getIdFichero() {
        return idFichero;
    }

    public void setIdFichero(Long idFichero) {
        this.idFichero = idFichero;
    }

    public Serializable getFichero() {
        return fichero;
    }

    public void setFichero(Serializable fichero) {
        this.fichero = fichero;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    @XmlTransient
    public Collection<TareaScrum> getTareaScrumCollection() {
        return tareaScrumCollection;
    }

    public void setTareaScrumCollection(Collection<TareaScrum> tareaScrumCollection) {
        this.tareaScrumCollection = tareaScrumCollection;
    }

    public TareaScrum getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(TareaScrum idTarea) {
        this.idTarea = idTarea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFichero != null ? idFichero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FicherosScrum)) {
            return false;
        }
        FicherosScrum other = (FicherosScrum) object;
        if ((this.idFichero == null && other.idFichero != null) || (this.idFichero != null && !this.idFichero.equals(other.idFichero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FicherosScrum[ idFichero=" + idFichero + " ]";
    }
    
}
