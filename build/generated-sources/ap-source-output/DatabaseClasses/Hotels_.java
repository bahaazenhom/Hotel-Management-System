package DatabaseClasses;

import DatabaseClasses.Department;
import DatabaseClasses.Guest;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-03T14:33:17", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Hotels.class)
public class Hotels_ { 

    public static volatile SingularAttribute<Hotels, String> contactNum;
    public static volatile SingularAttribute<Hotels, String> manager;
    public static volatile CollectionAttribute<Hotels, Guest> guestCollection;
    public static volatile SingularAttribute<Hotels, Integer> id;
    public static volatile SingularAttribute<Hotels, String> email;
    public static volatile CollectionAttribute<Hotels, Department> departmentCollection;

}