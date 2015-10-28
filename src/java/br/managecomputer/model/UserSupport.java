/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.managecomputer.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lucas Oliveira
 */
@Entity
@Table(name = "user_support")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserSupport.findAll", query = "SELECT u FROM UserSupport u"),
    @NamedQuery(name = "UserSupport.findBySupportId", query = "SELECT u FROM UserSupport u WHERE u.supportId = :supportId"),
    @NamedQuery(name = "UserSupport.findByDescription", query = "SELECT u FROM UserSupport u WHERE u.description = :description"),
    @NamedQuery(name = "UserSupport.findByInsertedAt", query = "SELECT u FROM UserSupport u WHERE u.insertedAt = :insertedAt"),
    @NamedQuery(name = "UserSupport.findByStatus", query = "SELECT u FROM UserSupport u WHERE u.status = :status")})
public class UserSupport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "support_id")
    private Integer supportId;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "inserted_at")
    @Temporal(TemporalType.DATE)
    private Date insertedAt;
    @Column(name = "status")
    private Short status;
    @JoinColumn(name = "computer_id", referencedColumnName = "computer_id")
    @ManyToOne(optional = false)
    private Computer computerId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private ComputerUser userId;

    public UserSupport() {
    }

    public UserSupport(Integer supportId) {
        this.supportId = supportId;
    }

    public Integer getSupportId() {
        return supportId;
    }

    public void setSupportId(Integer supportId) {
        this.supportId = supportId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getInsertedAt() {
        return insertedAt;
    }

    public void setInsertedAt(Date insertedAt) {
        this.insertedAt = insertedAt;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Computer getComputerId() {
        return computerId;
    }

    public void setComputerId(Computer computerId) {
        this.computerId = computerId;
    }

    public ComputerUser getUserId() {
        return userId;
    }

    public void setUserId(ComputerUser userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supportId != null ? supportId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserSupport)) {
            return false;
        }
        UserSupport other = (UserSupport) object;
        if ((this.supportId == null && other.supportId != null) || (this.supportId != null && !this.supportId.equals(other.supportId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.managecomputer.model.UserSupport[ supportId=" + supportId + " ]";
    }
    
}
