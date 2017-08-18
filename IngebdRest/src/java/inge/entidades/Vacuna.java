/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inge.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lore
 */
@Entity
@Table(name = "Vacuna")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacuna.findAll", query = "SELECT v FROM Vacuna v")
    , @NamedQuery(name = "Vacuna.findByCodigo", query = "SELECT v FROM Vacuna v WHERE v.codigo = :codigo")
    , @NamedQuery(name = "Vacuna.findByDescripcion", query = "SELECT v FROM Vacuna v WHERE v.descripcion = :descripcion")
    , @NamedQuery(name = "Vacuna.findByEstado", query = "SELECT v FROM Vacuna v WHERE v.estado = :estado")
    , @NamedQuery(name = "Vacuna.findByMesAplicacion", query = "SELECT v FROM Vacuna v WHERE v.mesAplicacion = :mesAplicacion")
    , @NamedQuery(name = "Vacuna.findByDosis", query = "SELECT v FROM Vacuna v WHERE v.dosis = :dosis")
    , @NamedQuery(name = "Vacuna.findByUnidadMedida", query = "SELECT v FROM Vacuna v WHERE v.unidadMedida = :unidadMedida")
    , @NamedQuery(name = "Vacuna.findByObligatorio", query = "SELECT v FROM Vacuna v WHERE v.obligatorio = :obligatorio")})
public class Vacuna implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "mes_aplicacion")
    private Integer mesAplicacion;
    @Column(name = "dosis")
    private String dosis;
    @Column(name = "unidad_medida")
    private String unidadMedida;
    @Column(name = "obligatorio")
    private Boolean obligatorio;
    @ManyToMany(mappedBy = "vacunaCollection")
    private Collection<Agenda> agendaCollection;
    @JoinColumn(name = "ci_numero_Hijo", referencedColumnName = "ci_numero")
    @ManyToOne
    private Hijo cinumeroHijo;

    public Vacuna() {
    }

    public Vacuna(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Integer getMesAplicacion() {
        return mesAplicacion;
    }

    public void setMesAplicacion(Integer mesAplicacion) {
        this.mesAplicacion = mesAplicacion;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Boolean getObligatorio() {
        return obligatorio;
    }

    public void setObligatorio(Boolean obligatorio) {
        this.obligatorio = obligatorio;
    }

    @XmlTransient
    public Collection<Agenda> getAgendaCollection() {
        return agendaCollection;
    }

    public void setAgendaCollection(Collection<Agenda> agendaCollection) {
        this.agendaCollection = agendaCollection;
    }

    public Hijo getCinumeroHijo() {
        return cinumeroHijo;
    }

    public void setCinumeroHijo(Hijo cinumeroHijo) {
        this.cinumeroHijo = cinumeroHijo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacuna)) {
            return false;
        }
        Vacuna other = (Vacuna) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inge.entidades.Vacuna[ codigo=" + codigo + " ]";
    }
    
}
