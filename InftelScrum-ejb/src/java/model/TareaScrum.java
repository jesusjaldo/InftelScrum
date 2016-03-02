/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author inftel20
 */
@Entity
@Table(name = "TAREA_SCRUM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TareaScrum.findAll", query = "SELECT t FROM TareaScrum t"),
    @NamedQuery(name = "TareaScrum.findByIdTarea", query = "SELECT t FROM TareaScrum t WHERE t.idTarea = :idTarea"),
    @NamedQuery(name = "TareaScrum.findByEstado", query = "SELECT t FROM TareaScrum t WHERE t.estado = :estado"),
    @NamedQuery(name = "TareaScrum.findByNombre", query = "SELECT t FROM TareaScrum t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TareaScrum.findByDescripcion", query = "SELECT t FROM TareaScrum t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TareaScrum.findByFechaIni", query = "SELECT t FROM TareaScrum t WHERE t.fechaIni = :fechaIni"),
    @NamedQuery(name = "TareaScrum.findByFechaFin", query = "SELECT t FROM TareaScrum t WHERE t.fechaFin = :fechaFin"),
    @NamedQuery(name = "TareaScrum.findByTiempoEstimado", query = "SELECT t FROM TareaScrum t WHERE t.tiempoEstimado = :tiempoEstimado")})
public class TareaScrum implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "SeqIdTareaScrum", sequenceName = "SEQUENCE_TAREA_SCRUM", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqIdTareaScrum")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TAREA")
    private Long idTarea;
    @Size(max = 100)
    @Column(name = "ESTADO")
    private String estado;
    @Size(max = 20)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 1000)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "FECHA_INI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIni;
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Column(name = "TIEMPO_ESTIMADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tiempoEstimado;
    @JoinColumn(name = "ID_FICHERO", referencedColumnName = "ID_FICHERO")
    @ManyToOne
    private FicherosScrum idFichero;
    @JoinColumn(name = "ID_PROYECTO", referencedColumnName = "ID_PROYECTO")
    @ManyToOne
    private ProyectoScrum idProyecto;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private UsuarioScrum idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTarea")
    private Collection<FicherosScrum> ficherosScrumCollection;

    public TareaScrum() {
    }

    public TareaScrum(Long idTarea) {
        this.idTarea = idTarea;
    }

    public Long getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Long idTarea) {
        this.idTarea = idTarea;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(Date tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public FicherosScrum getIdFichero() {
        return idFichero;
    }

    public void setIdFichero(FicherosScrum idFichero) {
        this.idFichero = idFichero;
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

    @XmlTransient
    public Collection<FicherosScrum> getFicherosScrumCollection() {
        return ficherosScrumCollection;
    }

    public void setFicherosScrumCollection(Collection<FicherosScrum> ficherosScrumCollection) {
        this.ficherosScrumCollection = ficherosScrumCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTarea != null ? idTarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TareaScrum)) {
            return false;
        }
        TareaScrum other = (TareaScrum) object;
        if ((this.idTarea == null && other.idTarea != null) || (this.idTarea != null && !this.idTarea.equals(other.idTarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TareaScrum[ idTarea=" + idTarea + " ]";
    }
    
}
