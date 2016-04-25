/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nackademin.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author borgs_000
 */
@Entity
@Table(name = "PHONENUMBERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phonenumbers.findAll", query = "SELECT p FROM Phonenumbers p"),
    @NamedQuery(name = "Phonenumbers.findById", query = "SELECT p FROM Phonenumbers p WHERE p.id = :id"),
    @NamedQuery(name = "Phonenumbers.findByPhonenumber", query = "SELECT p FROM Phonenumbers p WHERE p.phonenumber = :phonenumber")})
public class Phonenumbers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "PHONENUMBER")
    private String phonenumber;
    @JoinColumn(name = "OWNER_ID", referencedColumnName = "ID")
    @ManyToOne
    private Person ownerId;

    public Phonenumbers() {
    }

    public Phonenumbers(Integer id) {
        this.id = id;
    }

    public Phonenumbers(String number, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Person getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Person ownerId) {
        this.ownerId = ownerId;
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
        if (!(object instanceof Phonenumbers)) {
            return false;
        }
        Phonenumbers other = (Phonenumbers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nackademin.phonebook.Phonenumbers[ id=" + id + " ]";
    }
    
}
