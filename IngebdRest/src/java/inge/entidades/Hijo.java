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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@Table(name = "Hijo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hijo.findAll", query = "SELECT h FROM Hijo h")
    , @NamedQuery(name = "Hijo.findByCiNumero", query = "SELECT h FROM Hijo h WHERE h.ciNumero = :ciNumero")
    , @NamedQuery(name = "Hijo.findByNombre", query = "SELECT h FROM Hijo h WHERE h.nombre = :nombre")
    , @NamedQuery(name = "Hijo.findByApellido", query = "SELECT h FROM Hijo h WHERE h.apellido = :apellido")
    , @NamedQuery(name = "Hijo.findByFechaNacimiento", query = "SELECT h FROM Hijo h WHERE h.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Hijo.findByLugarNacimiento", query = "SELECT h FROM Hijo h WHERE h.lugarNacimiento = :lugarNacimiento")
    , @NamedQuery(name = "Hijo.findBySexo", query = "SELECT h FROM Hijo h WHERE h.sexo = :sexo")
    , @NamedQuery(name = "Hijo.findByNacionalidad", query = "SELECT h FROM Hijo h WHERE h.nacionalidad = :nacionalidad")
    , @NamedQuery(name = "Hijo.findByDireccion", query = "SELECT h FROM Hijo h WHERE h.direccion = :direccion")
    , @NamedQuery(name = "Hijo.findByDepartamento", query = "SELECT h FROM Hijo h WHERE h.departamento = :departamento")
    , @NamedQuery(name = "Hijo.findByMunicipio", query = "SELECT h FROM Hijo h WHERE h.municipio = :municipio")
    , @NamedQuery(name = "Hijo.findByBarrio", query = "SELECT h FROM Hijo h WHERE h.barrio = :barrio")
    , @NamedQuery(name = "Hijo.findByReferenciaDomicilio", query = "SELECT h FROM Hijo h WHERE h.referenciaDomicilio = :referenciaDomicilio")
    , @NamedQuery(name = "Hijo.findByResponsable", query = "SELECT h FROM Hijo h WHERE h.responsable = :responsable")
    , @NamedQuery(name = "Hijo.findByTelefonoContacto", query = "SELECT h FROM Hijo h WHERE h.telefonoContacto = :telefonoContacto")
    , @NamedQuery(name = "Hijo.findBySeguroMedico", query = "SELECT h FROM Hijo h WHERE h.seguroMedico = :seguroMedico")
    , @NamedQuery(name = "Hijo.findByAlergias", query = "SELECT h FROM Hijo h WHERE h.alergias = :alergias")})
public class Hijo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ci_numero")
    private Integer ciNumero;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "lugar_nacimiento")
    private String lugarNacimiento;
    @Column(name = "sexo")
    private Boolean sexo;
    @Column(name = "nacionalidad")
    private String nacionalidad;
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
    @Column(name = "responsable")
    private String responsable;
    @Column(name = "telefono_contacto")
    private Integer telefonoContacto;
    @Column(name = "seguro_medico")
    private String seguroMedico;
    @Column(name = "alergias")
    private String alergias;
    @ManyToMany(mappedBy = "hijoCollection")
    private Collection<Agenda> agendaCollection;
    @JoinColumn(name = "id_Usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(mappedBy = "cinumeroHijo")
    private Collection<Vacuna> vacunaCollection;

    public Hijo() {
    }

    public Hijo(Integer ciNumero) {
        this.ciNumero = ciNumero;
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

    public Boolean getSexo() {
        return sexo;
    }

    public void setSexo(Boolean sexo) {
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

    public Integer getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(Integer telefonoContacto) {
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
    public Collection<Agenda> getAgendaCollection() {
        return agendaCollection;
    }

    public void setAgendaCollection(Collection<Agenda> agendaCollection) {
        this.agendaCollection = agendaCollection;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public Collection<Vacuna> getVacunaCollection() {
        return vacunaCollection;
    }

    public void setVacunaCollection(Collection<Vacuna> vacunaCollection) {
        this.vacunaCollection = vacunaCollection;
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
        if (!(object instanceof Hijo)) {
            return false;
        }
        Hijo other = (Hijo) object;
        if ((this.ciNumero == null && other.ciNumero != null) || (this.ciNumero != null && !this.ciNumero.equals(other.ciNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inge.entidades.Hijo[ ciNumero=" + ciNumero + " ]";
    }
    
}
