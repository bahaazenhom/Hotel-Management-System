/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseClasses;

import DatabaseClasses.Guest;
import DatabaseClasses.Department;
import java.io.Serializable;
import java.util.Collection;
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

/**
 *
 * @author Bahaa Zenhom
 */
@Entity
@Table(name = "Hotels")
@NamedQueries({
    @NamedQuery(name = "Hotels.findAll", query = "SELECT h FROM Hotels h")})
public class Hotels implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "manager")
    private String manager;
    @Basic(optional = false)
    @Column(name = "contact_num")
    private String contactNum;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotelbranchID")
    private Collection<Department> departmentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotelID")
    private Collection<Guest> guestCollection;

    public Hotels() {
    }

    public Hotels(Integer id) {
        this.id = id;
    }

    public Hotels(Integer id, String email, String manager, String contactNum) {
        this.id = id;
        this.email = email;
        this.manager = manager;
        this.contactNum = contactNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public Collection<Department> getDepartmentCollection() {
        return departmentCollection;
    }

    public void setDepartmentCollection(Collection<Department> departmentCollection) {
        this.departmentCollection = departmentCollection;
    }

    public Collection<Guest> getGuestCollection() {
        return guestCollection;
    }

    public void setGuestCollection(Collection<Guest> guestCollection) {
        this.guestCollection = guestCollection;
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
        if (!(object instanceof Hotels)) {
            return false;
        }
        Hotels other = (Hotels) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication3.GuiForms.Hotels[ id=" + id + " ]";
    }
    
}
