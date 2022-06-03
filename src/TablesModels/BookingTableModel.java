package TablesModels;



import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.*;
import java.lang.*;
import DatabaseClasses.*;

public class BookingTableModel extends AbstractTableModel {
    private static final int dateCol=0;
    private static final int chechInCol=1;
    private static final int checkOutCol=2;
    private static final int empCol=3;
    private static final int guestCol=4;
    private static final int payCol=5;
    private String[] columns={"Booking Date","Check In Date","Check Out Date","Employee ID","Guest ID","Payment ID"};
    private List<Booking> bookings;
   public BookingTableModel(List<Booking> list){
        this.bookings=list;
    }
    @Override
    public int getRowCount() {
        return bookings.size();
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
/*
    
     private static final int dateCol=0;
    private static final int chechInCol=1;
    private static final int checkOutCol=2;
    private static final int empCol=3;
    private static final int guestCol=4;
    private static final int payCol=5;
    */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Booking booking=bookings.get(rowIndex);
        switch (columnIndex){
            case dateCol:return booking.getDateS();
            case chechInCol:return booking.getCheckInDate();
            case checkOutCol:return booking.getCheckOutDate();
            case empCol:return booking.getEmployeeID();
            case guestCol:return booking.getGuestID();
            case payCol:return booking.getPaymentID();
            default:return booking.getId();
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
