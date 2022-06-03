package TablesModels;


import DatabaseClasses.Room;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import DatabaseClasses.*;
public class  RoomsTableModel extends AbstractTableModel {
    private static final int idCol=0;
    private static final int typeCol=1;
    private static final int floorCol=2;
    private static final int airConditionedCol=3;
    private static final int petCol=4;
    private static final int smokeCol=5;
    private static final int availabledCol=6;
   
    private String[] columns={"ID","Type","Floor","Air Conditioned?","Pet Friendly?","Smoke Friendly","Available"};
    private List<Room> rooms;
    public RoomsTableModel(List<Room> list){
        this.rooms=list;
    }
    @Override
    public int getRowCount() {
        return rooms.size();
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
        Room room=rooms.get(rowIndex);
        switch (columnIndex){
            case idCol:return room.getId();
            case typeCol:return room.getType();
            case floorCol:return room.getFloor();
            case airConditionedCol:return room.getAirConditions();
            case petCol:return room.getPetFiendly();
            case smokeCol:return room.getSmokeFiendly();
            case availabledCol:return room.getAvailability();
            default:return room.getType();
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
