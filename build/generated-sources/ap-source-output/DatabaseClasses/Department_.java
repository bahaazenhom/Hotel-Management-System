package DatabaseClasses;

import DatabaseClasses.Employee;
import DatabaseClasses.Hotels;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-03T14:33:17", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Department.class)
public class Department_ { 

    public static volatile SingularAttribute<Department, Hotels> hotelbranchID;
    public static volatile SingularAttribute<Department, String> name;
    public static volatile CollectionAttribute<Department, Employee> employeeCollection;
    public static volatile SingularAttribute<Department, String> description;
    public static volatile SingularAttribute<Department, Integer> id;
    public static volatile SingularAttribute<Department, Employee> managerID;

}