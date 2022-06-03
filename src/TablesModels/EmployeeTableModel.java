package TablesModels;
import DatabaseClasses.*;
import javax.swing.table.AbstractTableModel;
import java.util.*;
import java.lang.*;
import javax.swing.event.TableModelListener;

public class EmployeeTableModel extends AbstractTableModel {


    /* String firstName=resultSet.getString("first_name");
        String second_name=resultSet.getString("second_name");
        String email=resultSet.getString("email");
        String number=resultSet.getString("contuct_num");
        String role=resultSet.getString("role");
        float salary=resultSet.getFloat("salary");
        String proofId=resultSet.getString("proof_ID");
        String password=resultSet.getString("password");
        boolean access=resultSet.getBoolean("Access");*/
    private static final int firstNameCol=0;
    private static final int secondNameCol=1;
    private static final int roleColumn=2;
     private static final int AddressCol=3;
    private static final int emailColumn=4;
    private static final int salaryColumn=5;
    private static final int numberCol=6;
    private static final int passCol=7;
    private static final int proofIDCol=8;
    private static final int accessCol=9;
   
    private String[] columns={"First Name","Second Name","Role","Address","Email","Salary","Number","Password","Proof ID","System Acsess"};
    private List<Employee> employees;
    public EmployeeTableModel(List<Employee> list){
        this.employees=list;
    }
    @Override
    public int getRowCount() {
        return employees.size();
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
/* private static final int firstNameCol=0;
    private static final int secondNameCol=1;
    private static final int roleColumn=2;
    private static final int emailColumn=3;
    private static final int salaryColumn=4;
    private static final int numberCol=5;
    private static final int passCol=6;
    private static final int proofIDCol=7;*/
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee employee=employees.get(rowIndex);
        switch (columnIndex){
            case firstNameCol:return employee.getFirstName();
            case secondNameCol:return employee.getSecondName();
            case roleColumn:return employee.getRole();
            case emailColumn:return employee.getEmail();
            case salaryColumn:return employee.getSalary();
            case numberCol:return employee.getContuctNum();
            case passCol:return employee.getPassword();
            case proofIDCol:return employee.getProofID();
            case accessCol:return employee.getAccess();
            case AddressCol:return employee.getAddress();
            default:return employee.getId();
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
