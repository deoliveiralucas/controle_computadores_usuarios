/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.managecomputer.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lucas Oliveira
 */
@Entity
@Table(name = "responsible")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Responsible.findAll", query = "SELECT r FROM Responsible r"),
    @NamedQuery(name = "Responsible.findByResponsibleId", query = "SELECT r FROM Responsible r WHERE r.responsibleId = :responsibleId"),
    @NamedQuery(name = "Responsible.findByName", query = "SELECT r FROM Responsible r WHERE r.name = :name"),
    @NamedQuery(name = "Responsible.findByLogin", query = "SELECT r FROM Responsible r WHERE r.login = :login"),
    @NamedQuery(name = "Responsible.findByPassword", query = "SELECT r FROM Responsible r WHERE r.password = :password"),
    @NamedQuery(name = "Responsible.findByEmail", query = "SELECT r FROM Responsible r WHERE r.email = :email"),
    @NamedQuery(name = "Responsible.findByActive", query = "SELECT r FROM Responsible r WHERE r.active = :active")})
public class Responsible implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "responsible_id")
    private Integer responsibleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Size(max = 25)
    @Column(name = "login")
    private String login;
    @Size(max = 2147483647)
    @Column(name = "password")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 120)
    @Column(name = "email")
    private String email;
    @Column(name = "active")
    private Boolean active;
    @ManyToMany(mappedBy = "responsibleList")
    private List<Computer> computerList;

    public Responsible() {
    }

    public Responsible(Integer responsibleId) {
        this.responsibleId = responsibleId;
    }

    public Responsible(Integer responsibleId, String name) {
        this.responsibleId = responsibleId;
        this.name = name;
    }

    public Integer getResponsibleId() {
        return responsibleId;
    }

    public void setResponsibleId(Integer responsibleId) {
        this.responsibleId = responsibleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @XmlTransient
    public List<Computer> getComputerList() {
        return computerList;
    }

    public void setComputerList(List<Computer> computerList) {
        this.computerList = computerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (responsibleId != null ? responsibleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Responsible)) {
            return false;
        }
        Responsible other = (Responsible) object;
        if ((this.responsibleId == null && other.responsibleId != null) || (this.responsibleId != null && !this.responsibleId.equals(other.responsibleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.managecomputer.model.Responsible[ responsibleId=" + responsibleId + " ]";
    }
    
}
