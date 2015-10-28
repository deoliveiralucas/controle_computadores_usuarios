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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "computer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Computer.findAll", query = "SELECT c FROM Computer c"),
    @NamedQuery(name = "Computer.findByComputerId", query = "SELECT c FROM Computer c WHERE c.computerId = :computerId"),
    @NamedQuery(name = "Computer.findByName", query = "SELECT c FROM Computer c WHERE c.name = :name"),
    @NamedQuery(name = "Computer.findByMotherboard", query = "SELECT c FROM Computer c WHERE c.motherboard = :motherboard"),
    @NamedQuery(name = "Computer.findByHardDisk", query = "SELECT c FROM Computer c WHERE c.hardDisk = :hardDisk"),
    @NamedQuery(name = "Computer.findByProcessor", query = "SELECT c FROM Computer c WHERE c.processor = :processor"),
    @NamedQuery(name = "Computer.findByOperationalSystem", query = "SELECT c FROM Computer c WHERE c.operationalSystem = :operationalSystem"),
    @NamedQuery(name = "Computer.findByMemoryRam", query = "SELECT c FROM Computer c WHERE c.memoryRam = :memoryRam"),
    @NamedQuery(name = "Computer.findByUsbEnable", query = "SELECT c FROM Computer c WHERE c.usbEnable = :usbEnable"),
    @NamedQuery(name = "Computer.findByActive", query = "SELECT c FROM Computer c WHERE c.active = :active")})
public class Computer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "computer_id")
    private Integer computerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Size(max = 25)
    @Column(name = "motherboard")
    private String motherboard;
    @Size(max = 2147483647)
    @Column(name = "hard_disk")
    private String hardDisk;
    @Size(max = 155)
    @Column(name = "processor")
    private String processor;
    @Size(max = 155)
    @Column(name = "operational_system")
    private String operationalSystem;
    @Size(max = 120)
    @Column(name = "memory_ram")
    private String memoryRam;
    @Column(name = "usb_enable")
    private Boolean usbEnable;
    @Column(name = "active")
    private Boolean active;
    @JoinTable(name = "computer_responsible", joinColumns = {
        @JoinColumn(name = "computer_id", referencedColumnName = "computer_id")}, inverseJoinColumns = {
        @JoinColumn(name = "responsible_id", referencedColumnName = "responsible_id")})
    @ManyToMany
    private List<Responsible> responsibleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "computerId")
    private List<UserSupport> userSupportList;

    public Computer() {
    }

    public Computer(Integer computerId) {
        this.computerId = computerId;
    }

    public Computer(Integer computerId, String name) {
        this.computerId = computerId;
        this.name = name;
    }

    public Integer getComputerId() {
        return computerId;
    }

    public void setComputerId(Integer computerId) {
        this.computerId = computerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(String motherboard) {
        this.motherboard = motherboard;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getOperationalSystem() {
        return operationalSystem;
    }

    public void setOperationalSystem(String operationalSystem) {
        this.operationalSystem = operationalSystem;
    }

    public String getMemoryRam() {
        return memoryRam;
    }

    public void setMemoryRam(String memoryRam) {
        this.memoryRam = memoryRam;
    }

    public Boolean getUsbEnable() {
        return usbEnable;
    }

    public void setUsbEnable(Boolean usbEnable) {
        this.usbEnable = usbEnable;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @XmlTransient
    public List<Responsible> getResponsibleList() {
        return responsibleList;
    }

    public void setResponsibleList(List<Responsible> responsibleList) {
        this.responsibleList = responsibleList;
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
        hash += (computerId != null ? computerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Computer)) {
            return false;
        }
        Computer other = (Computer) object;
        if ((this.computerId == null && other.computerId != null) || (this.computerId != null && !this.computerId.equals(other.computerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.managecomputer.model.Computer[ computerId=" + computerId + " ]";
    }
    
}
