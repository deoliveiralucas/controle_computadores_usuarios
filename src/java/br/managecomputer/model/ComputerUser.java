/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.managecomputer.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author Lucas Oliveira
 */
@Entity
@Table(name = "computer_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComputerUser.findAll", query = "SELECT c FROM ComputerUser c"),
    @NamedQuery(name = "ComputerUser.findByUserId", query = "SELECT c FROM ComputerUser c WHERE c.userId = :userId"),
    @NamedQuery(name = "ComputerUser.findByName", query = "SELECT c FROM ComputerUser c WHERE c.name = :name"),
    @NamedQuery(name = "ComputerUser.findByArea", query = "SELECT c FROM ComputerUser c WHERE c.area = :area"),
    @NamedQuery(name = "ComputerUser.findByPhone", query = "SELECT c FROM ComputerUser c WHERE c.phone = :phone"),
    @NamedQuery(name = "ComputerUser.findByMail", query = "SELECT c FROM ComputerUser c WHERE c.mail = :mail"),
    @NamedQuery(name = "ComputerUser.findByActive", query = "SELECT c FROM ComputerUser c WHERE c.active = :active")})
public class ComputerUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Size(max = 25)
    @Column(name = "area")
    private String area;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Formato de telefone/fax inválido, deve ser xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 25)
    @Column(name = "phone")
    private String phone;
    @Size(max = 100)
    @Column(name = "mail")
    private String mail;
    @Column(name = "active")
    private Boolean active;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<UserSupport> userSupportList;

    public ComputerUser() {
    }

    public ComputerUser(Integer userId) {
        this.userId = userId;
    }

    public ComputerUser(Integer userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @XmlTransient
    public List<UserSupport> getUserSupportList() {
        return userSupportList;
    }

    public void setUserSupportList(List<UserSupport> userSupportList) {
        this.userSupportList = userSupportList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComputerUser)) {
            return false;
        }
        ComputerUser other = (ComputerUser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.managecomputer.model.ComputerUser[ userId=" + userId + " ]";
    }
    
}
