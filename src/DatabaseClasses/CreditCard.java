/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseClasses;
import java.lang.*;
import java.util.*;
/**
 *
 * @author Bahaa Zenhom
 */
public class CreditCard {
    private String cardNum;
    private String expire_Date;
    private String cvv;
    private int guestID;
    
    public CreditCard(String card,String expire,String cvv,int guestid){
        this.cardNum=card;
        this.expire_Date=expire;
        this.cvv=cvv;
        this.guestID=guestid;
    }
    
    public String getCardNum(){
        return this.cardNum;
    }
    public String getExpireDate(){
        return this.expire_Date;
    }
    public String getCvv(){
        return this.cvv;
    }
    public int getGuestid(){
        return this.guestID;
    }
}
