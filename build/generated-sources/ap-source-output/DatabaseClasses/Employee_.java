package DatabaseClasses;

import DatabaseClasses.Booking;
import DatabaseClasses.Department;
import DatabaseClasses.Employee;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-03T14:33:17", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, String> role;
    public static volatile SingularAttribute<Employee, Boolean> access;
    public static volatile SingularAttribute<Employee, String> address;
    public static volatile SingularAttribute<Employee, String> contuctNum;
    public static volatile SingularAttribute<Employee, Double> salary;
    public static volatile SingularAttribute<Employee, String> proofID;
    public static volatile CollectionAttribute<Employee, Booking> bookingCollection;
    public static volatile CollectionAttribute<Employee, Department> departmentCollection;
    public static volatile SingularAttribute<Employee, String> firstName;
    public static volatile SingularAttribute<Employee, String> password;
    public static volatile SingularAttribute<Employee, Employee> depID;
    public static volatile SingularAttribute<Employee, Integer> depid;
    public static volatile SingularAttribute<Employee, Integer> id;
    public static volatile SingularAttribute<Employee, String> email;
    public static volatile SingularAttribute<Employee, String> secondName;

}