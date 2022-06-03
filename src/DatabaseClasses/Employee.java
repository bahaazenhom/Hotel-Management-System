/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseClasses;

import DatabaseClasses.Department;
import DatabaseClasses.Booking;
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
@Table(name = "Employee")
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "proof_ID")
    private String proofID;
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "second_name")
    private String secondName;
    @Basic(optional = false)
    @Column(name = "role")
    private String role;
    @Basic(optional = false)
    @Column(name = "salary")
    private double salary;
    @Basic(optional = false)
    @Column(name = "contuct_num")
    private String contuctNum;
    @Column(name = "Access")
    private Boolean access;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "managerID")
    private Collection<Department> departmentCollection;
    @JoinColumn(name = "dep_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Employee depID;
    private int depid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeID")
    private Collection<Booking> bookingCollection;
    private String address;

    public Employee() {
    }

    public Employee(Integer id) {
        this.id = id;
    }

    public Employee( String firstName, String secondName, String email,  String contuctNum, String proofID, String address,int depID,String role, float salary, boolean access,String pass) {
     //first_name, second_name,email,contact_num,proof_ID,address,dep_ID,role,salary,Access,password   
        this.proofID = proofID;
        this.firstName = firstName;
        this.secondName = secondName;
        this.role = role;
        this.salary = salary;
        this.contuctNum = contuctNum;
        this.email = email;
        this.password=pass;
        this.access=access; 
        this.address=address;   
        this.depid=depID;
    }
public Employee(String firstName,String second_name,String role,String address,String proofId,double salary,String number,String email,String password, boolean access){
        this.proofID = proofId;
        this.firstName = firstName;
        this.secondName = second_name;
        this.role = role;
        this.salary = salary;
        this.contuctNum = number;
        this.email = email;
        this.password=password;
        this.access=access; 
        this.address=address;
     
}
    public Integer getId() {
        return id;
    }

    public String getAddress(){
        return this.address;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getProofID() {
        return proofID;
    }

    public void setProofID(String proofID) {
        this.proofID = proofID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getContuctNum() {
        return contuctNum;
    }

    public void setContactNum(String contactNum) {
        this.contuctNum = contactNum;
    }

    public Boolean getAccess() {
        return access;
    }

    public void setAccess(Boolean access) {
        this.access = access;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Department> getDepartmentCollection() {
        return departmentCollection;
    }

    public void setDepartmentCollection(Collection<Department> departmentCollection) {
        this.departmentCollection = departmentCollection;
    }

    public int getDepID() {
        return depid;
    }

    public void setDepID(int depID) {
        this.depid = depID;
    }

    public Collection<Booking> getBookingCollection() {
        return bookingCollection;
    }

    public void setBookingCollection(Collection<Booking> bookingCollection) {
        this.bookingCollection = bookingCollection;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication3.GuiForms.Employee[ id=" + id + " ]";
    }
    
}
