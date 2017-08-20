/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lore
 */
@Entity
@Table(name = "vacuna")
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
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @Basic(optional = false)
    @Column(name = "mes_aplicacion")
    private int mesAplicacion;
    @Basic(optional = false)
    @Column(name = "dosis")
    private String dosis;
    @Basic(optional = false)
    @Column(name = "unidad_medida")
    private String unidadMedida;
    @Basic(optional = false)
    @Column(name = "obligatorio")
    private boolean obligatorio;
    @JoinColumn(name = "fk_hijo", referencedColumnName = "ci_numero")
    @ManyToOne
    private Hijos fkHijo;
    @OneToMany(mappedBy = "fkVacuna")
    private Collection<Agenda> agendaCollection;

    public Vacuna() {
    }

    public Vacuna(String codigo) {
        this.codigo = codigo;
    }

    public Vacuna(String codigo, String descripcion, boolean estado, int mesAplicacion, String dosis, String unidadMedida, boolean obligatorio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.mesAplicacion = mesAplicacion;
        this.dosis = dosis;
        this.unidadMedida = unidadMedida;
        this.obligatorio = obligatorio;
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

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getMesAplicacion() {
        return mesAplicacion;
    }

    public void setMesAplicacion(int mesAplicacion) {
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

    public boolean getObligatorio() {
        return obligatorio;
    }

    public void setObligatorio(boolean obligatorio) {
        this.obligatorio = obligatorio;
    }

    public Hijos getFkHijo() {
        return fkHijo;
    }

    public void setFkHijo(Hijos fkHijo) {
        this.fkHijo = fkHijo;
    }

    @XmlTransient
    public Collection<Agenda> getAgendaCollection() {
        return agendaCollection;
    }

    public void setAgendaCollection(Collection<Agenda> agendaCollection) {
        this.agendaCollection = agendaCollection;
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
        return "com.service.Vacuna[ codigo=" + codigo + " ]";
    }
    
}
