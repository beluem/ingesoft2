/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lore
 */
@Entity
@Table(name = "agenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agenda.findAll", query = "SELECT a FROM Agenda a")
    , @NamedQuery(name = "Agenda.findByIdAgenda", query = "SELECT a FROM Agenda a WHERE a.idAgenda = :idAgenda")
    , @NamedQuery(name = "Agenda.findByFechaAgendada", query = "SELECT a FROM Agenda a WHERE a.fechaAgendada = :fechaAgendada")
    , @NamedQuery(name = "Agenda.findByHoraAgendada", query = "SELECT a FROM Agenda a WHERE a.horaAgendada = :horaAgendada")
    , @NamedQuery(name = "Agenda.findByCedulaVacunante", query = "SELECT a FROM Agenda a WHERE a.cedulaVacunante = :cedulaVacunante")})
public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_agenda")
    private Integer idAgenda;
    @Basic(optional = false)
    @Column(name = "fecha_agendada")
    @Temporal(TemporalType.DATE)
    private Date fechaAgendada;
    @Basic(optional = false)
    @Column(name = "hora_agendada")
    @Temporal(TemporalType.TIME)
    private Date horaAgendada;
    @Basic(optional = false)
    @Column(name = "cedula_vacunante")
    private int cedulaVacunante;
    @JoinColumn(name = "fk_hijo", referencedColumnName = "ci_numero")
    @ManyToOne
    private Hijos fkHijo;
    @JoinColumn(name = "fk_vacuna", referencedColumnName = "codigo")
    @ManyToOne
    private Vacuna fkVacuna;

    public Agenda() {
    }

    public Agenda(Integer idAgenda) {
        this.idAgenda = idAgenda;
    }

    public Agenda(Integer idAgenda, Date fechaAgendada, Date horaAgendada, int cedulaVacunante) {
        this.idAgenda = idAgenda;
        this.fechaAgendada = fechaAgendada;
        this.horaAgendada = horaAgendada;
        this.cedulaVacunante = cedulaVacunante;
    }

    public Integer getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(Integer idAgenda) {
        this.idAgenda = idAgenda;
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

    public int getCedulaVacunante() {
        return cedulaVacunante;
    }

    public void setCedulaVacunante(int cedulaVacunante) {
        this.cedulaVacunante = cedulaVacunante;
    }

    public Hijos getFkHijo() {
        return fkHijo;
    }

    public void setFkHijo(Hijos fkHijo) {
        this.fkHijo = fkHijo;
    }

    public Vacuna getFkVacuna() {
        return fkVacuna;
    }

    public void setFkVacuna(Vacuna fkVacuna) {
        this.fkVacuna = fkVacuna;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAgenda != null ? idAgenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agenda)) {
            return false;
        }
        Agenda other = (Agenda) object;
        if ((this.idAgenda == null && other.idAgenda != null) || (this.idAgenda != null && !this.idAgenda.equals(other.idAgenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.service.Agenda[ idAgenda=" + idAgenda + " ]";
    }
    
}
