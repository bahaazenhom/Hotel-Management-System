/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseClasses;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Bahaa Zenhom
 */
@Entity
@Table(name = "Booking")
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b")})
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "check_in_date")
    @Temporal(TemporalType.DATE)
    private String checkInDate;
    @Column(name = "check_out_date")
    @Temporal(TemporalType.DATE)
    private String checkOutDate;
    @JoinTable(name = "booking_has_service", joinColumns = {
     @JoinColumn(name = "booking_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
    @JoinColumn(name = "service_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Service> serviceCollection;
    @JoinColumn(name = "employee_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Employee employeeID;
    private int employeeId;
    @JoinColumn(name = "guest_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Guest guestID;
    private int guestId;
    @JoinColumn(name = "payment_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Payment_1 paymentID;
    private int paymentId;
 private String dateS;
    public Booking() {
    }

    public Booking(Integer id) {
        this.id = id;
    }

    public Booking(Integer id, String checkInDate) {
        this.id = id;
        this.checkInDate = checkInDate;
    }
      public Booking(String checkInDate,String checkOutDate,int employeeid,int guestid,int paymentid) {
        this.checkInDate = checkInDate;
        this.checkOutDate=checkOutDate;
        this.employeeId=employeeid;
        this.guestId=guestid;
        this.paymentId=paymentid;
    }
        public Booking(String date,String checkInDate,String checkOutDate,int employeeid,int guestid,int paymentid) {
        this.checkInDate = checkInDate;
        this.checkOutDate=checkOutDate;
        this.employeeId=employeeid;
        this.guestId=guestid;
        this.paymentId=paymentid;
        this.dateS=date;
    }
        public Booking(String checkInDate,int employeeid,int guestid,int paymentid){
        this.checkInDate = checkInDate;
        this.employeeId=employeeid;
        this.guestId=guestid;
        this.paymentId=paymentid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
public String getDateS() {
        return dateS;
    }

    public void setDateS(String date) {
        this.dateS = date;
    }
    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Collection<Service> getServiceCollection() {
        return serviceCollection;
    }

    public void setServiceCollection(Collection<Service> serviceCollection) {
        this.serviceCollection = serviceCollection;
    }

    public int getEmployeeID() {
        return employeeId;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeId = employeeID;
    }

    public int getGuestID() {
        return guestId;
    }

    public void setGuestID(int guestID) {
        this.guestId= guestID;
    }

    public int getPaymentID() {
        return paymentId;
    }

    public void setPaymentID(int paymentID) {
        this.paymentId= paymentID;
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
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication3.GuiForms.Booking[ id=" + id + " ]";
    }
    
}
