/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseClasses;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Bahaa Zenhom
 */
@Entity
@Table(name = "Department")
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d")})
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "manager_ID", referencedColumnName = "ID")
    @ManyToOne
    private Employee managerID;
    @JoinColumn(name = "hotel_branch_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Hotels hotelbranchID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "depID")
    private Collection<Employee> employeeCollection;

    public Department() {
        
    }

    public Department(Integer id) {
        this.id = id;
    }

    public Department(String name,String description) {
        this.name = name;
        this.description=description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getManagerID() {
        return managerID;
    }

    public void setManagerID(Employee managerID) {
        this.managerID = managerID;
    }

    public Hotels getHotelbranchID() {
        return hotelbranchID;
    }

    public void setHotelbranchID(Hotels hotelbranchID) {
        this.hotelbranchID = hotelbranchID;
    }

    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
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
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication3.GuiForms.Department[ id=" + id + " ]";
    }
    
}
