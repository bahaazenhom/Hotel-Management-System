/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseClasses;

import DatabaseClasses.Guest;
import DatabaseClasses.Booking;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Bahaa Zenhom
 */
@Entity
@Table(name = "payment")
@NamedQueries({
    @NamedQuery(name = "Payment_1.findAll", query = "SELECT p FROM Payment_1 p")})
public class Payment_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "total_payment")
    private double totalPayment;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentID")
    private Collection<Booking> bookingCollection;
    @JoinColumn(name = "guest_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Guest guestID;
    private int guestId;

    public Payment_1() {
    }

    public Payment_1(Integer id) {
        this.id = id;
    }

  
  public Payment_1(Integer id, String type, Date date, double totalPayment) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.totalPayment = totalPayment;
    }
    public Payment_1(int guestId,String type) {
        this.guestId = guestId;
        this.type = type;   
        
        
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public Collection<Booking> getBookingCollection() {
        return bookingCollection;
    }

    public void setBookingCollection(Collection<Booking> bookingCollection) {
        this.bookingCollection = bookingCollection;
    }

    public int getGuestID() {
        return guestId;
    }

    public void setGuestID(int guestID) {
        this.guestId = guestID;
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
        if (!(object instanceof Payment_1)) {
            return false;
        }
        Payment_1 other = (Payment_1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication3.GuiForms.Payment_1[ id=" + id + " ]";
    }
    
}
