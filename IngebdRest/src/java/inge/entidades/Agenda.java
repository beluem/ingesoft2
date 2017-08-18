/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inge.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lore
 */
@Entity
@Table(name = "Agenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agenda.findAll", query = "SELECT a FROM Agenda a")
    , @NamedQuery(name = "Agenda.findById", query = "SELECT a FROM Agenda a WHERE a.id = :id")
    , @NamedQuery(name = "Agenda.findByFechaAgendada", query = "SELECT a FROM Agenda a WHERE a.fechaAgendada = :fechaAgendada")
    , @NamedQuery(name = "Agenda.findByHoraAgendada", query = "SELECT a FROM Agenda a WHERE a.horaAgendada = :horaAgendada")
    , @NamedQuery(name = "Agenda.findByCedulaVacunante", query = "SELECT a FROM Agenda a WHERE a.cedulaVacunante = :cedulaVacunante")})
public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha_agendada")
    @Temporal(TemporalType.DATE)
    private Date fechaAgendada;
    @Column(name = "hora_agendada")
    @Temporal(TemporalType.TIME)
    private Date horaAgendada;
    @Column(name = "cedula_vacunante")
    private Integer cedulaVacunante;
    @JoinTable(name = "muchos_Agenda_tiene_muchos_Vacuna", joinColumns = {
        @JoinColumn(name = "id_Agenda", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "codigo_Vacuna", referencedColumnName = "codigo")})
    @ManyToMany
    private Collection<Vacuna> vacunaCollection;
    @JoinTable(name = "muchos_Hijo_tiene_muchos_Agenda", joinColumns = {
        @JoinColumn(name = "id_Agenda", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "ci_numero_Hijo", referencedColumnName = "ci_numero")})
    @ManyToMany
    private Collection<Hijo> hijoCollection;

    public Agenda() {
    }

    public Agenda(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaAgendada() {
        return fechaAgendada;
    }

    public void setFechaAgendada(Date fechaAgendada) {
        this.fechaAgendada = fechaAgendada;
    }

    public Date getHoraAgendada() {
        return horaAgendada;
    }

    public void setHoraAgendada(Date horaAgendada) {
        this.horaAgendada = horaAgendada;
    }

    public Integer getCedulaVacunante() {
        return cedulaVacunante;
    }

    public void setCedulaVacunante(Integer cedulaVacunante) {
        this.cedulaVacunante = cedulaVacunante;
    }

    @XmlTransient
    public Collection<Vacuna> getVacunaCollection() {
        return vacunaCollection;
    }

    public void setVacunaCollection(Collection<Vacuna> vacunaCollection) {
        this.vacunaCollection = vacunaCollection;
    }

    @XmlTransient
    public Collection<Hijo> getHijoCollection() {
        return hijoCollection;
    }

    public void setHijoCollection(Collection<Hijo> hijoCollection) {
        this.hijoCollection = hijoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agenda)) {
            return false;
        }
        Agenda other = (Agenda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inge.entidades.Agenda[ id=" + id + " ]";
    }
    
}
