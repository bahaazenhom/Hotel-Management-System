/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TablesModels;

import DatabaseClasses.Room;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import DatabaseClasses.*;
/**
 *
 * @author Bahaa Zenhom
 */
public class GuestTableModel extends AbstractTableModel {
    private static final int firstName=0;
    private static final int SecondName=1;
    private static final int email=2;
    private static final int contuctNum=3;
     private static final int proofId=4;
   
    private String[] columns={"First Name","Second Name","Email","Contuct Number","Proof ID"};
    private List<Guest> guests;
    public  GuestTableModel(List<Guest> list){
        this.guests=list;
    }
    @Override
    public int getRowCount() {
        return guests.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0,columnIndex).getClass();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Guest guest=guests.get(rowIndex);
        switch (columnIndex){
            case firstName:return guest.getFirstName();
            case SecondName:return guest.getSecondName();
            case email:return guest.getEmail();
            case contuctNum:return guest.getContactNum();
            case proofId:return guest.getProofID();
         
            default:return guest.getFirstName();
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
