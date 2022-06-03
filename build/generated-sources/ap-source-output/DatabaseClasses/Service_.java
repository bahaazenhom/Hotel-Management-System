package DatabaseClasses;

import DatabaseClasses.Booking;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-03T14:33:17", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Service.class)
public class Service_ { 

    public static volatile SingularAttribute<Service, Double> cost;
    public static volatile SingularAttribute<Service, String> name;
    public static volatile SingularAttribute<Service, String> description;
    public static volatile SingularAttribute<Service, Integer> id;
    public static volatile CollectionAttribute<Service, Booking> bookingCollection;

}