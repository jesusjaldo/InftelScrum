/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Lob;
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
@Table(name = "PROYECTO_SCRUM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProyectoScrum.findAll", query = "SELECT p FROM ProyectoScrum p"),
    @NamedQuery(name = "ProyectoScrum.findByIdProyecto", query = "SELECT p FROM ProyectoScrum p WHERE p.idProyecto = :idProyecto"),
    @NamedQuery(name = "ProyectoScrum.findByNombre", query = "SELECT p FROM ProyectoScrum p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "ProyectoScrum.findByFechaInicio", query = "SELECT p FROM ProyectoScrum p WHERE p.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "ProyectoScrum.findByFechaFin", query = "SELECT p FROM ProyectoScrum p WHERE p.fechaFin = :fechaFin"),
    @NamedQuery(name = "ProyectoScrum.findByDescripcion", query = "SELECT p FROM ProyectoScrum p WHERE p.descripcion = :descripcion")})
public class ProyectoScrum implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SeqIdProyectoScrum", sequenceName = "SECUENCIA_PROYECTO_SCRUM", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqIdProyectoScrum")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROYECTO")
    private BigDecimal idProyecto;
    @Size(max = 20)
    @Column(name = "NOMBRE")
    private String nombre;
    @Lob
    @Column(name = "ESTADOS")
    private byte[] estados;
    @Lob
    @Column(name = "CHAT")
    private byte[] chat;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Size(max = 500)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "idProyecto",  cascade = CascadeType.REMOVE)
    private Collection<TareaScrum> tareaScrumCollection;
    @OneToMany(mappedBy = "idProyecto",cascade = CascadeType.REMOVE)
    private Collection<UsuyproScrum> usuyproScrumCollection;
    @JoinColumn(name = "ID_ADMIN", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private UsuarioScrum idAdmin;
    
    

    public ProyectoScrum() {
    }

    public ProyectoScrum(BigDecimal idProyecto) {
        this.idProyecto = idProyecto;
    }

    public BigDecimal getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(BigDecimal idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getEstados() {
        return estados;
    }

    public void setEstados(byte[] estados) {
        this.estados = estados;
    }

    public byte[] getChat() {
        return chat;
    }

    public void setChat(byte[] chat) {
        this.chat = chat;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public UsuarioScrum getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(UsuarioScrum idAdmin) {
        this.idAdmin = idAdmin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProyecto != null ? idProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectoScrum)) {
            return false;
        }
        ProyectoScrum other = (ProyectoScrum) object;
        if ((this.idProyecto == null && other.idProyecto != null) || (this.idProyecto != null && !this.idProyecto.equals(other.idProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ProyectoScrum[ idProyecto=" + idProyecto + " ]";
    }
    
}
