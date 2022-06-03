
package TablesModels;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import DatabaseClasses.*;
public class  ServiceTableModel extends AbstractTableModel {
    private static final int nameCol=0;
    private static final int descCol=1;
    private static final int costCol=2;

    private String[] columns={"Service Name","Dscription","Cost"};
    private List<Service> services;
    public ServiceTableModel(List<Service> list){
        this.services=list;
    }
    @Override
    public int getRowCount() {
        return services.size();
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
        Service service=services.get(rowIndex);
        switch (columnIndex){
            case nameCol:return service.getName();
            case descCol:return service.getDescription();
            case costCol:return service.getCost();
            default:return service.getName();
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
