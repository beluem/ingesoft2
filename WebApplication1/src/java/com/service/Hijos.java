/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lore
 */
@Entity
@Table(name = "hijos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hijos.findAll", query = "SELECT h FROM Hijos h")
    , @NamedQuery(name = "Hijos.findByCiNumero", query = "SELECT h FROM Hijos h WHERE h.ciNumero = :ciNumero")
    , @NamedQuery(name = "Hijos.findByNombre", query = "SELECT h FROM Hijos h WHERE h.nombre = :nombre")
    , @NamedQuery(name = "Hijos.findByApellido", query = "SELECT h FROM Hijos h WHERE h.apellido = :apellido")
    , @NamedQuery(name = "Hijos.findByFechaNacimiento", query = "SELECT h FROM Hijos h WHERE h.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Hijos.findByLugarNacimiento", query = "SELECT h FROM Hijos h WHERE h.lugarNacimiento = :lugarNacimiento")
    , @NamedQuery(name = "Hijos.findBySexo", query = "SELECT h FROM Hijos h WHERE h.sexo = :sexo")
    , @NamedQuery(name = "Hijos.findByNacionalidad", query = "SELECT h FROM Hijos h WHERE h.nacionalidad = :nacionalidad")
    , @NamedQuery(name = "Hijos.findByDireccion", query = "SELECT h FROM Hijos h WHERE h.direccion = :direccion")
    , @NamedQuery(name = "Hijos.findByDepartamento", query = "SELECT h FROM Hijos h WHERE h.departamento = :departamento")
    , @NamedQuery(name = "Hijos.findByMunicipio", query = "SELECT h FROM Hijos h WHERE h.municipio = :municipio")
    , @NamedQuery(name = "Hijos.findByBarrio", query = "SELECT h FROM Hijos h WHERE h.barrio = :barrio")
    , @NamedQuery(name = "Hijos.findByReferenciaDomicilio", query = "SELECT h FROM Hijos h WHERE h.referenciaDomicilio = :referenciaDomicilio")
    , @NamedQuery(name = "Hijos.findByResponsable", query = "SELECT h FROM Hijos h WHERE h.responsable = :responsable")
    , @NamedQuery(name = "Hijos.findByTelefonoContacto", query = "SELECT h FROM Hijos h WHERE h.telefonoContacto = :telefonoContacto")
    , @NamedQuery(name = "Hijos.findBySeguroMedico", query = "SELECT h FROM Hijos h WHERE h.seguroMedico = :seguroMedico")
    , @NamedQuery(name = "Hijos.findByAlergias", query = "SELECT h FROM Hijos h WHERE h.alergias = :alergias")})
public class Hijos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ci_numero")
    private Integer ciNumero;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "lugar_nacimiento")
    private String lugarNacimiento;
    @Basic(optional = false)
    @Column(name = "sexo")
    private boolean sexo;
    @Basic(optional = false)
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "departamento")
    private String departamento;
    @Column(name = "municipio")
    private String municipio;
    @Column(name = "barrio")
    private String barrio;
    @Column(name = "referencia_domicilio")
    private String referenciaDomicilio;
    @Basic(optional = false)
    @Column(name = "responsable")
    private String responsable;
    @Basic(optional = false)
    @Column(name = "telefono_contacto")
    private int telefonoContacto;
    @Column(name = "seguro_medico")
    private String seguroMedico;
    @Column(name = "alergias")
    private String alergias;
    @OneToMany(mappedBy = "fkHijo")
    private Collection<Vacuna> vacunaCollection;
    @JoinColumn(name = "usuario_padre", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuarios usuarioPadre;
    @OneToMany(mappedBy = "fkHijo")
    private Collection<Agenda> agendaCollection;

    public Hijos() {
    }

    public Hijos(Integer ciNumero) {
        this.ciNumero = ciNumero;
    }

    public Hijos(Integer ciNumero, String nombre, String apellido, Date fechaNacimiento, String lugarNacimiento, boolean sexo, String nacionalidad, String direccion, String responsable, int telefonoContacto) {
        this.ciNumero = ciNumero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.lugarNacimiento = lugarNacimiento;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
        this.direccion = direccion;
        this.responsable = responsable;
        this.telefonoContacto = telefonoContacto;
    }

    public Integer getCiNumero() {
        return ciNumero;
    }

    public void setCiNumero(Integer ciNumero) {
        this.ciNumero = ciNumero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public boolean getSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getReferenciaDomicilio() {
        return referenciaDomicilio;
    }

    public void setReferenciaDomicilio(String referenciaDomicilio) {
        this.referenciaDomicilio = referenciaDomicilio;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public int getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(int telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getSeguroMedico() {
        return seguroMedico;
    }

    public void setSeguroMedico(String seguroMedico) {
        this.seguroMedico = seguroMedico;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    @XmlTransient
    public Collection<Vacuna> getVacunaCollection() {
        return vacunaCollection;
    }

    public void setVacunaCollection(Collection<Vacuna> vacunaCollection) {
        this.vacunaCollection = vacunaCollection;
    }

    public Usuarios getUsuarioPadre() {
        return usuarioPadre;
    }

    public void setUsuarioPadre(Usuarios usuarioPadre) {
        this.usuarioPadre = usuarioPadre;
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
        hash += (ciNumero != null ? ciNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hijos)) {
            return false;
        }
        Hijos other = (Hijos) object;
        if ((this.ciNumero == null && other.ciNumero != null) || (this.ciNumero != null && !this.ciNumero.equals(other.ciNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.service.Hijos[ ciNumero=" + ciNumero + " ]";
    }
    
}
