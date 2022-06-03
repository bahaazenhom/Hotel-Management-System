/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseClasses;

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
@Table(name = "guest")
@NamedQueries({
    @NamedQuery(name = "Guest.findAll", query = "SELECT g FROM Guest g")})
public class Guest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "second_name")
    private String secondName;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "contact_num")
    private String contactNum;
    @Basic(optional = false)
    @Column(name = "proof_ID")
    private String proofID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guestID")
    private Collection<Booking> bookingCollection;
    @JoinColumn(name = "hotel_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Hotels hotelID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guestID")
    private Collection<Payment_1> paymentCollection;

    public Guest() {
    }

    public Guest(Integer id) {
        this.id = id;
    }

    public Guest(String firstName, String secondName, String email, String contactNum, String proofID) {
      
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.contactNum = contactNum;
        this.proofID = proofID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String getProofID() {
        return proofID;
    }

    public void setProofID(String proofID) {
        this.proofID = proofID;
    }

    public Collection<Booking> getBookingCollection() {
        return bookingCollection;
    }

    public void setBookingCollection(Collection<Booking> bookingCollection) {
        this.bookingCollection = bookingCollection;
    }

    public Hotels getHotelID() {
        return hotelID;
    }

    public void setHotelID(Hotels hotelID) {
        this.hotelID = hotelID;
    }

    public Collection<Payment_1> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment_1> paymentCollection) {
        this.paymentCollection = paymentCollection;
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
        if (!(object instanceof Guest)) {
            return false;
        }
        Guest other = (Guest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication3.GuiForms.Guest[ id=" + id + " ]";
    }
    
}
