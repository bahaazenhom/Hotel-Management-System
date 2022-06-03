/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseClasses;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.*;
import java.sql.*;
/**
 *
 * @author Bahaa Zenhom
 */
@Entity
@Table(name = "room")
@NamedQueries({
    @NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r")})
public class Room implements Serializable {

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
    @Column(name = "floor")
    private Character floor;
    @Basic(optional = false)
    @Column(name = "air_conditions")
    private Boolean airConditions;
    @Column(name = "smoke_fiendly")
    private Boolean smokeFiendly;
    @Column(name = "pet_fiendly")
    private Boolean petFiendly;
    private Boolean availability;

    public Room() {
    }

    public Room(Integer id) {
        this.id = id;
    }

    public Room(Integer id,String type, Character floor, boolean airConditions,boolean petFriendly,boolean smokeFriendly,boolean available) {
        this.id=id;
        this.type = type;
        this.floor = floor;
        this.airConditions = airConditions;
        this.smokeFiendly=smokeFriendly;
        this.petFiendly=petFriendly;
        this.availability=available;
    }
public Integer getId() {
        return id;
    }

public Boolean getAvailability(){
    return this.availability;
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

    public Character getFloor() {
        return floor;
    }

    public void setFloor(Character floor) {
        this.floor = floor;
    }

    public boolean getAirConditions() {
        return airConditions;
    }

    public void setAirConditions(boolean airConditions) {
        this.airConditions = airConditions;
    }

    public Boolean getSmokeFiendly() {
        return smokeFiendly;
    }

    public void setSmokeFiendly(Boolean smokeFiendly) {
        this.smokeFiendly = smokeFiendly;
    }

    public Boolean getPetFiendly() {
        return petFiendly;
    }

    public void setPetFiendly(Boolean petFiendly) {
        this.petFiendly = petFiendly;
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
        if (!(object instanceof Room)) {
            return false;
        }
        Room other = (Room) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication3.GuiForms.Room[ id=" + id + " ]";
    }
    
}
